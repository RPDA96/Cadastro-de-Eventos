package com.eventoapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Convidado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;
	
	@NotEmpty
	private String cpf;

	@NotEmpty
	private String nomeConvidado;
	
	@ManyToOne
	private Evento evento;
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNomeConvidado() {
		return nomeConvidado;
	}
	public void setNomeConvidado(String nomeConvidado) {
		this.nomeConvidado = nomeConvidado;
	}
	
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	@Override
	public String toString() {
		return "Convidado [cpf=" + cpf + ", nomeConvidado=" + nomeConvidado + "]";
	}	
}
