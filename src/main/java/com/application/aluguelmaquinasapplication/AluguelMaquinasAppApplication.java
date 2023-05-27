package com.application.aluguelmaquinasapplication;

import com.application.aluguelmaquinasapplication.dto.UsuarioDTO;
import com.application.aluguelmaquinasapplication.entity.*;
import com.application.aluguelmaquinasapplication.repository.*;
import com.application.aluguelmaquinasapplication.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.IntStream;

@SpringBootApplication
public class AluguelMaquinasAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AluguelMaquinasAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(UsuarioService usuarioService) {
        return args -> {
//
//            final var endereco = new Endereco();
//            endereco.setCep("12345678");
//            endereco.setRua("Rua barbosa");
//            endereco.setNumero(123L);
//            endereco.setCidade("São Paulo");
//            endereco.setBairro("Jd. Floresta");
//            endereco.setUf("SP");
//
//            final var usuario = new Usuario();
//            usuario.setCpf("58939755586");
//            usuario.setNome("Teste da nobrega");
//            usuario.setEmail("john@email.com");
//            usuario.setSenha("123456");
//            usuario.setTelefone("11912345678");
//
//
//            usuario.setEndereco(endereco);
//            endereco.setUsuario(usuario);
//
//            IntStream.range(0, 10).forEach(x -> usuarioService.salvar(UsuarioDTO.fromUsuario(usuario)));
//            usuarioService.salvar(UsuarioDTO.fromUsuario(usuario));

//            System.out.println(usuarioService.consultarPorId(10L));

//            usuarioService.consultarTodos().forEach(System.out::println);
//
//            System.out.println();
//            usuarioService.deletar(2L);
//            usuarioService.consultarTodos().forEach(System.out::println);

            final var updateUsuario = usuarioService.consultarPorId(2L);

            final var u = updateUsuario.toUsuario();

//            u.setNome("Joś ufshaaaaaa");
            u.getEndereco().setRua("Rua do sabão de alho");

            System.out.println("a");
            UsuarioDTO.fromUsuario(u);
            System.out.println("b");
            usuarioService.atualizar(UsuarioDTO.fromUsuario(u));

        };
    }

