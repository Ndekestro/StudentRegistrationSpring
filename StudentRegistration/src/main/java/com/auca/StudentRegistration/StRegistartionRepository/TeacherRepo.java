package com.auca.StudentRegistration.StRegistartionRepository;

import com.auca.StudentRegistration.StRegistrationModel.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, String> {
}
