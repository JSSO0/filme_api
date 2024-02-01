package com.api.filme.controller

import com.api.filme.model.FilmeModel
import com.api.filme.service.FilmeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/filmes")
class FilmeController {
    FilmeService filmeService

    @Autowired
    FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService
    }

    @GetMapping
    List<FilmeModel> getAllFilmes() {
        return filmeService.buscarTodosFilmes()
    }

    @GetMapping("/avaliados")
    List<FilmeModel> getFilmesAvaliados() {
        return filmeService.buscarFilmesAvaliados()
    }

    @GetMapping("/naoavaliados")
    List<FilmeModel> getFilmesNaoAvaliados() {
        return filmeService.buscarFilmesNaoAvaliados()
    }

    @PostMapping
    ResponseEntity<String> criarFilme(@RequestBody FilmeModel filmeModel) {
        System.out.println(filmeModel)
        filmeService.criarFilme(filmeModel)
        return ResponseEntity.status(HttpStatus.CREATED).body("Filme criado com sucesso.")
    }

    @PutMapping("/{id}")
    ResponseEntity<String> atualizarFilme(@PathVariable Long id, @RequestBody FilmeModel filmeModel) {
        filmeModel.id = id
        filmeService.atualizarFilme(filmeModel)
        return ResponseEntity.ok("Filme atualizado com sucesso.")
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> excluirFilme(@PathVariable Long id) {
        filmeService.excluirFilme(id as FilmeModel)
        return ResponseEntity.ok("Filme excluído com sucesso.")
    }

}
