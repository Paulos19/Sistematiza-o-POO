CREATE TABLE dados(
          id TEXT PRIMARY KEY UNIQUE NOT NULL,
          name TEXT NOT NULL,
          cpf INTEGER UNIQUE NOT NULL,
          capacidadeveiculo INT NOT NULL
      );