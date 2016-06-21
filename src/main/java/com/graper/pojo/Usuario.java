package com.graper.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
@SequenceGenerator(name="seq", initialValue=1, allocationSize=999999999)
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq") //-- Define como eu quero que seja a geração de valores
	@Column(name="UsuCod")
	private int id;
	@Column(name="UsuNom")
	private String nome;
	@Column(name="UsuSexo", length=1)
	private String sexo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + ", sexo=" + sexo + "]";
	}
	
	
}
