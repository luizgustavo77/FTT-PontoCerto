
CREATE DATABASE PontoCerto
GO

USE PontoCerto
GO

CREATE TABLE [Usuarios] (
  [CPF] bigint primary key,
  [Senha] varchar(20),
  [Nome] varchar(255),
  [Endereco] int,
  [Perfil] int
)
GO

CREATE TABLE [Enderecos] (
  [Id] int PRIMARY KEY IDENTITY(1, 1),
  [CEP] varchar(8),
  [Bairro] varchar(255),
  [Rua] varchar(255),
  [Cidade] varchar(255),
  [Estado] varchar(255)
)
GO

CREATE TABLE [TabelaGeral] (
  [Id] int PRIMARY KEY IDENTITY(1, 1),
  [Descricao] varchar(255)
)
GO

CREATE TABLE [TabelaGeralDependente] (
  [Id] int PRIMARY KEY IDENTITY(1, 1),
  [TabelaGeral] int,
  [Descricao] varchar(255),
  [Sigla] varchar(5)
)
GO

CREATE TABLE [Fretados] (
  [Id] int PRIMARY KEY IDENTITY(1, 1),
  [Numero] int,
  [Motorista] bigint,
  [Descricao] varchar(255),
  [Entrada] time,
  [Saida] time
)
GO

CREATE TABLE [Rotas] (
  [Parada] int,
  [Fretado] int
)
GO

ALTER TABLE [Usuarios] ADD FOREIGN KEY ([Endereco]) REFERENCES [Enderecos] ([Id])
GO

ALTER TABLE [Usuarios] ADD FOREIGN KEY ([Perfil]) REFERENCES [TabelaGeralDependente] ([Id])
GO

ALTER TABLE [TabelaGeralDependente] ADD FOREIGN KEY ([TabelaGeral]) REFERENCES [TabelaGeral] ([Id])
GO

ALTER TABLE [Fretados] ADD FOREIGN KEY ([Motorista]) REFERENCES [Usuarios] ([CPF])
GO

ALTER TABLE [Rotas] ADD FOREIGN KEY ([Parada]) REFERENCES [Enderecos] ([Id])
GO

ALTER TABLE [Rotas] ADD FOREIGN KEY ([Fretado]) REFERENCES [Fretados] ([Id])
GO

insert into TabelaGeral (Descricao) values ('Perfil')

insert into TabelaGeralDependente (TabelaGeral, Descricao, Sigla) values (1, 'Comum', 'CM')
insert into TabelaGeralDependente (TabelaGeral, Descricao, Sigla) values (1, 'Admin', 'AD')

insert into Enderecos (CEP, Bairro, Rua, Cidade, Estado) values('09896160', 'Planalto', 'Rua Cassiano Gabus Mendes', 'Sao Bernardo do Campo', 'SP')
insert into Enderecos (CEP, Bairro, Rua, Cidade, Estado) values('09895110', 'Planalto', 'Rua Benedito Conrado Filho', 'Sao Bernardo do Campo', 'SP')

insert into Usuarios (CPF, Senha, Nome, Endereco, Perfil) values (12345678945, 123456, 'Teste', 1, 1)
insert into Usuarios (CPF, Senha, Nome, Endereco, Perfil) values (22728957845, 123456, 'Teste admin', 2, 2)
