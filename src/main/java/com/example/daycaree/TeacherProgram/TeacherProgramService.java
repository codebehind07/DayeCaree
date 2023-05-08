package com.example.daycaree.TeacherProgram;

import AssignProgram.AssignProgram;
import TeacherDto.TeacherForm;
import com.example.daycaree.Child.ChildRepository;
import com.example.daycaree.Child.ChildService;
import com.example.daycaree.Parent.ParentRepository;
import com.example.daycaree.Teacher.Teacher;
import com.example.daycaree.Teacher.TeacherRepository;
import com.example.daycaree.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherProgramService {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ChildService _cs;

    @Autowired
    private UserService _us;

    @Autowired
    private TeacherProgramRepository teacherProgramRepository;


    public TeacherProgram saveTeacherProgram(AssignProgram _ap)
    {

        Teacher teacher = teacherRepository.findByTeacherId(_ap.getTeacherId());
        System.out.println("TID" + teacher.getTeacherId());
        TeacherProgram _tp = new TeacherProgram();
         if(teacher.getTeacherId() > 0) {
             _tp.setProgram(_ap.getProgram());
             _tp.setComment(_ap.getComment());
             _tp.setTeacher(teacher);

             teacherProgramRepository.save(_tp);

             return _tp;
         }
        return _tp;
    }
}
