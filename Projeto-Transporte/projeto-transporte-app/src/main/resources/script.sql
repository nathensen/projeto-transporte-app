CREATE DATABASE IF NOT EXISTS transportedb;
USE transportedb;

CREATE TABLE Motorista (
    id_motorista INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) UNIQUE
);

CREATE TABLE Onibus (
    id_onibus INT PRIMARY KEY AUTO_INCREMENT,
    placa VARCHAR(10) UNIQUE NOT NULL,
    modelo VARCHAR(50)
);

CREATE TABLE Rota (
    id_rota INT PRIMARY KEY AUTO_INCREMENT,
    origem VARCHAR(50) NOT NULL,
    destino VARCHAR(50) NOT NULL,
    id_motorista INT,
    id_onibus INT,
    FOREIGN KEY (id_motorista) REFERENCES Motorista(id_motorista),
    FOREIGN KEY (id_onibus) REFERENCES Onibus(id_onibus)
);