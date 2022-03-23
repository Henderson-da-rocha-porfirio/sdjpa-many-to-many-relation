package com.tuyo.associations.onetomany.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Como este campo é auto-incremento ou serial(no postgresql) nós usaremos um @GeneratedValue
	private long id;
	private String name;
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<NumeroTelefone> numbers;

	public long getId() {
		return id;
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

	public void addPhoneNumber(NumeroTelefone number) {
		if (number != null) {
			if (numbers == null) {
				numbers = new HashSet<>();
			}
			number.setCustomer(this);
			numbers.add(number);
		}

	}

}
