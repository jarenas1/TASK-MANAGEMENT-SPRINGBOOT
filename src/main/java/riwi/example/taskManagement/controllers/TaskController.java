package riwi.example.taskManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import riwi.example.taskManagement.entities.TaskEntity;
import riwi.example.taskManagement.services.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String listTasks(Model model){
        model.addAttribute("tasks", taskService.read());
        return "list-tasks";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("task", new TaskEntity());
        return "form-task";
    }

    @PostMapping("/save")
    public String saveTask(@ModelAttribute TaskEntity taskEntity, RedirectAttributes redirectAttributes){
        taskService.create(taskEntity);
        redirectAttributes.addFlashAttribute("message", "Task saved successfully");
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        TaskEntity taskEntity = taskService.findById(id);
        if (taskEntity == null) {
            redirectAttributes.addFlashAttribute("error", "Task not found");
            return "redirect:/tasks";
        }
        model.addAttribute("task", taskEntity);
        return "form-task";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        taskService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Task deleted successfully");
        return "redirect:/tasks";
    }

    @GetMapping("/find")
    public String searchTasks(@RequestParam String title, Model model) {
        model.addAttribute("tasks", taskService.findByTitle(title));
        return "list-tasks";
    }

    @GetMapping("/detail/{id}")
    public String detailTask(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        TaskEntity taskEntity = taskService.findById(id);
        if (taskEntity == null) {
            redirectAttributes.addFlashAttribute("error", "Task not found");
            return "redirect:/tasks";
        }
        model.addAttribute("task", taskEntity);
        return "detail-task";
    }
}