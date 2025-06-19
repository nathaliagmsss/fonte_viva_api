package com.fonteviva.apirest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class criptoTeste {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaCriptografada = encoder.encode("25055505"); // ou qualquer senha
        System.out.println(senhaCriptografada);
    }
}
