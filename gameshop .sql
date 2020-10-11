-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 10, 2020 at 06:55 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gameshop`
--

-- --------------------------------------------------------

--
-- Table structure for table `artikli`
--

CREATE TABLE `artikli` (
  `id` int(255) NOT NULL,
  `id_fk` int(255) NOT NULL,
  `naziv` varchar(30) NOT NULL,
  `cena` int(10) NOT NULL,
  `tip` varchar(10) NOT NULL,
  `zanr` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `artikli`
--

INSERT INTO `artikli` (`id`, `id_fk`, `naziv`, `cena`, `tip`, `zanr`) VALUES
(1, 2, 'ass', 150, 'action', 'Game');

-- --------------------------------------------------------

--
-- Table structure for table `korisnici`
--

CREATE TABLE `korisnici` (
  `Id` int(255) NOT NULL,
  `id_fk` int(255) NOT NULL,
  `ime` varchar(255) NOT NULL,
  `prezime` varchar(30) NOT NULL,
  `god_rodjenja` varchar(20) NOT NULL,
  `br_telefona` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `nalog`
--

CREATE TABLE `nalog` (
  `Id` int(255) NOT NULL,
  `k_ime` varchar(25) NOT NULL,
  `mail` varchar(30) NOT NULL,
  `lozinka` varchar(25) NOT NULL,
  `tip` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nalog`
--

INSERT INTO `nalog` (`Id`, `k_ime`, `mail`, `lozinka`, `tip`) VALUES
(1, 'admin', 'admin', 'admin', 'a');

-- --------------------------------------------------------

--
-- Table structure for table `prodavci`
--

CREATE TABLE `prodavci` (
  `Id` int(255) NOT NULL,
  `id_fk` int(255) NOT NULL,
  `naziv` varchar(30) NOT NULL,
  `web_site` varchar(30) NOT NULL,
  `pib` int(11) NOT NULL,
  `br_telefona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `racuni`
--

CREATE TABLE `racuni` (
  `Id` int(255) NOT NULL,
  `ime_proizvoda` varchar(30) NOT NULL,
  `cena` int(15) NOT NULL,
  `tip` varchar(15) NOT NULL,
  `zanr` varchar(20) NOT NULL,
  `ime_prodavca` varchar(20) NOT NULL,
  `vrsta_kartice` varchar(20) NOT NULL,
  `broj_kartice` int(15) NOT NULL,
  `dat_isteka` varchar(10) NOT NULL,
  `kod` int(15) NOT NULL,
  `k_korisnik` varchar(25) NOT NULL,
  `ime_korisnika` varchar(20) NOT NULL,
  `prezime` varchar(30) NOT NULL,
  `br_tel` int(15) NOT NULL,
  `zemlja` varchar(15) NOT NULL,
  `grad` varchar(15) NOT NULL,
  `datuk_kupovine` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `racuni`
--

INSERT INTO `racuni` (`Id`, `ime_proizvoda`, `cena`, `tip`, `zanr`, `ime_prodavca`, `vrsta_kartice`, `broj_kartice`, `dat_isteka`, `kod`, `k_korisnik`, `ime_korisnika`, `prezime`, `br_tel`, `zemlja`, `grad`, `datuk_kupovine`) VALUES
(1, 'ass', 150, 'action', 'Game', 'ubi', 'Visa', 123235465, '1/2020', 5456, 'metan', 'Nikola', 'Nikol', 648683201, 's', 's', '2020/10/10');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artikli`
--
ALTER TABLE `artikli`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `korisnici`
--
ALTER TABLE `korisnici`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `id_fk` (`id_fk`);

--
-- Indexes for table `nalog`
--
ALTER TABLE `nalog`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `prodavci`
--
ALTER TABLE `prodavci`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `id_fk` (`id_fk`);

--
-- Indexes for table `racuni`
--
ALTER TABLE `racuni`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `artikli`
--
ALTER TABLE `artikli`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `korisnici`
--
ALTER TABLE `korisnici`
  MODIFY `Id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `nalog`
--
ALTER TABLE `nalog`
  MODIFY `Id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `prodavci`
--
ALTER TABLE `prodavci`
  MODIFY `Id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `racuni`
--
ALTER TABLE `racuni`
  MODIFY `Id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `korisnici`
--
ALTER TABLE `korisnici`
  ADD CONSTRAINT `korisnici_ibfk_1` FOREIGN KEY (`id_fk`) REFERENCES `nalog` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `prodavci`
--
ALTER TABLE `prodavci`
  ADD CONSTRAINT `prodavci_ibfk_1` FOREIGN KEY (`id_fk`) REFERENCES `nalog` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
