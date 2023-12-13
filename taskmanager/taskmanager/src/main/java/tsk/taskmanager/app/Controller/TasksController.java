package tsk.taskmanager.app.Controller;

import jakarta.annotation.PostConstruct;
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

  @Transactional
  @PostMapping("task/{taskId}/delete")
  public ModelAndView delete(ModelAndView mav, @RequestParam Integer taskId){
    taskRepository.deleteById(taskId);

    return new ModelAndView("redirect:/");
  }

  @PostConstruct
  public void init(){
    Task t1 = new Task();
    t1.setName("Reading book");
    t1.setComment("at least 30 minutes");
    t1.setCompleted(false);
    taskRepository.saveAndFlush(t1);

    Task t2 = new Task();
    t2.setName("FitBoxing");
    t2.setComment("at least 40 minutes");
    t2.setCompleted(true);
    taskRepository.saveAndFlush(t2);

    Task t3 = new Task();
    t3.setName("Watering Flowers");
    t3.setComment("everyday");
    t3.setCompleted(true);
    taskRepository.saveAndFlush(t3);

    Task t4 = new Task();
    t4.setName("Not to eat sweets");
    t4.setComment("eat vegetables instead");
    t4.setCompleted(false);
    taskRepository.saveAndFlush(t4);

    Task t5 = new Task();
    t5.setName("playing video games");
    t5.setComment("at most 2 hours");
    t5.setCompleted(true);
    taskRepository.saveAndFlush(t5);
  }

}
