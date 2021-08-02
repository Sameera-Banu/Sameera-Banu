package com.example.demo.service;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.domain.repository.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.domain.entity.User;

@Service
@Transactional
/**
 * Implements UserService interface
 * @author Sameera
 *
 */
public class UserServiceImple implements UserService
{
 @Autowired
 private UserRepo repo;
	  
	@Override
	public void save(String na, String ema, String pa,String pa1)throws ServiceException
	{
		User r=new User();
    	r.setEmail(ema);
    	r.setName(na);
    	r.setPassword(pa);
    	r.setPassword1(pa1);
         try
         {
	      repo.save(r);
         }
         catch(Exception e)
         {
	    	  throw new ServiceException(e.getMessage());
         }
	}

	@Override
	public boolean validate(String u, String pw)
	{
		boolean a=false;
	    a=repo.existsCheck(u,pw);
	    if(a==true)
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    } 
	}

	@Override
	public boolean validateName(String u) 
	{
        boolean a=false;
	    a=repo.existsName(u);
	    if(a==true)
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	}

	@Override
	
	public boolean validateMail(String u)
	{
        boolean a=false;
	    a=repo.existsMail(u);
	    if(a==true)
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	}
}
