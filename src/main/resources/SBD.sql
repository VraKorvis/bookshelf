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
  (1, 'Граф Монте-Кристо', 'Роман «Граф Монте-Кристо» — классика, которую действительно перечитывают.', 'А.Дюма', '9785699324385', 1957, TRUE);

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (2, 'Три мушкетера', 'Три мушкетера(роман)', 'А.Дюма', '9785699324386', 1980, TRUE);

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (3, 'Три мушкетера Двадцать лет спустя', 'Историко-приключенческий роман французского писателя Александра Дюма — продолжение романа «Три мушкетёра», вторая книга трилогии Александра Дюма-отца о королевских мушкетёрах.', 'А.Дюма', '9785699324387', 1980, FALSE);

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (4, 'Виконт де Бражелон, или Десять лет спустя', 'Роман французского писателя Александра Дюма, третья часть трилогии романов о трёх мушкетёрах и д’Артаньяне.', 'А.Дюма', '9785699324388', 1980, FALSE);

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (5, 'Оно', 'Роман американского писателя Стивена Кинга, написанный в жанре ужасов. Повествование ведется параллельно в разных временных интервалах, один из которых соответствует детству главных героев, а другой — их взрослой жизни.', 'С.Кинг', '9785699324389', 1994, TRUE);

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
  (15, 'Верный меч', 'Повести о Дунке и Эгге(вселенная ПЛИО, за 90 лет до)', 'Джорж Мартин', '9785170247103', 2003, FALSE );

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (16, 'Таинственный рыцарь', 'Повести о Дунке и Эгге(вселенная ПЛИО, за 90 лет до)', 'Джорж Мартин', '9785170247104', 2010, FALSE );

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (17, 'Межевой рыцарь', 'Повести о Дунке и Эгге(вселенная ПЛИО, за 90 лет до)', 'Джорж Мартин', '9785170247103', 1998, FALSE );

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (18, 'Трудно быть богом', 'Должен вас предупредить вот о чем. Выполняя задание,вы будете при оружии для поднятия авторитета. Но пускать его в ход вам не разрешается ни при каких обстоятельствах.Ни при каких обстоятельствах. Вы меня поняли? - Эрнест Хемингуэй', 'Аркадий Стругацкий, Борис Стругацкий', '9785170249777', 2011, TRUE);

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (19, 'Пикник на обочине', '"Счастье для всех, и пусть никто не уйдет обиженным!" Знаковые слова... Шедевр братьев Стругацких. ', 'Аркадий Стругацкий, Борис Стругацкий', '9785170247202', 2011, TRUE);

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (20, 'Лангольеры', 'Повесть американского писателя Стивена Кинга, написанная в жанрах психологического ужаса и фантастики', 'С.Кинг', '9785271449222', 1994, TRUE);

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (21, 'Потаенное окно, потаенный сад', 'Быть писателем заманчиво, а известным — ещё и опасно. В этом однажды убедился Мортон Рейни, открыв дверь загородного дома мужчине в шляпе. Фермер Джон Шутер обвинил автора в плагиате и предложил разобраться без посторонних. Чтобы хуже не было. ', 'С.Кинг', '9785271447228 ', 1994, TRUE);

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (22, 'Туман', 'Повесть американского писателя Стивена Кинга, написанная в жанре психологического ужаса.', 'С.Кинг', '9785271449522', 1994, TRUE);

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (23, 'Философия java', 'Философия Java сложилась, как совокупность свойств многих языков программирования создававшихся для выполнения определенных задач в определенной среде.', 'Брюс Эккель', '9785221749521 ', 2016, TRUE);

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (24, 'Алгоритмы и структуры данных. Новая версия для Оберона', 'В классическом учебнике тьюринговского лауреата Ник-лауса Вирта аккуратно, на тщательно подобранных примерах прорабатываются традиционные темы алгоритмики – сортировка и поиск, рекурсия, динамические структуры данных.', 'Никлаус Вирт', '9785970600115', 2016, FALSE);

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (25, 'Java SE8. Базовый курс', 'В версии Java SE 8 внедрены значительные усовершенствования, оказывающие влияние на технологии и прикладные программные интерфейсы API, образующие ядро платформы Java.', 'Кей С.Хорстманн', '9785221749521 ', 2015, FALSE );

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (26, 'Java Эффективное программирование', 'Джошуа Блох детально описывает приемы, которые используют эксперты, создававшие платформу Java.', 'Блох Дж.', '9785221749521', 2014, FALSE );

INSERT INTO test.bookshelf (ID, title, description, author, ISBN, year, readAlready) VALUES
  (27, 'Совершенный код', 'Более 10 лет первое издание этой книги считалось одним из лучших практических руководств по программированию.', 'Стив Макконнелл', '9785750200641', 2017, FALSE );









