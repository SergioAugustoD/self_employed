package br.com.self_employed.auth;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.self_employed.services.User.UserDTO;
import br.com.self_employed.utils.GeneralUtilities;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register/{role}")
    public ResponseEntity<Response> register(@RequestBody UserDTO userDTO, @PathVariable String role) {
        
        String uriPath = "/register/{role}";
        URI uri = GeneralUtilities.toUri(uriPath);
        Response response = authService.register(userDTO, role);
        System.out.println("CHEGOU AQUI" + response);
        return ResponseEntity.created(uri).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody AuthDTO authDTO) {
        Response response = authService.login(authDTO);
        return ResponseEntity.ok().body(response);
    }
}