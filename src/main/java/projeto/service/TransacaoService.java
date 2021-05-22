package projeto.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.model.Conta;
import projeto.model.MovimentoConta;
import projeto.model.Transacao;
import projeto.repository.ContaRepository;
import projeto.repository.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	public Transacao depositar(MovimentoConta deposito) throws Exception {
		Transacao transacao = criaTransacaoMovimento(deposito, "Depósito");
		if (realizaDeposito(transacao))
			transacaoRepository.save(transacao);
		return transacao;
	}
	
	public Transacao sacar(MovimentoConta saque) throws Exception {
		Transacao transacao = criaTransacaoMovimento(saque, "Saque");
		if (realizaSaque(transacao))
			transacaoRepository.save(transacao);
		return transacao;
	}
	
	// função que cria o objeto transação para poder ser realizado um depósito ou saque posteriormente
	private Transacao criaTransacaoMovimento(MovimentoConta movimentoConta, String tipoTransacao) throws ParseException {
		Transacao transacao = new Transacao();
		transacao.setIdConta(movimentoConta.getIdConta());
		transacao.setValor(movimentoConta.getValor());
		transacao.setTipoTransacao(tipoTransacao);
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		String formatado = formato.format(new Date());
		Date data = formato.parse(formatado);
		transacao.setDataTransacao(data);
		return transacao;
	}
	
	// função que realiza o depósito em uma conta
	private boolean realizaDeposito(Transacao transacao) throws Exception {
		Optional<Conta> c = contaRepository.findById(transacao.getIdConta());
		Conta conta = contaRepository.buscaContaPorIdConta(transacao.getIdConta());
		if (c.isPresent())
			if (conta.isFlagAtivo()) {
				conta.setSaldo(conta.getSaldo() + transacao.getValor());
				contaRepository.save(conta);
				return true;
			} else
				throw new Exception("A conta está bloqueada!");
		else 
			throw new Exception("Conta não cadastrada!");
	}

	// função que realiza o saque em uma conta, é verificado se tem saldo suficiente para esta ação
	private boolean realizaSaque(Transacao transacao) throws Exception {
		Optional<Conta> c = contaRepository.findById(transacao.getIdConta());
		Conta conta = contaRepository.buscaContaPorIdConta(transacao.getIdConta());
		if (c.isPresent())
			if (conta.isFlagAtivo()) {
				if (conta.getSaldo() < transacao.getValor())
					throw new Exception("Saldo insuficiente! Saldo disponível: " + conta.getSaldo());
				else {
					conta.setSaldo(conta.getSaldo() - transacao.getValor());
					contaRepository.save(conta);
					return true;
				}
			} else throw new Exception("A conta está bloqueada!");
		else
			throw new Exception("Conta não cadastrada!");
	}
	
	// função que busca uma lista de todas as transações feitas entre um período de tempo
	public List<Transacao> buscarPorPeriodo(Long idConta, String dataInicio, String dataFim) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date dataI = formato.parse(dataInicio);
		Date dataF = formato.parse(dataFim);
		
		return transacaoRepository.buscaTransacaoPorIdContaData(idConta, dataI, dataF);
	}
}
