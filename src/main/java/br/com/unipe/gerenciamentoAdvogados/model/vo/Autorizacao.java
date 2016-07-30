package br.com.unipe.gerenciamentoAdvogados.model.vo;

import javax.persistence.Entity;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

@Audited
@Entity
public class Autorizacao extends EntityMaster {
	
	@NotAudited
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
