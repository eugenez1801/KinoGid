package com.example.kinogid.movies

object MovieCatalog{
    /*val actionGenre = Genre.ACTION.displayingGenre
    val adventureGenre = Genre.ADVENTURE.displayingGenre
    val animationGenre = Genre.ANIMATION.displayingGenre
    val biographyGenre = Genre.BIOGRAPHY.displayingGenre
    val comedyGenre = Genre.COMEDY.displayingGenre
    val crimeGenre = Genre.CRIME.displayingGenre
    val documentaryGenre = Genre.DOCUMENTARY.displayingGenre
    val dramaGenre = Genre.DRAMA.displayingGenre
    val familyGenre = Genre.FAMILY.displayingGenre
    val fantasyGenre = Genre.FANTASY.displayingGenre
    val horrorGenre = Genre.HORROR.displayingGenre
    val musicalGenre = Genre.MUSICAL.displayingGenre
    val mysteryGenre = Genre.MYSTERY.displayingGenre
    val romanceGenre = Genre.ROMANCE.displayingGenre
    val sctFiGenre = Genre.SCI_FI.displayingGenre
    val sportGenre = Genre.SPORT.displayingGenre
    val superheroGenre = Genre.SUPERHERO.displayingGenre
    val thrillerGenre = Genre.THRILLER.displayingGenre
    val warGenre = Genre.WAR.displayingGenre
    val westernGenre = Genre.WESTERN.displayingGenre*/
    val movieList = listOf(
        Movie(0, "Побег из Шоушенка", 1994, 144, "16+",
            setOf(Genre.CRIME, Genre.DRAMA), 9.3f, 9.1f, "Пусто"),

        Movie(1, "Крестный отец", 1972, 175, "16+",
            setOf(Genre.CRIME, Genre.DRAMA), 9.2f, 8.7f, "Пусто"),

        Movie(2, "Темный рыцарь", 2008, 152, "14+",
            setOf(Genre.ACTION, Genre.CRIME, Genre.DRAMA, Genre.SUPERHERO, Genre.THRILLER),
            9.0f, 8.5f, "Пусто"),

        Movie(3, "Крестный отец 2", 1972, 202, "16+",
            setOf(Genre.CRIME, Genre.DRAMA), 9.0f, 8.5f, "Пусто"),

        Movie(4, "12 разгневанных мужчин", 1957, 96, "16+",
            setOf(Genre.DRAMA, Genre.CRIME), 9.0f, 8.5f, "Пусто"),

        Movie(5, "Властелин колец: Возвращение короля", 2003, 201, "12+",
            setOf(Genre.ACTION, Genre.ADVENTURE, Genre.DRAMA, Genre.FANTASY), 9.0f, 8.7f, "Пусто"),

        Movie(6, "Список Шиндлера", 1993, 195, "16+",
            setOf(Genre.BIOGRAPHY, Genre.DRAMA, Genre.DOCUMENTARY), 9.0f, 8.8f, "Пусто"),

        Movie(7, "Криминальное чтиво", 1994, 154, "18+",
            setOf(Genre.CRIME, Genre.DRAMA, Genre.COMEDY, Genre.THRILLER), 8.9f, 8.7f, "Пусто"),

        Movie(8, "Властелин колец: Братство кольца", 2001, 178, "12+",
            setOf(Genre.ACTION, Genre.ADVENTURE, Genre.DRAMA, Genre.FANTASY), 8.9f, 8.6f, "Пусто"),

        Movie(9, "Хороший, плохой, злой", 1996, 161, "12+",
            setOf(Genre.ADVENTURE, Genre.WESTERN), 8.8f, 8.5f, "Пусто"),

        Movie(10, "Форрест Гамп", 1994, 144, "0+",
            setOf(Genre.DRAMA, Genre.ROMANCE), 8.8f, 8.9f, "Пусто"),

        Movie(11, "Властелин колец: Две крепости", 2002, 179, "12+",
            setOf(Genre.ACTION, Genre.ADVENTURE, Genre.DRAMA, Genre.FANTASY), 8.8f, 8.6f, "Пусто"),

        Movie(12, "Бойцовский клуб", 1999, 139, "18+",
            setOf(Genre.CRIME, Genre.DRAMA, Genre.THRILLER), 8.8f, 8.7f, "Пусто"),

        Movie(13, "Начало", 2010, 148, "12+",
            setOf(Genre.ACTION, Genre.SCI_FI,Genre.THRILLER), 8.8f, 8.7f, "Пусто"),

        Movie(14, "Звёздные войны: Эпизод 5 - Империя наносит ответный удар", 1980, 124, "0+",
            setOf(Genre.ACTION, Genre.ADVENTURE, Genre.SCI_FI), 8.7f, 8.1f, "Пусто"),

        Movie(15, "Матрица", 1999, 136, "16+",
            setOf(Genre.ACTION, Genre.SCI_FI), 8.7f, 8.5f, "Пусто"),

        Movie(16, "Славные парни", 1990, 145, "16+",
            setOf(Genre.BIOGRAPHY, Genre.CRIME, Genre.DRAMA), 8.7f, 8.1f, "Пусто"),

        Movie(17, "Пролетая над гнездом кукушки", 1975, 133, "16+",
            setOf(Genre.DRAMA), 8.7f, 8.5f, "Пусто"),

        Movie(18, "Интерстеллар", 2014, 169, "12+",
            setOf(Genre.ADVENTURE, Genre.DRAMA, Genre.SCI_FI), 8.7f, 8.7f, "Пусто"),

        Movie(19, "Семь", 1995, 127, "18+",
            setOf(Genre.CRIME, Genre.DRAMA, Genre.MYSTERY, Genre.THRILLER), 8.6f, 8.3f, "Пусто"),

        Movie(20, "Эта замечательная жизнь", 1946, 130, "12+",
            setOf(Genre.DRAMA, Genre.FANTASY, Genre.FAMILY, Genre.ROMANCE), 8.6f, 8.4f, "Пусто"),

        Movie(21, "Молчание ягнят", 1991, 118, "18+",
            setOf(Genre.DRAMA, Genre.CRIME, Genre.HORROR, Genre.THRILLER), 8.6f, 8.3f, "Пусто"),

        Movie(22, "Семь самураев", 1991, 207, "16+",
            setOf(Genre.ACTION, Genre.DRAMA), 8.6f, 8.2f, "Пусто"),

        Movie(23, "Спасти рядового Райана", 1998, 169, "16+",
            setOf(Genre.DRAMA, Genre.WAR), 8.6f, 8.2f, "Пусто"),

        Movie(24, "Город Бога", 2002, 130, "16+",
            setOf(Genre.CRIME, Genre.DRAMA), 8.6f, 8.0f, "Пусто"),

        Movie(25, "Зелёная миля", 1999, 189, "14+",
            setOf(Genre.CRIME, Genre.DRAMA, Genre.FANTASY, Genre.MYSTERY), 8.6f, 9.1f, "Пусто"),

        Movie(26, "Жизнь прекрасна", 1997, 116, "0+",
            setOf(Genre.COMEDY, Genre.DRAMA, Genre.ROMANCE, Genre.WAR), 8.6f, 8.6f, "Пусто"),

        Movie(27, "Терминатор 2: Судный день", 1991, 137, "16+",
            setOf(Genre.ACTION, Genre.ADVENTURE, Genre.SCI_FI), 8.6f, 8.4f, "Пусто"),

        Movie(28, "Звездные войны: Эпизод 4 – Новая надежда", 1977, 121, "0+",
            setOf(Genre.ACTION, Genre.ADVENTURE, Genre.SCI_FI), 8.6f, 8.1f, "Пусто"),

        Movie(29, "Назад в будущее", 1985, 116, "12+",
            setOf(Genre.COMEDY, Genre.ADVENTURE, Genre.SCI_FI), 8.5f, 8.6f, "Пусто"),

        Movie(30, "Унесённые призраками", 2001, 124, "12+",
            setOf(Genre.ANIMATION, Genre.ADVENTURE, Genre.FAMILY, Genre.FANTASY), 8.6f, 8.5f, "Пусто"),

        Movie(31, "Пианист", 2002, 150, "16+",
            setOf(Genre.BIOGRAPHY, Genre.DRAMA, Genre.WAR), 8.5f, 8.5f, "Пусто"),

        Movie(32, "Гладиатор", 2000, 155, "18+",
            setOf(Genre.ACTION, Genre.ADVENTURE, Genre.DRAMA), 8.5f, 8.6f, "Пусто"),

        Movie(33, "Паразиты", 2019, 132, "18+",
            setOf(Genre.DRAMA, Genre.THRILLER, Genre.COMEDY), 8.5f, 8.0f, "Пусто"),

        Movie(34, "Психо", 1960, 109, "16+",
            setOf(Genre.DRAMA, Genre.HORROR, Genre.MYSTERY, Genre.THRILLER), 8.5f, 8.1f, "Пусто"),

        Movie(35, "Король Лев", 1994, 88, "0+",
            setOf(Genre.ANIMATION, Genre.FAMILY, Genre.DRAMA, Genre.MUSICAL), 8.5f, 8.8f, "Пусто"),

        Movie(36, "Могила светлячков", 1988, 88, "12+",
            setOf(Genre.ANIMATION, Genre.DRAMA, Genre.WAR), 8.5f, 8.2f, "Пусто"),

        Movie(37, "Отступники", 2006, 151, "16+",
            setOf(Genre.CRIME, Genre.DRAMA, Genre.THRILLER), 8.5f, 8.5f, "Пусто"),

        Movie(38, "Одержимость", 2014, 106, "16+",
            setOf(Genre.DRAMA), 8.5f, 8.4f, "Пусто"),

        Movie(39, "Харакири", 1962, 133, "16+",
            setOf(Genre.DRAMA,Genre.MYSTERY), 8.6f, 8.2f, "Пусто"),

        Movie(40, "Американская история X", 1998, 119, "16+",
            setOf(Genre.CRIME, Genre.DRAMA), 8.5f, 8.3f, "Пусто"),

        Movie(41, "Престиж", 2006, 130, "12+",
            setOf(Genre.DRAMA, Genre.MYSTERY, Genre.SCI_FI, Genre.THRILLER), 8.5f, 8.5f, "Пусто"),

        Movie(42, "Леон", 1994, 110, "16+",
            setOf(Genre.ACTION, Genre.CRIME, Genre.DRAMA, Genre.THRILLER), 8.5f, 8.7f, "Пусто"),

        Movie(43, "Человек-паук: Паутина вселенных", 2023, 140, "6+",
            setOf(Genre.ANIMATION, Genre.ADVENTURE, Genre.ACTION, Genre.FAMILY, Genre.FANTASY), 8.5f, 8.4f, "Пусто"),

        Movie(44, "Касабланка", 1942, 102, "6+",
            setOf(Genre.DRAMA, Genre.ROMANCE, Genre.WAR), 8.5f, 8.0f, "Пусто")
        )
}