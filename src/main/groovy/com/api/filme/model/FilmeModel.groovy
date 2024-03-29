package com.api.filme.model

import groovy.transform.Canonical

@Canonical
class FilmeModel {
    String id = UUID.randomUUID().toString()
    String nome
    String descricao
    Integer duracao
    Boolean avaliado
    Integer avaliacao
}