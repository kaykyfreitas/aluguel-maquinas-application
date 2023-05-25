package com.application.aluguelmaquinasapplication;

import com.application.aluguelmaquinasapplication.entity.Usuario;
import com.application.aluguelmaquinasapplication.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AluguelMaquinasAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AluguelMaquinasAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(UsuarioRepository usuarioRepository) {
        return args -> {
            final var usuario = new Usuario(1, "John Doe");

            usuarioRepository.save(usuario);
        };
    }

}
