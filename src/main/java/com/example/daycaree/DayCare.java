package com.example.daycaree;

import AssignProgram.AssignProgram;
import ChildDto.ParentChild;
import ChildDto.ParentChildForm;
import ChildDto.UserLogin;
import ChildGrades.ChildGrades;
import TeacherDto.TeacherForm;
import Utility.Utility;
import com.example.daycaree.Bill.Bill;
import com.example.daycaree.Bill.BillService;
import com.example.daycaree.Child.Child;
import com.example.daycaree.Child.ChildService;
import com.example.daycaree.ChildGrade.ChildGrade;
import com.example.daycaree.ChildGrade.ChildGradeService;
import com.example.daycaree.ChildGrade.ChildParentGrade;
import com.example.daycaree.Parent.Parent;
import com.example.daycaree.Parent.ParentBill;
import com.example.daycaree.Parent.ParentService;
import com.example.daycaree.Teacher.Teacher;
import com.example.daycaree.Teacher.TeacherPrograms;
import com.example.daycaree.Teacher.TeacherService;
import com.example.daycaree.TeacherProgram.TeacherProgram;
import com.example.daycaree.TeacherProgram.TeacherProgramService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static Utility.Utility.*;

@Controller
public class DayCare {
    @Autowired
    private ParentService _ps = new ParentService();

    @Autowired
    private ChildService  _cs = new ChildService();

    @Autowired
    private TeacherService  _ts = new TeacherService();

    @Autowired
    private BillService _bs = new BillService();

    @Autowired
    private TeacherProgramService _tps = new TeacherProgramService();

    @Autowired
    private ChildGradeService _cgs = new ChildGradeService();

    String user = "";


    final Logger logger = LoggerFactory.getLogger(DayCare.class);
    @GetMapping("/")
    public String Index(Model model, ParentChildForm _PCF) {
        try
        {
            logger.debug("Application Started");
            model.addAttribute("ParentChildForm", new ParentChildForm());

            return "index";
        }
        catch (Exception ex){
            logger.debug(ex.getMessage());
            return ex.getMessage();
        }

    }

    @GetMapping("/Login")
    public String Login(Model model,HttpSession session)
    {
        try
        {

            //session.invalidate();
            user = (String) session.getAttribute("username");
            System.out.println(user);
            if(user != null)
            {
                return "redirect:/";
            }
            model.addAttribute("UserLogin", new UserLogin());

            return "Login";
        }
        catch (Exception ex)
        {
            logger.debug(ex.getMessage());
            return ex.getMessage();
        }
    }

    @GetMapping("/Dashboard")
    public String Dashboard() {
        try
        {
            return "Teacher";
        }
        catch (Exception ex)
        {
            logger.debug(ex.getMessage());
            return ex.getMessage();
        }


    }

    @GetMapping("/Child")
    public String Child(Model model, HttpSession session)
    {
            try
            {

                user = (String) session.getAttribute("username");
                model.addAttribute("user", user);
                List<Child> child = _cs.FindAllChild();
                model.addAttribute("child", child);

                return "Child";
            }
            catch (Exception ex){
                logger.debug(ex.getMessage());
                return ex.getMessage();
            }

    }

    /*@GetMapping("/PChild")
    public String PChild(Model model) {

        List<ParentChild> ParentChild =  _ps.FindParentChild();
        model.addAttribute("PC",ParentChild);

        return "PChild";

    }*/

    @GetMapping("/PBills")
    public String PBill(Model model,HttpSession session) {
        try
        {

            user = (String) session.getAttribute("username");
            model.addAttribute("user", user);
            List<ParentBill> PBill = _bs.FindParentBill();
            model.addAttribute("Bill", PBill);

            return "PBills";
        }
        catch (Exception ex){
           logger.debug(ex.getMessage());
           return ex.getMessage();
        }
    }

    @GetMapping("/Parent")
    public String Parent(Model model,HttpSession session)
    {
        try
        {
            user = (String) session.getAttribute("username");
            model.addAttribute("user", user);
            List<Parent> parents = _ps.FindAllParent();

            model.addAttribute("parents", parents);

            return "Parent";
        }
catch (Exception ex)
{
            logger.debug(ex.getMessage());
            return ex.getMessage();
}
    }
    @GetMapping("/Report")
    public String Report(Model model,HttpSession session)
    {
        try
        {
            user = (String) session.getAttribute("username");
            model.addAttribute("user", user);
            List<ChildParentGrade> CP = _cgs.FindAllChildGrade();

            model.addAttribute("Bill", new Bill());
            model.addAttribute("ChildBill", CP);

            return "Report";
        }
        catch (Exception ex){
            logger.debug(ex.getMessage());
            return ex.getMessage();
        }

    }

    @GetMapping("/Teacher")
    public String Teacher(Model model,HttpSession session)
    {
        try
        {
            user = (String) session.getAttribute("username");
            model.addAttribute("user", user);
            List<TeacherPrograms> teacher = _ts.FindAllTeachers();
            model.addAttribute("teacher", teacher);

            return "Teacher";
        }
        catch (Exception ex){
            logger.debug(ex.getMessage());
            return ex.getMessage();
        }
    }
    @GetMapping("/users-profile")
    public String Profile(HttpSession session,Model model)
    {
        try
        {
            user = (String) session.getAttribute("username");
            model.addAttribute("user", user);
            return "users-profile";
        }
        catch (Exception ex)
        {
            logger.debug(ex.getMessage());
            return ex.getMessage();
        }
    }

