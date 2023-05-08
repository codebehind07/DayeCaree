package com.example.daycaree.Teacher;

import ChildDto.ParentChildForm;
import TeacherDto.TeacherForm;
import Utility.Utility;
import com.example.daycaree.Child.Child;
import com.example.daycaree.Child.ChildRepository;
import com.example.daycaree.Child.ChildService;
import com.example.daycaree.Parent.Parent;
import com.example.daycaree.Parent.ParentRepository;
import com.example.daycaree.Users.UserService;
import com.example.daycaree.Users.Users;
import com.example.daycaree.Users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeacherService {

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
    private UsersRepository usersRepository;


    public Teacher saveTeacher(TeacherForm _tcf)
    {
        Integer t = findByFirstnameAndLastname(_tcf.getFirstname(),_tcf.getLastname());
        Utility _ut = new Utility();
        Teacher _t = new Teacher();
        if(t == 0)
        {
            _t.setFirstname(_tcf.getFirstname());
            _t.setLastname(_tcf.getLastname());
            _t.setPhone(_tcf.getPhone());
            _t.setAddress(_tcf.getAddress());
            _t.setEmail(_tcf.getEmail());


            teacherRepository.save(_t);

            Users _u = new Users();
            _u.setUsername(_tcf.getEmail());
            _u.setFirstname(_tcf.getFirstname());
            _u.setSecondname(_tcf.getLastname());
            _u.setLastname(_tcf.getLastname());
            _u.setPassword("password");
            _u.setIsVissible(0);


            String Salt = _ut.getSalt(30);
            String EncPass = _ut.generateSecurePassword(_u.getPassword(),Salt);



            //Encrypt Password
            _u.setSeckey(Salt);
            _u.setPassword(EncPass);

            usersRepository.save(_u);
            return  _t;
        }
        return _t;
    }

    public Integer findByFirstnameAndLastname(String firstname, String lastname){
        return teacherRepository.findByFirstnameAndLastname(firstname, lastname);
    }


    public List<TeacherPrograms> FindAllTeachers(){

        return teacherRepository.FindAllTeachers();
    }
    public List<Teacher> FindAllTeacher(){

        return teacherRepository.FindAllTeacher();
    }
}
