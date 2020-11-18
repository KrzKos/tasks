package pl.kostkiewicz.tasks.mapper;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.kostkiewicz.tasks.dto.TaskDTO;
import pl.kostkiewicz.tasks.model.Task;

import java.util.Optional;

@Component
@Slf4j
public class TaskMapper {

    public TaskDTO from(Task task) {
        log.info("Task before: {}", task);
        ModelMapper modelMapper = new ModelMapper();
        TaskDTO taskDTO = modelMapper.map(task, TaskDTO.class);
        log.info("Task after: {}", taskDTO);
        return taskDTO;
    }
    public Task from(TaskDTO taskDTO){
        log.info("Task before: {}", taskDTO);
        ModelMapper modelMapper= new ModelMapper();
        Task task = modelMapper.map(taskDTO, Task.class);
        log.info("Task after: {}", task);
        return task;
    }

    /*public Optional<TaskDTO> from(Optional<Task> task) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<TaskDTO> result = modelMapper.map(task, TaskDTO.class)
    }*/
}
