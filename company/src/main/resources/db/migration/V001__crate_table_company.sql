CREATE TABLE company (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(80) NOT NULL,
    cnpj VARCHAR(20) NOT NULL
);

INSERT INTO company (name, cnpj) VALUES ('Empresa 1', '11111111111111');
INSERT INTO company (name, cnpj) VALUES ('Empresa 2', '22222222222222');
INSERT INTO company (name, cnpj) VALUES ('Empresa 3', '33333333333333');
