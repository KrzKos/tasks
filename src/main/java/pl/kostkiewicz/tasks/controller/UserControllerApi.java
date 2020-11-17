package pl.kostkiewicz.tasks.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kostkiewicz.tasks.dto.UserDTO;
import pl.kostkiewicz.tasks.service.UserService;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserControllerApi {
    private final UserService userService;

    @GetMapping
    public List<UserDTO> getAll(){
        return userService.findAll();
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody UserDTO userDTO){
        UserDTO savedUser = userService.create(userDTO);
        return ResponseEntity.created(URI.create("/api/user/" + savedUser.getId())).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable long id){
        UserDTO result = userService.findById(id);
        return ResponseEntity.ok(result);
    }

}
