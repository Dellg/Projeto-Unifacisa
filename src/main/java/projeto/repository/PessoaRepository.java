package projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projeto.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	@Query("SELECT p FROM Pessoa p WHERE p.idPessoa = :idPessoaParam")
	public Pessoa buscaPessoaPorIdPessoa(@Param("idPessoaParam") Long idPessoa);

	@Query("SELECT p FROM Pessoa p WHERE p.cpf = :cpfParam")
	public Pessoa buscaPessoaPorCpf(@Param("cpfParam") String cpf);
	
	@Query("SELECT p FROM Pessoa p WHERE p.nome = :nomeParam")
	public Pessoa buscaPessoaPorNome(@Param("nomeParam") String nome);
}
