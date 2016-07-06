-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 27, 2015 at 04:59 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `suptodo`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `Id` int(6) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `Password` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=111118 ;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`Id`, `Name`, `Password`) VALUES
(111111, 'Martin', 'supinfo'),
(111112, 'Dale', 'supinf0'),
(111113, 'Dong', 'dong123'),
(111114, 'Cui', 'cui123'),
(111115, 'Luo', 'supinfo'),
(111116, 'Xiao', 'supinfo'),
(111117, 'MAX', 'SUPINFO');

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE IF NOT EXISTS `manager` (
  `Id` int(6) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `Password` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=100003 ;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`Id`, `Name`, `Password`) VALUES
(100000, 'Alex', 'supinfo'),
(100001, 'Nadi', 'supinfo'),
(100002, 'Jean', 'supinfo');

-- --------------------------------------------------------

--
-- Table structure for table `todo`
--

CREATE TABLE IF NOT EXISTS `todo` (
  `Id` int(4) NOT NULL AUTO_INCREMENT,
  `UserId` int(6) DEFAULT NULL,
  `Message` varchar(1000) NOT NULL,
  `Checked` varchar(10) NOT NULL,
  `AddDate` varchar(30) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Dumping data for table `todo`
--

INSERT INTO `todo` (`Id`, `UserId`, `Message`, `Checked`, `AddDate`) VALUES
(12, 111111, 'Hello, I am alex , I want someone help me to....\r\nDate: 2015-06-23 12:53:25\r\n\r\nComment by Martin :hello , I see it,... 2015-06-23 12:54:14\r\n\r\nComment by Martin : jaijsfaowe 2015-06-23 14:22:21\r\n\r\nComment by Martin :jjdioadffioafadfasdff 2015-06-27 21:59:03\r\n\nComment by Martin :test 2015-06-27 22:07:36', 'true', '2015-06-23 12:53:25'),
(13, 111111, ' amne jdjaff jdffaje\r\nDate: 2015-06-23 14:21:56\r\n\r\nComment by Martin :hello  2015-06-27 16:40:06\r\n\r\nComment by Martin :I am a employee 2015-06-27 17:32:27\r\n\r\nComment by Martin :show the comment 2015-06-27 17:39:03\r\n\r\nComment by Dong :check the comment 2015-06-27 17:43:51\r\n\r\nComment by Dong :let''s add a comment 2015-06-27 18:05:54this one is out of date', 'true', '2015-06-23 14:21:56'),
(14, 111111, 'a new todo\nsomething need to do\n hello\nDate: 2015-06-27 19:23:37This one is out of date', 'true', '2015-06-27 19:23:37'),
(15, 111111, 'Now, I am Nadi , some people don''t want to take class \r\nDate: 2015-06-27 22:26:56\r\n\r\nComment by Martin :hello , i am lazy 2015-06-27 22:28:01\r\n\nComment by Martin :Write a comment, 2015-06-27 22:28:47', 'true', '2015-06-27 22:26:56'),
(16, 111111, 'jjaijsdfoapiefapsfasdfasdff\r\nDate: 2015-06-27 22:52:36\r\n\nComment by Martin :Write a commentdadad 2015-06-27 22:58:04', 'true', '2015-06-27 22:52:36'),
(17, 111111, 'You must do a good presentation, I will give you 20 points!\r\nDate: 2015-06-27 22:56:41', 'false', '2015-06-27 22:56:41'),
(18, 111111, 'Your group is best.\r\nDate: 2015-06-27 22:57:37', 'false', '2015-06-27 22:57:37');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
