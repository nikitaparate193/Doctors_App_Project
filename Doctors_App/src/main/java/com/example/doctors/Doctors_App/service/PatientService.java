package com.example.doctors.Doctors_App.service;

import com.example.doctors.Doctors_App.model.Doctor;
import com.example.doctors.Doctors_App.model.Patient;
import com.example.doctors.Doctors_App.repository.IDoctorRepo;
import com.example.doctors.Doctors_App.repository.IPatientRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private IPatientRepo iPatientRepository;
    @Autowired
    private IDoctorRepo doctorRepository;
    public String addPatient(Patient patientObj) {
        Integer doctorId = patientObj.getDoctor().getDoctorId();
        Doctor doctorObject = doctorRepository.getReferenceById(doctorId);
        patientObj.setDoctor(doctorObject);
        iPatientRepository.save(patientObj);
        return "Patient added successfully!!";
    }

    public List<Patient> getPatient() {
        return iPatientRepository.findAll();
    }

    public String deletePatientById(Integer id) {
        iPatientRepository.deleteById(id);
        return "Patient deleted successfully!!";
    }
    @Transactional
    public String updatePatientById(Patient patientObj) {
        iPatientRepository.updatePatientById(patientObj.getPatientId(),patientObj.getPatientName(),patientObj.getPatientEmail(),patientObj.getPatientPhoneNumber());
        return "Patient deleted successfully!!";
    }
}
