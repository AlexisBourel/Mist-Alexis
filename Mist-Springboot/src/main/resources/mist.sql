-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 30, 2018 at 09:09 AM
-- Server version: 5.6.38-log
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mist`
--

-- --------------------------------------------------------

--
-- Table structure for table `agent`
--

DROP TABLE IF EXISTS `agent`;
CREATE TABLE IF NOT EXISTS `agent` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `motdepasse` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `id_profil` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3wa50if079jnq26tuftbfc853` (`id_profil`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `agent`
--

INSERT INTO `agent` (`id`, `email`, `motdepasse`, `nom`, `prenom`, `id_profil`) VALUES
(1, NULL, NULL, NULL, NULL, NULL),
(2, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `arme`
--

DROP TABLE IF EXISTS `arme`;
CREATE TABLE IF NOT EXISTS `arme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_arme` varchar(255) NOT NULL,
  `type_munition` varchar(255) NOT NULL,
  `nom_arme` varchar(255) NOT NULL,
  `numero_serie_arme` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `arme`
--

INSERT INTO `arme` (`id`, `type_arme`, `type_munition`, `nom_arme`, `numero_serie_arme`) VALUES
(4, 'Semi-Automatique', '22', 'Beretta', 'EX15430984'),
(5, 'Fusil à pompe', '12', 'Winchester', 'LP43GP543');

-- --------------------------------------------------------

--
-- Table structure for table `condamnation`
--

DROP TABLE IF EXISTS `condamnation`;
CREATE TABLE IF NOT EXISTS `condamnation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_condamnation` datetime DEFAULT NULL,
  `motif` varchar(255) DEFAULT NULL,
  `id_suspect_cond` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl73xch4oouxem3kyb03r4iwd8` (`id_suspect_cond`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `document`
--

DROP TABLE IF EXISTS `document`;
CREATE TABLE IF NOT EXISTS `document` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_emission` datetime DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `id_suspect` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKondljdp8jrpg1jqghqy706v3w` (`id_suspect`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adresse` varchar(255) DEFAULT NULL,
  `date_naissance` datetime DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `profil`
--

DROP TABLE IF EXISTS `profil`;
CREATE TABLE IF NOT EXISTS `profil` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `profil`
--

INSERT INTO `profil` (`id`, `libelle`) VALUES
(1, 'ADMIN'),
(2, 'UTILISATEUR');

-- --------------------------------------------------------

--
-- Table structure for table `suspect`
--

DROP TABLE IF EXISTS `suspect`;
CREATE TABLE IF NOT EXISTS `suspect` (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `motdepasse` varchar(60) NOT NULL,
  `id_profil` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2rpdpv15clle66lxyvro27vuh` (`id_profil`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `email`, `motdepasse`, `id_profil`) VALUES
(4, 'Jordan', 'Suzanne', 'fdq@fdz.fr', 'cvdsq', 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `agent`
--
ALTER TABLE `agent`
  ADD CONSTRAINT `FK3wa50if079jnq26tuftbfc853` FOREIGN KEY (`id_profil`) REFERENCES `profil` (`id`);

--
-- Constraints for table `condamnation`
--
ALTER TABLE `condamnation`
  ADD CONSTRAINT `FKl73xch4oouxem3kyb03r4iwd8` FOREIGN KEY (`id_suspect_cond`) REFERENCES `suspect` (`id`);

--
-- Constraints for table `document`
--
ALTER TABLE `document`
  ADD CONSTRAINT `FKondljdp8jrpg1jqghqy706v3w` FOREIGN KEY (`id_suspect`) REFERENCES `suspect` (`id`);

--
-- Constraints for table `suspect`
--
ALTER TABLE `suspect`
  ADD CONSTRAINT `FKo5ym7qqdr9v09a2a8r1hbmuex` FOREIGN KEY (`id`) REFERENCES `personne` (`id`);

--
-- Constraints for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `FK2rpdpv15clle66lxyvro27vuh` FOREIGN KEY (`id_profil`) REFERENCES `profil` (`id`),
  ADD CONSTRAINT `fk_id_profil` FOREIGN KEY (`id_profil`) REFERENCES `profil` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
