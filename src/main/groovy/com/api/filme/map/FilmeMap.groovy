package com.api.filme.map

import com.api.filme.model.FilmeModel

class FilmeMap {

        static Map<String, Object> mapearParaParametros(FilmeModel filmeModel) {
            return [
                    'id': filmeModel.id,
                    'nome': filmeModel.nome,
                    'descricao': filmeModel.descricao,
                    'duracao': filmeModel.duracao,
                    'avaliado': filmeModel.avaliado,
                    'avaliacao': filmeModel.avaliacao

            ] as Map<String, Object>
        }

}
