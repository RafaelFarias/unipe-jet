package br.com.unipe.gerenciamentoAdvogados.model.vo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 * Indica ao Hibernate/JPA que está classe terá uma representação no banco de
 * dados
 * 
 * @author moacir
 *
 */
@Entity
public class Advogado extends EntityMaster {

	@Column(name = "numerooabpb", length = 200, columnDefinition = "TEXT")
	private String numeroOab;

	@Transient
	private String subsecao;

	/**
	 * Indica a associação 1-1 com a entidade de destino, neste caso como foi
	 * colocado a propriedade optional=false, será gerado uma chave estrangeira
	 * na tabela not null
	 */
	@OneToOne(targetEntity = Usuario.class, optional = false)
	private Usuario usuario;

	/**
	 * Indica a associação 1-n com a entidade de destino, o mappedBy indica a
	 * propriedade que na entidade de destino que terá o mapeamento bidirecional
	 */
	@OneToMany(targetEntity = Anuidade.class, mappedBy = "advogado")
	private Set<Anuidade> anuidade;

	@ManyToMany(targetEntity = Evento.class)
	@JoinTable(name = "evento_advogado", joinColumns = @JoinColumn(name = "advogado_id"), inverseJoinColumns = @JoinColumn(name = "evento_id"))
	private Set<Evento> eventos;

	public String getNumeroOab() {
		return numeroOab;
	}

	public void setNumeroOab(String numeroOab) {
		this.numeroOab = numeroOab;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Anuidade> getAnuidade() {
		return anuidade;
	}

	public void setAnuidade(Set<Anuidade> anuidade) {
		this.anuidade = anuidade;
	}

	public Set<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}

}