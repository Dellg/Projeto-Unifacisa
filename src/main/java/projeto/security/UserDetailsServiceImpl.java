package projeto.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import projeto.model.Pessoa;
import projeto.repository.PessoaRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private PessoaRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		Optional<Pessoa> user = Optional.of(userRepository.buscaPessoaPorNome(userName));
		user.orElseThrow(() -> new UsernameNotFoundException(userName + " não encontrado!"));
		return user.map(UserDetailsImpl::new).get();
	}
}
