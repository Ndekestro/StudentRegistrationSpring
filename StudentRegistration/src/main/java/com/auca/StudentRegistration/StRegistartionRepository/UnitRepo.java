package com.auca.StudentRegistration.StRegistartionRepository;

import com.auca.StudentRegistration.StRegistrationModel.AcademicUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepo extends JpaRepository<AcademicUnit,String> {
}
