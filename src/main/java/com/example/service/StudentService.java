package com.example.service;

import com.example.dto.StudentInfoDto;

public interface StudentService {

    StudentInfoDto getStudentInfo();

    StudentInfoDto getStudentInfo(String name);

    StudentInfoDto getStudentInfo(String name, String studentCode);

    StudentInfoDto getStudentInfo(StudentInfoDto studentInfoDto);
}
