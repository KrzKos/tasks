package pl.kostkiewicz.tasks.service;

import pl.kostkiewicz.tasks.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    TaskDTO create(TaskDTO taskDTO);
    List<TaskDTO> findAll();
    TaskDTO finById(long id);
    TaskDTO update(TaskDTO taskDTO);
    void delete(long id);
}
