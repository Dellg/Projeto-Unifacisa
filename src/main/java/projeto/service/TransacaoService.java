package projeto.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.model.Transacao;
import projeto.repository.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository transacaoRepository;

	public Transacao cadastrarTransacao(Transacao transacao) {
		transacaoRepository.save(transacao);
		return transacao;
	}
	
	public List<Transacao> buscarPorPeriodo(Long idConta, String dataInicio, String dataFim) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date dataI = formato.parse(dataInicio);
		Date dataF = formato.parse(dataFim);
		
		return transacaoRepository.buscaTransacaoPorIdContaData(idConta, dataI, dataF);
	}
}
