package com.api.filme.service

import com.api.filme.dao.FilmeDAO
import com.api.filme.model.FilmeModel
import com.api.filme.sql.FilmeQuerys
import groovy.sql.Sql
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FilmeService {

    private final FilmeDAO filmeDAO

    private FilmeQuerys filmeQuerys

    private final Sql sql

    @Autowired
    FilmeService(FilmeDAO filmeDAO, FilmeQuerys filmeQuerys, Sql sql) {
        this.filmeDAO = filmeDAO
        this.filmeQuerys = filmeQuerys
        this.sql = sql
    }

    List<FilmeModel> buscarTodosFilmes() {
        return filmeDAO.buscarFilme()
    }

    List<FilmeModel> buscarFilmesAvaliados() {
        return filmeDAO.buscarFilmeAvaliado()
    }

    List<FilmeModel> buscarFilmesNaoAvaliados() {
        return filmeDAO.buscarFilmeNaoAvaliado()
    }

    void criarFilme(FilmeModel filmeModel) {
        try {
            def verificaExistencia = sql.firstRow(filmeQuerys.VERIFICAR_FILME, [filmeModel.nome])

            if (verificaExistencia[0] > 0) {
                throw new RuntimeException("Um filme com este nome já existe!")
            } else {
                filmeDAO.criarFilme(filmeModel)
            }

        } catch (Exception e) {
            // Trate a exceção ou lance uma exceção personalizada se necessário
            throw new RuntimeException("Erro ao criar Filme Step 2: " + e.getMessage(), e);
        }
    }

    void atualizarFilme(FilmeModel filmeModel) {
        filmeDAO.atualizarFilme(filmeModel)
    }

    void excluirFilme(UUID id) {
        try {
            filmeDAO.deleteFilme(id)
        } catch (Exception e) {
            // Trate a exceção ou lance uma exceção personalizada se necessário
            throw new RuntimeException("Erro ao excluir filme: " + e.getMessage(), e);
        }
    }
}
