package sansuy.com.br.siagi.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import sansuy.com.br.siagi.model.Usuario;
import sansuy.com.br.siagi.repository.UsuarioRepository;

public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	/*
	 * Here we are using dummy data, you need to load user data from database or
	 * other third party application
	 */
	User user = findUserbyUername(username);

	UserBuilder builder = null;
	if (user != null) {
	    builder = User.withUsername(username);
	    builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
	    builder.authorities(user.getAuthorities());

	} else {
	    throw new UsernameNotFoundException("User not found.");
	}

	return builder.build();
    }

    private User findUserbyUername(String username) {

	Usuario usuario = usuarioRepository.findOneByUsername(username);
	if (usuario != null) {

	    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	    authorities.add(new SimpleGrantedAuthority("ADMIN"));
	    authorities.add(new SimpleGrantedAuthority("USER"));

	    return new User(username, usuario.getPassword(), authorities);
	}
	return null;
    }
}
