package br.com.unipe.unipejet.model.vo;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Voo extends EntityMaster {

	private String numVoo;
	private String cidadeOrigem;
	private String cidadeDestino;
	private String horaPartida;
	private String duracao;
	private String distancia;
	private String preco;
	private String capacidade;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;

	@ManyToMany(targetEntity = Passageiro.class, mappedBy="voos")
	private Set<Passageiro> passageiros;

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Set<Passageiro> getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(Set<Passageiro> passageiros) {
		this.passageiros = passageiros;
	}

	public String getNumVoo() {
		return numVoo;
	}

	public void setNumVoo(String numVoo) {
		this.numVoo = numVoo;
	}

	public String getCidadeOrigem() {
		return cidadeOrigem;
	}

	public void setCidadeOrigem(String cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}

	public String getCidadeDestino() {
		return cidadeDestino;
	}

	public void setCidadeDestino(String cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}

	public String getHoraPartida() {
		return horaPartida;
	}

	public void setHoraPartida(String horaPartida) {
		this.horaPartida = horaPartida;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getDistancia() {
		return distancia;
	}

	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}

}
