package com.henry.todolist.controller;

import com.henry.todolist.entity.Task;
import com.henry.todolist.service.TaskServices;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = {"http://localhost:3000"})
public class ToDoListRestController {

    @Autowired
    private TaskServices taskServices;

    @GetMapping("/completed")
    public Collection<Task> getCompletedTasks() {
        return taskServices.getCompletedTasks();
    }

    @GetMapping()
    public Collection<Task> getUnCompletedTasks() {
        return taskServices.getUnCompletedTasks();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Integer id) {
        return taskServices.getTask(id);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) throws URISyntaxException {
        Task savedTask = taskServices.addTask(task);

        return ResponseEntity.created(new URI("/tasks/" + savedTask.getId())).body(savedTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task) throws NotFoundException {
        if (taskServices.getTask(task.getId()) == null)
            throw new NotFoundException("Task not found for id:" + task.getId());
        Task updatedTask = taskServices.updateTask(task);

        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Integer id) throws NotFoundException {
        if (taskServices.getTask(id) == null)
            throw new NotFoundException("Task not found for id:" + id);

        taskServices.deleteTask(id);

        return ResponseEntity.ok().build();

    }

}
