package riwi.example.taskManagement.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import riwi.example.taskManagement.entities.TaskEntity;
import riwi.example.taskManagement.repositories.TaskRepository;
import riwi.example.taskManagement.services.TaskService;

import java.util.List;

@Service
public class TaskImplemetation implements TaskService {

    //INYECTAMOS EL REPO PARA ACCEDER A LOS METODOS CRUD
    @Autowired
    TaskRepository taskRepository;


    public List<TaskEntity> read(){
        return taskRepository.findAll();
    }

    public TaskEntity findById(Long id){
        return taskRepository.findById(id).orElse(null); //SI NO ENCUENTRA NULL
    }

    public TaskEntity create(TaskEntity taskEntity){
        return taskRepository.save(taskEntity);
    }

    public void delete(Long id){
        taskRepository.deleteById(id);
    }

    public List<TaskEntity> findByTitle(String title){
        return taskRepository.findByTitle(title);
    }
}