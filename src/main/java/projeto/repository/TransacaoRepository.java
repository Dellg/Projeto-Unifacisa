package projeto.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projeto.model.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

	@Query("SELECT t FROM Transacao t WHERE t.idConta = :idConta AND t.dataTransacao >= :dataInicio and t.dataTransacao <= :dataFim")
	public List<Transacao> buscaTransacaoPorIdContaData(@Param("idConta") Long idConta,
			@Param("dataInicio") Date dataInicio, @Param("dataFim") Date dataFim);

}
