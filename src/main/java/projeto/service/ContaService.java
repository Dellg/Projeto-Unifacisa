package projeto.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.model.Conta;
import projeto.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	public Conta cadastrarConta(Conta conta) throws ParseException {
		conta.setSaldo(0);
		conta.setLimiteSaqueDiario(500);
		conta.setFlagAtivo(true);
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		String formatado = formato.format(new Date());
		Date dataCriacao = formato.parse(formatado);
		conta.setDataCriacao(dataCriacao);
		contaRepository.save(conta);
		return conta;
	}
	
	public Conta bloquearConta(Conta conta) throws Exception {
		return mudarStatusConta(conta, false);
	}
	
	public Conta desbloquearConta(Conta conta) throws Exception {
		return mudarStatusConta(conta, true);
	}
	
	private Conta mudarStatusConta(Conta conta, boolean status) throws Exception {
		Optional<Conta> c = contaRepository.findById(conta.getIdConta());
		Conta contaAtual = contaRepository.buscaContaPorIdConta(conta.getIdConta());
		if (c.isPresent()) {
			if (contaAtual.isFlagAtivo() == !status) {
				contaAtual.setFlagAtivo(status);
				contaRepository.save(contaAtual);
			} else
				if (status)
					throw new Exception("A conta já está desbloqueada!");
				else
					throw new Exception("A conta já está bloqueada!");
		} else 
			throw new Exception("Conta não cadastrada!");
		return contaAtual;
	}

	public List<Conta> buscaContaPorIdPessoa(Long idPessoa) {
		return contaRepository.buscaContaPorIdPessoa(idPessoa);
	}
}
