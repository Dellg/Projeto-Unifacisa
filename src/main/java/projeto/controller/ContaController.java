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

import projeto.model.Conta;
import projeto.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {

	@Autowired
	private ContaService contaService;

	@PostMapping("/cadastrar")
	public ResponseEntity<Conta> PostCadastrar(@RequestBody Conta conta) throws ParseException {
		return ResponseEntity.status(HttpStatus.CREATED).body(contaService.cadastrarConta(conta));
	}

	@PostMapping("/bloquear")
	public ResponseEntity<Conta> PostBloquear(@RequestBody Conta conta) throws Exception {
		return ResponseEntity.status(HttpStatus.CREATED).body(contaService.bloquearConta(conta));
	}

	@PostMapping("/desbloquear")
	public ResponseEntity<Conta> PostDesbloquear(@RequestBody Conta conta) throws Exception {
		return ResponseEntity.status(HttpStatus.CREATED).body(contaService.desbloquearConta(conta));
	}

	@GetMapping
	public List<Conta> GetContaPessoa(@RequestParam("idPessoa") Long idPessoa) {
		return contaService.buscaContaPorIdPessoa(idPessoa);
	}

}
