package com.example.daycaree;

import ChildDto.ParentChild;
import ChildDto.ParentChildForm;
import ChildDto.UserLogin;
import TeacherDto.TeacherForm;
import Utility.Utility;
import com.example.daycaree.Bill.Bill;
import com.example.daycaree.Bill.BillService;
import com.example.daycaree.Child.Child;
import com.example.daycaree.Child.ChildService;
import com.example.daycaree.ChildGrade.ChildGradeService;
import com.example.daycaree.ChildGrade.ChildParentGrade;
import com.example.daycaree.Parent.Parent;
import com.example.daycaree.Parent.ParentBill;
import com.example.daycaree.Parent.ParentService;
import com.example.daycaree.Teacher.TeacherPrograms;
import com.example.daycaree.Teacher.TeacherRepository;
import com.example.daycaree.Teacher.TeacherService;
import com.example.daycaree.TeacherProgram.TeacherProgramService;
import com.example.daycaree.Users.UserService;
import com.example.daycaree.Users.Users;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.util.List;

import static Utility.Utility.*;

@Controller
public class Login {

    @Autowired
    private UserService _us = new UserService();

    @Autowired
    private ParentService _ps = new ParentService();

    @Autowired
    private ChildService _cs = new ChildService();

    @Autowired
    private TeacherService _ts = new TeacherService();

    @Autowired
    private BillService _bs = new BillService();

    @Autowired
    private TeacherProgramService _tps = new TeacherProgramService();

    @Autowired
    private ChildGradeService _cgs = new ChildGradeService();

    DayCare _dc = new DayCare();
    String user = "";
    final Logger logger = LoggerFactory.getLogger(Login.class);

     Utility _ut = new Utility();

