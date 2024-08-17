package riwi.example.taskManagement.services.implementation;

import org.springframework.stereotype.Service;
import riwi.example.taskManagement.entities.TaskEntity;
import riwi.example.taskManagement.services.TaskService;

import java.util.List;

@Service
public class TaskImplemetation implements TaskService {
    @Override
    public List<TaskEntity> findByTitle(String title) {
        return List.of();
    }
}
