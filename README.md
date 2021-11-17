# Case_Backend

## Sobre

Este é um projeto utilizando Java e Spring para gerenciamento de pessoas.

## Endpoints

Os seguintes endpoints são disponibilizados para o gerenciamento:

* Cria uma nova pessoa: `POST/pessoa/cadastrar` <br/>
* Busca uma determinada pessoa pelo id: `GET/pessoa/{id}` <br/>
* Atualiza os dados de uma determinada pessoa: `PUT/pessoa/atualizar` <br/>
* Lista todas as pessoas contidas no banco de dados: `GET/pessoa/listar` <br/>
* Deleta uma pessoa pelo id: `DELETE/pessoa/{id}` <br/>

`POST/pessoa/cadastrar`

Para cadastrar uma nova pessoa os seguintes parametros devem ser passados:

**Body:**

```json
{
   "nome": "Fulano de Tal",
   "identificador": "18824395627"
}
```

**Onde:** <br/>
`nome` - String. <br/>
`identificador` - String - Letras e caracteres especiais serão removidos caso informados.

### Documentation

* Swagger: [http://localhost:8080/swagger-ui.html#/](http://localhost:8080/swagger-ui.html#/)

### Banco de dados

Para o banco de dados foi utilizado o MySql, as configurações de banco estão no arquivo application.properties e devem ser alteradas para utilizar no seu banco de dados.
