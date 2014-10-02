-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Окт 02 2014 г., 16:22
-- Версия сервера: 5.5.25
-- Версия PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `networkdb`
--

-- --------------------------------------------------------

--
-- Структура таблицы `ads`
--

CREATE TABLE IF NOT EXISTS `ads` (
  `AD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `manufacturer` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `note` text,
  `CREATE_DATE` date DEFAULT NULL,
  `life_time` int(11) DEFAULT NULL,
  `id_owner` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`AD_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=26 ;

--
-- Дамп данных таблицы `ads`
--

INSERT INTO `ads` (`AD_ID`, `manufacturer`, `model`, `note`, `CREATE_DATE`, `life_time`, `id_owner`, `price`) VALUES
(24, 'Samsung', 'TV', '1', '2014-10-02', 1, 7, 1),
(25, 'Ð¡Ð°ÑÑÑÐ½', 'Ð³ÑÐµÐ±Ð°Ð½ÑÐ¹ Ð¿ÑÐ»ÐµÑÐ¾Ñ', 'Хочу сегодня', '2014-10-02', 5, 7, 300);

-- --------------------------------------------------------

--
-- Структура таблицы `messages`
--

CREATE TABLE IF NOT EXISTS `messages` (
  `message_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SENDERID` int(11) DEFAULT NULL,
  `RECEIVERID` int(11) DEFAULT NULL,
  `SUBJECT` varchar(255) DEFAULT NULL,
  `TEXT` text,
  `isSending` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`message_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Дамп данных таблицы `messages`
--

INSERT INTO `messages` (`message_ID`, `SENDERID`, `RECEIVERID`, `SUBJECT`, `TEXT`, `isSending`) VALUES
(1, 1, 1, 'x', 'y', 0);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CREATEDATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `MODIFIEDDATE` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `CREATEBY` int(11) DEFAULT NULL,
  `MODIFIEDBY` int(11) DEFAULT NULL,
  `NICKNAME` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `SURNAME` varchar(255) DEFAULT NULL,
  `BIRTHDAY` date DEFAULT NULL,
  `EDUCATION` varchar(255) DEFAULT NULL,
  `JOB` varchar(255) DEFAULT NULL,
  `CITY` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `ACCESLEVEL` int(11) DEFAULT NULL,
  `COUNTNEWMESSAGES` int(11) DEFAULT NULL,
  `COUNTNEWWALLMESSAGES` int(11) DEFAULT NULL,
  `telephone` char(20) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=15 ;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`USER_ID`, `CREATEDATE`, `MODIFIEDDATE`, `CREATEBY`, `MODIFIEDBY`, `NICKNAME`, `NAME`, `SURNAME`, `BIRTHDAY`, `EDUCATION`, `JOB`, `CITY`, `EMAIL`, `PASSWORD`, `ACCESLEVEL`, `COUNTNEWMESSAGES`, `COUNTNEWWALLMESSAGES`, `telephone`) VALUES
(1, '2014-09-11 09:59:17', '0000-00-00 00:00:00', NULL, NULL, 'Alibaba', 'Vasiliy', 'Alibabaev', NULL, NULL, NULL, 'Izmail', 'alibaba@gmail.com', 'qwerty', 0, 0, 0, NULL),
(2, '2014-09-11 11:18:33', '0000-00-00 00:00:00', NULL, NULL, 'Alibaba', 'Vasiliy', 'Alibabaev', NULL, NULL, NULL, 'Izmail', 'alibaba@gmail.com', 'qwerty', 0, 0, 0, NULL),
(3, '2014-09-11 11:23:25', '0000-00-00 00:00:00', NULL, NULL, 'Alibaba', 'Vasiliy', 'Alibabaev', NULL, NULL, NULL, 'Izmail', 'alibaba@gmail.com', 'qwerty', 0, 0, 0, NULL),
(4, '2014-09-11 11:24:45', '0000-00-00 00:00:00', NULL, NULL, 'Alibaba', 'Vasiliy', 'Alibabaev', NULL, NULL, NULL, 'Izmail', 'alibaba@gmail.com', 'qwerty', 0, 0, 0, NULL),
(5, '2014-09-11 12:30:06', '0000-00-00 00:00:00', NULL, NULL, 'Alibaba', 'Vasiliy', 'Alibabaev', NULL, NULL, NULL, 'Izmail', 'alibaba@gmail.com', 'qwerty', 0, 0, 0, NULL),
(6, '2014-09-11 12:40:11', '0000-00-00 00:00:00', NULL, NULL, '2', '2', '2', NULL, NULL, NULL, 'odessa', '2', '2', 1, 0, 0, NULL),
(7, '2014-09-11 12:45:37', '0000-00-00 00:00:00', NULL, NULL, '1', '1', '1', NULL, NULL, NULL, 'odessa', '1', '1', 1, 0, 0, NULL),
(8, '2014-09-12 08:29:30', '0000-00-00 00:00:00', NULL, NULL, 'kolbasnik', 'alex', 'bay', NULL, NULL, NULL, 'odessa', 'kolbastnik@gmail.com', 'qwerty', 1, 0, 0, NULL),
(9, '2014-09-12 09:40:03', '0000-00-00 00:00:00', NULL, NULL, '1', '1', '1', NULL, NULL, NULL, 'kiev', '1', '1', 1, 0, 0, NULL),
(10, '2014-09-25 10:11:26', '0000-00-00 00:00:00', NULL, NULL, '7', '7', '7', NULL, NULL, NULL, 'odessa', '7', '7', 1, 0, 0, NULL),
(11, '2014-09-29 09:35:08', '0000-00-00 00:00:00', NULL, NULL, 'a', 'a', 'a', NULL, NULL, NULL, 'odessa', 'a', 'a', 1, 0, 0, NULL),
(12, '2014-09-30 07:29:18', '0000-00-00 00:00:00', NULL, NULL, 'Kolbas', 'Alexander', 'Baydarov', NULL, NULL, NULL, 'odessa', 'kolbastnik@gmail.com', '1', 1, 0, 0, NULL),
(13, '2014-10-02 06:36:51', '0000-00-00 00:00:00', NULL, NULL, 'a', 'a', 'a', NULL, NULL, NULL, 'odessa', 'a', 'a', 1, 0, 0, NULL),
(14, '2014-10-02 06:37:26', '0000-00-00 00:00:00', NULL, NULL, 'alex', 'alex', 'bb', NULL, NULL, NULL, 'odessa', 'kolbastnik@gmail.com', 'vbs4745', 1, 0, 0, NULL);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
