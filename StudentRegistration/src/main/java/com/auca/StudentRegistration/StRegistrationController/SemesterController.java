package com.auca.StudentRegistration.StRegistrationController;

import com.auca.StudentRegistration.StRegistrationModel.Semester;
import com.auca.StudentRegistration.StRegistrationService.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/semester" , produces = (MediaType.APPLICATION_JSON_VALUE), consumes = (MediaType.APPLICATION_JSON_VALUE))
public class SemesterController {
    private static final long serialVersionUID = 1L;
    @Autowired
    private SemesterService semService;
    @PostMapping(value = "/savetheSemester")
    public ResponseEntity<?> createSemester(@RequestBody Semester semester){
        if(semester != null ){
            String message = semService.saveSemester(semester);
            if(message != null){
                return new ResponseEntity<>("Semester Saved Successfully", HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<>("Semester Not Saved",HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        else {
            return new ResponseEntity<>("Something went wrong",HttpStatus.BAD_GATEWAY);
        }
    }
    @GetMapping(value = "/listtheSemesters")
    public ResponseEntity<List<Semester>> listSemester() {
        List<Semester> sems = semService.listSemesters();
        return new ResponseEntity<>(sems, HttpStatus.OK);
    }
    @PutMapping(value = "/updatetheSemester/{code}")
    public ResponseEntity<String> updateSemester(@PathVariable String code, @RequestBody Semester semester) {
        if (semester != null) {
            String message = semService.updateSemester(code, semester);
            if (message != null) {
                return new ResponseEntity<>("Semester Updated Successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Semester Not Updated Successfully", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping(value = "/deletetheSemester/{code}")
    public ResponseEntity<String> deleteSemester(@PathVariable String code) {
        if (code != null) {
            String message = semService.deleteSemester(code);
            if (message != null) {
                return new ResponseEntity<>("Semester Deleted Successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Semester Not Deleted Successfully", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
        }
    }
}
