-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Окт 08 2014 г., 16:34
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=41 ;

--
-- Дамп данных таблицы `ads`
--

INSERT INTO `ads` (`AD_ID`, `manufacturer`, `model`, `note`, `CREATE_DATE`, `life_time`, `id_owner`, `price`) VALUES
(24, 'Samsung', 'TV', '1', '2014-10-02', 1, 7, 1),
(27, 'LG', 'microwave', 'cheap', '2014-10-03', 1, 16, 600),
(29, 'Samsung', 'TV 42"', 'for new year', '2014-10-03', 10, 17, 3000),
(33, 'Tefal', 'utug', 'today and new', '2014-10-08', 1, 16, 100),
(37, 'Sony', 'Телефон Iphone 6 1', '1', '2014-10-08', 10, 16, 1),
(38, 'Apple', 'ноутбук Mac Book Pro самая новая модель', 'срочно', '2014-10-08', 1, 16, 4000),
(39, 'Sony', 'плоский телевизор', 'по Одессе', '2014-10-08', 1, 16, 5),
(40, 'Sony', 'Телефон Iphone 6 ыыы', 'ы', '2014-10-08', 1, 16, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `devices`
--

CREATE TABLE IF NOT EXISTS `devices` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_manufacturer` int(11) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Дамп данных таблицы `devices`
--

INSERT INTO `devices` (`id`, `id_manufacturer`, `name`) VALUES
(1, 1, 'Чайник'),
(2, 1, 'Телевизор'),
(3, 1, 'Телефон'),
(4, 3, 'Телефон Iphone 6'),
(5, 3, 'ноутбук Mac Book Pro');

-- --------------------------------------------------------

--
-- Структура таблицы `favorite_ads`
--

CREATE TABLE IF NOT EXISTS `favorite_ads` (
  `user_id` int(11) DEFAULT NULL,
  `ad_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Дамп данных таблицы `favorite_ads`
--

INSERT INTO `favorite_ads` (`user_id`, `ad_id`) VALUES
(17, 24),
(16, 33);

-- --------------------------------------------------------

--
-- Структура таблицы `manufacturers`
--

CREATE TABLE IF NOT EXISTS `manufacturers` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Дамп данных таблицы `manufacturers`
--

INSERT INTO `manufacturers` (`ID`, `NAME`) VALUES
(1, 'Sony'),
(2, 'Samsung'),
(3, 'Apple'),
(4, 'Toshiba'),
(5, 'Dell'),
(6, 'Tefal'),
(7, 'Kenwood'),
(8, 'Panasonic');

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
