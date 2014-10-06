-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Окт 06 2014 г., 16:09
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=33 ;

--
-- Дамп данных таблицы `ads`
--

INSERT INTO `ads` (`AD_ID`, `manufacturer`, `model`, `note`, `CREATE_DATE`, `life_time`, `id_owner`, `price`) VALUES
(24, 'Samsung', 'TV', '1', '2014-10-02', 1, 7, 1),
(25, 'Ð¡Ð°ÑÑÑÐ½', 'Ð³ÑÐµÐ±Ð°Ð½ÑÐ¹ Ð¿ÑÐ»ÐµÑÐ¾Ñ', 'Хочу сегодня', '2014-10-02', 5, 7, 300),
(26, 'samsung', 'tvtv', '* ÐÑÐ¸Ð¼Ð¸ÑÐ°Ð½Ð¸Ðµ', '2014-10-03', 5, 15, 3000),
(27, 'LG', 'microwave', 'cheap', '2014-10-03', 1, 16, 600),
(28, 'Sony', 'telephone z1', '* ÐÑÐ¸Ð¼Ð¸ÑÐ°Ð½Ð¸Ðµ', '2014-10-03', 1, 16, 4000),
(29, 'Samsung', 'TV 42"', 'for new year', '2014-10-03', 10, 17, 3000),
(30, '1', '1', '1', '2014-10-03', 1, 16, 1),
(31, '2', '2', '2', '2014-10-03', 1, 16, 2),
(32, '3', '3', '3', '2014-10-03', 30, 16, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `favorite_ads`
--

CREATE TABLE IF NOT EXISTS `favorite_ads` (
  `user_id` int(11) DEFAULT NULL,
  `ad_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
  `COUNTNEWMESSAGES` int(11) DEFAULT NULL,
  `COUNTNEWWALLMESSAGES` int(11) DEFAULT NULL,
  `telephone` char(20) DEFAULT NULL,
  `ACCESSLEVEL` int(11) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=18 ;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`USER_ID`, `CREATEDATE`, `MODIFIEDDATE`, `CREATEBY`, `MODIFIEDBY`, `NICKNAME`, `NAME`, `SURNAME`, `BIRTHDAY`, `EDUCATION`, `JOB`, `CITY`, `EMAIL`, `PASSWORD`, `COUNTNEWMESSAGES`, `COUNTNEWWALLMESSAGES`, `telephone`, `ACCESSLEVEL`) VALUES
(16, '2014-10-03 12:56:59', '0000-00-00 00:00:00', NULL, NULL, '1', '1', '1', NULL, NULL, NULL, 'odessa', '1', '1', 0, 0, NULL, 1),
(17, '2014-10-03 12:57:16', '0000-00-00 00:00:00', NULL, NULL, '2', '2', '2', NULL, NULL, NULL, 'odessa', '2', '2', 0, 0, NULL, 2);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
