package com.example.daycaree.Users;

import ChildDto.ParentChildForm;
import com.example.daycaree.Child.Child;
import com.example.daycaree.Child.ChildRepository;
import com.example.daycaree.Login;
import com.example.daycaree.Parent.Parent;
import com.example.daycaree.Parent.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ChildRepository childRepository;


    public Users saveUser(ParentChildForm _pcf)
    {
        Integer ch = findUsersByUsername(_pcf.getPEmail());

        Users u = new Users();
        LocalDate dt ;
        if(ch == 0)
        {

            u.setFirstname(_pcf.getPFirstname());
            u.setLastname(_pcf.getPLastname());
            u.setIsVissible(0);
            u.setPassword(_pcf.getPassword());
            u.setSecondname(_pcf.getPLastname());
            u.setUsername(_pcf.getPEmail());
            u.setSignInDate(LocalDate.now());
            u.setSeckey(_pcf.getSeckey());
            return  usersRepository.save(u);

        }
        return u;
    }


    public Integer findUsersByUsername (String username)
    {
        return usersRepository.findUsersByUsername(username);
    }


    public Users Login (String username, String password)
    {
        return usersRepository.Login(username,password);
    }

    public Users Logins (String username)
    {
        return usersRepository.Logins(username);
    }

}
