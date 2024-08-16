-- database: ../DataBase/KSAQQ.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
|----------------------------------------|
Autor : Katherine Sanchez 
Fecha : 
Script: Creacion de la estructura de datos para EcuFauna
*/
DROP TABLE IF EXISTS SKCatalogoUb;
DROP TABLE IF EXISTS SKHormiguero;
DROP TABLE IF EXISTS SKIngestaNativa;
DROP TABLE IF EXISTS SKSexoHormiga;
DROP TABLE IF EXISTS SKGenoAlimento;

--
CREATE TABLE SKCatalogoUb (
    idSKCatalogoUb          INTEGER     PRIMARY KEY AUTOINCREMENT,
    SKNrCategoria           int         NOT NULL,
    SKLugar                 TEXT        NOT NULL,
    SKEstado                VARCHAR(1)  NOT NULL DEFAULT('A')CHECK (SKEstado  IN ('A','X')),
    SKFechaModificacion     DATETIME    DEFAULT current_timestamp

);

CREATE TABLE SKIngestaNativa (
    idSKIngestaNativa       INTEGER PRIMARY KEY AUTOINCREMENT,
    SKClasificacion         TEXT    NOT NULL,
    SKDescripcion           TEXT,
    SKEstado                VARCHAR(1)  NOT NULL DEFAULT('A')CHECK (SKEstado  IN ('A','X')),
    SKFechaModificacion     DATETIME    DEFAULT current_timestamp
);

CREATE TABLE SKSexoHormiga (
    idSKSexoHormiga         INTEGER     PRIMARY KEY AUTOINCREMENT,
    SKSexo                  TEXT        NOT NULL,
    SKEstado                VARCHAR(1)  NOT NULL DEFAULT('A')CHECK (SKEstado  IN ('A','X')),
    SKFechaModificacion     DATETIME    DEFAULT current_timestamp
);

CREATE TABLE SKGenoAlimento (
    idSKGenoAlimento        INTEGER     PRIMARY KEY AUTOINCREMENT,
    SKGenoAlimento          TEXT        NOT NULL,
    SKEstado                VARCHAR(1)  NOT NULL DEFAULT('A')CHECK (SKEstado  IN ('A','X')),
    SKFechaModificacion     DATETIME    DEFAULT current_timestamp

);

CREATE TABLE SKHormiguero (
    idSKHormiguero          INTEGER     PRIMARY KEY AUTOINCREMENT,
    SKTipoHormiga           TEXT        NOT NULL,
    idSKSexoHormiga         INTEGER     REFERENCES SKSexoHormiga(idSKSexoHormiga),
    idSKIngestaNativa       INTEGER     REFERENCES SKIngestaNativa(idSKIngestaNativa),
    idSKGenoAlimento        INTEGER     REFERENCES SKGenoAlimento(idSKGenoAlimento),
    idSKCatalogoUb          INTEGER     REFERENCES SKCatalogoUb(idSKCatalogoUb), 
    SKEstado                VARCHAR(1)  NOT NULL DEFAULT('V') CHECK (SKEstado IN ('V','X')),
    SKFechaModificacion     DATETIME    DEFAULT current_timestamp
);





