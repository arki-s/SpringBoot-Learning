package tsk.taskmanager.Domain.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tsk.taskmanager.Domain.Repository.TaskRepository;

@Service
@Transactional
public class TaskService {
  @Autowired
  TaskRepository taskRepository;
}
