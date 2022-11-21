package com.example.service.impl;

import com.example.dto.StudentInfoDto;
import com.example.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public StudentInfoDto getStudentInfo() {
        StudentInfoDto studentInfoDto = new StudentInfoDto();
        studentInfoDto.setStudentCode("11111");
        studentInfoDto.setName("张三");
        studentInfoDto.setAge(18);
        studentInfoDto.setSex("男");
        studentInfoDto.setAddress("重庆市巴南区白鹤村19号");
        return studentInfoDto;
    }

    @Override
    public StudentInfoDto getStudentInfo(String name) {
        StudentInfoDto studentInfoDto = new StudentInfoDto();
        studentInfoDto.setStudentCode("11111");
        studentInfoDto.setName(name);
        studentInfoDto.setAge(18);
        studentInfoDto.setSex("男");
        studentInfoDto.setAddress("重庆市巴南区白鹤村19号");
        return studentInfoDto;
    }

    @Override
    public StudentInfoDto getStudentInfo(String name, String studentCode) {
        StudentInfoDto studentInfoDto = new StudentInfoDto();
        studentInfoDto.setStudentCode(studentCode);
        studentInfoDto.setName(name);
        studentInfoDto.setAge(18);
        studentInfoDto.setSex("男");
        studentInfoDto.setAddress("重庆市巴南区白鹤村19号");
        return studentInfoDto;
    }

    @Override
    public StudentInfoDto getStudentInfo(StudentInfoDto studentInfoDto) {
        return studentInfoDto;
    }
}
