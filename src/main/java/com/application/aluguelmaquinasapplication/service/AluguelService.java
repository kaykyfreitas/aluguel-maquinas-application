package com.application.aluguelmaquinasapplication.service;

import com.application.aluguelmaquinasapplication.entity.Aluguel;

public interface AluguelService {
    
    void alugar(Aluguel aluguel);
    void atualizar(Aluguel aluguel);
    void consultar(Long idReserva);
    
}
