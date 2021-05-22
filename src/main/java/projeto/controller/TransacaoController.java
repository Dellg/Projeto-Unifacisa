package projeto.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projeto.model.Transacao;
import projeto.service.TransacaoService;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

	@Autowired
	private TransacaoService transacaoService;

	@PostMapping("/cadastrar")
	public ResponseEntity<Transacao> PostCadastrar(@RequestBody Transacao transacao) {
		return ResponseEntity.status(HttpStatus.CREATED).body(transacaoService.cadastrarTransacao(transacao));
	}
	
	@GetMapping
	public List<Transacao> getDashboard(@RequestParam("idConta") Long idConta, @RequestParam("dataInicio") String dataInicio, @RequestParam("dataFim") String dataFim) throws ParseException{
		return transacaoService.buscarPorPeriodo(idConta, dataInicio, dataFim);
	}
}
