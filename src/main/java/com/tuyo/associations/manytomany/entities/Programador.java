package com.tuyo.associations.manytomany.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Programador Pica {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@Column(name = "salary") 																// colocar @Column porque no database não está sal mas salary
	private int sal;																		// fetch=FetchType.EAGER = habilitando o eager fetching. // fetch=FetchType.EAGER é passado no Pai e faz referência ao Lazy que está no objeto Filho.
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER) 							// A anotação JoinTable tem que ser exatamente igual ao que está na tabela Join do database: programadores_projetos
	@JoinTable(name = "programadores_projetos", 	// E usando @JoinTable, estamos falando para o hibernate que esta é uma tabela Join e também informará o que são as chaves na tabela do database em questão e como elas estão associadas.
			joinColumns = @JoinColumn(name = "programador_id", referencedColumnName = "id"), // joinColumns = coluna join da tabela: programador_id é a coluna join da tabela Programador.
			inverseJoinColumns = @JoinColumn(name = "projeto_id", referencedColumnName = "id")) // inverseJoinColumns = é a coluna join da outra tabela que está no relacionamento ManyToMany: projeto_id
	private Set<Projeto> projetos; 																// referencedColumnName = são os ids dos PK's de Programador e de Projeto
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

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public Set<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(Set<Projeto> projetos) {
		this.projetos = projetos;
	}

	@Override		// Método toString = quero que imprima exatamente na ordem que está alí embaixo e não que venha diretamente de object.
	public String toString() {
		return "Programador [id=" + id + ", name=" + name + ", sal=" + sal + "]";
	}

}
