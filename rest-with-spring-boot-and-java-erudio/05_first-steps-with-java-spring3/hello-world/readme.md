# Hello, World!

Famosa primeira aplicação, utilizando Java e Spring Boot 3.

Contudo, essa aplicação possui algumas pecualiaridades:

1. Apresenta um contador de execuções;
2. Pode receber como parâmetro uma querystring chamada "name"

## Exemplos:

### a. Chamada sem parâmetro:

```
http://localhost:8080/greeting
```

#### Exibirá:

```json
{"id":1,"content":"Hello, World!"}
```

### b. Chamada com parâmetro:


```
http://localhost:8080/greeting?name=Melgarejo.dev
```

#### Retornará:

```json
{"id":2,"content":"Hello, Melgarejo.dev!"}
```

---

