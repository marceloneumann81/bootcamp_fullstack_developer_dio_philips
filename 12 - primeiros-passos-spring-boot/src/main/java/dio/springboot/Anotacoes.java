package dio.springboot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Anotacoes {

	
	@Autowired
	private Calculadora calculadora;
	
	@Value("${nome}")
	private String nome;
	
	@Value("${name: DEFAULT}")
	private String nomeNaoEncontrado;
	
	@Value("${email}")
	private String email;
	
	@Value("${telefones}")
	private List<Long> telefones = new ArrayList<>(Arrays.asList(new Long[] {}));
	
	@Autowired
	private Remetente remetente;
	
	void executaTestesAnotacoes() {
		System.out.println("--------");
		System.out.println(" O resultado é: " + calculadora.somar(10, 10));
		System.out.println("--------");
		
		System.out.println("USANDO APPLICATION.PROPERTIES");
		System.out.println("--------");
		
		System.out.println("Mensagem enviada por: " + this.nome
							+ "\nE-mail: " + this.email
							+ "\nCom telefones para contato: " + this.telefones);
		System.out.println("--------");
		
		System.out.println("Mensagem enviada por: " + this.nomeNaoEncontrado
				+ "\nE-mail: " + this.email
				+ "\nCom telefones para contato: " + this.telefones);
		System.out.println("--------");
		
		
		System.out.println("VIA CLASSE REMETENTE");
		System.out.println("Mensagem enviada por: " + remetente.getNome()
				+ "\nE-mail: " + remetente.getEmail()
				+ "\nCom telefones para contato: " + remetente.getTelefones());
		System.out.println("--------");
	}
}
