package com.example.demo.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.entity.User;

@Repository
/**
 * This interface extends repository to perform user services
 * @author Sameera
 *
 */
public interface UserRepo extends JpaRepository<User,String> {
	
	/**
	 * This method checks whether the query exists in db
	 * @param sname gets the name of the user
	 * @param pass gets the password of the user
	 * @return it returns true if exists else false
	 */
	@Query("select case when count(c)> 0 then true else false end from User c where c.name=?1 and c.password=?2")
	boolean existsCheck(String sname,String pass);
	
	/**
	 * This method checks whether the query exists in db
	 * @param name gets the name of the user
	 * @return it returns true if exists else false
	 */
	@Query("select case when count(c)> 0 then true else false end from User c where c.name=?1")
	boolean existsName(String sname);
	
	/**
	 * This method checks whether the query exists in db
	 * @param mail gets the email of the user
	 * @return it returns true if exists else false
	 */
	@Query("select case when count(c)> 0 then true else false end from User c where c.email=?1")
	boolean existsMail(String mail);	
}
