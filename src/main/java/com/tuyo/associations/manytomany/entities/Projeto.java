package com.tuyo.associations.manytomany.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@ManyToMany(mappedBy = "projetos")
	private Set<Programador> programadores;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Programador> getProgrammers() {
		return programadores;
	}

	public void setProgrammers(Set<Programador> programadores) {
		this.programadores = programadores;
	}

	@Override
	public String toString() {
		return "Projeto [id=" + id + ", name=" + name + "]";
	}

}
