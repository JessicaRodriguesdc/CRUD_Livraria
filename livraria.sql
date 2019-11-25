-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 25-Nov-2019 às 03:45
-- Versão do servidor: 10.1.40-MariaDB
-- versão do PHP: 7.1.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `livraria`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nomeCliente` varchar(50) NOT NULL,
  `cpf` varchar(15) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `nomeCliente`, `cpf`, `telefone`) VALUES
(1, 'Jessica Rodrigues', '123456789', '123456789'),
(2, 'Marcelino Rodrigues', '098877667', '12345679'),
(3, 'Emily Maria', '12345678998', '30219948'),
(4, 'Emersson', '08879255381', '86669666');

-- --------------------------------------------------------

--
-- Estrutura da tabela `livro`
--

CREATE TABLE `livro` (
  `id` int(11) NOT NULL,
  `nomeLivro` varchar(50) NOT NULL,
  `autorLivro` varchar(255) DEFAULT NULL,
  `anoLivro` smallint(6) NOT NULL,
  `generoLivro` varchar(100) NOT NULL,
  `editoraLivro` varchar(100) NOT NULL,
  `paginasLivro` smallint(6) DEFAULT NULL,
  `statusLivro` char(15) NOT NULL,
  `idCliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `livro`
--

INSERT INTO `livro` (`id`, `nomeLivro`, `autorLivro`, `anoLivro`, `generoLivro`, `editoraLivro`, `paginasLivro`, `statusLivro`, `idCliente`) VALUES
(1, 'O outro eu', 'Rodrigues', 2019, 'terror', 'Paple', 250, 'D', 0),
(5, 'So pensava em você', 'Rodrigues', 2018, 'Romance', 'Paple', 45, 'A', 1),
(7, 'Lutas', 'Rodrigues', 1999, 'Aventura', 'Paple', 65, 'A', 3),
(8, 'O jogo da jogos', 'Rodrigues', 2017, 'fantasia', 'Paple', 86, 'D', 0),
(16, 'Sei que isso não é real', 'Rodrigues', 2016, 'terror', 'Paple', 98, 'A', 4),
(23, 'Meu Principe', 'Rodrigues', 1998, 'fantasia', 'Paple', 50, 'D', 1),
(27, 'Os 3 lobos', 'Rodrigues', 2016, 'Aventura', 'Paple', 79, 'D', 0),
(28, 'Ja não sei mais', 'Rodrigues', 2016, 'fantasia', 'Paple', 87, 'D', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `livro`
--
ALTER TABLE `livro`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `livro`
--
ALTER TABLE `livro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
