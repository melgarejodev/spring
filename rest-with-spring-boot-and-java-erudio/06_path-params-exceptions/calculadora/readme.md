# Cacluladora

API para realizar operações matemáticas.
Objetos de estudo: Path Params e Exceptions.

## Sintaxe:

```HTML
http://<URL_BASE>[:<PORTA>]/<OPERACAO>/<NUMERO1>/<NUMERO2>
```

**Onde:**

* <URL_BASE> - Endereço raiz do host. Ex: localhot
* <PORTA> - (opcional) Porta de comunicação do host. Ex: localhost:8080
* <OPERACAO> - Operação aritmética desejada (detalhamento abaixo)
* <NUMERO1> - Primeiro número informado, poderá ser um valor inteiro ou decimal.
* <NUMERO2> - Segundo número informado, poderá ser um valor inteiro ou decimal.

**OBS:** 
* Os valores de <NUMERO1> e <NUMERO2> podem ser inteiros ou decimais.
* O papel de cada número dependerá da operação aritmética selecionada.

**Operações aritméticas disponiveis:**

* Soma - sum. Ex: http://localhost:8080/sum/numberOne/numberTwo
* **sub** - Diferença entre o minuendo e o subtraendo. Ex: http://localhost:8080/sub/minuendo/subtraendo

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
