package projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projeto.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {
	
	@Query("SELECT c FROM Conta c WHERE c.idConta = :idConta")
	public Conta buscaContaPorIdConta(@Param("idConta") Long idConta);

	@Query("SELECT c FROM Conta c WHERE c.idPessoa = :idPessoaParam")
	public List<Conta> buscaContaPorIdPessoa(@Param("idPessoaParam") Long idPessoa);
}
