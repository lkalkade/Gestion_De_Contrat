-- phpMyAdmin SQL Dump
-- version 4.5.1
-- 
http://www.phpmyadmin.net
--
-- 
Client :  127.0.0.1
-- Généré le :  Jeu 18 Février 2016 à 14:44
-- 
Version du serveur :  10.1.8-MariaDB
-- Version de PHP :  5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;

/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;

/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;

/*!40101 SET NAMES utf8mb4 */;


--
-- Base de données :  `gestioncontrat`
--

-- --------------------------------------------------------

--
-- 
Structure de la table `client`

--

CREATE TABLE `client` (
  
	`Nom_Client` varchar(64) NOT NULL,
  
	`Num_Client` int(20) NOT NULL

	) 

ENGINE=InnoDB DEFAULT CHARSET=latin1;



--
-- Contenu de la table `client`


--

INSERT INTO `client` (`Nom_Client`, `Num_Client`) VALUES
('A2L COPY', 1234),
('AZ', 1236),
('AZERTY', 1235),
('BURGERKING', 1241),
('CHOUGAROU', 1238),
('CHUPS', 1239),
('JUJU', 1237),
('LALA', 1242),
('LAYS', 1240);

--

--------------------------------------------------------

--
-- Structure de la table `contrat`

--

CREATE TABLE `contrat` (
  
	`Num_Contrat` int(20) NOT NULL,
  
	`Nom_Client` varchar(64) NOT NULL,

	`Date_Contrat` varchar(64) NOT NULL,
  
	`Type_Contrat` varchar(64) NOT NULL,
  	
	`Forfait` varchar(64) NOT NULL,
  
	`Deplacement` varchar(64) NOT NULL,
  
	`Temps_Restant` varchar(64) NOT NULL,
  
	`Temps_Total` varchar(64) NOT NULL,
  
	`Report` varchar(64) NOT NULL,
  
	`Statut_Contrat` varchar(64) NOT NULL

	) 

ENGINE=InnoDB DEFAULT CHARSET=latin1;



--
-- Contenu de la table `contrat`


--

INSERT INTO `contrat` (`Num_Contrat`, `Nom_Client`, `Date_Contrat`, `Type_Contrat`, `Forfait`, `Deplacement`, `Temps_Restant`, `Temps_Total`, `Report`, `Statut_Contrat`) VALUES
(12345678, 'A2L COPY', '26/01/2016', 'Sage', '10:00:00', 'Oui', '00:00:00', '10:00:00', '00:00:00', 'Inactif'),
(12345680, 'AZERTY', '27/01/2016', 'Materiel', '03:00:00', 'Oui', '00:00:00', '05:00:00', '02:00:00', 'Hors Forfait'),
(12345681, 'AZ', '27/01/2016', 'Logiciel', '02:00:00', 'Oui', '00:00:00', '02:00:00', '00:00:00', 'Inactif'),
(12345682, 'JUJU', '28/01/2016', 'Sage', '10:00:00', 'Oui', '00:00', '10:00', '00:00', 'Inactif');

-- 

--------------------------------------------------------

--
-- Structure de la table `intervention`

--

CREATE TABLE `intervention` (
  
	`Num_Intervention` int(20) NOT NULL,
  
	`Nom_Technicien` varchar(64) NOT NULL,
  
	`Date_Intervention` varchar(64) NOT NULL,
  
	`Heure_Debut` varchar(64) NOT NULL,
  
	`Heure_Fin` varchar(64) NOT NULL,
  
	`Duree_Intervention` varchar(64) NOT NULL,
  
	`Num_Contrat` int(20) NOT NULL

	) 

ENGINE=InnoDB DEFAULT CHARSET=latin1;



--
-- Contenu de la table `intervention`


--

INSERT INTO `intervention` (`Num_Intervention`, `Nom_Technicien`, `Date_Intervention`, `Heure_Debut`, `Heure_Fin`, `Duree_Intervention`, `Num_Contrat`) VALUES
(1, '', '', '', '', '', 12345680),
(2, 'AZERTY', '14/02/2016', '12:00', '13:00', '01:00', 12345680),
(3, 'AZ', '17/02/2016', '10:00', '12:00', '02:00', 12345682),
(4, 'AZER', '17/02/2016', '10:00', '14:00', '04:00', 12345682),
(5, 'AZER', '18/02/2016', '12:00', '14:00', '02:00', 12345682),
(6, 'AZER', '19/02/2016', '12:00', '14:00', '02:00', 12345682),
(7, 'AZER', '20/02/2016', '12:00', '14:00', '02:00', 12345682),
(8, 'ASERT', '17/02/2016', '11:00', '12:00', '01:00', 12345681),
(9, 'ADERT', '17/02/2016', '12:00', '13:00', '01:00:00', 12345681);



--
-- Index pour les tables exportées
--

--
-- 
Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`Nom_Client`);



--
-- Index pour la table `contrat`
--
ALTER TABLE `contrat`
  ADD PRIMARY KEY (`Num_Contrat`),
  ADD KEY `Nom_Client` (`Nom_Client`);



--
-- Index pour la table `intervention`
--
ALTER TABLE `intervention`
  ADD PRIMARY KEY (`Num_Intervention`),
  ADD KEY `Num_Contrat` (`Num_Contrat`),
  ADD KEY `Num_Contrat_2` (`Num_Contrat`),
  ADD KEY `Num_Contrat_3` (`Num_Contrat`);



--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `contrat`
--
ALTER TABLE `contrat`
  ADD CONSTRAINT `contrat_ibfk_1` FOREIGN KEY (`Nom_Client`) REFERENCES `client` (`Nom_Client`);



--
-- Contraintes pour la table `intervention`

--
ALTER TABLE `intervention`
  ADD CONSTRAINT `intervention_ibfk_1` FOREIGN KEY (`Num_Contrat`) REFERENCES `contrat` (`Num_Contrat`);



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;

/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
