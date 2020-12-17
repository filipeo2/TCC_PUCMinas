## POC #3 - Uso analítico de dados

O vídeo desta demonstração está disponível no [YouTube](https://youtu.be/1t7Ru5VrCmI)

***

## Instruções

#### 1º - Opção 1 - Restaurar backup do banco de dados SQL Server 2019 (versão utilizada 15.0.2070.41)
- Instalar o SQL Server Management 18 (versão utilizada 15.0.18358.0) e restaurar o backup `master.bak` no database `master` disponibilizado na pasta [./Backup do DW](./Backup&nbsp;do&nbsp;DW)

*Para detalhes sobre a restauração: https://docs.microsoft.com/pt-br/sql/relational-databases/backup-restore/restore-a-database-backup-using-ssms?view=sql-server-ver15*


#### 1º - Opção 2 - Importar os dados disponibilizados em Excel através do utilitário de importação de dados do SQL Server

Além do backup disponibilizado na opção 1, o conteúdo das tabelas está disponível também em excel para ser importado via utilitário.

- Utilizar o utilitário `SQL Server Import and Export Data` já disponibilizado com a instalação do SQL Server para importar os dados presentes em cada uma das abas do Excel `DadosCompletos.xlsx` , disponibilizado no caminho [Backup do DW](./Backup&nbsp;do&nbsp;DW)

- Durante a importação selecionar `Microsoft Excel` como data source e o arquivo excel, selecionar `Microsoft OLE DB Driver for SQLServer` e o database master como destino. Escolher a opção `Copy data from one or more tables or views` e selecionar as 6 tabelas `DM*-*`

*Obs.: A importação por este método adiciona indevidamente os caracteres `'` e `$'` no início e no fim do nome sugerido para a nova tabela e esses caracteres precisam ser retirados ainda nesta tela, antes das tabelas serem criadas na instância. Portanto é necessário editar o nome das tabelas na coluna `Destination`.


#### 2º - Abrir o projeto PowerBI e reconfigurar a conexão com o SQL Server local
- Expandir a janela `Fields`, clicar com o botão direito do mouse em uma tabela e escolher a opção `Edit Query`

- Na aba `Home`, abrir o `Advanced editor` e editar o endereço da instância SQL Server já definida para a nova instância local iniciada no passo 1.

De:
```
let
    Source = Sql.Database("DESKTOP-B1S624R\SQLEXPRESS", "master"),
    #"dbo_DMComum-Calendário" = Source{[Schema="dbo",Item="DMComum-Calendário"]}[Data]
in
    #"dbo_DMComum-Calendário"
```

Para:
```
let
    Source = Sql.Database("nome_do_seu_computador_aqui\SQLEXPRESS", "master"),
    #"dbo_DMComum-Calendário" = Source{[Schema="dbo",Item="DMComum-Calendário"]}[Data]
in
    #"dbo_DMComum-Calendário"
```
- Fazer o mesmo procedimento acima para as outras 5 tabelas.