 CREATE DATABASE bruna;

USE bruna;

CREATE TABLE pessoa
  (
     id           INT(11) NOT NULL auto_increment,
     ultimonome   VARCHAR(255) NOT NULL,
     primeironome VARCHAR(255),
     idade        INT(11),
     profissao    VARCHAR(30),
     PRIMARY KEY (id)
  );

CREATE TABLE pedido
  (
     pedidoid     INT(11) NOT NULL auto_increment,
     numeropedido INT(11) NOT NULL,
     pessoaid     INT(11),
     valor        INT(11),
     PRIMARY KEY (pedidoid),
     FOREIGN KEY (pessoaid) REFERENCES pessoa(id)
  );

INSERT INTO pessoa
            (ultimonome,
             primeironome,
             idade,
             profissao)
VALUES      ('Cavalcante',
             'Tamer',
             28,
             'Professor');

INSERT INTO pessoa
            (ultimonome,
             primeironome,
             idade,
             profissao)
VALUES      ('Bueno',
             'Lucas',
             25,
             'Professor');

INSERT INTO pessoa
            (ultimonome,
             primeironome,
             idade,
             profissao)
VALUES      ('Wachinski',
             'Glaucio',
             39,
             'Professor');

INSERT INTO pessoa
            (ultimonome,
             primeironome,
             idade,
             profissao)
VALUES      ('Barreto',
             'Luciano',
             33,
             'Professor');

INSERT INTO pessoa
            (ultimonome,
             primeironome,
             idade,
             profissao)
VALUES      ('Pereira',
             'Flavio',
             40,
             'Professor');

INSERT INTO pessoa
            (ultimonome,
             primeironome,
             idade,
             profissao)
VALUES      ('Barbosa',
             'Denilson',
             40,
             'Professor');

INSERT INTO pessoa
            (ultimonome,
             primeironome,
             idade,
             profissao)
VALUES      ('Temer',
             'Michel',
             99,
             'Presidente');

INSERT INTO pessoa
            (ultimonome,
             primeironome,
             idade,
             profissao)
VALUES      ('Buarque',
             'Chico',
             73,
             'Músico');

INSERT INTO pessoa
            (ultimonome,
             primeironome,
             idade,
             profissao)
VALUES      ('Carlos',
             'Roberto',
             76,
             'Músico');

INSERT INTO pessoa
            (ultimonome,
             primeironome,
             idade,
             profissao)
VALUES      ('Junior',
             'Neymar',
             25,
             'Jogador');

INSERT INTO pedido
            (numeropedido,
             pessoaid,
             valor)
VALUES      (123,
             1,
             3123);

INSERT INTO pedido
            (numeropedido,
             pessoaid,
             valor)
VALUES      (124,
             1,
             13445);

INSERT INTO pedido
            (numeropedido,
             pessoaid,
             valor)
VALUES      (125,
             1,
             12344);

INSERT INTO pedido
            (numeropedido,
             pessoaid,
             valor)
VALUES      (126,
             2,
             87879);

INSERT INTO pedido
            (numeropedido,
             pessoaid,
             valor)
VALUES      (127,
             2,
             12266);

INSERT INTO pedido
            (numeropedido,
             pessoaid,
             valor)
VALUES      (128,
             3,
             223);

INSERT INTO pedido
            (numeropedido,
             pessoaid,
             valor)
VALUES      (129,
             3,
             77898);

SELECT DISTINCT profissao
FROM   pessoa;

SELECT primeironome
FROM   pessoa
WHERE  ( idade > 35 );

SELECT ultimonome
FROM   pessoa
WHERE  profissao LIKE 'p%';

SELECT ultimonome
FROM   pessoa
WHERE  ( idade >= 30 )
       AND ( idade <= 40 );

SELECT *
FROM   pessoa
WHERE  id IN ( 1, 5, 7, 10 );  