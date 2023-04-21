COMO RODAR APLICAÇÃO NO APACHE.
Tools >> Library >> New Library >> name "MyLibraryAPI2" >> Add JAR/Folder >> 
"Selecionar o arquivo referente a jcalendar-1.4.jar e flatlaf-3.0.jar" >>
>> OK >> "Em libraries adicionar a biblioteca criada >> 


VIDEO https://www.youtube.com/watch?v=HsxUlODSvfM
BASE PARA PROGRAMAÇÃO DO BANCO DE DADOS


DOWNLOAD DOS ARQUIVOS PAKCPAGE .JAR
Criado pasta onde estão armazenados os pacotes .jar dos arquivos suporte da aplicação. 
H2 >> https://github.com/h2database/h2database/releases/download/version-2.1.214/h2-2022-06-13.zip


RODANDO CONSOLE APLICATION.
Para rodar é necessário iniciar a aplicação. Para tal, executar o comando:
	java -jar h2*.jar
	Substituir o * pelo complemento da versão do banco de dados.
	java -jar h2-2.1.214.jar
	
Lembrando que esse comando para ser executado com exatidadão, é necessário abrir a pasta bin do H2 via CMD
através do comando CD.
	cd D:\thiag\Documents\00 - Programação\API-2\DataBaseH2\Packpage\h2-2.1.214\bin



Agora com interface aberta, em SQL statement realizar o comando para criar o banco de dados:
Create database gerenciamento;
USE gerenciamento; 

CREATE TABLE `aula` (
  `id` int PRIMARY KEY auto_increment,
  `nome` varchar(200),
  `inicio` Datetime,
  `final` Datetime
);

CREATE TABLE `aluno` (
  `alunoId` int PRIMARY KEY auto_increment,
  `nome`  varchar(200)
);

CREATE TABLE `aluno_sala` (
  `id` int,
  `alunoId` int
);

CREATE TABLE `tarefa` (
  `Id_tarefa` int PRIMARY KEY auto_increment,
  `nome`  varchar(200),
  `data_inicial` Date,
  `data_entrega` Date
);

CREATE TABLE `aluno_tarefa` (
  `Id` int PRIMARY KEY auto_increment,
  `Id_tarefa` int,
  `Id_aluno` int,
  `nome`  varchar(200),
  `data_entrega` Date,
  `nota` double,
  `comentarios`  varchar(500)
);

ALTER TABLE `aluno_sala` ADD FOREIGN KEY (`id`) REFERENCES `aula` (`id`);

ALTER TABLE `aluno_sala` ADD FOREIGN KEY (`alunoId`) REFERENCES `aluno` (`alunoId`);

ALTER TABLE `aluno_tarefa` ADD FOREIGN KEY (`Id_tarefa`) REFERENCES `tarefa` (`Id_tarefa`);

ALTER TABLE `aluno_tarefa` ADD FOREIGN KEY (`Id_aluno`) REFERENCES `aluno` (`alunoId`);

_______________________________________________________________________________________________________
Após a criação do banco, será gerado o arquivo no users do windows como nome do bd criado.





>>> AGORA ENCERRAREMOS A CONEXÃO COM CONFIGURADOR DE BANCO DE DADOS, NO PROMPT DE COMANDO EXECUTAR:
	CTRL+C


_______________________________________________________________________________________________________
_______________________________________________________________________________________________________
_______________________________________________________________________________________________________
_______________________________________________________________________________________________________

CONECTANDO BANCO DE DADOS MODO DE MEMÓRIA.