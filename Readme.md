1. Criar um Filme (POST):
URL: http://localhost:8080/filmes
Método: POST
Body (JSON):
json
   {
        "nome": "edfsfduu",
        "descricao": "textto",
        "duracao": 120,
        "avaliado": true,
        "avaliacao": 5
   }
Certifique-se de ajustar a URL conforme necessário, dependendo de onde sua aplicação está hospedada e a porta que está usando.

2. Obter todos os Filmes (GET):
URL: http://localhost:8080/filmes
Método: GET

3. Obter Filmes Avaliados (GET):
URL: http://localhost:8080/filmes/avaliados
Método: GET

4. Obter Filmes Não Avaliados (GET):
URL: http://localhost:8080/filmes/naoavaliados
Método: GET

5. Atualizar um Filme (PUT):
URL: http://localhost:8080/filmes/{id} (Substitua {id} pelo ID do filme que deseja atualizar)
Método: PUT
Body (JSON):
json
{
    "nome": "Novo Nome do Filme",
    "descricao": "Nova Descrição do Filme",
    "duracao": 150,
    "avaliado": true,
    "avaliacao": 4.5
}

6. Excluir um Filme (DELETE):
URL: http://localhost:8080/filmes/{id} (Substitua {id} pelo ID do filme que deseja excluir)
Método: DELETE