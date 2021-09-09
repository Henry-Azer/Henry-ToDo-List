package com.henry.todolist.service.services_impl;

import com.henry.todolist.entity.Task;
import com.henry.todolist.repository.TaskRepository;
import com.henry.todolist.service.TaskServices;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class TaskServicesImpl implements TaskServices {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Integer taskId){
        taskRepository.deleteById(taskId);
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.saveAndFlush(task);
    }

    @Override
    public Task getTask(Integer taskId) {
        return taskRepository.findById(taskId).get();
    }

    @Override
    public Collection<Task> getCompletedTasks() {
        return taskRepository.getAllByComplete(true);
    }

    @Override
    public Collection<Task> getUnCompletedTasks() {
        return taskRepository.getAllByCompleteOrderByDueDate(false);
    }
}
