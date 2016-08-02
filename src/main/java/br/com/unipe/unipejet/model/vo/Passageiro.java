package br.com.unipe.unipejet.model.vo;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.unipe.unipejet.model.TipoPessoa;

@Entity
public class Passageiro extends EntityMaster {

	private String nome;
	private String rg;
	private String cpf;
	private String numCartaoMilha;	
	private String username;
	private String password;
	
	@ManyToMany(targetEntity = Voo.class)
	@JoinTable(name = "voo_passageiro", joinColumns = @JoinColumn(name = "passageiro_id"), inverseJoinColumns = @JoinColumn(name = "voo_id"))
	private Set<Voo> voos;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataNascimento;

	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoPessoa;

	@OneToOne(targetEntity = Autorizacao.class)
	private Autorizacao autorizacao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Autorizacao getAutorizacao() {
		return autorizacao;
	}

	public void setAutorizacao(Autorizacao autorizacao) {
		this.autorizacao = autorizacao;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumCartaoMilha() {
		return numCartaoMilha;
	}

	public void setNumCartaoMilha(String numCartaoMilha) {
		this.numCartaoMilha = numCartaoMilha;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
