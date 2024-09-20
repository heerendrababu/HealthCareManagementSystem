package com.HealthCareDemo.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.HealthCareDemo.dao.AdminDao;
import com.HealthCareDemo.dao.DoctorDao;
import com.HealthCareDemo.model.Doctor;


@Controller
public class DoctorController 
{
	//1) verify doctor email to re-direct to Registration page
     @RequestMapping("verifyEmail")
	 public ModelAndView DoctorRegistration(String email) // it simplifies our code or else /*public ModelAndView verifyEmail(HttpServletRequest request)
	{
                                                                                                               // String email = request.getParameter("email");  
        boolean exists = AdminDao.checkDoctorEmailExists(email);
	    ModelAndView mv = new ModelAndView();

	    if (exists)
	    {
	        mv.setViewName("DoctorRegistration.jsp");
	    }
	    else
	    {
	        mv.addObject("verifyMessage", "Email address not found. Please check and try again.");
	        mv.setViewName("VerifyDocEmail.jsp");
	    }

	    return mv;
	}

	 // Inserting Doctor Details
	 @RequestMapping("insertdoctor")
	 // 1] Reading data from FrontENd 
	 public ModelAndView insertDoctorDetails(HttpServletRequest request) // it will return all data in string format
	 {
		String n = request.getParameter("docName");
		String e = request.getParameter("docEmail");
	    long m = Long.parseLong(request.getParameter("mobile"));
		String pass = request.getParameter("password");
        String gen = request.getParameter("gender");
        String prof = request.getParameter("profession");

			    
	    Doctor d = new Doctor(n,e,m,pass,gen,prof); //2] read data  store it in model
	    // 1st Check if email already exists
	    boolean exists = DoctorDao.checkDoctorEmailExists(e);	    
	     ModelAndView mv = new ModelAndView();
	     if (exists)
	     {
	         mv.addObject("verifyMessage", "Email is already registered.");
	         mv.setViewName("DoctorRegistration.jsp");
	     }
	     // if email not found duplicate then insert new record into table
	     else
	     {
	         DoctorDao.insertDoctorDetails(d);
	         mv.addObject("verifyMessage", "Registration successful.");
	         mv.addObject("showBackToLogin", true); // Indicate successful registration
	         mv.setViewName("DoctorRegistration.jsp");
	     }
		return mv;
	    
	   
	 }
	// Checking doctor login and redirect to "welcomeDoctor.jsp" page
	 @RequestMapping("doctor")
	 public ModelAndView checkDoctorCredentials(String email,String password)
	 {
		 boolean isAuthenticated = DoctorDao.checkDoctorLogin(email, password);
	        ModelAndView mv = new ModelAndView();  
	        if (isAuthenticated) 
	        {
	            mv.setViewName("WelcomeDoctor.jsp"); // Redirect to welcomeDoctor.jsp on successful login
	        }
	        else 
	        {
	            mv.addObject("DoctorloginError", "Invalid email or password. Please try again.");
	            mv.setViewName("Doctor.jsp"); // Redirect to login.jsp on failed login
	        } 
		
		return mv;
		 
	 }
	 
}
