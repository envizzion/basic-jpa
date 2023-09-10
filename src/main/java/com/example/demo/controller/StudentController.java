package com.example.demo.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.StudentService;

@RestController()
@RequestMapping("/student")
public class StudentController {

	@Autowired()
	StudentService studentService;
	
    @GetMapping(":number")
    public ResponseEntity<Map<String,Object>> retrieveAllStudents( @PathVariable() int number) {

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("message", number);
        return new ResponseEntity<>(response, HttpStatus.OK);    }
    
    @PostMapping()
    public String postFunc(@RequestBody() Map body) {
        System.out.println("message response" + body.get("message"));
        studentService.saveSudent(body);
        return "data awa " + body.get("message");
    }
	
}
