package com.tuyo.associations.onetomany.entities;

import javax.persistence.*;

@Entity
public class NumeroTelefone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String number;
	private String type;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Cliente cliente;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Cliente getCustomer() {
		return cliente;
	}

	public void setCustomer(Cliente cliente) {
		this.cliente = cliente;
	}

}
