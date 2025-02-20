# Spring JPA

<p>Projeto de uma API para gerenciamento de eventos, desenvolvida com Java, Spring Boot e Spring JPA. Um CRUD simples para praticar os estudos com Spring JPA</p>

## Endpoints da API

#### Localização
- Criar uma localizacao: POST - http://localhost:8080/location
```
{
    "name": "",
    "address": "",
    "capacity": 0
}
```
- Atualizar um cadastro de localizacao: PUT - http://localhost:8080/location
```
{
    "id": "",
    "name": "",
    "address": "",
    "capacity": 0
}
```
- Deletar localizacao: DELETE - http://localhost:8080/location/id_localizacao
- Buscar todas as localizacoes: GET - http://localhost:8080/location
- Buscar Localizacao por ID: GET - http://localhost:8080/location/id_localizacao

#### Participantes
- Criar cadastro de participante: POST - http://localhost:8080/attendee
```
{
    "name": "",
    "email": ""
}
```
- Atualizar cadastro de participante: PUT - http://localhost:8080/attendee
```
{
    "id": "",
    "name": "",
    "email": ""
}
```
- Deletar participante: DELETE - http://localhost:8080/attendee/id_participante
- Buscar todos os participantes: GET - http://localhost:8080/attendee
- Buscar participante por ID: GET - http://localhost:8080/attendee/id_participante

#### Eventos
- Criar um evento: POST - http://localhost:8080/event
```
{
    "name": "",
    "date": "2025-02-27T15:00:00",
    "attendees": [
        "id_participante",
        "id_participante"
    ],
    "location": {
        "id": ""
    }
}
```
- Buscar eventos: GET - http://localhost:8080/event



