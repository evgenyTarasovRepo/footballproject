package com.tarasov.footballproject.controllers;

import com.tarasov.footballproject.dto.get.GetManagerDTO;
import com.tarasov.footballproject.dto.post.PostManagerDTO;
import com.tarasov.footballproject.services.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ManagerController {
    private ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping("/managers")
    public ResponseEntity<Void> saveManager(@RequestBody PostManagerDTO postManagerDTO) {
        managerService.saveManager(postManagerDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/managers")
    public ResponseEntity<List<GetManagerDTO>> findAllManagers() {
        List<GetManagerDTO> managers = managerService.findAllManagers();
        return ResponseEntity.ok(managers);
    }

    @GetMapping("/managers/{id}")
    public ResponseEntity<GetManagerDTO> findManagerById(@PathVariable Integer id) {
        GetManagerDTO manager = managerService.findManagerById(id);
        return ResponseEntity.ok(manager);
    }

    @DeleteMapping("/managers/{id}")
    public ResponseEntity<String> deleteManagerById(@PathVariable Integer id) {
        managerService.deleteManager(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/managers/{id}")
    public ResponseEntity<PostManagerDTO> updateManager(@PathVariable Integer id, @RequestBody PostManagerDTO postManagerDTO) {
        managerService.updateManager(id, postManagerDTO);
        return ResponseEntity.ok(postManagerDTO);
    }
}
