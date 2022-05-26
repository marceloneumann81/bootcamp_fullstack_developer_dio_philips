package dio.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dio.springboot.jpa.model.User;
import dio.springboot.jpa.repository.UserRepository;

@Component
public class MyApp implements CommandLineRunner{
	
	@Autowired
	private Anotacoes anotacoes;
	
	@Autowired
	private UserRepository repository;

	@Override
	public void run(String... args) throws Exception {
		
		//primeiras explicações sobre anotações e como utilizá-las
		//anotacoes.executaTestesAnotacoes();
		
		
		
		
		List<User> users = repository.findByNameContaining("Marcelo");
		
		
		for(User u: users) {
			System.out.println(u);
		}
		
		
	}
	
	
	
	private void insertUser() {
		
		User user = new User();
		
		user.setName("Marcelo Neumann");
		user.setUsername("marneumann");
		user.setPassword("1234");
		
		repository.save(user);
	}

}
