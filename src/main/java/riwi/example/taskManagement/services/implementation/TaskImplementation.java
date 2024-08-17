package riwi.example.taskManagement.services.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import riwi.example.taskManagement.entities.TaskEntity;
import riwi.example.taskManagement.repositories.TaskRepository;
import riwi.example.taskManagement.services.TaskService;

import java.util.List;

@Service
public class TaskImplementation implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<TaskEntity> read() {
        return taskRepository.findAll();
    }

    @Override
    public TaskEntity findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public TaskEntity create(TaskEntity taskEntity) {
        return taskRepository.save(taskEntity);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<TaskEntity> findByTitle(String title) {
        return taskRepository.findByTitle(title);
    }
}
