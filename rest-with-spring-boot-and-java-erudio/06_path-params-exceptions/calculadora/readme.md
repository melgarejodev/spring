# Cacluladora

API para realizar operações matemáticas.
Objetos de estudo: Path Params e Exceptions.

## Sintaxe:

```HTML
http://<URL_BASE>[:<PORTA>]/sum/numberOne/numberTwo
```

**Onde:**

* <URL_BASE> - Endereço raiz do host. Ex: localhot
* <PORTA> - (opcional) Porta de comunicação do host. Ex: localhost:8080
* sum - Operação de soma
* numberOne, numberTwo - Elementos da operação aritmética selecionada. Podem ser números inteiros ou decimais.

**Operações aritméticas disponiveis:**

* Soma -

## Exemplos:

### a. Soma entre dois números inteiros:

```HTML
http://localhost:8080/sum/1/2
```

#### Retorno:

```HTML
3.0
```

### b. Soma entre dois números decimais:

```HTML
http://localhost:8080/sum/3.2/6.9
```

#### Retorno:

```HTML
10.100000000000001
```

### c. Soma com valor errado (Exception):

```HTML
http://localhost:8080/sum/5.5/A
```

### Retorno:

```HTML
{"timestamp":"2023-05-19T15:59:06.957+00:00","message":"Informe valores numericos!","details":"uri=/sum/5.5/A"}
```
