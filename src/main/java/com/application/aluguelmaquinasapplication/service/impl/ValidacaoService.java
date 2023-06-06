package com.application.aluguelmaquinasapplication.service.impl;

import java.util.Objects;

import com.application.aluguelmaquinasapplication.exception.ValidacaoException;

public abstract class ValidacaoService<T> {
    
    protected void validarObjeto(T obj){
        if (Objects.isNull(obj))
            throw new ValidacaoException("Obj nulo");
    }

}
