package tsk.taskmanager.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tsk.taskmanager.Domain.Model.Task;
import tsk.taskmanager.Domain.Repository.TaskRepository;

import java.util.List;

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
  public ModelAndView createform(ModelAndView mav, @ModelAttribute("formModel")Task Task){
    taskRepository.saveAndFlush(Task);
    return new ModelAndView("redirect:/");

  }

}
