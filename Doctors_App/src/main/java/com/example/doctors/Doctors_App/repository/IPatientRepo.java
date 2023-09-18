package com.example.doctors.Doctors_App.repository;

import com.example.doctors.Doctors_App.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepo extends JpaRepository<Patient,Integer> {
    @Modifying
    @Query(value = "update patient set patient_Name =:patientName , patient_Email =:patientEmail , patient_Phone_Number =:patientPhoneNumber where patient_id =:patientId",nativeQuery = true)
    void updatePatientById(Integer patientId, String patientName, String patientEmail, String patientPhoneNumber);
}
