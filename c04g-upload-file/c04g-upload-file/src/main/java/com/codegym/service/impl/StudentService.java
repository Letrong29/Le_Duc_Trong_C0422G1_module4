package com.codegym.service.impl;

import com.codegym.model.Student;
import com.codegym.repository.IStudentRepository;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository iStudentRepository;

    @Override
    public Student findById(Integer id) {
        return this.iStudentRepository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return this.iStudentRepository.findAll();
    }

    @Override
    public void save(Student studentObj) {

        // Step 3: Process with File
        try {
            String fileName = studentObj.getImgFile().getOriginalFilename();
            FileCopyUtils.copy(studentObj.getImgFile().getBytes(),
                    new File("D:/up/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.iStudentRepository.save(studentObj);
    }
}
