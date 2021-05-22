package projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.model.Conta;
import projeto.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	public Conta cadastrarConta(Conta conta) {
		contaRepository.save(conta);
		return conta;
	}

	public List<Conta> buscaContaPorIdPessoa(Long idPessoa) {
		return contaRepository.buscaContaPorIdPessoa(idPessoa);
	}
}
