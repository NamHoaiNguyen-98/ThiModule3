package com.example.thuchanhmodule3.controller;

import com.example.thuchanhmodule3.model.Classroom;
import com.example.thuchanhmodule3.model.Student;
import com.example.thuchanhmodule3.service.ClassroomService;
import com.example.thuchanhmodule3.service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/students")
public class StudentServlet extends HttpServlet  {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "":
                display(request, response);
                break;
            case "create":
                createGet(request, response);
                break;
            case "update":
                updateGet(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                createPost(request, response);
                break;
            case "update":
                updatePost(request, response);
                break;
            case "search":
                searchByName(request,response);
                break;
        }
    }


    public void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = StudentService.getInstance().findAll();
        request.setAttribute("students",students);
        RequestDispatcher rq = request.getRequestDispatcher("display.jsp");
        rq.forward(request,response);
    }


    public void createGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Classroom> classrooms = ClassroomService.getInstance().findAll();
        request.setAttribute("classrooms", classrooms);
        RequestDispatcher rq = request.getRequestDispatcher("create.jsp");
        rq.forward(request,response);
    }


    public void createPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StudentService.getInstance().create(request);
        response.sendRedirect("/students");
    }


    public void updateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Classroom> classrooms = ClassroomService.getInstance().findAll();
        Student student = StudentService.getInstance().findOne(request);
        request.setAttribute("classrooms", classrooms);
        request.setAttribute("student", student);
        RequestDispatcher rq = request.getRequestDispatcher("update.jsp");
        rq.forward(request,response);
    }


    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StudentService.getInstance().update(request);
        response.sendRedirect("/students");

    }


    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StudentService.getInstance().delete(request);
        response.sendRedirect("/students");
    }
    public void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = StudentService.getInstance().searchByName(request);
        request.setAttribute("students", students);
        RequestDispatcher rq = request.getRequestDispatcher("display.jsp");
        rq.forward(request, response);
    }
}
