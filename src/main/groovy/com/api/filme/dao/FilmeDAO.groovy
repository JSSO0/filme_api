package com.api.filme.dao

import groovy.sql.Sql

class FilmeDAO {

    static final String INSERT_FILME_SQL = "INSERT INTO filme (id, nome, descricao, duracao, avaliado, avaliacao) VALUES (?, ?, ?, ?, ?, ?)"

    Sql sql

    FilmeService(Sql sql) {
        this.sql = sql
    }

    void criarFilme(Filme filme) {
        sql.executeInsert(INSERT_FILME_SQL, [filme.id, filme.nome, filme.descricao, filme.duracao, filme.avaliado, filme.avaliacao])
    }
}
