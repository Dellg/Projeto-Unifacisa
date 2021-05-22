package projeto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_transacao")
public class Transacao {

	@Id
	@Column(name = "id_transacao")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTransacao;

	@Column(name = "id_conta")
	private Long idConta;

	@Column(name = "valor", nullable = false)
	private double valor;

	@Column(name = "data_transacao", nullable = false)
	private Date dataTransacao;

	// getters e setters
	public Long getIdTransacao() {
		return idTransacao;
	}
	public void setIdTransacao(Long idTransacao) {
		this.idTransacao = idTransacao;
	}

	public Long getIdConta() {
		return idConta;
	}
	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getDataTransacao() {
		return dataTransacao;
	}
	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}
}
