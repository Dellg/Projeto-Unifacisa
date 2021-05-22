package projeto.model;

// MovimentoConta é um objeto usado apenas para gerar Transações, seja ela do tipo depósito ou saque
public class MovimentoConta {

	private Long idConta;

	private double valor;

	// Getters e Setters
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
}
