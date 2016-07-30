package br.com.unipe.gerenciamentoAdvogados.model.vo;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Evento extends EntityMaster {

	private String nome;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;

	@ManyToMany(targetEntity = Advogado.class, mappedBy="eventos")
	private Set<Advogado> advogados;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Set<Advogado> getAdvogados() {
		return advogados;
	}

	public void setAdvogados(Set<Advogado> advogados) {
		this.advogados = advogados;
	}

}
