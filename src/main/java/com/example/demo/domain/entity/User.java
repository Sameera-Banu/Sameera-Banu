package com.example.demo.domain.entity;
import javax.persistence.*;  

@Entity
@Table(name="users")  
/**
 * Get the user details given in the signup page
 * @author Sameera
 *
 */
public class User
{  
@Id
private String name;
private String email; 
private String password;
private String password1;

  /**
   * @return it returns name 
   */
   public String getName() {  
    return name;  
    }  
   
    /**
    * sets name
    * @param name The name of the user
    */
    public void setName(String name) {  
    this.name = name;  
     } 
    
    /**
     * @return it returns password
     */
     public String getPassword() {  
     return password;  
     }  
     
     /**
      * sets password
      * @param password The value of new password 
      */
     public void setPassword(String password) {  
     this.password =password;  
     } 
     
     /**
      * @return it returns email
      */
      public String getEmail() {  
      return email;  
      } 
      
      /**
       * sets email
       * @param email The emailId entered by the user
       */
     public void setEmail(String email) {  
     this.email =email;  
     }
     
     /**
      * @return it returns password1
      */
     public String getPassword1() {
	 return password1;
     }
     
    /**
     * sets password1
     * @param password1 the value of confirm password
     */
     public void setPassword1(String password1) {
	 this.password1 = password1;
     }  
} 


