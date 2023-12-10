package tsk.taskmanager.Domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tsk.taskmanager.Domain.Model.Task;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
public Optional<Task> findById(Integer name);
}
