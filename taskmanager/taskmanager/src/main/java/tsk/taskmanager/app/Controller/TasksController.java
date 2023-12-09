package tsk.taskmanager.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tsk.taskmanager.Domain.Repository.TaskRepository;

public class TasksController {

  @Autowired
  TaskRepository taskRepository;

  @RequestMapping("/")
  public ModelAndView index(ModelAndView mav) {

    mav.setViewName("/task/index");

    return mav;
  }

}
