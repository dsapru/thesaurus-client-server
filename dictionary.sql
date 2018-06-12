-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 28, 2017 at 01:03 AM
-- Server version: 5.7.19
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
-- Database: `thesaurus`
--

-- --------------------------------------------------------

--
-- Table structure for table `dictionary`
--

DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE IF NOT EXISTS `dictionary` (
  `input_word` varchar(256) NOT NULL,
  `Value` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dictionary`
--

INSERT INTO `dictionary` (`input_word`, `Value`) VALUES
('test', ' trial,examination,experiment,assay,try,proof'),
('brave', 'courageous,fearless,dauntless,intrepid,plucky,daring'),
('calm', 'quiet,peaceful,still,tranquil,mild,serene,smooth,composed'),
('dangerous', 'perilous,hazardous,risky,uncertain,unsafe'),
('decide', 'determine,settle,choose,resolve'),
('eager', 'keen,fervent,enthusiastic,involved,interested,alive to'),
('explain', 'elaborate,clarify,define,interpret,justify,account for'),
('wrong', 'incorrect,inaccurate,mistaken,erroneous,improper'),
('valid', 'authorized,legitimate'),
('abandon', 'drops, dumps, ditches, discards; deserts, leaves; ends,\r\ngives up; looses, empties, vacates, resigns, quits');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
