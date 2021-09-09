package com.henry.todolist.service;

import com.henry.todolist.entity.Task;
import javassist.NotFoundException;

import java.util.Collection;

public interface TaskServices {

    Task addTask(Task task);
    Task updateTask(Task task);
    void deleteTask(Integer taskId) throws NotFoundException;

    Task getTask(Integer taskId);
    Collection<Task> getCompletedTasks();
    Collection<Task> getUnCompletedTasks();
}
