package dio.springboot.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dio.springboot.jpa.model.User;

public interface UserRepository extends JpaRepository<User, Integer>  {

	//Query Method
	List<User> findByNameContaining(String nome);
	
	//Query Method
	User findByUsername(String username);
	
	//Query Override
	@Query("SELECT u FROM User u WHERE u.name LIKE %:name%")
	List<User> filtrarPorNome(@Param("name") String name);
}
