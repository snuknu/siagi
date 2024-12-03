package sansuy.com.br.siagi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sansuy.com.br.siagi.dto.DTOLogin;
import sansuy.com.br.siagi.dto.DTOUsuario;

@RestController
public class LoginController {

    private final AuthenticationManager authenticationManager;

    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<DTOUsuario> login(@RequestBody DTOLogin login) {

        Authentication authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(login.getUsername(), login.getPassword());

        Authentication authenticationResponse = this.authenticationManager.authenticate(authenticationRequest);

        System.out.println(authenticationResponse.getDetails());

        DTOUsuario usuario = new DTOUsuario();
        usuario.setUsername(login.getUsername());
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

}
