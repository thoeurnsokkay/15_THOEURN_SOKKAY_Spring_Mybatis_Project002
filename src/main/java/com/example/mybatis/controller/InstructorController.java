package com.example.mybatis.controller;

import com.example.mybatis.model.Instructor;
import com.example.mybatis.model.response.ApiResponse;
import com.example.mybatis.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructor>>> getInstructors() {

        List<Instructor> instructors = instructorService.getInstructors();
        ApiResponse<List<Instructor>> response = ApiResponse.<List<Instructor>>builder()
                .timestamp(LocalDateTime.now())
                .message("All Instructors have been successfully fetched!!")
                .status(HttpStatus.OK)
                .payload(instructors)
                .build();
        response.setMessage("success");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructor>> getInstructorById(@PathVariable Integer id) {
        Instructor instructor = instructorService.getInstructorsById(id);

        if (instructor != null) {
            ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                    .timestamp(LocalDateTime.now())
                    .message("Get instructor successfully!!")
                    .status(HttpStatus.OK)
                    .payload(instructor)
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ApiResponse.<Instructor>builder()
                        .timestamp(LocalDateTime.now())
                        .message("Instructor not found")
                        .status(HttpStatus.NOT_FOUND)
                        .payload(null)
                        .build()
        );
    }

    @PostMapping
    public ApiResponse<Instructor> createInstructor(@RequestBody Instructor instructor ) {
        instructorService.createInstructor(instructor);
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .timestamp(LocalDateTime.now())
                .message("Create instructor successfully")
                .status(HttpStatus.CREATED)
                .payload(instructorService.createInstructor(instructor))
                .build();
        return response;
    }

    @DeleteMapping("/{id}")
    public String deleteTicketId(@PathVariable Integer id){
        for(Instructor instructor : instructorService.getInstructors()){
            if(instructor.getInstructorId() == id){
                instructor.remove(instructor);
                return "Remove Success!!";
            }
        }
        return "Ticker not found!!";
    }

}


