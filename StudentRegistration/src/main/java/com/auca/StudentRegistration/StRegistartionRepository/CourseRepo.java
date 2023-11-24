package com.auca.StudentRegistration.StRegistartionRepository;

import com.auca.StudentRegistration.StRegistrationModel.AcademicUnit;
import com.auca.StudentRegistration.StRegistrationModel.Course;
import com.auca.StudentRegistration.StRegistrationModel.CourseDefinition;
import com.auca.StudentRegistration.StRegistrationModel.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {
    boolean existsByDepartmentAndSemester(AcademicUnit department, Semester semester);
    public boolean existsByCourseDefinition(CourseDefinition courseDefinition);
    List<Course> findByDepartmentAndSemester(AcademicUnit department, Semester semester);

}
