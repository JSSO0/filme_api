package com.api.filme.sql

import groovy.sql.Sql

class Querys {

    static final String INSERT_FILME_SQL = "INSERT INTO filme (id, nome, descricao, duracao, avaliado, avaliacao) VALUES (?, ?, ?, ?, ?, ?)"
    static final String SELECT_FILME = "SELECT * FROM filme"
    static final String SELECT_FILME_AVALIADO = "SELECT * FROM filme WHERE avaliado = false"
    static final String SELECT_FILME_NAO_AVALIADO = "SELECT * FROM filme WHERE avaliado = true"
    static final String UPDATE_FILME = "UPDATE filme SET nome = ?, descricao = ?, duracao = ?, avaliado = ?, avaliacao = ? WHERE id = ?"
    static final String DELETE_FILME = "DELETE FROM filme WHERE id = ?"
    static final String SELECT_FILME_ESPECIFICO = "SELECT COUNT(*) AS count FROM filme WHERE id = ?"

    Sql sql

    Querys(Sql sql) {
        this.sql = sql
    }
}
