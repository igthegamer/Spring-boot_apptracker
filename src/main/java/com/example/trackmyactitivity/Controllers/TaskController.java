package com.example.trackmyactitivity.Controllers;

import com.example.trackmyactitivity.Entities.Task;
import com.example.trackmyactitivity.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;



    @PostMapping("/add_task")
    public Task addTask(@RequestBody String desciption){
        return taskService.addTask(desciption);
    }
    @PutMapping("/update/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody String status) {
        return taskService.updateTask(id, status);
    }
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable String status) {
        return taskService.getTasksByStatus(status);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
