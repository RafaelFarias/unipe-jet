package br.com.unipe.unipejet.model.vo;

import java.text.SimpleDateFormat;
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

import org.springframework.format.annotation.DateTimeFormat;

import br.com.unipe.unipejet.model.TipoPessoa;

@Entity
public class Usuario extends EntityMaster {

	private String nome;
	private String email;
	private String rg;
	private String cpf;
	private String numCartaoMilha;	
	private String login;
	private String senha;
	private Long quantidadeMilhas;
	
	@ManyToMany(targetEntity = Voo.class)
	@JoinTable(name = "voo_usuario", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "voo_id"))
	private Set<Voo> voos;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
	
	public String getDataNascimentoStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataNascimentoStr = "";
		if(dataNascimento != null){
			dataNascimentoStr = sdf.format(dataNascimento.getTime());
		}
		return dataNascimentoStr;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getQuantidadeMilhas() {
		if(quantidadeMilhas == null){
			quantidadeMilhas = 0L;
		}
		return quantidadeMilhas;
	}

	public void setQuantidadeMilhas(Long quantidadeMilhas) {
		this.quantidadeMilhas = quantidadeMilhas;
	}
}