    @PostMapping("/Login")
    public String Login(@Valid @ModelAttribute("_Lg") UserLogin _Lg, BindingResult bindingResult, Model model, HttpSession session)
    {
        try
        {
            System.out.println("get Password"+ _Lg.getPassword());
            System.out.println("get Username"+ _Lg.getUsername());
            String targetUrl = "";
            if (bindingResult.hasErrors())
            {
                model.addAttribute("UserLogin", new UserLogin());
                return "/Login";
            }
            else
            {
                String Pass = _Lg.getPassword();
                System.out.println("Pass" + Pass);
                String Salt = _ut.getSalt(30);
                _Lg.setPassword(_ut.generateSecurePassword(Pass,Salt));
                Users resp = _us.Login(_Lg.getUsername(), _Lg.getPassword());
                //Users resp = _us.Logins(_Lg.getUsername());
                System.out.println("Real Pass"+ Pass);
                System.out.println("Enc Pass"+ _Lg.getPassword());
                System.out.println("Salt"+ Salt);

                System.out.println("Enter Here");
                //This For Encryption fo Password
                
                   if (resp == null || resp.getUsername() == "" )
                {
                    model.addAttribute("UserLogin", new UserLogin());
                    model.addAttribute("Error", "Invalid User ! Pls Try Again ! ");
                    System.out.println("Count" + "loginAttempt");
                    // Number Of Login Count

                    int loginAttempt;
                    if (session.getAttribute("loginCount") == null)
                    {
                        session.setAttribute("loginCount", 0);
                        loginAttempt = 0;
                    }
                    else
                    {
                        loginAttempt = (Integer) session.getAttribute("loginCount");
                    }

                    System.out.println("Enter Paas" + loginAttempt);
                    if (loginAttempt >3)
                    {

                        long lastAccessedTime = session.getLastAccessedTime();
                        Date date = new Date();
                        long currentTime = date.getTime();
                        long timeDiff = currentTime - lastAccessedTime;
                        // 20 minutes in milliseconds
                        if (timeDiff >= 1200000)
                        {
                            //invalidate user session, so they can try again
                            session.invalidate();
                        }
                        else
                        {
                            // Error message
                            model.addAttribute("Email","You have exceeded the 3 failed login attempt. Please try loggin in in 20 minutes, or call our customer service center at 1-800 555-1212.");
                        }

                        model.addAttribute("Email", "Please check your email for password reset");
                        return "/Login";
                    }
                    else

                    {
                        loginAttempt++;
                        int allowLogin = 3-loginAttempt;
                        model.addAttribute("message","loginAttempt= "+loginAttempt+". Invalid username or password. You have "+allowLogin+" attempts remaining. Please try again! <br>Not a registered cusomer? Please <a href=\"register.jsp\">register</a>!");
                    }

               boolean Valid = _ut.verifyUserPassword(_Lg.getPassword(),resp.getPassword(),resp.getSeckey());
               // System.out.println("Valid" + Valid);
                System.out.println("Enter Paas" + _Lg.getPassword());
                System.out.println("Password Enc" + resp.getPassword());
                System.out.println("Sec Key" + resp.getSeckey());
              //  if(Valid == true) {
                    session.setAttribute("username", resp.getUsername());
                    if (resp.getUserId() == 1) {
                        System.out.println("Level 1" + resp.getUserId());
                        targetUrl = "/PBill";

                    } else if (resp.getUserId() == 52) {
                        System.out.println("Level 2" + resp.getUserId());
                        targetUrl = "/Admin";
                    } else if (resp.getUserId() == 3) {
                        System.out.println("Level 3" + resp.getUserId());
                        targetUrl = "/Bill";
                    }
                }
                return "redirect:" + targetUrl;
           // }
        }
        catch (Exception ex){
            logger.debug(ex.getMessage());
            return ex.getMessage();
        }
    }

    public String getUsername(Model model,HttpSession session){
        try
        {
            user = (String) session.getAttribute("username");
            model.addAttribute("user", user);
            System.out.println("user" + user);
            return user;
        }
        catch (Exception ex)
        {
            logger.debug(ex.getMessage());
            return ex.getMessage();
        }
    }

   /* @GetMapping("/PBills")
    public String PBills(Model model,HttpSession session)
    {
        try
        {
            user = (String) session.getAttribute("username");
            model.addAttribute("user", user);
            return "PBills";
        }
        catch (Exception ex)
        {
          return   ex.getMessage();
        }
    }*/

    @GetMapping("/Admin")
    public String Admin(Model model,HttpSession session)
    {
        try {
            user = (String) session.getAttribute("username");
            model.addAttribute("user", user);

            return "/Admin/Admin";
        }
        catch (Exception ex)
        {
            logger.debug(ex.getMessage());
            return ex.getMessage();
        }
    }

    @GetMapping("/Bills")
    public String Bills(Model model,HttpSession session)
    {
        try {


                user = (String) session.getAttribute("username");
                model.addAttribute("user", user);
                List<ParentBill> PBill = _bs.FindParentBill();
                model.addAttribute("Bill", PBill);
                return "/Admin/Bill";
            }
        catch (Exception ex){
            logger.debug(ex.getMessage());
         return    ex.getMessage();
        }

    }

    @GetMapping("/Childs")
    public String Childs(Model model,HttpSession session)
    {
        try {


            user = (String) session.getAttribute("username");
            model.addAttribute("user", user);
            List<Child> child = _cs.FindAllChild();
            model.addAttribute("child", child);
            return "/Admin/Child";
        }
        catch (Exception ex)
        {
            logger.debug(ex.getMessage());
            return ex.getMessage();
        }
    }

    @GetMapping("/Parents")
    public String Parents(Model model,HttpSession session)
    {
        try {
            user = (String) session.getAttribute("username");
            model.addAttribute("user", user);
            List<Parent> parents = _ps.FindAllParent();

            model.addAttribute("parents", parents);
            return "/Admin/Parent";
        }
        catch (Exception ex)
        {
            logger.debug(ex.getMessage());
            return ex.getMessage();
        }
    }

    @GetMapping("/Reports")
    public String Reports(Model model,HttpSession session)
    {
        try {
            user = (String) session.getAttribute("username");
            model.addAttribute("user", user);
            List<ChildParentGrade> CP = _cgs.FindAllChildGrade();

            model.addAttribute("ChildBill", CP);
            return "/Admin/Report";
        }
        catch (Exception ex){
            logger.debug(ex.getMessage());
            return ex.getMessage();
        }
    }

    @GetMapping("/Teachers")
    public String Teachers(Model model,HttpSession session)
    {
        try {
            user = (String) session.getAttribute("username");
            model.addAttribute("user", user);
            List<TeacherPrograms> teacher = _ts.FindAllTeachers();

            model.addAttribute("teacher", teacher);

            return "/Admin/Teacher";
        }
        catch (Exception ex){
            logger.debug(ex.getMessage());
          return   ex.getMessage();
        }
    }


    public String GetRole()
    {

        return "";
    }

    public Integer Validate()
    {
        return 0;
    }

    @GetMapping("/PBill")
    public String PBill(Model model,HttpSession session)
    {
        try
        {
            user = (String) session.getAttribute("username");
            model.addAttribute("user", user);
            List<ParentBill> Bill =  _bs.FindParentChildBill(user);
            model.addAttribute("Bill",Bill);
            return "/Parent/PBill";
        }
        catch (Exception ex)
        {
            logger.debug(ex.getMessage());
            return   ex.getMessage();
        }
    }


    @GetMapping("/PChild")
    public String PAddChild(Model model,HttpSession session)
    {
        try
        {
            user = (String) session.getAttribute("username");
            model.addAttribute("user", user);
            model.addAttribute("Pcf", new ParentChildForm());
            return "/Parent/AddChild";
        }
        catch (Exception ex)
        {
            logger.debug(ex.getMessage());
            return   ex.getMessage();
        }
    }

    @GetMapping("/PChild")
    public String PChild(Model model,HttpSession session)
    {
        try
        {
            user = (String) session.getAttribute("username");
            model.addAttribute("user", user);
            List<ParentChild> PBill =  _bs.FindParentChild(user);
            model.addAttribute("PC",PBill);
            return "/Parent/PChild";
        }
        catch (Exception ex)
        {
            logger.debug(ex.getMessage());
            return ex.getMessage();
        }
    }


    // @RequestMapping("/logout")
    @RequestMapping(value = "/SignOut")
        public String logout(HttpSession session)
    {
        if (session != null) {
            session.invalidate();
        }

        return "redirect:/";

    }


}
