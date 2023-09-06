package com.example.thuchanhmodule3.service;

import com.example.thuchanhmodule3.DAO.StudentDAO;
import com.example.thuchanhmodule3.model.Classroom;
import com.example.thuchanhmodule3.model.Student;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;


public class StudentService implements IGenerateService<Student> {

    private static StudentService studentService;

    private StudentService() {
    }

    ;

    public static StudentService getInstance() {
        if (studentService == null) {
            studentService = new StudentService();
        }
        return studentService;
    }

    @Override
    public List<Student> findAll() {
        return StudentDAO.getInstance().findAll();
    }

    @Override
    public Student findOne(HttpServletRequest request) {
        int idStudent = Integer.parseInt(request.getParameter("idStudent"));
        return StudentDAO.getInstance().findOne(idStudent);
    }

    @Override
    public void create(HttpServletRequest request) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        LocalDate dob = LocalDate.parse(request.getParameter("dob"));
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        Classroom classroom = ClassroomService.getInstance().findOne(request);
        Student student = new Student(name, email, dob, address, phoneNumber, classroom);
        StudentDAO.getInstance().create(student);
    }

    @Override
    public void update(HttpServletRequest request) {
        int idStudent = Integer.parseInt(request.getParameter("idStudent"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        LocalDate dob = LocalDate.parse(request.getParameter("dob"));
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        Classroom classroom = ClassroomService.getInstance().findOne(request);
        Student student = new Student(idStudent, name, email, dob, address, phoneNumber, classroom);
        StudentDAO.getInstance().update(student);
    }

    @Override
    public void delete(HttpServletRequest request) {
        int idStudent = Integer.parseInt(request.getParameter("idStudent"));
        StudentDAO.getInstance().delete(idStudent);

    }
    public List<Student> searchByName(HttpServletRequest request) {
        String search = request.getParameter("search");
        request.setAttribute("search",search);
        return StudentDAO.getInstance().searchByName(search);
    }

}
