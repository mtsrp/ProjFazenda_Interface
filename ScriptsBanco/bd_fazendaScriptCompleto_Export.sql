-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 11-Maio-2019 às 00:27
-- Versão do servidor: 5.7.23
-- versão do PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bd_fazenda`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
CREATE TABLE IF NOT EXISTS `funcionario` (
  `cod_func` smallint(6) NOT NULL AUTO_INCREMENT,
  `nome_func` varchar(45) NOT NULL,
  `dta_adm` date NOT NULL,
  `usuario_func` varchar(10) NOT NULL,
  `senha_func` varchar(20) DEFAULT NULL,
  `dta_dem` date DEFAULT NULL,
  `cod_permis` tinyint(4) NOT NULL,
  `cod_setor` tinyint(4) NOT NULL,
  `email_func` varchar(60) NOT NULL,
  `nasc_func` date NOT NULL,
  `sexo_func` varchar(1) NOT NULL,
  PRIMARY KEY (`cod_func`),
  KEY `FK_FUNC_PERMIS` (`cod_permis`),
  KEY `FK_FUNC_SETOR` (`cod_setor`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `ocorrencia`
--

DROP TABLE IF EXISTS `ocorrencia`;
CREATE TABLE IF NOT EXISTS `ocorrencia` (
  `cod_ocor` tinyint(4) NOT NULL AUTO_INCREMENT,
  `cod_setor` tinyint(4) NOT NULL,
  `titulo_ocor` varchar(45) NOT NULL,
  `desc_ocor` varchar(200) NOT NULL,
  `data_ocor` date NOT NULL,
  `cod_status` tinyint(4) NOT NULL,
  PRIMARY KEY (`cod_ocor`,`cod_setor`),
  KEY `FK_OCOR_SETOR` (`cod_setor`),
  KEY `FK_OCOR_STATUS` (`cod_status`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `permissao`
--

DROP TABLE IF EXISTS `permissao`;
CREATE TABLE IF NOT EXISTS `permissao` (
  `cod_permis` tinyint(4) NOT NULL AUTO_INCREMENT,
  `tipo_permis` varchar(20) NOT NULL,
  PRIMARY KEY (`cod_permis`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `permissao`
--

INSERT INTO `permissao` (`cod_permis`, `tipo_permis`) VALUES
(1, 'Administrador'),
(2, 'Funcionario');

-- --------------------------------------------------------

--
-- Estrutura da tabela `setor`
--

DROP TABLE IF EXISTS `setor`;
CREATE TABLE IF NOT EXISTS `setor` (
  `cod_setor` tinyint(4) NOT NULL AUTO_INCREMENT,
  `nome_setor` varchar(30) NOT NULL,
  `ativo_sn` char(1) NOT NULL,
  PRIMARY KEY (`cod_setor`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `setor`
--

INSERT INTO `setor` (`cod_setor`, `nome_setor`, `ativo_sn`) VALUES
(1, 'Pasto', 's'),
(2, 'Celeiro', 'S');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tarefa`
--

DROP TABLE IF EXISTS `tarefa`;
CREATE TABLE IF NOT EXISTS `tarefa` (
  `cod_tarefa` tinyint(4) NOT NULL AUTO_INCREMENT,
  `cod_setor` tinyint(4) NOT NULL,
  `titulo_tarefa` varchar(45) NOT NULL,
  `desc_tarefa` varchar(200) NOT NULL,
  `data_tarefa` date NOT NULL,
  `cod_status` tinyint(4) NOT NULL,
  PRIMARY KEY (`cod_tarefa`,`cod_setor`),
  KEY `FK_TAREFA_SETOR` (`cod_setor`),
  KEY `FK_TAREFA_STATUS` (`cod_status`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_status`
--

DROP TABLE IF EXISTS `tb_status`;
CREATE TABLE IF NOT EXISTS `tb_status` (
  `cod_status` tinyint(4) NOT NULL AUTO_INCREMENT,
  `tipo_status` varchar(45) NOT NULL,
  PRIMARY KEY (`cod_status`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
