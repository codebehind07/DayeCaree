package com.example.daycaree.ChildGrade;

import AssignProgram.AssignProgram;
import ChildGrades.ChildGrades;
import com.example.daycaree.Child.Child;
import com.example.daycaree.Child.ChildRepository;
import com.example.daycaree.Child.ChildService;
import com.example.daycaree.Teacher.Teacher;
import com.example.daycaree.Teacher.TeacherRepository;
import com.example.daycaree.TeacherProgram.TeacherProgram;
import com.example.daycaree.TeacherProgram.TeacherProgramRepository;
import com.example.daycaree.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildGradeService {


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

    @Autowired
    private ChildGradeRepository childGradeRepository;


    public ChildGrade saveChildGrade(ChildGrades _cg)
    {

        Child child = childRepository.findByChildId(_cg.getChildId());
        System.out.println("TID" + child.getChildId());
        ChildGrade _cga = new ChildGrade();
        if(child.getChildId() > 0)

        {
            _cga.setChildId(_cg.getChildId());
            _cga.setComment(_cg.getComment());
            _cga.setGrade(_cg.getGrade());
            _cga.setProgramId(_cg.getProgramId());
            _cga.setChild(child);

            childGradeRepository.save(_cga);

            return _cga;
        }
        return _cga;
    }

 public List<ChildParentGrade> FindAllChildGrade(){
        return childGradeRepository.FindAllChildGrade();
 }

}
