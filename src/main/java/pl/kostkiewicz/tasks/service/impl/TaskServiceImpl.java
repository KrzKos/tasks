package pl.kostkiewicz.tasks.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kostkiewicz.tasks.dto.TaskDTO;
import pl.kostkiewicz.tasks.exeption.TaskNotFoundException;
import pl.kostkiewicz.tasks.mapper.TaskMapper;
import pl.kostkiewicz.tasks.model.Task;
import pl.kostkiewicz.tasks.model.User;
import pl.kostkiewicz.tasks.repository.TaskRepository;
import pl.kostkiewicz.tasks.repository.UserRepository;
import pl.kostkiewicz.tasks.service.TaskService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    public TaskDTO create(TaskDTO taskDTO) {
        Task task = taskMapper.from(taskDTO);
        User user = userRepository.getOne(taskDTO.getUserId());
        task.setUser(user);
        taskDTO.setId(taskRepository.save(task).getId());
        return taskDTO;
    }

    @Override
    public List<TaskDTO> findAll() {
        List<Task> taskList  = taskRepository.findAll();
        return taskList.stream()
                .map(task -> taskMapper.from(task))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO finById(long id) {
        Optional<Task> result = taskRepository.findById(id);
        return result.map(task -> taskMapper.from(task)).orElseThrow(() -> new TaskNotFoundException(id));
    }

    @Override
    public TaskDTO update(TaskDTO taskDTO) {
        User user = userRepository.findById(taskDTO.getUserId()).orElseThrow();
        Task updatedTask = taskRepository.findById(taskDTO.getId())
                .map(task -> {
                    task = taskMapper.from(taskDTO);
                    task.setUser(user);
                    return taskRepository.save(task);
                }).orElseThrow(() -> new TaskNotFoundException(taskDTO.getId()));
        return taskMapper.from(updatedTask);
    }

    @Override
    public void delete(long id) {
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()){
            taskRepository.delete(task.get());
        } else {
            throw new TaskNotFoundException(id);
        }
    }
}
