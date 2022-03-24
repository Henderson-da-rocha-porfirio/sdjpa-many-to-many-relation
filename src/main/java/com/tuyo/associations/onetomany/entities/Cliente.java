package com.tuyo.associations.onetomany.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 									// Como este campo é auto-incremento ou serial(no postgresql) nós usaremos um @GeneratedValue e AUTO em strategy.
	private long id;
	private String name; 																// Definimos a associação mas o hibernate ou JPA ainda não sabe dessa associação.
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL,fetch=FetchType.EAGER)   // Daí por isso colocar a @OneToMany anotação do JPA para fazê-los saber da associação.
	private Set<NumeroTelefone> numbers; 												// Também precisamos dizer à eles quem quer o mapeamento: NumeroTelefone que tem seu próprio mapeamento.
																						// "cliente" é quem diz que a Primary Key está no Cliete e ele próprio salva o mapeamento,
																						//  e dessa maneira mapeamos com sucesso Cliente para o NumeroTelefone.
	public long getId() {																// cascade é utilizado para realizar o efeito cascata (útil para CRUD também neste contexto
		return id;																		// ALL = é usado para vários tipos.
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<NumeroTelefone> getNumbers() {
		return numbers;
	}

	public void setNumbers(Set<NumeroTelefone> numbers) {
		this.numbers = numbers;
	}

	public void addNumeroTelefone(NumeroTelefone number) {
		if (number != null) {
			if (numbers == null) {
				numbers = new HashSet<>();
			}
			number.setCustomer(this);
			numbers.add(number);
		}

	}

}
