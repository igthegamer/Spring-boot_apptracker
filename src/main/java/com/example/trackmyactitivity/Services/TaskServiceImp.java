package com.example.trackmyactitivity.Services;

import com.example.trackmyactitivity.Entities.Task;
import com.example.trackmyactitivity.Repositories.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImp implements TaskService{

    @Autowired
    private  TaskRepo taskRepository;



    @Override
    public Task addTask(String description) {
        Task task = new Task();
        task.setDescription(description);
        task.setStatus("not done");
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, String status) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()){
            Task task = taskOptional.get();
            task.setStatus(status);
            return taskRepository.save(task);
        } else {
            throw new RuntimeException("task not found");
        }
    }

    @Override
    public void deleteTask(Long  id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }
}
