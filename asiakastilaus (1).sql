-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 08.09.2022 klo 13:01
-- Palvelimen versio: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `asiakastilaus`
--

-- --------------------------------------------------------

--
-- Rakenne taululle `asiakas`
--

CREATE TABLE `asiakas` (
  `ASIAKASNUMERO` int(11) NOT NULL,
  `ASIAKKAAKSITULOPAIVA` date NOT NULL,
  `YRITYS` text NOT NULL,
  `ETUNIMI` text NOT NULL,
  `SUKUNIMI` text NOT NULL,
  `KATUOSOITE` text NOT NULL,
  `POSTITOIMIPAIKKA` text NOT NULL,
  `PUHELIN` text NOT NULL,
  `EMAIL` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Vedos taulusta `asiakas`
--

INSERT INTO `asiakas` (`ASIAKASNUMERO`, `ASIAKKAAKSITULOPAIVA`, `YRITYS`, `ETUNIMI`, `SUKUNIMI`, `KATUOSOITE`, `POSTITOIMIPAIKKA`, `PUHELIN`, `EMAIL`) VALUES
(4, '2022-09-08', 'Riveria ', 'Denis', 'Bogdanov', '', '', '', ''),
(5, '2022-09-08', 'riveria', 'Katja', 'Gaeva', '', '', '', ''),
(9, '2022-09-08', 'Joensuu Oy', 'Matti', 'Siivonen', '', '', '', ''),
(10, '2022-09-08', 'fg', 'as', 'sdf', 'rweg', '', '', ''),
(11, '2022-09-08', 'mg', 'dd', 'vngh', 'gm,', '', '', ''),
(12, '2022-09-08', 'mg', 'dd', 'vngh', 'gm,', '', '', ''),
(13, '2022-09-08', 'mg', 'dd', 'vngh', 'gm,', '', '', '');

-- --------------------------------------------------------

--
-- Rakenne taululle `asiakas2`
--

CREATE TABLE `asiakas2` (
  `ASIAKASNUMERO` int(11) NOT NULL,
  `ASIAKKAAKSITULOPAIVA` date NOT NULL,
  `YRITYS` text NOT NULL,
  `ETUNIMI` text NOT NULL,
  `SUKUNIMI` text NOT NULL,
  `KATUOSOITE` text NOT NULL,
  `POSTITOIMIPAIKKA` text NOT NULL,
  `PUHELIN` text NOT NULL,
  `EMAIL` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Vedos taulusta `asiakas2`
--

INSERT INTO `asiakas2` (`ASIAKASNUMERO`, `ASIAKKAAKSITULOPAIVA`, `YRITYS`, `ETUNIMI`, `SUKUNIMI`, `KATUOSOITE`, `POSTITOIMIPAIKKA`, `PUHELIN`, `EMAIL`) VALUES
(1, '2010-11-12', 'Jukka Oy', 'Jukka', 'Kukkonen', 'Haapaniementie 3', 'KUOPIO', '0402113421', 'jukka.kukkonen@hotmail.com'),
(2, '2011-08-12', 'Jukka 2 Oy', 'Jukka', 'Kukkonen', 'Lasitie 3', 'JOENSUU', '0503454422', 'kimmo.kukkonen@hotmail.com'),
(3, '2010-03-04', 'Teemu Oy', 'Teemu', 'Heikkinen', 'Kellopolku 3', 'JOENSUU', '050786821', 'teemu.heikkinen@hotmail.com'),
(4, '2011-02-02', 'Tiina Ky', 'Tiina', 'Heikkinen', 'Kellopolku 3', 'JOENSUU', '050788812', 'tiina.heikkinen@yahoo.com'),
(5, '2011-05-04', 'Leena Oy', 'Leena', 'Turunen', 'Käsityökuja 3', 'JOENSUU', '044567123', 'leena.turunen@gmail.com'),
(6, '2009-05-04', 'Harrin Asennus Ky', 'Harri', 'Heikkinen', 'Asennuskatu 23', 'JOENSUU', '0405234123', 'harri.turunen@gmail.com');

-- --------------------------------------------------------

--
-- Rakenne taululle `kayttaja`
--

CREATE TABLE `kayttaja` (
  `TUNNUS` varchar(30) NOT NULL,
  `SALASANA` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Vedos taulusta `kayttaja`
--

INSERT INTO `kayttaja` (`TUNNUS`, `SALASANA`) VALUES
('HeikkiHuoltohenkilO', 0xffe81907991fde1cc363d39fc08dcf89ca),
('HeikkiHuoltohenkilO2', 0xffe81907991fde1cc363d39fc08dcf89ca);

-- --------------------------------------------------------

--
-- Rakenne taululle `tilaus`
--

CREATE TABLE `tilaus` (
  `tilausnumero` int(11) NOT NULL,
  `asiakasnumero` int(11) NOT NULL,
  `tilauspaiva` date NOT NULL,
  `toimituspaiva` date NOT NULL,
  `erapaiva` date NOT NULL,
  `maksutapa` text NOT NULL,
  `lisatiedot` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Vedos taulusta `tilaus`
--

INSERT INTO `tilaus` (`tilausnumero`, `asiakasnumero`, `tilauspaiva`, `toimituspaiva`, `erapaiva`, `maksutapa`, `lisatiedot`) VALUES
(1, 1, '2019-11-22', '2019-11-22', '2019-12-11', '1', 0),
(2, 2, '2019-10-22', '2019-10-22', '2019-11-11', '1', 0),
(3, 3, '2019-11-22', '2019-11-22', '2019-12-11', '1', 0),
(4, 4, '2019-10-22', '2019-10-22', '2019-11-11', '1', 0),
(5, 5, '2019-09-22', '2019-09-22', '2019-11-11', '1', 0);

-- --------------------------------------------------------

--
-- Rakenne taululle `tilausrivi`
--

CREATE TABLE `tilausrivi` (
  `tilausrivinumero` int(11) NOT NULL,
  `tilausnumero` int(11) NOT NULL,
  `tuotenumero` int(11) NOT NULL,
  `maara` int(11) NOT NULL,
  `hinta` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Vedos taulusta `tilausrivi`
--

INSERT INTO `tilausrivi` (`tilausrivinumero`, `tilausnumero`, `tuotenumero`, `maara`, `hinta`) VALUES
(1, 1, 1, 2, '5'),
(2, 1, 2, 2, '4'),
(3, 2, 2, 3, '5'),
(4, 2, 3, 2, '9'),
(5, 2, 4, 2, '25'),
(6, 3, 1, 2, '5'),
(7, 3, 2, 2, '4'),
(8, 3, 4, 2, '25'),
(9, 4, 1, 2, '5'),
(10, 4, 3, 2, '9'),
(11, 4, 4, 2, '25'),
(12, 5, 1, 1, '5');

-- --------------------------------------------------------

--
-- Rakenne taululle `tuote`
--

CREATE TABLE `tuote` (
  `tuotenumero` int(11) NOT NULL,
  `tuotenimi` text NOT NULL,
  `selite` text NOT NULL,
  `ahinta` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Vedos taulusta `tuote`
--

INSERT INTO `tuote` (`tuotenumero`, `tuotenimi`, `selite`, `ahinta`) VALUES
(1, 'SAHA', 'RAKENNUSSAHA', 5),
(2, 'VASARA', 'RAKENNUSKÄYTTÖÖN', 4),
(3, 'METRIMITTA', '10 M', 9),
(4, 'KIRVES', '3 kg', 25);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `asiakas`
--
ALTER TABLE `asiakas`
  ADD PRIMARY KEY (`ASIAKASNUMERO`);

--
-- Indexes for table `asiakas2`
--
ALTER TABLE `asiakas2`
  ADD PRIMARY KEY (`ASIAKASNUMERO`);

--
-- Indexes for table `kayttaja`
--
ALTER TABLE `kayttaja`
  ADD PRIMARY KEY (`TUNNUS`);

--
-- Indexes for table `tilaus`
--
ALTER TABLE `tilaus`
  ADD PRIMARY KEY (`tilausnumero`),
  ADD KEY `asiakasnumero` (`asiakasnumero`),
  ADD KEY `lisatiedot` (`lisatiedot`);

--
-- Indexes for table `tilausrivi`
--
ALTER TABLE `tilausrivi`
  ADD PRIMARY KEY (`tilausrivinumero`),
  ADD KEY `tilausnumero` (`tilausnumero`),
  ADD KEY `tuotenumero` (`tuotenumero`),
  ADD KEY `maara` (`maara`),
  ADD KEY `hinta` (`hinta`);

--
-- Indexes for table `tuote`
--
ALTER TABLE `tuote`
  ADD PRIMARY KEY (`tuotenumero`),
  ADD KEY `ahinta` (`ahinta`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `asiakas`
--
ALTER TABLE `asiakas`
  MODIFY `ASIAKASNUMERO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Rajoitteet vedostauluille
--

--
-- Rajoitteet taululle `tilaus`
--
ALTER TABLE `tilaus`
  ADD CONSTRAINT `tilaus_ibfk_1` FOREIGN KEY (`asiakasnumero`) REFERENCES `asiakas2` (`asiakasnumero`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Rajoitteet taululle `tilausrivi`
--
ALTER TABLE `tilausrivi`
  ADD CONSTRAINT `tilausrivi_ibfk_1` FOREIGN KEY (`tuotenumero`) REFERENCES `tuote` (`tuotenumero`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tilausrivi_ibfk_2` FOREIGN KEY (`tilausnumero`) REFERENCES `tilaus` (`tilausnumero`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
