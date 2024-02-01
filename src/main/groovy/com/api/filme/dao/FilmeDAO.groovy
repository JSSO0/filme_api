package com.api.filme.dao

import com.api.filme.model.FilmeModel
import com.api.filme.sql.FilmeQuerys
import com.api.filme.map.FilmeMap
import groovy.sql.Sql
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

import javax.sql.DataSource

@Repository
class FilmeDAO {

    @Autowired
    private FilmeQuerys filmeQuerys

    private final Sql sql

    @Autowired
    FilmeDAO(DataSource dataSource, FilmeQuerys filmeQuerys) {
        this.sql = new Sql(dataSource)
        this.filmeQuerys = filmeQuerys
    }

    // Get geral
    List<FilmeModel> buscarFilme() {
        try {
            return sql.rows(filmeQuerys.SELECT_FILME)
        } catch (Exception e) {
            // Trate a exceção ou lance uma exceção personalizada se necessário
            throw new RuntimeException("Erro ao buscar filmes: ${e.message}", e)
        }
    }

    // Get avaliado
    List<FilmeModel> buscarFilmeAvaliado() {
        try {
            return sql.rows(filmeQuerys.SELECT_FILME_AVALIADO)
        } catch (Exception e) {
            // Trate a exceção ou lance uma exceção personalizada se necessário
            throw new RuntimeException("Erro ao buscar filmes avaliados: ${e.message}", e)
        }
    }

    // Get não avaliado
    List<FilmeModel> buscarFilmeNaoAvaliado() {
        try {
            return sql.rows(filmeQuerys.SELECT_FILME_NAO_AVALIADO)
        } catch (Exception e) {
            // Trate a exceção ou lance uma exceção personalizada se necessário
            throw new RuntimeException("Erro ao buscar filmes não avaliados: ${e.message}", e)
        }
    }

    // Post
    void criarFilme(FilmeModel filmeModel) {
        try {
            Map<String, Object> parametros = FilmeMap.mapearParaParametros(filmeModel)
            def sqlQuery = filmeQuerys.INSERT_FILME_SQL
            println "Executando SQL: ${sqlQuery} com parâmetros: ${parametros}"
            sql.executeInsert(sqlQuery, parametros)
        } catch (Exception e) {
            // Trate a exceção ou lance uma exceção personalizada se necessário
            throw new RuntimeException("Erro ao criar filme: ${e.message}", e)
        }
    }

    // Put
    void atualizarFilme(FilmeModel filmeModel) {
        try {
            // Verifica se o filme existe antes de atualizar
            if (filmeExiste(filmeModel.id as Long)) {
                Map<String, Object> parametros = FilmeMap.mapearParaParametros(filmeModel)
                sql.executeUpdate(filmeQuerys.UPDATE_FILME, parametros)
            }
        } catch (Exception e) {
            // Trate a exceção ou lance uma exceção personalizada se necessário
            throw new RuntimeException("Erro ao atualizar filme: ${e.message}", e)
        }
    }

    // Delete
    void deleteFilme(FilmeModel filmeModel) {
        try {
            // Verifica se o filme existe antes de excluir
            if (filmeExiste(filmeModel.id as Long)) {
                sql.executeUpdate(filmeQuerys.DELETE_FILME, [filmeModel.id])
            }
        } catch (Exception e) {
            // Trate a exceção ou lance uma exceção personalizada se necessário
            throw new RuntimeException("Erro ao excluir filme: ${e.message}", e)
        }
    }

    // Verifica se um filme com o ID fornecido existe
    private boolean filmeExiste(Long id) {
        try {
            def resultado = sql.firstRow(filmeQuerys.SELECT_FILME_ESPECIFICO, [id])
            return resultado.count > 0
        } catch (Exception e) {
            // Trate a exceção ou lance uma exceção personalizada se necessário
            throw new RuntimeException("Erro ao verificar existência do filme: ${e.message}", e)
        }
    }
}