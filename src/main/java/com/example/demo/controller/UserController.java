package com.example.demo.controller;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo.domain.entity.User;
import com.example.demo.service.UserService;

@Controller
/**
 * Acts as a controller for mapping user related services
 * @author Sameera
 *
 */
public class UserController 
{
@Autowired
private UserService u;
		
       /**
        * performs login 
        * @param username gets the username entered by the user
        * @param password gets the password entered by the user
        * @param session sets the username session attribute
        * @param redirectAttributes sets the username attribute for redirecting 
        * @param modelMap sets the error attribute 
        * @return it redirects to '/list' if validation of user is success else return index page with a error message
        */
		@RequestMapping(value = "/log")
		public String login(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpSession session,
			RedirectAttributes redirectAttributes,
			ModelMap modelMap)
		{
			if(u.validate(username,password))
			{
				session.setAttribute("name", username);
				
			    	redirectAttributes.addFlashAttribute("names", username);
				return "redirect:/list";
			} else {
				modelMap.put("error", "Invalid Account");
				return "index.jsp";
			}
		}
		
		/**
		 * Returns signup page
		 * @return signup.jsp
		 */
		@RequestMapping(value = "/signup")
		public String signingup()
		{
			return "signup.jsp";
		}
		
		/**
		 * Logout the user and returns index page
		 * @param session used to remove name attribute
		 * @return index.jsp
		 */
		@RequestMapping(value = "/logout")
		public String logout(HttpSession session)
		{
			session.removeAttribute("name");
			return "index.jsp";
		}
		
		/**
		 * Performs signup
		 * @param us gets the values entered in signup page
		 * @param modelMap sets the error attibute 
		 * @return it redirects to index page when a user account is created else redirect to signup page with a error message
		 */
			@RequestMapping(value = "/sign")
		public String signing(User us,ModelMap modelMap)
	    {
			if(us.getEmail().isEmpty()||us.getName().isEmpty()||us.getPassword().isEmpty()||us.getPassword1().isEmpty()==true)
			{
				
				modelMap.put("error", "Please fill all the fields");	
				return "signup.jsp";	
			}
			if(u.validateName(us.getName())==true) {
				modelMap.put("error", "The username which you have entered is already present,Please try another");	
				return "signup.jsp";	
	
			}
			if(u.validateMail(us.getEmail())==true) {
				modelMap.put("error", "The Email which you have entered is already present,Please try another");	
				return "signup.jsp";	
	
			}
		
			if(us.getPassword().equals(us.getPassword1()))
			{
				
			u.save(us.getName(),us.getEmail(),us.getPassword(),us.getPassword1());
				
			if(u.validate(us.getName(),us.getPassword()))
			{
				
				return "redirect:/";			
			}
			else
			{
				modelMap.put("error", "Invalid username and password");	
				return "signup.jsp";
			}
			}
			else
			{
			modelMap.put("error", "Password does not match");	
			return "signup.jsp";
			}
		}
}
