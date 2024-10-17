package com.example.trackmyactitivity.Services;
import com.example.trackmyactitivity.Entities.Task;



import java.util.List;

public interface TaskService {
    Task addTask(String description);
    Task updateTask(Long id, String status);
    void deleteTask(Long id);
    List<Task> getAllTasks();
    List<Task> getTasksByStatus(String status);
}
