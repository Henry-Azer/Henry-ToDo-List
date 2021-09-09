package com.henry.todolist.repository;

import com.henry.todolist.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    Collection<Task> getAllByComplete(boolean complete);
    Collection<Task> getAllByCompleteOrderByDueDate(boolean complete);

}
