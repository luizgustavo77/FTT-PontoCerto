CREATE TABLE [Usuarios] (
  [Id] int PRIMARY KEY IDENTITY(1, 1),
  [CPF] varchar(20),
  [Nome] varchar(255),
  [Endereco] int,
  [Perfil] int
)
GO

CREATE TABLE [Enderecos] (
  [Id] int PRIMARY KEY IDENTITY(1, 1),
  [CEP] int,
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

CREATE TABLE [Fretado] (
  [Id] int PRIMARY KEY IDENTITY(1, 1),
  [Numero] int,
  [Motorista] int,
  [Descricao] varchar(255),
  [Entrada] datetime,
  [Saida] datetime
)
GO

CREATE TABLE [Rota] (
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

ALTER TABLE [Fretado] ADD FOREIGN KEY ([Motorista]) REFERENCES [Usuarios] ([Id])
GO

ALTER TABLE [Rota] ADD FOREIGN KEY ([Parada]) REFERENCES [Enderecos] ([Id])
GO

ALTER TABLE [Rota] ADD FOREIGN KEY ([Fretado]) REFERENCES [Fretado] ([Id])
GO
