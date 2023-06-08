package br.com.self_employed.utils;

import java.net.URI;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public interface GeneralUtilities {
    public static URI toUri(String path) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(path)
                .build()
                .toUri();
    }

    public static String encode(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}