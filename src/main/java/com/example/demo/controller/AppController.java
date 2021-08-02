package com.example.demo.controller;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.junit.platform.commons.PreconditionViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo.domain.entity.App;
import com.example.demo.service.AppService;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
/**
 * Acts as a controller for mapping application related services
 * @author Sameera
 *
 */
public class AppController
{
@Autowired
private AppService ap;

   /**
    * Return index page
    * @return it returns index page
    */
	@RequestMapping(value = "/")
	public String home()
	{
		return "index.jsp";
	}
	
	/**
	 * Deletes the todo
	 * @param id unique id to delete todo item
	 * @param redirectAttributes to set attributes for redirecting 
	 * @return redirects to map '/list'
	 * @throws ServiceException on Service error
	 */
	@RequestMapping(value = "/delete/{id}")
	public String deleting(@PathVariable("id")int id,RedirectAttributes redirectAttributes)throws ServiceException
	{
		try
		{
	    ap.delete(id);
		}
		catch(Exception e)
		{
	    throw new ServiceException(e.getMessage());
        }
	redirectAttributes.addFlashAttribute("names",ap.getUname());
	return "redirect:/list";
	}
	
	/**
	 * Sends the edit page
	 * @param id gets the unique id of a todo needs to be edited
	 * @param values gets the value of the todo needs to be edited
	 * @return it returns edit.jsp page
	 */
	@RequestMapping(value="/edit")
	public ModelAndView editing(@RequestParam("id") int id,@RequestParam("val") String values)
	{
    ap.setUpid(id);
	ModelAndView m=new ModelAndView("edit.jsp");
	m.addObject("lvalue",values);
	return m;
	}
	
	/**
	 * Edits the todo
	 * @param tvalue The new todo value entered by the user
	 * @param redirectAttributes to set attributes for redirecting 
	 * @return redirects to map '/list'
	 * @throws ServiceException on service error
	 */
	@RequestMapping(value = "/edit2")
	public String updating(@RequestParam("list") String tvalue,RedirectAttributes redirectAttributes)throws ServiceException
	{
		int t=ap.getUpid();
		try 
		{
		ap.update(t, tvalue);
	    }
		catch(Exception e)
		{
	     throw new ServiceException(e.getMessage());
	     }
    	redirectAttributes.addFlashAttribute("names",ap.getUname());
        return "redirect:/list";
	}
	
	/**
	 * Creates new todo
	 * @param newlist The todo value entered by the user
	 * @param redirectAttributes to set attributes for redirecting 
	 * @return redirects to map '/list'
     * @throws PreconditionViolationException on failing some preconditions
	 * @throws ServiceException on service error
	 */
	@RequestMapping(value = "/create")
	public String creating(@RequestParam("new") String newlist,RedirectAttributes redirectAttributes)throws PreconditionViolationException,ServiceException
	{  
		if(newlist.isEmpty())
		{
			throw new PreconditionViolationException("Todo value should not be null");
		}
		try
	   {
		ap.newT(newlist);
	    }
	    catch(Exception e)
	   {
  	    throw new ServiceException(e.getMessage());
  	    }
    	redirectAttributes.addFlashAttribute("names",ap.getUname());
		return "redirect:/list";
     }
	
	/**
	 * Lists todo items of a particular user
	 * @param model the model object is used to get the attribute which is redirected 
	 * @return it returns view.jsp page
	 */
	@RequestMapping(value = "/list")
	public ModelAndView viewing(Model model)
	{
		String s=(String)model.asMap().get("names");
		ap.setUname(s);
	    List<App> tlist=ap.listing1(s);
		ModelAndView mv=new ModelAndView("view.jsp");
		mv.addObject("list", tlist);
		mv.addObject("user",s);
		return mv;
	}	
}
