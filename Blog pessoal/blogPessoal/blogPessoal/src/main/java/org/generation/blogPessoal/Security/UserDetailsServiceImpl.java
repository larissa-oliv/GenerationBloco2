package org.generation.blogPessoal.Security;


import org.generation.blogPessoal.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        usuario.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));
        return usuario.map(UserDetailsImpl::new).get();
    }
}
