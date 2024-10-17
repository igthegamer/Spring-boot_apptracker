package com.example.trackmyactitivity.Repositories;

import com.example.trackmyactitivity.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface TaskRepo extends JpaRepository<Task, Long> {
        List<Task> findByStatus(String status);
    }


