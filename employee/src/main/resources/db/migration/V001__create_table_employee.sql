CREATE TABLE employee (
    id          INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(80) NOT NULL,
    sector      VARCHAR(20) NOT NULL,
    company_id  INT NOT NULL
);

INSERT INTO employee (name, sector, company_id) VALUES ('Funcionario 1', 'Setor A', 1);
INSERT INTO employee (name, sector, company_id) VALUES ('Funcionario 2', 'Setor A', 1);
INSERT INTO employee (name, sector, company_id) VALUES ('Funcionario 3', 'Setor B', 1);
INSERT INTO employee (name, sector, company_id) VALUES ('Funcionario 1', 'Setor A', 2);
INSERT INTO employee (name, sector, company_id) VALUES ('Funcionario 2', 'Setor A', 2);
INSERT INTO employee (name, sector, company_id) VALUES ('Funcionario 3', 'Setor B', 2);
INSERT INTO employee (name, sector, company_id) VALUES ('Funcionario 1', 'Setor A', 3);
INSERT INTO employee (name, sector, company_id) VALUES ('Funcionario 2', 'Setor A', 3);
INSERT INTO employee (name, sector, company_id) VALUES ('Funcionario 3', 'Setor B', 3);