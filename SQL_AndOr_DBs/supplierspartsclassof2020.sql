-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Aug 16, 2019 at 05:09 PM
-- Server version: 5.7.26
-- PHP Version: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `supplierspartsclassof2020`
--

-- --------------------------------------------------------

--
-- Table structure for table `part`
--

DROP TABLE IF EXISTS `part`;
CREATE TABLE IF NOT EXISTS `part` (
  `pnumber` varchar(3) NOT NULL,
  `pname` varchar(20) NOT NULL,
  `color` varchar(20) NOT NULL,
  `city` varchar(20) NOT NULL,
  PRIMARY KEY (`pnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `part`
--

INSERT INTO `part` (`pnumber`, `pname`, `color`, `city`) VALUES
('p1', 'tv', 'black', 'london'),
('p2', 'desk', 'gray', 'paris'),
('p3', 'tv', 'white', 'paris');

-- --------------------------------------------------------

--
-- Table structure for table `sp`
--

DROP TABLE IF EXISTS `sp`;
CREATE TABLE IF NOT EXISTS `sp` (
  `snumber` varchar(3) NOT NULL,
  `pnumber` varchar(3) NOT NULL,
  `qty` int(11) NOT NULL,
  PRIMARY KEY (`snumber`,`pnumber`),
  KEY `sp_ibfk_2` (`pnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sp`
--

INSERT INTO `sp` (`snumber`, `pnumber`, `qty`) VALUES
('s1', 'p1', 100),
('s1', 'p2', 150),
('s1', 'p3', 200),
('s2', 'p1', 500),
('s2', 'p2', 290),
('s3', 'p2', 300),
('s4', 'p2', 100),
('s4', 'p3', 100),
('s5', 'p2', 250),
('s5', 'p3', 200);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
CREATE TABLE IF NOT EXISTS `supplier` (
  `snumber` varchar(3) NOT NULL,
  `sname` varchar(20) NOT NULL,
  `status` int(11) NOT NULL,
  `city` varchar(20) NOT NULL,
  PRIMARY KEY (`snumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`snumber`, `sname`, `status`, `city`) VALUES
('s1', 'jones', 20, 'london'),
('s2', 'johnson', 22, 'paris'),
('s3', 'green', 20, 'london'),
('s4', 'jones', 25, 'paris'),
('s5', 'black', 28, 'rome');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `sp`
--
ALTER TABLE `sp`
  ADD CONSTRAINT `sp_ibfk_1` FOREIGN KEY (`snumber`) REFERENCES `supplier` (`snumber`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sp_ibfk_2` FOREIGN KEY (`pnumber`) REFERENCES `part` (`pnumber`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
