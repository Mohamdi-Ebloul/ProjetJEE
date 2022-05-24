-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 24 mai 2022 à 00:23
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `electricite`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `tel` int(11) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `Adresse` varchar(50) NOT NULL,
  `categorie` varchar(50) NOT NULL,
  `nb_fil` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Structure de la table `compteur`
--

DROP TABLE IF EXISTS `compteur`;
CREATE TABLE IF NOT EXISTS `compteur` (
  `code_compteur` int(11) NOT NULL AUTO_INCREMENT,
  `Date_placement` varchar(30) NOT NULL,
  `status` varchar(30) NOT NULL DEFAULT '"Active"',
  `code_client` int(11) NOT NULL,
  PRIMARY KEY (`code_compteur`),
  KEY `code_client` (`code_client`)
) ENGINE=MyISAM AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `consommation`
--

DROP TABLE IF EXISTS `consommation`;
CREATE TABLE IF NOT EXISTS `consommation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Index_precedent` int(11) NOT NULL DEFAULT '0',
  `Index_nouveau` int(11) NOT NULL DEFAULT '0',
  `CONSOMMATION` int(11) NOT NULL DEFAULT '0',
  `Montant_total` decimal(11,0) NOT NULL DEFAULT '0',
  `Montant_nouveau` decimal(11,0) NOT NULL DEFAULT '0',
  `code_compteur` int(11) NOT NULL,
  `date_changement` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `code_compteur` (`code_compteur`)
) ENGINE=MyISAM AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `factur`
--

DROP TABLE IF EXISTS `factur`;
CREATE TABLE IF NOT EXISTS `factur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_factur` int(11) NOT NULL,
  `Index_precedent` int(11) NOT NULL,
  `Index_nouveau` int(11) NOT NULL,
  `Montant_total` decimal(10,0) NOT NULL,
  `Montant_nouveau` decimal(10,0) NOT NULL,
  `date` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
