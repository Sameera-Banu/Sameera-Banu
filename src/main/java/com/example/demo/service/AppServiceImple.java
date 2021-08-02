package com.example.demo.service;
import java.util.*;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.domain.entity.App;
import com.example.demo.domain.repository.AppRepo;

@Service
@Transactional
/**
 * Implements the AppService Interface
 * @author Sameera
 */
public class AppServiceImple implements AppService
{
	@Autowired  
    private AppRepo repot;
	public int upid;
	public String uname;
	
	@Override
	public String getUname()
	{
		return uname;
	}
	
	@Override
	public void setUname(String uname) 
	{
		this.uname = uname;
	}
	
	@Override
	public int getUpid()
	{
		return upid;
	}
	
    @Override
	public void setUpid(int upid) 
    {
		this.upid = upid;
	}

    @Override
	public void newT(String n)throws ServiceException
    {
         App t=new App();
	     t.setTlist(n);
	     t.setTname(uname);
	     try
	      {
	      repot.save(t);
	      }
	      catch(Exception e)
	      {
	    	  throw new ServiceException(e.getMessage());
	      }
	}

   @Override
	public void delete(int id) throws ServiceException
	{
		try
		{
		 repot.deleteById(id);
		}
		catch(Exception e)
	      {
	     throw new ServiceException(e.getMessage());
          }	
	}

    @Override
	public void update(int get, String set)throws ServiceException 
    {
	       App s=repot.findById(get).orElse(null);
	       s.setTlist(set);
	       try
	       {
	       repot.save(s);
	       }
	       catch(Exception e)
	       {
		    throw new ServiceException(e.getMessage());
           }
     }

     @Override
	public List<App> listing1(String s) 
     {
		return repot.listing(s);
	 }
}
