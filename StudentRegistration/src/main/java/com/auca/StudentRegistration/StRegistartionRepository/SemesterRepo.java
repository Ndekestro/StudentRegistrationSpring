package com.auca.StudentRegistration.StRegistartionRepository;

import com.auca.StudentRegistration.StRegistrationModel.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterRepo extends JpaRepository<Semester, String> {
}
