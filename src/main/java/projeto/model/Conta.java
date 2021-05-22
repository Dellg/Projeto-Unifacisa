package projeto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_conta")
public class Conta {

	@Id
	@Column(name = "id_conta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConta;

	@Column(name = "id_pessoa", nullable = false)
	private Long idPessoa;

	@Column(name = "saldo", nullable = false)
	private double saldo;
	
	@Column(name = "limite_saque_diario", nullable = false)
	private double limiteSaqueDiario;
	
	@Column(name = "flag_ativo", nullable = false)
	private Boolean flagAtivo;

	@Column(name = "tipo_conta", nullable = false)
	private Integer tipoConta;

	@Column(name = "data_criacao", nullable = false)
	private Date dataCriacao;

	public Conta(Long idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	public Conta() {
	}

	// getters e setters
	public Long getIdConta() {
		return idConta;
	}
	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getLimiteSaqueDiario() {
		return limiteSaqueDiario;
	}
	public void setLimiteSaqueDiario(double limiteSaqueDiario) {
		this.limiteSaqueDiario = limiteSaqueDiario;
	}

	public boolean isFlagAtivo() {
		return flagAtivo;
	}
	public void setFlagAtivo(boolean flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	public int getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(int tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}