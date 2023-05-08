package com.example.daycaree.Parent;

import ChildDto.ParentChild;
import ChildDto.ParentChildForm;
import com.example.daycaree.Bill.BillService;
import com.example.daycaree.Child.Child;
import com.example.daycaree.Child.ChildRepository;
import com.example.daycaree.Child.ChildService;
import com.example.daycaree.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private ChildService _cs;

    @Autowired
    private UserService _us;

    @Autowired
    private BillService _bs;
    public Parent saveParent(ParentChildForm _pcf)
    {
        Integer cp = findByFirstnameAndLastname(_pcf.getPFirstname(),_pcf.getPLastname());
        Child child = new Child();
        Parent p = new Parent();
        Child c = new Child();
        if(cp == 0)
        {
            p.setFirstname(_pcf.getPFirstname());
            p.setLastname(_pcf.getPLastname());
            p.setPhone(_pcf.getPPhone());
            p.setAddress(_pcf.getPAddress());
            p.setEmail(_pcf.getPEmail());
            p.setComment(_pcf.getPComment());
            p.setIsVissible(0);

            parentRepository.save(p);
            _cs.saveChild(_pcf,p);
           // _bs.saveBill(_pcf,p);
            _us.saveUser(_pcf);

            return  p;
        }
        return p;
    }

    public Integer findByFirstnameAndLastname(String firstname, String lastname){
        return parentRepository.findByFirstnameAndLastname(firstname, lastname);
    }

    public List<Parent> FindAllParent(){

        return parentRepository.FindAllParent();
    }

    public List<ParentChild> FindParentChild()
    {
        return childRepository.FindParentChild();
    }

}
