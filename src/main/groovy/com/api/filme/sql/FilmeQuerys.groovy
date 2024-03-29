package com.api.filme.sql

import org.springframework.stereotype.Component

@Component
class FilmeQuerys {

    static final String INSERT_FILME_SQL = "INSERT INTO filme (id, nome, descricao, duracao, avaliado, avaliacao) VALUES (?, ?, ?, ?, ?, ?)"
    static final String SELECT_FILME = "SELECT * FROM filme"
    static final String SELECT_FILME_AVALIADO = "SELECT * FROM filme WHERE avaliado = true"
    static final String SELECT_FILME_NAO_AVALIADO = "SELECT * FROM filme WHERE avaliado = false"
    static final String UPDATE_FILME = "UPDATE filme SET nome = ?, descricao = ?, duracao = ?, avaliado = ?, avaliacao = ? WHERE id = ?"
    static final String DELETE_FILME = "DELETE FROM filme WHERE id = ?"
    static final String SELECT_FILME_ESPECIFICO = "SELECT COUNT(*) AS count FROM filme WHERE id = ?"
    static final String VERIFICAR_FILME = "SELECT COUNT(*) FROM filme WHERE nome = ?;"
    static final String VERIFICAR_FILME_ID = "SELECT COUNT(*) FROM filme WHERE id = ? ::uuid;"
}
