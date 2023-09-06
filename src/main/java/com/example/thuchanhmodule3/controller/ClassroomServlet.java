package com.example.thuchanhmodule3.controller;

import com.example.thuchanhmodule3.model.Classroom;
import com.example.thuchanhmodule3.service.ClassroomService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClassroomServlet", value = "/classrooms")
public class ClassroomServlet extends HttpServlet {

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
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                createPost(request, response);
                break;
        }
    }


    public void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Classroom> classrooms = ClassroomService.getInstance().findAll();
        request.setAttribute("classrooms", classrooms);
        RequestDispatcher rq = request.getRequestDispatcher("displayClassroom.jsp");
        rq.forward(request,response);
    }


    public void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rq = request.getRequestDispatcher("createClassroom.jsp");
        rq.forward(request,response);
    }


    public void createPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ClassroomService.getInstance().create(request);
        response.sendRedirect("/classrooms");
    }



}