//    @Bean
//    public CommandLineRunner runner(
//            UsuarioRepository usuarioRepository,
//            EnderecoRepository enderecoRepository,
//            CategoriaRepository categoriaRepository,
//            MaquinaRepository maquinaRepository,
//            ImagemMaquinaRepository imagemMaquinaRepository,
//            ReservaRepository reservaRepository,
//            AluguelRepository aluguelRepository,
//            AvaliacaoUsuarioRepository avaliacaoUsuarioRepository,
//            AvaliacaoMaquinaRepository avaliacaoMaquinaRepository
//    ) {
//        return args -> {
//
//            try {
//
//                persistirEntidades(
//                        usuarioRepository,
//                        enderecoRepository,
//                        categoriaRepository,
//                        maquinaRepository,
//                        imagemMaquinaRepository,
//                        reservaRepository,
//                        aluguelRepository,
//                        avaliacaoUsuarioRepository,
//                        avaliacaoMaquinaRepository
//                );
//
//                Thread.sleep(5000);
//
//                atualizarEntidades(
//                        usuarioRepository,
//                        enderecoRepository,
//                        categoriaRepository,
//                        maquinaRepository,
//                        imagemMaquinaRepository,
//                        reservaRepository,
//                        aluguelRepository,
//                        avaliacaoUsuarioRepository,
//                        avaliacaoMaquinaRepository
//                );
//
//            } catch (Exception e) {
//                System.err.println(e.getMessage());
//            }
//
//        };
//    }
//
//    public static void persistirEntidades(
//            UsuarioRepository usuarioRepository,
//            EnderecoRepository enderecoRepository,
//            CategoriaRepository categoriaRepository,
//            MaquinaRepository maquinaRepository,
//            ImagemMaquinaRepository imagemMaquinaRepository,
//            ReservaRepository reservaRepository,
//            AluguelRepository aluguelRepository,
//            AvaliacaoUsuarioRepository avaliacaoUsuarioRepository,
//            AvaliacaoMaquinaRepository avaliacaoMaquinaRepository
//    ) throws InterruptedException {
//
//        final var usuario = new Usuario();
//        usuario.setId(1L);
//        usuario.setCpf("58939755586");
//        usuario.setNome("John Doezinho");
//        usuario.setEmail("john@email.com");
//        usuario.setSenha("123456");
//        usuario.setTelefone("11912345678");
//        usuarioRepository.save(usuario);
//
//        Thread.sleep(1000);
//
//        final var endereco = new Endereco();
//        endereco.setCep("12345678");
//        endereco.setRua("Rua silva");
//        endereco.setNumero(123L);
//        endereco.setCidade("São Paulo");
//        endereco.setBairro("Jd. Floresta");
//        endereco.setUf("SP");
//        endereco.setUsuario(usuario);
//        enderecoRepository.save(endereco);
//
//        Thread.sleep(1000);
//
//        final var categoria = new Categoria();
//        categoria.setNome("Industrial");
//        categoriaRepository.save(categoria);
//
//        Thread.sleep(1000);
//
//        final var maquina = new Maquina();
//        maquina.setTitulo("Empilhadeira");
//        maquina.setDescricao("Empilhadeira com suporte de até 1 tonelada.");
//        maquina.setValorDiaria(BigDecimal.valueOf(1000.00));
//        maquina.setCategoria(categoria);
//        maquinaRepository.save(maquina);
//
//        Thread.sleep(1000);
//
//        final var imagemMaquina = new ImagemMaquina();
//        imagemMaquina.setNome("imagem-empilhadeira.png");
//        imagemMaquina.setTipo("png");
//        imagemMaquina.setTamanho(6987L);
//        imagemMaquina.setConteudo("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//        imagemMaquina.setMaquina(maquina);
//        imagemMaquinaRepository.save(imagemMaquina);
//
//        Thread.sleep(1000);
//
//        final var reserva = new Reserva();
//        reserva.setDataReserva(LocalDate.now());
//        reserva.setDataRetirada(LocalDate.now());
//        reserva.setDataPrevDevolucao(LocalDate.now().plusDays(10));
//        reserva.setUsuario(usuario);
//        reserva.setMaquina(maquina);
//        reservaRepository.save(reserva);
//
//        Thread.sleep(1000);
//
//        final var aluguel = new Aluguel();
//        aluguel.setDataDevolucao(LocalDate.now());
//        aluguel.setMulta(null);
//        aluguel.setValorTotal(BigDecimal.valueOf(2500.00));
//        aluguel.setReserva(reserva);
//        aluguelRepository.save(aluguel);
//
//        Thread.sleep(1000);
//
//        final var avaliacaoUsuario = new AvaliacaoUsuario();
//        avaliacaoUsuario.setDescricao("Usuario deveolveu a maquina em boas condições.");
//        avaliacaoUsuario.setAvaliacao(5.0F);
//        avaliacaoUsuario.setReserva(reserva);
//        avaliacaoUsuarioRepository.save(avaliacaoUsuario);
//
//        Thread.sleep(1000);
//
//        final var avaliacaoMaquina = new AvaliacaoMaquina();
//        avaliacaoMaquina.setDescricao("A maquina não apresentou defeitos.");
//        avaliacaoMaquina.setAvaliacao(5.0F);
//        avaliacaoMaquina.setReserva(reserva);
//        avaliacaoMaquinaRepository.save(avaliacaoMaquina);
//    }
//
//
//    public static void atualizarEntidades(
//            UsuarioRepository usuarioRepository,
//            EnderecoRepository enderecoRepository,
//            CategoriaRepository categoriaRepository,
//            MaquinaRepository maquinaRepository,
//            ImagemMaquinaRepository imagemMaquinaRepository,
//            ReservaRepository reservaRepository,
//            AluguelRepository aluguelRepository,
//            AvaliacaoUsuarioRepository avaliacaoUsuarioRepository,
//            AvaliacaoMaquinaRepository avaliacaoMaquinaRepository
//    ) throws InterruptedException {
//
//        final var usuarioSalvo = usuarioRepository.findById(1L).orElseThrow(() -> new RuntimeException("not found"));
//        usuarioSalvo.setNome(usuarioSalvo.getNome().concat(" ATUALIZADO"));
//        usuarioRepository.save(usuarioSalvo);
//
//        Thread.sleep(1000);
//
//        final var enderecoSalvo = enderecoRepository.findById(1L).orElseThrow(() -> new RuntimeException("not found"));
//        enderecoSalvo.setRua(enderecoSalvo.getRua().concat(" ATUALIZADO"));
//        enderecoRepository.save(enderecoSalvo);
//
//        Thread.sleep(1000);
//
//        final var categoriaSalva = categoriaRepository.findById(1L).orElseThrow(() -> new RuntimeException("not found"));
//        categoriaSalva.setNome(categoriaSalva.getNome().concat(" ATUALIZADO"));
//        categoriaRepository.save(categoriaSalva);
//
//        Thread.sleep(1000);
//
//        final var maquinaSalva = maquinaRepository.findById(1L).orElseThrow(() -> new RuntimeException("not found"));
//        maquinaSalva.setTitulo(maquinaSalva.getTitulo().concat(" ATUALIZADO"));
//        maquinaRepository.save(maquinaSalva);
//
//        Thread.sleep(1000);
//
//        final var imagemMaquinaSalva = imagemMaquinaRepository.findById(1L).orElseThrow(() -> new RuntimeException("not found"));
//        imagemMaquinaSalva.setNome(imagemMaquinaSalva.getNome().concat(" ATUALIZADO"));
//        imagemMaquinaRepository.save(imagemMaquinaSalva);
//    }

}
