-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Mar 05, 2020 at 08:39 PM
-- Server version: 8.0.18
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `woohoo_computers`
--

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
CREATE TABLE IF NOT EXISTS `inventory` (
  `itemId` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `itemName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `itemDesc` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `qty` int(11) NOT NULL,
  `price` double NOT NULL,
  `image` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `itemType` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `searchTerms` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`itemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`itemId`, `itemName`, `itemDesc`, `qty`, `price`, `image`, `itemType`, `searchTerms`) VALUES
('ad1', 'Antique phones', 'Pristine Condition, email for specifics.  Edison is best known in telephony for the carbon transmitter that was the basis of telephone transmitters for more than a century. He experimented with many o', 25, 200, 'resources/images/ad1.png', 'phone', 'ph.*'),
('ad2', 'Rotary Phones', 'Comes in many different Styles, including the Indian \"Princess\" shown here.', 50, 200, 'resources/images/ad2.png', 'phone', 'ph.*'),
('ip1', 'Motorola', 'Worlds first Cell Phone! Motorolla spokesperson not included.', 10, 99.99, 'resources/images/ip1.jpg', 'phone', 'mo.*'),
('ip2', 'Telegraph', '- . .-.. . --. .-. .- .--. ....(Morse Code for : Telegraph)\r\nFirst Machine used for the Transatlantic cable that ran from UK to the America\'s. ', 1, 5000000.99, 'resources/images/ip2.jpg', 'phone', 'mo.*'),
('lt1', 'Packard Bell', ' Their computers were among the first IBM PC compatibles sold in retail chains such as Sears', 50, 500, 'resources/images/lt1.jpg', 'laptop', 'l.*'),
('lt2', 'Osborne 1', 'The Osborne 1 is the first commercially successful portable microcomputer, released on April 3, 1981 by Osborne Computer Corporation.', 4, 8000, 'resources/images/lt2.png', 'laptop', 'l.*'),
('pc1', 'Macintosh', 'The original Macintosh was the first mass-market personal computer that featured a graphical user interface, built-in screen and mouse', 3, 500000, 'resources/images/pc1.png', 'desktop', 'pc.*'),
('pc2', 'IBM PCX', 'An immediate success, the IBM PC quickly becomes the industry standard, and was one of the reasons Time magazine chose the \"personal computer\" as its 1982 Man of the Year.', 25, 5000, 'resources/images/pc2.png', 'desktop', 'pc.*'),
('pc3', 'Atsushi Lizuka', 'One of the first desktop design\'s from Japan.', 4, 13500, 'resources/images/pc3.jpg', 'desktop', 'pc.*'),
('tablet', 'Ancient Sumerian Tablet', 'The Sumerian language was developed in ancient Mesopotamia and is the oldest known written language. This language was written in a script known as cuneiform, which was later adapted by other language', 1, 50000000, 'resources/images/tablet.png', 'tablet', 't.*');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(50) NOT NULL,
  `type` varchar(10) NOT NULL DEFAULT 'user',
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`email`, `password`, `type`) VALUES
('111@edu.edu', 't1lEGFNnF4E=', 'user'),
('blahblah@some.net', 'hx9U7Ck4HVM=', 'user'),
('earl@me.com', 'hx9U7Ck4HVM=', 'user'),
('earl1@me.com', 'hx9U7Ck4HVM=', 'user'),
('email@what.com', 'srglEyb3QHc=', 'user'),
('hello@gmail.com', 'hx9U7Ck4HVM=', 'user'),
('help@gmail.com', 'hx9U7Ck4HVM=', 'user'),
('new@email.com', 'hx9U7Ck4HVM=', 'user'),
('newone@something.com', 'hx9U7Ck4HVM=', 'user'),
('nothing@but.net', 'hx9U7Ck4HVM=', 'user'),
('nothing@ubt.net', 'hx9U7Ck4HVM=', 'user'),
('somethinnew@gmail.com', 'hx9U7Ck4HVM=', 'user'),
('somethinnew1@gmail.com', 'hx9U7Ck4HVM=', 'user'),
('somethinnew12@gmail.com', 'hx9U7Ck4HVM=', 'user');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
