package com.api.filme.service

import com.api.filme.dao.FilmeDAO
import com.api.filme.model.FilmeModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.List

@Service
class FilmeService {

    private final FilmeDAO filmeDAO

    @Autowired
    FilmeService(FilmeDAO filmeDAO) {
        this.filmeDAO = filmeDAO
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
        filmeDAO.criarFilme(filmeModel)
    }

    void atualizarFilme(FilmeModel filmeModel) {
        filmeDAO.atualizarFilme(filmeModel)
    }

    void excluirFilme(FilmeModel filmeModel) {
        filmeDAO.deleteFilme(filmeModel)
    }
}
