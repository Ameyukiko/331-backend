package se331.lab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import se331.lab.util.SupabaseStorageService;

import org.springframework.web.bind.annotation.CrossOrigin;

@RestController   //เปลี่ยนจาก @Controller → @RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*") //เพิ่มนี้
public class SupabaseController {

    final SupabaseStorageService supabaseStorageService;

    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String fileUrl = supabaseStorageService.uploadFile(file);
            return ResponseEntity.ok(fileUrl);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error uploading file: " + e.getMessage());
        }
    }
}

