package riwi.example.taskManagement.services;

import riwi.example.taskManagement.entities.TaskEntity;

import java.util.List;

public interface TaskService {
    List<TaskEntity> findByTitle(String title);
    List<TaskEntity> read();
    TaskEntity findById(Long id);
    TaskEntity create(TaskEntity taskEntity);
    void delete(Long id);


}
