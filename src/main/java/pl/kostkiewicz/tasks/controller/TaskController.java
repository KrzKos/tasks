package pl.kostkiewicz.tasks.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kostkiewicz.tasks.dto.TaskDTO;
import pl.kostkiewicz.tasks.service.TaskService;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/task")
public class TaskController {
    private final TaskService taskService;



    @PostMapping
    public ResponseEntity save(@RequestBody TaskDTO taskDTO){
        Long taskId = taskService.create(taskDTO).getId();
        return ResponseEntity.created(URI.create("/api/task/"+ taskId)).build();
    }

    @GetMapping
    public List<TaskDTO> getAll() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return ResponseEntity.ok(taskService.finById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody TaskDTO taskDTO, @PathVariable long id){
        taskDTO.setId(id);
        TaskDTO updated = taskService.update(taskDTO);
        if(!taskDTO.getId().equals(id) || updated != null) {
            return ResponseEntity.created(URI.create("/api/task/" + taskDTO.getId())).body(updated);
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id){
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
