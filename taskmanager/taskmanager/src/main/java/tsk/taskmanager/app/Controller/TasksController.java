package tsk.taskmanager.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import tsk.taskmanager.Domain.Model.Task;
import tsk.taskmanager.Domain.Repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class TasksController {

  @Autowired
  TaskRepository taskRepository;

  @GetMapping("/")
  public ModelAndView index(ModelAndView mav) {
    mav.setViewName("task/index");
    List<Task> taskList = taskRepository.findAll();
    mav.addObject("taskList", taskList);
    return mav;
  }

  @GetMapping("task/create")
  public ModelAndView create(ModelAndView mav, @ModelAttribute("formModel") Task task){
    mav.setViewName("task/create");
    return mav;
  }

  @Transactional
  @PostMapping("task/create")
  public ModelAndView createform(ModelAndView mav, @ModelAttribute("formModel")Task task){
    taskRepository.saveAndFlush(task);
    return new ModelAndView("redirect:/");
  }

  @GetMapping("task/{taskId}/edit")
  public ModelAndView edit(ModelAndView mav, @ModelAttribute("formModel")Task task, @PathVariable int taskId){
    mav.setViewName("task/edit");
    Optional<Task> data = taskRepository.findById((Integer) taskId);
    mav.addObject("formModel", data.get());
    return mav;
  }

  @Transactional
  @PostMapping("task/edit")
  public ModelAndView editform(ModelAndView mav, @ModelAttribute("formModel")Task task){
    taskRepository.saveAndFlush(task);
    return new ModelAndView("redirect:/");
  }
}
