package com.example.demo.service;
import org.hibernate.service.spi.ServiceException;

/**
 * Declares user specific functions
 * @author Sameera
 */
public interface UserService {
	
	/**
	 * Stores the values entered in signup page to db
	 * @param na gets the username
	 * @param ema gets the email
	 * @param pa gets the new password
	 * @param pa1 gets the confirm password
	 * @exception ServiceException on service error
	 */
    public void save(String na,String ema,String pa,String pa1)throws ServiceException;
    
    /**
	 * Validate whether the username and password exists in db
	 * @param u gets the username 
	 * @param pw gets the password
	 * @return it returns true if exists else returns false 
	 */
	public boolean validate(String u,String pw);
	
	/**	
	 *  username should be unique to each user
	 *  This method is used to check whether the entered username is already exists
	 *  @param u gets the username 
	 *   @return it returns true if already exists else return false
	 */
	public boolean validateName(String u);
	
	/**
	 * Email should be unique to each user
	 *  This method is used to check whether the entered Email is already exist
	 *  @param u gets the email 
	 *  @return it returns true if already exists else return false
	 */
	public boolean validateMail(String u);
}
