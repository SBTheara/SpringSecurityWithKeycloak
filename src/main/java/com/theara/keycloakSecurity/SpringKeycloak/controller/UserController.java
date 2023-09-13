package com.theara.keycloakSecurity.SpringKeycloak.controller;
import com.theara.keycloakSecurity.SpringKeycloak.entity.User;
import com.theara.keycloakSecurity.SpringKeycloak.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/get-all")
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping(value = "/add-new-user")
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PutMapping(value = "/update-user/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(userService.update(user, id));
    }

    @DeleteMapping(value = "/delete-by-id/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        userService.delete(id);
        return ResponseEntity.ok("Delete success");
    }
}
