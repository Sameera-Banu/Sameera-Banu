package com.example.demo.domain.repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.entity.App;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
/**
 * This interface extends repository to perform application services
 * @author Sameera
 */
public interface AppRepo extends JpaRepository<App,Integer>{
	
	/**
	 * This method performs select query to return todo list
	 * @param name gets the name of the user
	 * @return todo list of a specified user
	 */
	@Query("select u from App u where u.name=?1")
	List<App> listing(String name);
}
