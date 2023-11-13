package dev.rakesh.test.controllers;

import dev.rakesh.test.models.StudentModel;
import dev.rakesh.test.repositories.StudentRepository;
import dev.rakesh.test.service.ApiResponse; // Make sure to have this import

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map; // Add this import for Map
import java.util.List;

@RequestMapping("/api/v1")
@RestController
@CrossOrigin(maxAge = 3600)
public class StudentController {
    
    @Autowired
    private StudentRepository studentRepository;
    ApiResponse response = new ApiResponse(); 
    
 


    @GetMapping("/getStudents")
    public ResponseEntity<?> getStudents() {
        ApiResponse response = new ApiResponse();

        try {
            List <StudentModel> students = studentRepository.findAll();
            
            response.putAll(Map.of(
                "success", true,
                "message", "Students fetched successfully",
                "data", students
            ));

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.putAll(Map.of(
                "success", false,
                "message", "Failed to fetch students",
                "error", e.getMessage()
            ));

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }



    @PostMapping("/addStudent")
    public ResponseEntity<?> addStudent(@RequestBody StudentModel student) {
        try {
            StudentModel savedStudent = studentRepository.save(student);
            
            response.putAll(Map.of(
                "success", true,
                "message", "Student added successfully",
                "data", savedStudent
            ));
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            response.putAll(Map.of(
                "success", false,
                "message", "Failed to add student",
                "error", e.getMessage()
            ));
            e.printStackTrace(); // Log the exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }



    @GetMapping("/hello")
    public ResponseEntity<?> hello() {
        try {
            // Simulating successful response data
            Object data = "Hello, Spring Boot!";
            response.putAll(Map.of(
                "success", true,
                "message", "Request successful",
                "data",   data
  
            ));
            return ResponseEntity.status(HttpStatus.OK).body(response); // Use OK status for successful response
        } catch (Exception e) {
            
            response.putAll(Map.of(
                "success", false,
                "message", "Something went wrong",
                "error", e.getMessage()
            ));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}













// package dev.rakesh.test.controllers;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

// import java.util.HashMap;
// import java.util.Map;

// @RestController
// public class StudentController {

//     @GetMapping("/hello")
//     public ResponseEntity<?> hello() {
//         try {
//             // Simulating successful response data
//             Object data = "Hello, Spring Boot!";

//             Map<String, Object> responseData = new HashMap<>();
//             responseData.put("success", true);
//             responseData.put("message", "Product created successfully");
//             responseData.put("data", data);

//             return ResponseEntity.status(HttpStatus.CREATED).body(responseData);
//         } catch (Exception e) {
//             Map<String, Object> responseData = new HashMap<>();
//             responseData.put("success", false);
//             responseData.put("message", "Something went wrong");
//             responseData.put("error", e.getMessage());

//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
//         }
//     }
// }
