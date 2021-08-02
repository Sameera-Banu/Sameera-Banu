package com.example.demo.domain.entity;
import javax.persistence.*; 

@Entity
@Table(name="todolist")  
/**
 * Gets the details of a todo item 
 * @author Sameera
 */
public class App 
{  
@Id
private int id;
private String name;
private String list;

 /**
 * @return returns the id of a todo item
 */
 public int getTid() 
 {  
    return id;  
 }  
 
 /**
 *  sets the id of a todo item 
 *  @param id  Auto generated unique id for todo items
 */
 public void setTid(int id) 
 {  
   this.id = id;  
 }
 
 /**
 * @return the value of a todo item
 */
 public String getTlist() 
 {  
    return list;  
 } 
 
 /**
 * sets the value of list
 * @param list The value of a todo item
 */
 public void setTlist(String list)
 {  
    this.list = list;  
 } 
 
 /**
 * @return it returns the name of the user who created the todo
 */
 public String getTname() 
 {  
    return name;  
 } 
 
 /**
 * sets the name 
 * @param name The name of the user who created the todo
 */
 public void setTname(String name) 
 {  
   this.name = name;  
 }  
} 
