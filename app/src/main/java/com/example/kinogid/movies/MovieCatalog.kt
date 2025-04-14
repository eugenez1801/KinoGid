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
        Movie(0, "Побег из Шоушенка", 1994, 142, "16+",
            setOf(Genre.CRIME, Genre.DRAMA), 9.3f, 9.1f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BMGUwODNmMDYtZGY4NS00M2Q1LTgwY2" +
                    "ItMmEwY2UzMmY3MTM2XkEyXkFqcGc@._V1_FMjpg_UY3000_.jpg", 0, 0),

        Movie(1, "Крестный отец", 1972, 175, "16+",
            setOf(Genre.CRIME, Genre.DRAMA), 9.2f, 8.7f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BNGEwYjgwOGQtYjg5ZS00Njc1LTk2Z" +
                    "GEtM2QwZWQ2NjdhZTE5XkEyXkFqcGc@._V1_.jpg", 3, 5),

        Movie(2, "Темный рыцарь", 2008, 152, "14+",
            setOf(Genre.ACTION, Genre.CRIME, Genre.DRAMA, Genre.SUPERHERO, Genre.THRILLER),
            9.0f, 8.5f, "Пусто", "https://m.media-amazon" +
                    ".com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_FMjpg_UY3000_.jpg", 2, 1),

        Movie(3, "Крестный отец 2", 1972, 202, "16+",
            setOf(Genre.CRIME, Genre.DRAMA), 9.0f, 8.5f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BMWMwMGQzZTItY2JlNC00OWZiLWIyMDctN" +
                    "Dk2ZDQ2YjRjMWQ0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UY3000_.jpg", 6, 0),

        Movie(4, "12 разгневанных мужчин", 1957, 96, "16+",
            setOf(Genre.DRAMA, Genre.CRIME), 9.0f, 8.5f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BMWU4N2FjNzYtNTVkNC00NzQ0LTg0MjAtYTJlMjFhNGUxZDFmXkEyXkFqcGdeQXVyNjc1NTYyMjg@._V1_FMjpg_UY3000_.jpg", 0, 0),

        Movie(5, "Властелин колец: Возвращение короля", 2003, 201, "12+",
            setOf(Genre.ACTION, Genre.ADVENTURE, Genre.DRAMA, Genre.FANTASY), 9.0f, 8.7f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDI" +
                    "tYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UY3000_.jpg", 11, 4),

        Movie(6, "Список Шиндлера", 1993, 195, "16+",
            setOf(Genre.BIOGRAPHY, Genre.DRAMA), 9.0f, 8.8f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItY" +
                    "Tk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UY3000_.jpg", 7, 3),

        Movie(7, "Криминальное чтиво", 1994, 154, "18+",
            setOf(Genre.CRIME, Genre.DRAMA, Genre.COMEDY, Genre.THRILLER), 8.9f, 8.7f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2I" +
                    "tYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UY3000_.jpg", 1, 1),

        Movie(8, "Властелин колец: Братство кольца", 2001, 178, "12+",
            setOf(Genre.ACTION, Genre.ADVENTURE, Genre.DRAMA, Genre.FANTASY), 8.9f, 8.6f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_FMjpg_UY3000_.jpg", 4, 0),

        Movie(9, "Хороший, плохой, злой", 1966, 161, "12+",
            setOf(Genre.ADVENTURE, Genre.WESTERN), 8.8f, 8.5f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BMWRlYTNlZDgtMmJhNC00MTMzLWFkOTktZmFhZDljMjNiNTg4XkEyXkFqcGc@._V1_.jpg"),

        Movie(10, "Форрест Гамп", 1994, 144, "18+",
            setOf(Genre.DRAMA, Genre.ROMANCE, Genre.COMEDY), 8.8f, 8.9f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_FMjpg_UY3000_.jpg", 6, 3),

        Movie(11, "Властелин колец: Две крепости", 2002, 179, "12+",
            setOf(Genre.ACTION, Genre.ADVENTURE, Genre.DRAMA, Genre.FANTASY), 8.8f, 8.6f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BZGMxZTdjZmYtMmE2Ni00ZTdkLWI5NTgtNjlmMjBiNzU2MmI5XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UY3000_.jpg", 2, 0),

        Movie(12, "Бойцовский клуб", 1999, 139, "18+",
            setOf(Genre.CRIME, Genre.DRAMA, Genre.THRILLER), 8.8f, 8.7f, "Пусто", "https://" +
                    "m.media-amazon.com/images/M/MV5BOTgyOGQ1NDItNGU3Ny00MjU3LTg2YWEtNmEyYjBiMjI1Y2M5XkEyXkFqcGc@._V1_.jpg"),

        Movie(13, "Начало", 2010, 148, "12+",
            setOf(Genre.ACTION, Genre.SCI_FI, Genre.THRILLER), 8.8f, 8.7f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_FMjpg_UY3000_.jpg", 4, 0),

        Movie(14, "Звездные войны: Эпизод 5 – Империя наносит ответный удар", 1980, 124, "12+",
            setOf(Genre.ACTION, Genre.ADVENTURE, Genre.SCI_FI), 8.7f, 8.1f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BYmU1NDRjNDgtMzhiMi00NjZmLTg5NGItZDNiZjU5NTU4OTE0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UY3000_.jpg", 2, 0),

        Movie(15, "Матрица", 1999, 136, "16+",
            setOf(Genre.ACTION, Genre.SCI_FI), 8.7f, 8.5f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UY3000_.jpg", 4, 0),

        Movie(16, "Славные парни", 1990, 145, "16+",
            setOf(Genre.BIOGRAPHY, Genre.CRIME, Genre.DRAMA), 8.7f, 8.1f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BN2E5NzI2ZGMtY2VjNi00YTRjLWI1MDUtZGY5OWU1MWJjZjRjXkEyXkFqcGc@._V1_.jpg", 1, 0),

        Movie(17, "Пролетая над гнездом кукушки", 1975, 133, "16+",
            setOf(Genre.DRAMA), 8.7f, 8.5f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BYjBkMjgzMzYtNzRiMS00NDc3LWE4YTUtZjYxYjZhNjNhYzhhXkEyXkFqcGc@._V1_.jpg", 5, 6),

        Movie(18, "Интерстеллар", 2014, 169, "12+",
            setOf(Genre.ADVENTURE, Genre.DRAMA, Genre.SCI_FI), 8.7f, 8.7f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UY3000_.jpg", 1, 0),

        Movie(19, "Семь", 1995, 127, "18+",
            setOf(Genre.CRIME, Genre.DRAMA, Genre.MYSTERY, Genre.THRILLER), 8.6f, 8.3f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BOTUwODM5MTctZjczMi00OTk4LTg3NWUtNmVhMTAzNTNjYjcyXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UY3000_.jpg"),

        Movie(20, "Эта замечательная жизнь", 1946, 130, "12+",
            setOf(Genre.DRAMA, Genre.FANTASY, Genre.FAMILY, Genre.ROMANCE), 8.6f, 8.4f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BZjc4NDZhZWMtNGEzYS00ZWU2LThlM2ItNTA0YzQ0OTExMTE2XkEyXkFqcGdeQXVyNjUwMzI2NzU@._V1_FMjpg_UY3000_.jpg", 0, 1),

        Movie(21, "Молчание ягнят", 1991, 118, "18+",
            setOf(Genre.DRAMA, Genre.CRIME, Genre.HORROR, Genre.THRILLER), 8.6f, 8.3f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BNjNhZTk0ZmEtNjJhMi00YzFlLWE1MmEtYzM1M2ZmMGMwMTU4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UY3000_.jpg", 5, 1),

        Movie(22, "Семь самураев", 1954, 207, "16+",
            setOf(Genre.ACTION, Genre.DRAMA), 8.6f, 8.2f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BMmM2ZWM0MTktMDZlZi00ZDg4LWI2MTEtNDc5NzRmZTg2OGMyXkEyXkFqcGc@._V1_.jpg"),

        Movie(23, "Спасти рядового Райана", 1998, 169, "16+",
            setOf(Genre.DRAMA, Genre.WAR), 8.6f, 8.2f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BZjhkMDM4MWItZTVjOC00ZDRhLThmYTAtM2I5NzBmNmNlMzI1XkEyXkFqcGdeQXVyNDYyMDk5MTU@._V1_FMjpg_UY3000_.jpg", 5, 2),

        Movie(24, "Город Бога", 2002, 130, "16+",
            setOf(Genre.CRIME, Genre.DRAMA), 8.6f, 8.0f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BOTMwYjc5ZmItYTFjZC00ZGQ3LTlkNTMtMjZiNTZlMWQzNzI5XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UY3000_.jpg"),

        Movie(25, "Зеленая миля", 1999, 189, "14+",
            setOf(Genre.CRIME, Genre.DRAMA, Genre.FANTASY, Genre.MYSTERY), 8.6f, 9.1f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1_.jpg"),

        Movie(26, "Жизнь прекрасна", 1997, 116, "12+",
            setOf(Genre.COMEDY, Genre.DRAMA, Genre.ROMANCE, Genre.WAR), 8.6f, 8.6f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BYmJmM2Q4NmMtYThmNC00ZjRlLWEyZmItZTIwOTBlZDQ3NTQ1XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_FMjpg_UY3000_.jpg", 3, 0),

        Movie(27, "Терминатор 2: Судный день", 1991, 137, "16+",
            setOf(Genre.ACTION, Genre.ADVENTURE, Genre.SCI_FI), 8.6f, 8.4f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BMGU2NzRmZjUtOGUxYS00ZjdjLWEwZWItY2NlM2JhNjkxNTFmXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UY3000_.jpg", 4, 0),

        Movie(28, "Звездные войны: Эпизод 4 – Новая надежда", 1977, 121, "12+",
            setOf(Genre.ACTION, Genre.ADVENTURE, Genre.SCI_FI), 8.6f, 8.1f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BOTA5NjhiOTAtZWM0ZC00MWNhLThiMzEtZDFkOTk2OTU1ZDJkXkEyXkFqcGdeQXVyMTA4NDI1NTQx._V1_FMjpg_UY3000_.jpg", 7, 1),

        Movie(29, "Назад в будущее", 1985, 116, "12+",
            setOf(Genre.COMEDY, Genre.ADVENTURE, Genre.SCI_FI), 8.5f, 8.6f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BZmU0M2Y1OGUtZjIxNi00ZjBkLTg1MjgtOWIyNThiZWIwYjRiXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_FMjpg_UY3000_.jpg", 1, 0),

        Movie(30, "Унесенные призраками", 2001, 124, "12+",
            setOf(Genre.ANIMATION, Genre.ADVENTURE, Genre.FAMILY, Genre.FANTASY), 8.6f, 8.5f,
            "Пусто", "https://m.media-amazon.com/images/M/MV5BMjlmZmI5MDctNDE2YS00YWE0LWE5ZWItZDBhYWQ0NTcxNWRhXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UY3000_.jpg", 1, 0),

        Movie(31, "Пианист", 2002, 150, "16+",
            setOf(Genre.BIOGRAPHY, Genre.DRAMA, Genre.WAR), 8.5f, 8.5f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BYjk4MWM2ZTAtMmEwNy00MDAzLWE1ZTQtMjJlNTUwNDhhMmNmXkEyXkFqcGc@._V1_.jpg", 3, 0),

        Movie(32, "Гладиатор", 2000, 155, "18+",
            setOf(Genre.ACTION, Genre.ADVENTURE, Genre.DRAMA), 8.5f, 8.6f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BMDliMmNhNDEtODUyOS00MjNlLTgxODEtN2U3NzIxMGVkZTA1L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UY3000_.jpg", 5, 2),

        Movie(33, "Паразиты", 2019, 132, "18+",
            setOf(Genre.DRAMA, Genre.THRILLER, Genre.COMEDY), 8.5f, 8.0f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BYWZjMjk3ZTItODQ2ZC00NTY5LWE0ZDYtZTI3MjcwN2Q5NTVkXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_FMjpg_UY3000_.jpg", 4, 1),

        Movie(34, "Психо", 1960, 109, "16+",
            setOf(Genre.DRAMA, Genre.HORROR, Genre.MYSTERY, Genre.THRILLER), 8.5f, 8.1f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BNTQwNDM1YzItNDAxZC00NWY2LTk0M2UtNDIwNWI5OGUyNWUxXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UY3000_.jpg", 0, 1),

        Movie(35, "Король Лев", 1994, 88, "0+",
            setOf(Genre.ANIMATION, Genre.FAMILY, Genre.DRAMA, Genre.MUSICAL), 8.5f, 8.8f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BYTYxNGMyZTYtMjE3MS00MzNjLWFjNmYtMDk3N2FmM2JiM2M1XkEyXkFqcGdeQXVyNjY5NDU4NzI@._V1_FMjpg_UY3000_.jpg", 2, 3),

        Movie(36, "Могила светлячков", 1988, 88, "12+",
            setOf(Genre.ANIMATION, Genre.DRAMA, Genre.WAR), 8.5f, 8.2f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BZmY2NjUzNDQtNTgxNC00M2Q4LTljOWQtMjNjNDBjNWUxNmJlXkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_FMjpg_UY3000_.jpg"),

        Movie(37, "Отступники", 2006, 151, "16+",
            setOf(Genre.CRIME, Genre.DRAMA, Genre.THRILLER), 8.5f, 8.5f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BMTI1MTY2OTIxNV5BMl5BanBnXkFtZTYwNjQ4NjY3._V1_FMjpg_UY3000_.jpg", 4, 1),

        Movie(38, "Одержимость", 2014, 106, "16+",
            setOf(Genre.DRAMA), 8.5f, 8.4f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BOTA5NDZlZGUtMjAxOS00YTRkLTkwYmMtYWQ0NWEwZDZiNjEzXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UY3000_.jpg", 3, 1),

        Movie(39, "Харакири", 1962, 133, "16+",
            setOf(Genre.DRAMA, Genre.MYSTERY), 8.6f, 8.2f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BYjBmYTQ1NjItZWU5MS00YjI0LTg2OTYtYmFkN2JkMmNiNWVkXkEyXkFqcGdeQXVyMTMxMTY0OTQ@._V1_FMjpg_UY3000_.jpg"),

        Movie(40, "Американская история X", 1998, 119, "16+",
            setOf(Genre.CRIME, Genre.DRAMA), 8.5f, 8.3f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BZTRjMTdkMzctYWI1OS00ZmZkLWJhN2YtOGE3OTVhNTAwZTBhXkEyXkFqcGc@._V1_.jpg"),

        Movie(41, "Престиж", 2006, 130, "12+",
            setOf(Genre.DRAMA, Genre.MYSTERY, Genre.SCI_FI, Genre.THRILLER), 8.5f, 8.5f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BMjA4NDI0MTIxNF5BMl5BanBnXkFtZTYwNTM0MzY2._V1_FMjpg_UY3000_.jpg"),

        Movie(42, "Леон", 1994, 110, "16+",
            setOf(Genre.ACTION, Genre.CRIME, Genre.DRAMA, Genre.THRILLER), 8.5f, 8.7f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BODllNWE0MmEtYjUwZi00ZjY3LThmNmQtZjZlMjI2YTZjYmQ0XkEyXkFqcGdeQXVyNTc1NTQxODI@._V1_FMjpg_UY3000_.jpg"),

        Movie(43, "Человек-паук: Паутина вселенных", 2023, 140, "6+",
            setOf(Genre.ANIMATION, Genre.ADVENTURE, Genre.ACTION, Genre.FAMILY, Genre.FANTASY), 8.5f, 8.4f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BNThiZjA3MjItZGY5Ni00ZmJhLWEwN2EtOTBlYTA4Y2E0M2ZmXkEyXkFqcGc@._V1_.jpg"),

        Movie(44, "Касабланка", 1942, 102, "6+",
            setOf(Genre.DRAMA, Genre.ROMANCE, Genre.WAR), 8.5f, 8.0f, "Пусто",
            "https://m.media-amazon.com/images/M/MV5BY2IzZGY2YmEtYzljNS00NTM5LTgwMzUtMzM1NjQ4NGI0OTk0XkEyXkFqcGdeQXVyNDYyMDk5MTU@._V1_FMjpg_UY3000_.jpg", 3, 0)
        )
}