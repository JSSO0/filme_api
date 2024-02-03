package com.api.filme.map

import com.api.filme.model.FilmeModel
import org.springframework.stereotype.Component

@Component
class FilmeMap {

    static Map<String, Object> mapearParaParametros(FilmeModel filmeModel) {
        return [
                'id': UUID.fromString(filmeModel.id),
                'nome': filmeModel.nome,
                'descricao': filmeModel.descricao,
                'duracao': filmeModel.duracao,
                'avaliado': filmeModel.avaliado,
                'avaliacao': filmeModel.avaliacao ?: 0
        ] as Map<String, Object>
    }
}
