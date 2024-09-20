package com.HealthCareDemo.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.HealthCareDemo.model.DocVerify;
import com.HealthCareDemo.dao.AdminDao;

@Controller
public class AdminController {
    @RequestMapping("adminlogin")
    public ModelAndView insertAdminDetails(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String e = request.getParameter("tbEmail"); 
        String p = request.getParameter("tbPass");

        boolean result = AdminDao.checkAdminLogin(e, p);

        if (result) {
            // If admin details are correct, use the same "Admin.jsp" page but indicate that the admin is logged in.
            mv.addObject("isLoggedIn", true); // Add this attribute to indicate the login status.
            mv.setViewName("Admin.jsp");
        } else {
            mv.addObject("ErrorMessage", "False information, please enter the right credentials.");
            mv.setViewName("Admin.jsp");
        }
        return mv;
    }
    
    // Entering doctor mail_id's & names
	 @RequestMapping(value = "adminpage" , params = "Ddetails")
    public ModelAndView DocVerify(HttpServletRequest req)
    {
    	ModelAndView mv = new ModelAndView();
    	 // mv.addObject("Dverify",dverify); // getAttribute uses("variable", object);
		  mv.setViewName("Dverify.jsp");
		return mv;	
    }
	  @RequestMapping("addDoctorDetails")
	    public ModelAndView addDoctorDetails(HttpServletRequest request) {
	        ModelAndView mv = new ModelAndView();
	        String name = request.getParameter("doctorName");
	        String email = request.getParameter("doctorEmail");

	        // Check if email already exists
	        if (AdminDao.checkDoctorEmailExists(email)) {
	            // If email exists, set error message and forward to JSP page
	            mv.addObject("errorMessage", "Email already exists. Please use a different email.");
	            mv.setViewName("Dverify.jsp");
	        } else {
	            // Insert doctor details into the database
	            AdminDao.insertDoctorVerifyDetails(name, email);
	            // Set success message and forward to JSP page
	            mv.addObject("successMessage", "Doctor details inserted successfully.");
	            mv.setViewName("Dverify.jsp");
	        }

	        return mv;
	    }
	}
