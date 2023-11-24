package com.auca.StudentRegistration.StRegistrationController;

import com.auca.StudentRegistration.StRegistrationModel.AcademicUnit;
import com.auca.StudentRegistration.StRegistrationService.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/unit" , produces = (MediaType.APPLICATION_JSON_VALUE), consumes = (MediaType.APPLICATION_JSON_VALUE))
public class UnitController {
    private static final long serialVersionUID = 1L;
    @Autowired
    private UnitService unitService;
    @PostMapping(value = "/savetheUnit")
    public ResponseEntity<?> createUnit(@RequestBody AcademicUnit unit){
        if(unit != null ){

            String message = unitService.saveUnit(unit);
            if(message != null){
                return new ResponseEntity<>("Unit Saved Successfully", HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<>("Unit Not Saved",HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        else {
            return new ResponseEntity<>("Something went wrong",HttpStatus.BAD_GATEWAY);
        }
    }
    @GetMapping(value = "/listtheUnits")
    public ResponseEntity<List<AcademicUnit>> listUnits() {
        List<AcademicUnit> units = unitService.listUnits();
        return new ResponseEntity<>(units, HttpStatus.OK);
    }
    @PutMapping(value = "/updatetheUnit/{code}")
    public ResponseEntity<String> updateUnit(@PathVariable String code, @RequestBody AcademicUnit unit) {
        if (unit != null) {
            String message = unitService.updateUnit(code, unit);
            if (message != null) {
                return new ResponseEntity<>("Unit Updated Successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Unit Not Updated Successfully", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping(value = "/deletetheUnit/{code}")
    public ResponseEntity<String> deleteUnit(@PathVariable String code) {
        if (code != null) {
            String message = unitService.deleteUnit(code);
            if (message != null) {
                return new ResponseEntity<>("Unit Deleted Successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Unit Not Deleted Successfully", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
        }
    }
}
