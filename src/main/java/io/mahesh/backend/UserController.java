package io.mahesh.backend;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/patients")
@CrossOrigin
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<Patients> GetPatients() {
        return userRepository.findAll();
    }
    @GetMapping("/{id}")         
    public Patients GetPatient(@PathVariable Integer id) {
        return userRepository.findById(id).orElse(null);
    }
    @PostMapping("/") 
    public Patients PostPatient(@RequestBody Patients patients) {
        return userRepository.save(patients);
    }
    @PutMapping("/")
    public Patients PutPatient(@RequestBody Patients patients) {
        Patients oldUser = userRepository.findById(patients.getId()).orElse(null);
        oldUser.setName(patients.getName());
        oldUser.setEmail(patients.getEmail());
        oldUser.setPhone(patients.getPhone());
        oldUser.setIllness(patients.getIllness());
        oldUser.setDoctor(patients.getDoctor());
        oldUser.setDate(patients.getDate());
        return userRepository.save(oldUser);
    }
    @DeleteMapping("/{id}")
    public Integer DeletePatient(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return id;
    }
} 