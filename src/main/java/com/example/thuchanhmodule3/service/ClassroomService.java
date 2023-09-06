package com.example.thuchanhmodule3.service;

import com.example.thuchanhmodule3.DAO.ClassroomDAO;
import com.example.thuchanhmodule3.model.Classroom;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ClassroomService implements IGenerateService<Classroom> {

    private static ClassroomService classroomService;

    private ClassroomService() {
    }

    ;

    public static ClassroomService getInstance() {
        if (classroomService == null) {
            classroomService = new ClassroomService();
        }
        return classroomService;
    }

    @Override
    public List<Classroom> findAll() {
        return ClassroomDAO.getInstance().findAll();
    }

    @Override
    public Classroom findOne(HttpServletRequest request) {
        int idClassroom = Integer.parseInt(request.getParameter("idClassroom"));
        return ClassroomDAO.getInstance().findOne(idClassroom);


    }

    @Override
    public void create(HttpServletRequest request) {
        int idClassroom = Integer.parseInt(request.getParameter("idClassroom"));
        String nameClassroom = request.getParameter("nameClassroom");
        Classroom classroom = new Classroom(idClassroom, nameClassroom);
        ClassroomDAO.getInstance().create(classroom);
    }

    @Override
    public void update(HttpServletRequest request) {
        int idClassroom = Integer.parseInt(request.getParameter("idClassroom"));
        String nameClassroom = request.getParameter("nameClassroom");
        Classroom classroom = new Classroom(idClassroom, nameClassroom);
        ClassroomDAO.getInstance().update(classroom);

    }

    @Override
    public void delete(HttpServletRequest request) {
        int idClassroom = Integer.parseInt(request.getParameter("idClassroom"));
        ClassroomDAO.getInstance().delete(idClassroom);

    }
}
