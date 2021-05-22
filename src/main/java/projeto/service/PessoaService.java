package projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.model.Pessoa;
import projeto.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa cadastrarPessoa(Pessoa usuario) {
		pessoaRepository.save(usuario);
		return usuario;
	}

	public Pessoa buscaPorCpf(String cpf) {
		return pessoaRepository.buscaPessoaPorCpf(cpf);
	}

	public Pessoa buscaPorIdPessoa(Long idPessoa) {
		return pessoaRepository.buscaPessoaPorIdPessoa(idPessoa);
	}
}