    @GetMapping("/AddTeacher")
    public String AddTeacher(Model model,HttpSession session) {
        try
        {
            user = (String) session.getAttribute("username");
            model.addAttribute("user", user);
            model.addAttribute("TeacherForm", new TeacherForm());
            return "AddTeacher";
        }
        catch (Exception ex){
            logger.debug(ex.getMessage());
            return ex.getMessage();
        }
    }
    @GetMapping("/AssignTeacher")
    public String AssignTeacher(Model model,HttpSession session)
    {
        try
        {
            user = (String) session.getAttribute("username");
            model.addAttribute("user", user);
            model.addAttribute("AssignProgram", new AssignProgram());
            model.addAttribute("Teacher", _ts.FindAllTeacher());

            return "AssignTeacher";
        }
        catch (Exception ex)
        {
            logger.debug(ex.getMessage());
            return ex.getMessage();
        }
    }

    @GetMapping("/AddGrade")
    public String AddGrade(Model model,HttpSession session) {
         try{
        user = (String) session.getAttribute("username");
             model.addAttribute("user", user);
        model.addAttribute("ChildGrades", new ChildGrades());
        model.addAttribute("Child", _cs.FindAllChild());

        return "AssignGrade";
         }
         catch (Exception ex){
             logger.debug(ex.getMessage());
             return ex.getMessage();
         }
    }

    // Display Bill into the Bill page
    @GetMapping("/Bill")
    public String Bill(Model model,HttpSession session)
    {
        try
        {

        user = (String) session.getAttribute("username");
        model.addAttribute("user", user);
        List<ChildParentGrade> CP = _cgs.FindAllChildGrade();
        for(int i=0;i>=CP.size();i++)
        {
            System.out.println("PF"+ CP.get(i).getPFristname());
        }
        model.addAttribute("Bill", new Bill());
        model.addAttribute("ChildBill" ,CP);

        return "Bill";
        }
        catch (Exception ex)
        {
            logger.debug(ex.getMessage());
            return ex.getMessage();
        }
    }

    //Create Parent and CHild into the database with Encrypted Password
    @PostMapping("/Enroll")
    public String Enroll(@Valid @ModelAttribute("ParentChildForm") ParentChildForm _pcf, BindingResult bindingResult,Model model)
    {
        try
        {

            Utility _ut = new Utility();
            System.out.println(_pcf);

            if (bindingResult.hasErrors())
            {
                System.out.println("Enter here");
                return "index";
            }
            else
            {
                System.out.println("Enter here");
                String plainText = _pcf.getPassword();
                String Salt = _ut.getSalt(30);
                String EncPass = _ut.generateSecurePassword(plainText,Salt);
                System.out.println("Seckey" + EncPass);
                System.out.println("Salt"+ Salt);


                //Create Parent and CHild into the database
                _pcf.setSeckey(Salt);
                _pcf.setPassword(EncPass);
                Parent p = _ps.saveParent(_pcf);
                String Messg = "Registration Complete ! Pls Login to track Information";
                model.addAttribute("Message",Messg);
                return "index";
            }

      //  return "redirect:/";
        }
        catch (Exception ex)
        {
            logger.debug(ex.getMessage());
            return ex.getMessage();
        }
    }

    // Add Teacher Into The Database
    @PostMapping("/AddTeacher")
    public String AddTeacher(@Valid TeacherForm _tcf, Model model)
    {
        try
        {
        Teacher t = _ts.saveTeacher(_tcf);

       // return "/AddTeacher.html";
        return "redirect:/AddTeacher";
        }
        catch (Exception ex)
        {
            logger.debug(ex.getMessage());
            return ex.getMessage();
        }
    }


    // Add Teacher Into The Database
    @PostMapping("/AddChild")
    public String AddChild(@Valid ParentChildForm _pcf, Model model)
    {
        try
        {
            Child c = new Child();

            c.setIsVissible(0);
          //  c.se

            // return "/AddTeacher.html";
            return "redirect:/AddTeacher";
        }
        catch (Exception ex)
        {
            logger.debug(ex.getMessage());
            return ex.getMessage();
        }
    }

    // Assign Teacher To a Program
    @PostMapping("/AssignTeacher")
    public String AssignTeacher(@Valid AssignProgram _ap, Model model)
    {
        try
        {
        TeacherProgram tp = _tps.saveTeacherProgram(_ap);
        //return "AssignTeacher";
        return "redirect:/AssignTeacher";
        }
        catch (Exception ex)
        {
            logger.debug(ex.getMessage());
            return ex.getMessage();
        }
    }

    // Assign Grade To a Student
    @PostMapping("/AssignGrade")
    public String AssignGrade(@Valid ChildGrades _cg, Model model)
    {
        try
        {
        ChildGrade cg = _cgs.saveChildGrade(_cg);
       //return "AssignGrade";
        return "redirect:/AddGrade";
        }
        catch (Exception ex)
        {
            logger.debug(ex.getMessage());
            return ex.getMessage();
        }
    }

    @RequestMapping(value = "/SignOuts")
    public String Logout(Model model,HttpSession session)
    {
        try
        {
            Login _L = new Login();
            _L.logout(session);
             return "redirect:/";
        }
        catch (Exception ex)
        {
            logger.debug(ex.getMessage());
            return ex.getMessage();
        }
    }



}
