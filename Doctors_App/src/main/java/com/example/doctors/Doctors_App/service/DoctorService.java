package com.example.doctors.Doctors_App.service;

import com.example.doctors.Doctors_App.model.Doctor;
import com.example.doctors.Doctors_App.repository.IDoctorRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private IDoctorRepo iDoctorRepository;

    public String saveDoctor(Doctor doctorObj) {
        iDoctorRepository.save(doctorObj);
        return "Doctor added successfully!!";
    }

    public List<Doctor> getDoctorAll() {
        return iDoctorRepository.findAll();
    }
    @Transactional
    public String deleteDoctorById(Integer id) {
        iDoctorRepository.deleteDoctor(id);
        return "Doctor deleted successfully!!";
    }
    @Transactional
    public String updateDoctorById(Doctor doctorObj) {
        iDoctorRepository.updateDoctor(doctorObj.getDoctorId(),doctorObj.getDoctorName(),doctorObj.getEmail(),doctorObj.getPhoneNumber());
        return "Doctor Updated successfully!!";
    }
}
