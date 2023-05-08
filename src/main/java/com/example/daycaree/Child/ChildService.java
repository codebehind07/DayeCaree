package com.example.daycaree.Child;

import ChildDto.ParentChildForm;
import com.example.daycaree.Bill.Bill;
import com.example.daycaree.Bill.BillRepository;
import com.example.daycaree.Bill.BillService;
import com.example.daycaree.Parent.Parent;
import com.example.daycaree.Parent.ParentRepository;
import com.example.daycaree.Teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildService {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ChildRepository childRepository;


    @Autowired
    private BillRepository billRepository;

    public Long saveChild(ParentChildForm _pcf,Parent p)
    {
       Integer ch = findByFirstnameAndLastname(_pcf.getPFirstname(),_pcf.getPLastname());
        Long cid = Long.valueOf(0);
        Child c = new Child();
        Bill b = new Bill();
        if(ch == 0)
        {
            System.out.println("PID" + p.getParentId());
            c.setFirstname(_pcf.getCFirstname());
            c.setLastname(_pcf.getCLastname());
            c.setDOB(_pcf.getCDOB());
            c.setAddress(_pcf.getCAddress());
            c.setComment(_pcf.getCComment());
            c.setProgam(_pcf.getCProgram());
            c.setIsVissible(0);
            c.setParent(p);

            b.setProgram(_pcf.getCProgram());
            b.setComment(_pcf.getCProgram());
            b.setProgramId(GetProgramId(_pcf.getCProgram()));
            b.setAmount(GetProgramAmt(_pcf.getCProgram()));
            b.setChild(c);
            childRepository.save(c);
            billRepository.save(b);

            cid = c.getChildId();
        }
        System.out.println("cid6" + cid);
        return cid;
    }

    public Integer findByFirstnameAndLastname(String firstname, String lastname)
    {
        return childRepository.findByFirstnameAndLastname(firstname, lastname);
    }

    public List<Child> FindAllChild()
    {
        return childRepository.FindAllChild();
    }

    public  Integer GetProgramId(String Program)
    {
        Integer ProgId = 0;
        if (Program == "WaterColor Painting"){

            return 1;
        } else if (Program == "ParlyHouse & Nursary") {
            return 2;
        }
        else return 3;

    }

    public  Double GetProgramAmt(String Program)
    {
        Double Amt = 0.0;
        if (Program == "WaterColor Painting"){

            return 79.00;
        } else if (Program == "ParlyHouse & Nursary") {
            return 129.00;
        }
        else return 229.00;

    }
}
