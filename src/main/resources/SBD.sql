DROP DATABASE IF EXISTS test;

CREATE DATABASE test DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE test;

DROP TABLE IF EXISTS test.bookshelf;

CREATE TABLE test.bookshelf (
    ID INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
  , title VARCHAR(100) NOT NULL
  , description VARCHAR(255) NOT NULL
  , author VARCHAR(100)
  , ISBN VARCHAR(20)
  , year INT
  , readAlready BOOLEAN DEFAULT FALSE
)   ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO test.bookshelf(ID, title, description, author, ISBN, year, readAlready) VALUES
  (1, 'Узник замка ИФ', 'роман «Граф Монте-Кристо» — классика, которую действительно перечитывают.', 'A.Дюма', '9785699324385', 2009, TRUE);

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (2, 'Три мушкетера', 'Три мушкетера(роман)', 'A.Дюма', '9785699324386', 1988, TRUE);

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (3, 'Три мушкетера 20 лест спустя', 'Три мушкетера 20 лет спустя(роман)', 'A.Дюма', '9785699324387', 2001, FALSE);

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (4, 'Три мушкетера 30 лест спустя', 'Три мушкетера 30 лет спустя(роман)', 'A.Дюма', '9785699324388', 2001, FALSE);

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (5, 'Три мушкетера 40 лест спустя', 'Три мушкетера 40 лет спустя(роман)', 'A.Дюма', '9785699324389', 2001, FALSE);

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (6, 'Дерсу Узала', 'Дерсу Узала(биография) В дебрях Уссурийского края', 'Aрсеньев Владимир', '9785699324310', 2005, TRUE);

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (7, 'Лорд с планеты Земля', 'Лорд с планеты Земля(роман, фантастика)', 'Лукъяненко', '9785699324214', 2003, TRUE);

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (8, 'Татуированная кожа', 'Шпионы и все остальные. Данил Корецкий', 'Данил Корецкий', '9785170947140', 2004, TRUE);

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (9, 'Игра престолов', '1 книга цикла романов: Песнь Льда и Пламени', 'Джорж Мартин', '9785170247197', 1996, TRUE);

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (10, 'Битва королей', '2 книга цикла романов: Песнь Льда и Пламени', 'Джорж Мартин', '9785170247198', 1998, TRUE);

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (11, 'Буря мечей', '3 книга цикла романов: Песнь Льда и Пламени', 'Джорж Мартин', '9785170247199', 2000, TRUE);

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (12, 'Пир стервятников', '4 книга цикла романов: Песнь Льда и Пламени', 'Джорж Мартин', '9785170247199', 2005, FALSE );

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (13, 'Танец с драконами часть 1', '5 книга цикла романов: Песнь Льда и Пламени', 'Джорж Мартин', '9785170247200', 2011, FALSE );

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (14, 'Танец с драконами часть 2', '5 книга цикла романов: Песнь Льда и Пламени', 'Джорж Мартин', '9785170247201', 2011, FALSE );

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (15, 'The Winds of Winter / Ветра зимы(рабочее название)', 'Нет в продаже, ожидается поступление в 2018/2019г. 6 книга цикла романов: Песнь Льда и Пламени', 'Джорж Мартин', '9785170247202', 2018, FALSE );

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (16, 'A Dream of Spring / Грёзы о весне (рабочее название)', 'Нет в продаже, ожидается поступление в 2018/2019г. 6 книга цикла романов: Песнь Льда и Пламени', 'Джорж Мартин', '9785170247202', 2020, FALSE );

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (17, 'Межевой рыцарь', 'Повести о Дунке и Эгге(вселенная ПЛИО, за 90 лет до)', 'Джорж Мартин', '9785170247103', 1998, FALSE );

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (18, 'Верный меч', 'Повести о Дунке и Эгге(вселенная ПЛИО, за 90 лет до)', 'Джорж Мартин', '9785170247103', 2003, FALSE );

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (19, 'Таинственный рыцарь', 'Повести о Дунке и Эгге(вселенная ПЛИО, за 90 лет до)', 'Джорж Мартин', '9785170247104', 2010, FALSE );

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (20, 'Rogues / Принц-разбойник, брат короля', 'Хроники от лица мейстеров(вселенная ПЛИО, за 90 лет до)', 'Джорж Мартин', '9785170247482', 2013, FALSE );

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (21, 'The Princess and the Queen / Принцесса и королева', 'Хроники от лица мейстеров(вселенная ПЛИО, за 90 лет до)', 'Джорж Мартин', '9785170247483', 2014, FALSE );














