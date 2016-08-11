package br.com.unipe.unipejet.model.vo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;

	@ManyToMany(targetEntity = Usuario.class, mappedBy="voos")
	private Set<Usuario> usuarios;

	public Calendar getData() {
		return data;
	}
	
	public String getDataStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataStr = "";
		if(data != null){
			dataStr = sdf.format(data.getTime());
		}
		return dataStr;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
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
