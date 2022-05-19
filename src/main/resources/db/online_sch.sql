-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Май 19 2022 г., 19:25
-- Версия сервера: 5.5.25
-- Версия PHP: 5.2.12

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `online_sch`
--

-- --------------------------------------------------------

--
-- Структура таблицы `изм_цены`
--

CREATE TABLE IF NOT EXISTS `изм_цены` (
  `Код_курс` int(4) NOT NULL,
  `Ст_цена` int(8) NOT NULL,
  `Дата_изм` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `изм_цены`
--

INSERT INTO `изм_цены` (`Код_курс`, `Ст_цена`, `Дата_изм`) VALUES
(1001, 29890, '2022-03-31'),
(1011, 25500, '2020-04-18'),
(2001, 32000, '2020-04-21'),
(1001, 32000, '2021-08-06'),
(1014, 15000, '2021-07-01'),
(1002, 25990, '2018-01-01'),
(1003, 19990, '2018-01-01'),
(1011, 35500, '2018-01-01'),
(1012, 40000, '2018-01-01'),
(1013, 13990, '2018-01-01'),
(1014, 8000, '2018-01-01');

-- --------------------------------------------------------

--
-- Структура таблицы `купл_курс`
--

CREATE TABLE IF NOT EXISTS `купл_курс` (
  `Код_чека` int(6) NOT NULL DEFAULT '0',
  `код_уч` int(4) DEFAULT NULL,
  `код_курс` int(4) DEFAULT NULL,
  `дата_покупки` date DEFAULT NULL,
  `дата_оконч` date DEFAULT NULL,
  PRIMARY KEY (`Код_чека`),
  KEY `код_уч` (`код_уч`,`код_курс`),
  KEY `код_курс` (`код_курс`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `купл_курс`
--

INSERT INTO `купл_курс` (`Код_чека`, `код_уч`, `код_курс`, `дата_покупки`, `дата_оконч`) VALUES
(124514, 1007, 2001, '2021-10-10', '2022-07-10'),
(125361, 1005, 1011, '2021-10-08', '2022-06-08'),
(132451, 1002, 1001, '2021-10-06', '2022-06-06'),
(156264, 1008, 2001, '2020-09-01', '2022-07-01'),
(167254, 1001, 1003, '2021-07-10', '2022-07-10'),
(234525, 1003, 1002, '2021-09-01', '2022-06-01'),
(365723, 1010, 2011, '2020-04-11', '2022-08-11'),
(367452, 1009, 2002, '2020-05-12', '2022-05-12'),
(451723, 1004, 1002, '2021-10-08', '2022-06-08'),
(467237, 1011, 4001, '2021-09-01', '2022-07-01'),
(543412, 1006, 1013, '2021-09-01', '2022-06-01'),
(634524, 1013, 1014, '2021-11-18', '2022-06-01');

-- --------------------------------------------------------

--
-- Структура таблицы `курс_сотруд`
--

CREATE TABLE IF NOT EXISTS `курс_сотруд` (
  `Код_прикреп` varchar(10) NOT NULL,
  `Код_курс` int(4) DEFAULT NULL,
  `Код_сотруд` int(5) DEFAULT NULL,
  `Дата_прикреп` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Код_прикреп`),
  KEY `Код_курс` (`Код_курс`),
  KEY `Код_сотруд` (`Код_сотруд`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `курс_сотруд`
--

INSERT INTO `курс_сотруд` (`Код_прикреп`, `Код_курс`, `Код_сотруд`, `Дата_прикреп`) VALUES
('1', 1001, 10001, '01.09.2019'),
('10', 2001, 21001, '12.08.2020'),
('11', 2001, 21002, '12.08.2020'),
('12', 2002, 20001, '01.09.2020'),
('13', 2002, 21001, '12.08.2020'),
('14', 2011, 20001, '01.09.2020'),
('15', 3001, 30001, '01.09.2020'),
('16', 3001, 31001, '22.12.2020'),
('17', 3001, 31002, '18.10.2020'),
('18', 3002, 30001, '01.09.2020'),
('19', 3002, 31002, '18.10.2020'),
('2', 1001, 11001, '07.10.2020'),
('20', 3011, 30001, '01.09.2020'),
('21', 3011, 31002, '18.09.2020'),
('22', 4001, 40001, '01.09.2020'),
('23', 5001, 50001, '01.09.2020'),
('3', 1001, 11002, '19.11.2020'),
('4', 1002, 10001, '12.08.2020'),
('5', 1002, 11002, '03.06.2020'),
('6', 1002, 12001, '05.11.2020'),
('7', 1011, 10001, '16.06.2020'),
('8', 1011, 11002, '07.10.2020'),
('9', 2001, 20001, '01.09.2019');

-- --------------------------------------------------------

--
-- Структура таблицы `предметы`
--

CREATE TABLE IF NOT EXISTS `предметы` (
  `Код_пр` int(2) NOT NULL DEFAULT '0',
  `Предмет` varchar(28) DEFAULT NULL,
  PRIMARY KEY (`Код_пр`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `предметы`
--

INSERT INTO `предметы` (`Код_пр`, `Предмет`) VALUES
(1, 'Математика'),
(2, 'Русский язык'),
(3, 'Информатика'),
(4, 'Биология'),
(5, 'Химия'),
(6, 'Обществознание'),
(7, 'Китайский язык');

-- --------------------------------------------------------

--
-- Структура таблицы `сотрудники`
--

CREATE TABLE IF NOT EXISTS `сотрудники` (
  `Код_сотруд` int(5) NOT NULL DEFAULT '0',
  `Фамилия` varchar(20) DEFAULT NULL,
  `Имя` varchar(20) DEFAULT NULL,
  `Отчество` varchar(26) DEFAULT NULL,
  `Должность` varchar(26) DEFAULT NULL,
  `Номер_тр_книги` int(7) DEFAULT NULL,
  `Паспортные_данные` bigint(10) DEFAULT NULL,
  `Статус` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Код_сотруд`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `сотрудники`
--

INSERT INTO `сотрудники` (`Код_сотруд`, `Фамилия`, `Имя`, `Отчество`, `Должность`, `Номер_тр_книги`, `Паспортные_данные`, `Статус`) VALUES
(10001, 'Петров', 'Максим', 'Олегович', 'Преподаватель', 7654326, 1234669814, 'active'),
(11001, 'Генов', 'Егор', 'Артёмович', 'Куратор', 4534232, 3343673283, 'active'),
(11002, 'Бондаренко', 'Андрей', 'Викторович', 'Куратор', 3432563, 1467767247, 'active'),
(12001, 'Кожева', 'Марина', 'Ивановна', 'Эксперт', 3463734, 1425345235, 'active'),
(20001, 'Родина', 'Алёна', 'Сергеевна', 'Преподаватель', 7535435, 1234552535, 'active'),
(21001, 'Кривина', 'Мария', 'Павловна', 'Куратор', 5643637, 3645363654, 'active'),
(21002, 'Кривин', 'Антон', 'Павлович', 'Куратор', 5436637, 3443255263, 'active'),
(22001, 'Сидоров', 'Евгений', 'Владиславович', 'Эксперт', 3535562, 1234243434, 'active'),
(22002, 'Коровина', 'Анна', 'Сергеевна', 'Эксперт', 4374712, 3273643645, 'not_active'),
(30001, 'Витковская', 'Таисия', 'Славиевна', 'Преподаватель', 7653536, 1425267838, 'active'),
(31001, 'Нестеров', 'Никита', 'Дмитриевич', 'Куратор', 6647732, 1452562536, 'not_active'),
(31002, 'Канин', 'Илья', 'Владиславович', 'Куратор', 6345632, 1424526647, 'active'),
(31003, 'Кашина', 'Маргорита', 'Алексеевна', 'Куратор', 3645267, 1572532526, 'active'),
(40001, 'Марвина', 'Мария', 'Павловна', 'Преподаватель', 8364356, 1124626467, 'active'),
(41001, 'Колина', 'Софья', 'Вячеславовна', 'Куратор', 6253727, 1364562672, 'active'),
(42002, 'Андреенко', 'Андрей', 'Сергеевич', 'Эксперт', 3646327, 1263216546, 'active'),
(50001, 'Киров', 'Константин', 'Степанович', 'Преподаватель', 3654527, 3654362762, 'active'),
(51001, 'Фомина', 'Мария', 'Евгеньевна', 'Куратор', 2456267, 2415236255, 'active'),
(52001, 'Камин', 'Антон', 'Павлович', 'Эксперт', 3746372, 1124342634, 'active');

--
-- Триггеры `сотрудники`
--
DROP TRIGGER IF EXISTS `proverka_passport`;
DELIMITER //
CREATE TRIGGER `proverka_passport` BEFORE INSERT ON `сотрудники`
 FOR EACH ROW BEGIN
if (new.Паспортные_данные is NULL)
then
signal sqlstate '45000' set message_text = 'Не введены имя или фамилия';
end if;
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Структура таблицы `учебные_курсы`
--

CREATE TABLE IF NOT EXISTS `учебные_курсы` (
  `Код_курс` int(4) NOT NULL DEFAULT '0',
  `Код_пр` int(2) DEFAULT NULL,
  `Название` varchar(55) DEFAULT NULL,
  `Целевая_аудитория` varchar(5) DEFAULT NULL,
  `Стоимость` int(5) DEFAULT NULL,
  PRIMARY KEY (`Код_курс`),
  KEY `Код-пр` (`Код_пр`),
  KEY `Код-пр_2` (`Код_пр`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `учебные_курсы`
--

INSERT INTO `учебные_курсы` (`Код_курс`, `Код_пр`, `Название`, `Целевая_аудитория`, `Стоимость`) VALUES
(1001, 1, '100балльный бот', '10-11', 29890),
(1002, 1, '90+ баллов на изи', '10-11', 25990),
(1003, 1, 'Минимум 70+', '10-11', 19990),
(1011, 1, 'Олимпиады перечень', '10-11', 35500),
(1012, 1, 'Олимпиада Всерос', '10-11', 40000),
(1013, 1, 'Кружок 4-7', '4-7', 13990),
(1014, 1, 'Олимпиады для самых маленьких', '2-4', 8000),
(2001, 2, 'Пишем на все 100', '10-11', 29990),
(2002, 2, 'Только тест', '10-11', 16990),
(2003, 2, 'Только сочинение', '10-11', 12990),
(2011, 2, 'Русский язык 8-9', '8-9', 14500),
(2012, 2, 'Русский язык с самого начала', '4-7', 11299),
(3001, 3, 'Инфа на 100', '10-11', 29990),
(3002, 3, 'Инфа без проги', '10-11', 16990),
(3003, 3, 'Только программирование', '10-11', 12990),
(3011, 3, 'Прога с нуля', '7-9', 12990),
(3012, 3, 'Самое важное - Информатика', '5-9', 11500),
(4001, 4, 'Биология на 100', '10-11', 29990),
(4002, 4, 'Биология только тест', '10-11', 13500),
(4003, 4, 'Биология только вторая часть', '10-11', 9000),
(4011, 4, 'Биология с начала', '7-9', 10500),
(5001, 5, 'Химия на 100', '10-11', 24990),
(5002, 5, 'Химия только тест', '10-11', 18990),
(5003, 5, 'Химия только вторая часть', '10-11', 12990),
(5011, 5, 'Химия с начала', '7-9', 10000),
(6001, 6, 'Общество на 100', '10-11', 29990),
(6002, 6, 'Общество только тест', '10-11', 18000),
(6003, 6, 'Общество только эссе', '10-11', 9990),
(6011, 6, 'Общество с нуля', '7-9', 13990);

--
-- Триггеры `учебные_курсы`
--
DROP TRIGGER IF EXISTS `update_cost`;
DELIMITER //
CREATE TRIGGER `update_cost` BEFORE UPDATE ON `учебные_курсы`
 FOR EACH ROW BEGIN
if new.Стоимость < 0
then
signal sqlstate '45000' set message_text = 'Цена не может быть отрицательной!';
end if;
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Структура таблицы `ученики`
--

CREATE TABLE IF NOT EXISTS `ученики` (
  `Код_уч` int(4) NOT NULL DEFAULT '0',
  `Фамилия` varchar(18) DEFAULT NULL,
  `Имя` varchar(14) DEFAULT NULL,
  `Отчество` varchar(26) DEFAULT NULL,
  `Номер_класса` int(2) DEFAULT NULL,
  `Номер_тлф` bigint(11) DEFAULT NULL,
  `Электронная_почта` varchar(21) DEFAULT NULL,
  `Дата_Контр` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Код_уч`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `ученики`
--

INSERT INTO `ученики` (`Код_уч`, `Фамилия`, `Имя`, `Отчество`, `Номер_класса`, `Номер_тлф`, `Электронная_почта`, `Дата_Контр`) VALUES
(1001, 'Швинов', 'Максим', 'Павлович', 11, 76538237523, 'ehreyt@mail.ru', '01.11.2021'),
(1002, 'Марвин', 'Михаил', 'Георгивич', 11, 79374234627, 'fhgjhj@mail.ru', '01.11.2021'),
(1003, 'Шокина', 'Анна', 'Сергеевна', 10, 79946246753, 'shok@mail.ru', '01.11.2021'),
(1004, 'Керсанова', 'Мария', 'Васильевна', 10, 79125426142, 'kersan@mail.ru', '01.12.2021'),
(1005, 'Хоров', 'Павел', 'Александрович', 10, 79994526171, 'alex293@mail.ru', '01.11.2021'),
(1006, 'Рогина', 'Ульяна', 'Максимовна', 6, 79254216245, 'ulya@mail.ru', '01.01.2022'),
(1007, 'Нетеров', 'Никита', 'Антонович', 11, 79524163562, 'gfhgeyrg@mail.ru', '11.11.2021'),
(1008, 'Рогина', 'Марина', 'Максимовна', 11, 79165432424, 'rogmar@mail.ru', '01.11.2021'),
(1009, 'Норов', 'Максим', 'Владимирович', 10, 78245162541, 'uhghure@mail.ru', '09.11.2021'),
(1010, 'Керин', 'Антон', 'Рустамович', 8, 79976462175, 'geyrgue@mail.ru', '01.11.2021'),
(1011, 'Ковина', 'Валерия', 'Ивановна', 5, 79125461532, 'jeryhd@mail.ru', '07.12.2021'),
(1012, 'Кунов', 'Роман', 'Григорьевич', 11, 74213217495, 'griegr@mail.ru', '20.03.2022'),
(1013, 'Михеев', 'Максим', 'Сергеевич', 3, 79364328452, 'hornetreods@gmail.com', '18.11.2021');

--
-- Триггеры `ученики`
--
DROP TRIGGER IF EXISTS `proverka_pustoti`;
DELIMITER //
CREATE TRIGGER `proverka_pustoti` BEFORE INSERT ON `ученики`
 FOR EACH ROW BEGIN
if (new.Имя is NULL  or new.Фамилия is NULL)
then
signal sqlstate '45000' set message_text = 'Не введены имя или фамилия';
end if;
END
//
DELIMITER ;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `купл_курс`
--
ALTER TABLE `купл_курс`
  ADD CONSTRAINT `@q0@z0@v0@r0_@q0@z0@w0@x0_ibfk_1` FOREIGN KEY (`код_курс`) REFERENCES `учебные_курсы` (`Код_курс`),
  ADD CONSTRAINT `@q0@z0@v0@r0_@q0@z0@w0@x0_ibfk_2` FOREIGN KEY (`код_уч`) REFERENCES `ученики` (`Код_уч`);

--
-- Ограничения внешнего ключа таблицы `курс_сотруд`
--
ALTER TABLE `курс_сотруд`
  ADD CONSTRAINT `@q0@z0@w0@x0_@x0@u0@y0@w0@z0@k0_ibfk_1` FOREIGN KEY (`Код_курс`) REFERENCES `учебные_курсы` (`Код_курс`),
  ADD CONSTRAINT `@q0@z0@w0@x0_@x0@u0@y0@w0@z0@k0_ibfk_2` FOREIGN KEY (`Код_сотруд`) REFERENCES `сотрудники` (`Код_сотруд`);

--
-- Ограничения внешнего ключа таблицы `учебные_курсы`
--
ALTER TABLE `учебные_курсы`
  ADD CONSTRAINT `@z0@j1@l0@h0@t0@n1@l0_@q0@z0@w0@x0@n1_ibfk_1` FOREIGN KEY (`Код_пр`) REFERENCES `предметы` (`Код_пр`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
