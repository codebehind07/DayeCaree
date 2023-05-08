package com.example.daycaree.Bill;

import ChildDto.ParentChild;
import ChildDto.ParentChildForm;
import com.example.daycaree.Child.Child;
import com.example.daycaree.Child.ChildRepository;
import com.example.daycaree.Child.ChildService;
import com.example.daycaree.Parent.Parent;
import com.example.daycaree.Parent.ParentBill;
import com.example.daycaree.Parent.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ChildService _cs;

    public List<Bill> FindAllBill(){
        return billRepository.FindAllBill();
    }

    public Bill saveBill(ParentChildForm _pcf,Parent p)
    {
            Child c = new Child();
            Long bs = _cs.saveChild(_pcf,p);
            //c = childRepository.findByChildId(bs);
            System.out.println("bs"+bs);
            Bill b = new Bill();
            b.setProgram(_pcf.getCProgram());
            b.setComment(_pcf.getCProgram());
            b.setProgramId(GetProgramId(_pcf.getCProgram()));
            b.setAmount(GetProgramAmt(_pcf.getCProgram()));
            b.setChild(c);
            billRepository.save(b);

            return  b;

    }

    public List<ParentBill> FindParentBill()
    {
        return billRepository.FindParentBill();
    }

    public List<ParentBill> FindParentChildBill(String username)
    {
        return billRepository.FindParentChildBill(username);
    }

    public List<ParentChild> FindParentChild(String username)
    {
        return billRepository.FindParentChild(username);
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
