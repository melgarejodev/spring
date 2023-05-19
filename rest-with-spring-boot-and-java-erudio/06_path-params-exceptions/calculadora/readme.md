# Cacluladora

API para realizar operações matemáticas.
Objetos de estudo: Path Params e Exceptions.

## Sintaxe:

```HTML
http://<URL_BASE>[:<PORTA>]/<OPERACAO>/numberOne/numberTwo
```

**Onde:**

* <URL_BASE> - Endereço raiz do host. Ex: localhot
* <PORTA> - (opcional) Porta de comunicação do host. Ex: localhost:8080
* <OPERACAO> - Operação aritmética desejada (descritas abaixo)
* numberOne, numberTwo - Elementos da operação aritmética selecionada. Podem ser números inteiros ou decimais.

**Operações aritméticas disponiveis:**

* Soma - sum. Ex: http://localhost:8080/sum/numberOne/numberTwo
* Subtração - sub. Ex: http://localhost:8080/sub/numberOne/numberTwo

## Exemplos:

### a. Soma entre dois números inteiros:

```HTML
http://localhost:8080/sum/1/2
```

#### Retorno:

```HTML
3.0
```

### b. Subtração entre dois números decimais:

```HTML
http://localhost:8080/sub/8.4/3.4
```

#### Retorno:

```HTML
5.0
```

### c. Soma com valor errado (Exception):

```HTML
http://localhost:8080/sum/5.5/A
```

#### Retorno:

```HTML
{"timestamp":"2023-05-19T15:59:06.957+00:00","message":"Informe valores numericos!","details":"uri=/sum/5.5/A"}
```

#### Status code: 

```HTML
400
```
