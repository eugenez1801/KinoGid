package com.example.kinogid.data.models.movies

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
    var movieList = listOf(
        Movie(0, "Побег из Шоушенка", 1994, 142, "16+",
            setOf(Genre.CRIME, Genre.DRAMA), 9.3f, 9.1f, "Мудрая " +
                    "и вдохновляющая история о банкире Энди Дюфрейне, несправедливо осуждённом на " +
                    "пожизненный срок. Оказавшись за решёткой, он сталкивается с суровой реальностью " +
                    "тюремного мира, но отказывается сдаваться. Благодаря своему спокойствию и " +
                    "интеллекту, Энди постепенно завоёвывает уважение среди " +
                    "заключённых и даже охранников.\n" +
                    "Этот фильм — гимн человеческому духу, рассказывающий о том, что настоящая " +
                    "свобода начинается внутри нас. История о дружбе, терпении и невероятном " +
                    "упорстве, которая остаётся в сердце навсегда.",
            "https://m.media-amazon.com/images/M/MV5BMGUwODNmMDYtZGY4NS00M2Q1LTgwY2" +
                    "ItMmEwY2UzMmY3MTM2XkEyXkFqcGc@._V1_FMjpg_UY3000_.jpg", 0, 0),

        Movie(1, "Крестный отец", 1972, 175, "16+",
            setOf(Genre.CRIME, Genre.DRAMA), 9.2f, 8.7f, "Эпичная сага " +
                    "о власти, семье и неизбежной цене, которую приходится платить за величие. Дон " +
                    "Вито Корлеоне — глава могущественной мафиозной семьи, человек принципов и традиций, " +
                    "уважаемый друзьями и внушающий страх врагам. Когда на него совершают " +
                    "покушение, его сыновья оказываются перед выбором: сохранить честь семьи или " +
                    "пойти своим путём.\n" +
                    "Фильм не просто о преступном мире — это глубокое размышление о долге, " +
                    "предательстве и американской мечте, показанное через судьбу одной семьи. " +
                    "Великолепные актёры, непревзойдённая атмосфера и сцены, ставшие классикой кино.",
            "https://m.media-amazon.com/images/M/MV5BNGEwYjgwOGQtYjg5ZS00Njc1LTk2Z" +
                    "GEtM2QwZWQ2NjdhZTE5XkEyXkFqcGc@._V1_.jpg", 3, 5),

        Movie(2, "Темный рыцарь", 2008, 152, "14+",
            setOf(Genre.ACTION, Genre.CRIME, Genre.DRAMA, Genre.SUPERHERO, Genre.THRILLER),
            9.0f, 8.5f, "Готический экшен-триллер о противостоянии " +
                    "Бэтмена и его самого харизматичного врага — Джокера. Когда в Готэм приходит " +
                    "хаос в лице безумного преступника, Брюс Уэйн оказывается перед выбором: насколько " +
                    "далеко он готов зайти, чтобы спасти город? Фильм поднимает вопросы морали, жертвенности " +
                    "и тонкой грани между героем и злодеем.", "https://m.media-amazon" +
                    ".com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_FMjpg_UY3000_.jpg", 2, 1),

        Movie(3, "Крестный отец 2", 1974, 202, "16+",
            setOf(Genre.CRIME, Genre.DRAMA), 9.0f, 8.5f, "Продолжение " +
                    "легендарной саги о семье Корлеоне, где прошлое и настоящее переплетаются. " +
                    "Параллельно рассказывается история молодого Вито Корлеоне, строящего свою империю, " +
                    "и его сына Майкла, который пытается удержать власть. Это кино о цене успеха, " +
                    "одиночестве на вершине и том, как наследие отца может стать проклятием для сына.",
            "https://m.media-amazon.com/images/M/MV5BMWMwMGQzZTItY2JlNC00OWZiLWIyMDctN" +
                    "Dk2ZDQ2YjRjMWQ0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UY3000_.jpg", 6, 0),

        Movie(4, "12 разгневанных мужчин", 1957, 96, "16+",
            setOf(Genre.DRAMA, Genre.CRIME), 9.0f, 8.5f, "Напряжённая " +
                    "драма, разворачивающаяся в одной комнате, где 12 присяжных решают судьбу " +
                    "подростка, обвиняемого в убийстве. Под предлогом простого судебного дела " +
                    "скрывается глубокая история о предрассудках, справедливости и силе одного " +
                    "человека, способного изменить мнение остальных.",
            "https://m.media-amazon.com/images/M/MV5BMWU4N2FjNzYtNTVkNC00NzQ0LTg0MjAtYTJlMjFhNGUxZDFmXkEyXkFqcGdeQXVyNjc1NTYyMjg@._V1_FMjpg_UY3000_.jpg", 0, 0),

        Movie(5, "Властелин колец: Возвращение короля", 2003, 201, "12+",
            setOf(Genre.ACTION, Genre.ADVENTURE, Genre.DRAMA, Genre.FANTASY), 9.0f, 8.7f, "Эпичное завершение трилогии о борьбе за Средиземье. Фродо и Сэм приближаются к Роковой горе, чтобы уничтожить Кольцо, пока Арагорн ведёт последнюю битву против сил Тьмы. Фильм о дружбе, жертвенности и том, что даже самый маленький человек может изменить ход истории.",
            "https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDI" +
                    "tYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UY3000_.jpg", 11, 4),

        Movie(6, "Список Шиндлера", 1993, 195, "16+",
            setOf(Genre.BIOGRAPHY, Genre.DRAMA), 9.0f, 8.8f, "Пронзительная драма о немецком промышленнике Оскаре Шиндлере, который во время Холокоста спасает сотни евреев от гибели. История о том, как один человек, движимый состраданием, может противостоять целой системе зла. Фильм о человечности в самых тёмных временах.",
            "https://m.media-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItY" +
                    "Tk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UY3000_.jpg", 7, 3),

        Movie(7, "Криминальное чтиво", 1994, 154, "18+",
            setOf(Genre.CRIME, Genre.DRAMA, Genre.COMEDY, Genre.THRILLER), 8.9f, 8.7f, "Культовый фильм Тарантино, где переплетаются истории бандитов, боксёра и пары грабителей. Нелинейный сюжет, острые диалоги и чёрный юмор создают уникальный стиль. Это кино о случайностях, которые меняют жизни, и о том, что даже у преступников есть свои принципы.",
            "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2I" +
                    "tYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UY3000_.jpg", 1, 1),

        Movie(8, "Властелин колец: Братство кольца", 2001, 178, "12+",
            setOf(Genre.ACTION, Genre.ADVENTURE, Genre.DRAMA, Genre.FANTASY), 8.9f, 8.6f, "Эпичное фэнтези о начале опасного путешествия хоббита Фродо, которому предстоит уничтожить Кольцо Всевластия. Вместе с верными друзьями он отправляется в полный опасностей путь, где встретит древние расы, предательство и настоящую дружбу. Фильм о магии, долге и том, как даже самый маленький может изменить судьбу мира.",
            "https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_FMjpg_UY3000_.jpg", 4, 0),

        Movie(9, "Хороший, плохой, злой", 1966, 161, "12+",
            setOf(Genre.ADVENTURE, Genre.WESTERN), 8.8f, 8.5f, "Легендарный вестерн о трёх стрелках, ищущих спрятанное золото на фоне Гражданской войны. Каждый из них — мастер своего дела, но у каждого свои принципы и цели. Фильм о жадности, чести и неожиданных союзах, где музыка и атмосфера стали такими же культовыми, как и герои.",
            "https://m.media-amazon.com/images/M/MV5BMWRlYTNlZDgtMmJhNC00MTMzLWFkOTktZmFhZDljMjNiNTg4XkEyXkFqcGc@._V1_.jpg"),

        Movie(10, "Форрест Гамп", 1994, 144, "18+",
            setOf(Genre.DRAMA, Genre.ROMANCE, Genre.COMEDY), 8.8f, 8.9f, "Трогательная история простого человека с добрым сердцем, который неосознанно становится свидетелем ключевых событий Америки XX века. Его наивность и искренность помогают ему преодолеть любые трудности. Фильм о любви, судьбе и том, что жизнь — как коробка шоколадных конфет: никогда не знаешь, какая начинка тебе попадётся.",
            "https://m.media-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_FMjpg_UY3000_.jpg", 6, 3),

        Movie(11, "Властелин колец: Две крепости", 2002, 179, "12+",
            setOf(Genre.ACTION, Genre.ADVENTURE, Genre.DRAMA, Genre.FANTASY), 8.8f, 8.6f, "Продолжение эпичного путешествия, где братство распадается, а опасность растёт. Арагорн, Леголас и Гимли идут на помощь королевству Рохан, а Фродо и Сэм встречают таинственного Голлума. Фильм о предательстве, надежде и битвах, которые определят будущее Средиземья.",
            "https://m.media-amazon.com/images/M/MV5BZGMxZTdjZmYtMmE2Ni00ZTdkLWI5NTgtNjlmMjBiNzU2MmI5XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UY3000_.jpg", 2, 0),

        Movie(12, "Бойцовский клуб", 1999, 139, "18+",
            setOf(Genre.CRIME, Genre.DRAMA, Genre.THRILLER), 8.8f, 8.7f, "Провокационная драма о мужчине, страдающем бессонницей, который находит спасение в подпольных драках. Вместе с загадочным Тайлером Дёрденом он создаёт клуб, где мужчины могут быть свободными. Фильм о потребительстве, идентичности и том, что иногда, чтобы найти себя, нужно всё потерять.", "https://" +
                    "m.media-amazon.com/images/M/MV5BOTgyOGQ1NDItNGU3Ny00MjU3LTg2YWEtNmEyYjBiMjI1Y2M5XkEyXkFqcGc@._V1_.jpg"),

        Movie(13, "Начало", 2010, 148, "12+",
            setOf(Genre.ACTION, Genre.SCI_FI, Genre.THRILLER), 8.8f, 8.7f, "Захватывающий триллер о ворах, которые крадут идеи прямо из снов. Доминик Кобб получает шанс стереть своё прошлое, но для этого ему нужно совершить невозможное — внедрить чужую мысль. Фильм о реальности, памяти и тонкой грани между сном и явью.",
            "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_FMjpg_UY3000_.jpg", 4, 0),

        Movie(14, "Звездные войны: Эпизод 5 – Империя наносит ответный удар", 1980, 124, "12+",
            setOf(Genre.ACTION, Genre.ADVENTURE, Genre.SCI_FI), 8.7f, 8.1f, "Люк Скайуокер начинает обучение джедаю, а Повстанцы скрываются от Империи. Дарт Вейдер начинает охоту за героями, раскрывая шокирующую тайну. Фильм о тёмной стороне Силы, испытаниях и том, что даже в поражении можно найти надежду.",
            "https://m.media-amazon.com/images/M/MV5BYmU1NDRjNDgtMzhiMi00NjZmLTg5NGItZDNiZjU5NTU4OTE0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UY3000_.jpg", 2, 0),

        Movie(15, "Матрица", 1999, 136, "16+",
            setOf(Genre.ACTION, Genre.SCI_FI), 8.7f, 8.5f, "Нео узнаёт, что реальность — это иллюзия, а человечество порабощено машинами. Вместе с повстанцами он вступает в войну против системы. Фильм о выборе, свободе воли и том, что иногда нужно принять красную таблетку, чтобы увидеть правду.",
            "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UY3000_.jpg", 4, 0),

        Movie(16, "Славные парни", 1990, 145, "16+",
            setOf(Genre.BIOGRAPHY, Genre.CRIME, Genre.DRAMA), 8.7f, 8.1f, "Криминальная сага о восхождении и падении гангстера Генри Хилла. От мелких преступлений до крупных дел — его жизнь полна денег, власти и предательства. Фильм о том, как мафия стала американской мечтой для тех, кто не хотел играть по правилам.",
            "https://m.media-amazon.com/images/M/MV5BN2E5NzI2ZGMtY2VjNi00YTRjLWI1MDUtZGY5OWU1MWJjZjRjXkEyXkFqcGc@._V1_.jpg", 1, 0),

        Movie(17, "Пролетая над гнездом кукушки", 1975, 133, "16+",
            setOf(Genre.DRAMA), 8.7f, 8.5f, "Пациент психиатрической клиники Рэндл Макмерфи бросает вызов системе, пытаясь вернуть свободу себе и другим. Его бунт меняет жизни всех вокруг. Фильм о борьбе за индивидуальность, жестокости \"лечения\" и цене, которую приходится платить за непокорность.",
            "https://m.media-amazon.com/images/M/MV5BYjBkMjgzMzYtNzRiMS00NDc3LWE4YTUtZjYxYjZhNjNhYzhhXkEyXkFqcGc@._V1_.jpg", 5, 6),

        Movie(18, "Интерстеллар", 2014, 169, "12+",
            setOf(Genre.ADVENTURE, Genre.DRAMA, Genre.SCI_FI), 8.7f, 8.7f, "Фантастическая эпопея о группе исследователей, отправляющихся через червоточину в поисках нового дома для человечества. Бывший пилот Купер должен сделать невозможный выбор между миссией и семьёй. Фильм о любви, времени и космических загадках, где наука переплетается с глубокими человеческими эмоциями.",
            "https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UY3000_.jpg", 1, 0),

        Movie(19, "Семь", 1995, 127, "18+",
            setOf(Genre.CRIME, Genre.DRAMA, Genre.MYSTERY, Genre.THRILLER), 8.6f, 8.3f, "Мрачный детектив о двух сыщиках, расследующих серию убийств, основанных на семи смертных грехах. Чем ближе они к разгадке, тем больше понимают, что сами стали частью чьей-то жуткой игры. Фильм о морали, наказании и той тьме, что скрывается за фасадом большого города.",
            "https://m.media-amazon.com/images/M/MV5BOTUwODM5MTctZjczMi00OTk4LTg3NWUtNmVhMTAzNTNjYjcyXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UY3000_.jpg"),

        Movie(20, "Эта замечательная жизнь", 1946, 130, "12+",
            setOf(Genre.DRAMA, Genre.FANTASY, Genre.FAMILY, Genre.ROMANCE), 8.6f, 8.4f, "Трогательная рождественская сказка о Джордже Бейли, который в отчаянии решает, что мир был бы лучше без него. Но ангел показывает ему, как много хорошего он на самом деле сделал. Фильм о ценности каждого человека, доброте и том, что настоящее богатство — не в деньгах.",
            "https://m.media-amazon.com/images/M/MV5BZjc4NDZhZWMtNGEzYS00ZWU2LThlM2ItNTA0YzQ0OTExMTE2XkEyXkFqcGdeQXVyNjUwMzI2NzU@._V1_FMjpg_UY3000_.jpg", 0, 1),

        Movie(21, "Молчание ягнят", 1991, 118, "18+",
            setOf(Genre.DRAMA, Genre.CRIME, Genre.HORROR, Genre.THRILLER), 8.6f, 8.3f, "Психологический триллер о стажёрке ФБР, которой поручают опросить гениального, но опасного убийцу-каннибала, чтобы поймать другого маньяка. Фильм о разуме, страхе и тонкой грани между охотником и добычей, где самый ужасный монстр может оказаться самым проницательным.",
            "https://m.media-amazon.com/images/M/MV5BNjNhZTk0ZmEtNjJhMi00YzFlLWE1MmEtYzM1M2ZmMGMwMTU4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UY3000_.jpg", 5, 1),

        Movie(22, "Семь самураев", 1954, 207, "16+",
            setOf(Genre.ACTION, Genre.DRAMA), 8.6f, 8.2f, "Эпичная сага о группе ронинов, согласившихся защитить деревню от бандитов. Каждый из семи воинов — мастер своего дела, но смогут ли они победить, когда их сорок против одного? Фильм о чести, жертвенности и вечной борьбе добра со злом, ставший эталоном жанра.",
            "https://m.media-amazon.com/images/M/MV5BMmM2ZWM0MTktMDZlZi00ZDg4LWI2MTEtNDc5NzRmZTg2OGMyXkEyXkFqcGc@._V1_.jpg"),

        Movie(23, "Спасти рядового Райана", 1998, 169, "16+",
            setOf(Genre.DRAMA, Genre.WAR), 8.6f, 8.2f, "Жестокая и правдивая история о группе солдат, отправленных в тыл врага, чтобы найти и спасти последнего из выживших братьев Райанов. Фильм о цене войны, братстве и том, стоит ли одна жизнь риска многих других.",
            "https://m.media-amazon.com/images/M/MV5BZjhkMDM4MWItZTVjOC00ZDRhLThmYTAtM2I5NzBmNmNlMzI1XkEyXkFqcGdeQXVyNDYyMDk5MTU@._V1_FMjpg_UY3000_.jpg", 5, 2),

        Movie(24, "Город Бога", 2002, 130, "16+",
            setOf(Genre.CRIME, Genre.DRAMA), 8.6f, 8.0f, "Жёсткая драма о взрослении в фавелах Рио-де-Жанейро, где мальчишка с фотоаппаратом пытается выжить среди наркобанд и насилия. Фильм о том, как окружение формирует судьбу, и о редких лучах надежды в мире, где детство заканчивается слишком рано.",
            "https://m.media-amazon.com/images/M/MV5BOTMwYjc5ZmItYTFjZC00ZGQ3LTlkNTMtMjZiNTZlMWQzNzI5XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UY3000_.jpg"),

        Movie(25, "Зеленая миля", 1999, 189, "14+",
            setOf(Genre.CRIME, Genre.DRAMA, Genre.FANTASY, Genre.MYSTERY), 8.6f, 9.1f, "Мистическая драма о надзирателе тюрьмы, который встречает необычного заключённого — гиганта с даром исцеления. Но может ли чудо спасти его от жёсткой системы? Фильм о чудесах, несправедливости и том, что ангелы иногда приходят в самых неожиданных обличьях.",
            "https://m.media-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1_.jpg"),

        Movie(26, "Жизнь прекрасна", 1997, 116, "12+",
            setOf(Genre.COMEDY, Genre.DRAMA, Genre.ROMANCE, Genre.WAR), 8.6f, 8.6f, "Трагикомедия об отце, который превращает ужасы концлагеря в игру, чтобы спасти своего сына. Даже перед лицом смерти он дарит ребёнку детство. Фильм о силе любви, воображении и том, как человеческий дух может победить любую тьму.",
            "https://m.media-amazon.com/images/M/MV5BYmJmM2Q4NmMtYThmNC00ZjRlLWEyZmItZTIwOTBlZDQ3NTQ1XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_FMjpg_UY3000_.jpg", 3, 0),

        Movie(27, "Терминатор 2: Судный день", 1991, 137, "16+",
            setOf(Genre.ACTION, Genre.ADVENTURE, Genre.SCI_FI), 8.6f, 8.4f, "Футуристический боевик, где киборг из будущего должен защитить мальчика, который однажды спасёт человечество. Но новый терминатор куда опаснее всего, что они встречали раньше. Фильм о судьбе, технологиях и том, может ли машина стать более человечной, чем люди.",
            "https://m.media-amazon.com/images/M/MV5BMGU2NzRmZjUtOGUxYS00ZjdjLWEwZWItY2NlM2JhNjkxNTFmXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UY3000_.jpg", 4, 0),

        Movie(28, "Звездные войны: Эпизод 4 – Новая надежда", 1977, 121, "12+",
            setOf(Genre.ACTION, Genre.ADVENTURE, Genre.SCI_FI), 8.6f, 8.1f, "Эпическая космическая сага о юном Люке Скайуокере, который вместе с отважной принцессой Лейей, харизматичным контрабандистом Ханом Соло и мудрым джедаем Оби-Ваном Кеноби вступает в борьбу с Галактической Империей. Фильм, положивший начало легендарной франшизе, рассказывает о добре и зле, судьбе и том, как даже маленький бунт может изменить галактику.",
            "https://m.media-amazon.com/images/M/MV5BOTA5NjhiOTAtZWM0ZC00MWNhLThiMzEtZDFkOTk2OTU1ZDJkXkEyXkFqcGdeQXVyMTA4NDI1NTQx._V1_FMjpg_UY3000_.jpg", 7, 1),

        Movie(29, "Назад в будущее", 1985, 116, "12+",
            setOf(Genre.COMEDY, Genre.ADVENTURE, Genre.SCI_FI), 8.5f, 8.6f, "Захватывающая приключенческая комедия о подростке Марти Макфлае, который случайно попадает из 1985 года в 1955-й на машине времени, созданной эксцентричным доктором Брауном. Теперь ему нужно не только вернуться в своё время, но и убедиться, что его родители влюбляются друг в друга. Фильм о времени, судьбе и важности каждого нашего выбора.",
            "https://m.media-amazon.com/images/M/MV5BZmU0M2Y1OGUtZjIxNi00ZjBkLTg1MjgtOWIyNThiZWIwYjRiXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_FMjpg_UY3000_.jpg", 1, 0),

        Movie(30, "Унесенные призраками", 2001, 124, "12+",
            setOf(Genre.ANIMATION, Genre.ADVENTURE, Genre.FAMILY, Genre.FANTASY), 8.6f, 8.5f,
            "Волшебная история о девочке Тихиро, которая попадает в таинственный мир духов, где её родителей превращают в свиней. Чтобы спасти их и вернуться домой, ей придётся работать в бане для духов и не забывать своё имя. Этот анимационный шедевр рассказывает о взрослении, храбрости и важности оставаться собой в любых обстоятельствах.",
            "https://m.media-amazon.com/images/M/MV5BMjlmZmI5MDctNDE2YS00YWE0LWE5ZWItZDBhYWQ0NTcxNWRhXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UY3000_.jpg", 1, 0),

        Movie(31, "Пианист", 2002, 150, "16+",
            setOf(Genre.BIOGRAPHY, Genre.DRAMA, Genre.WAR), 8.5f, 8.5f, "Пронзительная военная драма о талантливом польском пианисте еврейского происхождения, который пытается выжить в варшавском гетто во время Второй мировой войны. Фильм, основанный на реальных событиях, показывает, как искусство и человеческая воля могут помочь пережить самые тёмные времена.",
            "https://m.media-amazon.com/images/M/MV5BYjk4MWM2ZTAtMmEwNy00MDAzLWE1ZTQtMjJlNTUwNDhhMmNmXkEyXkFqcGc@._V1_.jpg", 3, 0),

        Movie(32, "Гладиатор", 2000, 155, "18+",
            setOf(Genre.ACTION, Genre.ADVENTURE, Genre.DRAMA), 8.5f, 8.6f, "Эпическая историческая драма о римском генерале Максимусе, которого предательство превращает из любимого командующего в раба-гладиатора. Теперь он жаждет мести императору Коммоду, убившему его семью. Фильм о чести, предательстве и неукротимой жажде справедливости.",
            "https://m.media-amazon.com/images/M/MV5BMDliMmNhNDEtODUyOS00MjNlLTgxODEtN2U3NzIxMGVkZTA1L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UY3000_.jpg", 5, 2),

        Movie(33, "Паразиты", 2019, 132, "18+",
            setOf(Genre.DRAMA, Genre.THRILLER, Genre.COMEDY), 8.5f, 8.0f, "Остроумная и провокационная трагикомедия о бедной семье, которая постепенно внедряется в жизнь богатых хозяев, выдавая себя за высококлассных специалистов. Но их тщательно построенный план начинает рушиться с неожиданными последствиями. Фильм о социальном неравенстве, человеческой хитрости и том, как далеко люди готовы зайти ради лучшей жизни.",
            "https://m.media-amazon.com/images/M/MV5BYWZjMjk3ZTItODQ2ZC00NTY5LWE0ZDYtZTI3MjcwN2Q5NTVkXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_FMjpg_UY3000_.jpg", 4, 1),

        Movie(34, "Психо", 1960, 109, "16+",
            setOf(Genre.DRAMA, Genre.HORROR, Genre.MYSTERY, Genre.THRILLER), 8.5f, 8.1f, "Культовый психологический триллер о секретарше Мэрион Крейн, которая, украв деньги, останавливается в уединённом мотеле, управляемом застенчивым Норманом Бейтсом и его властной матерью. Фильм, перевернувший жанр ужасов, исследует тему раздвоения личности и показывает, что настоящий ужас часто скрывается за самыми обычными фасадами.",
            "https://m.media-amazon.com/images/M/MV5BNTQwNDM1YzItNDAxZC00NWY2LTk0M2UtNDIwNWI5OGUyNWUxXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UY3000_.jpg", 0, 1),

        Movie(35, "Король Лев", 1994, 88, "0+",
            setOf(Genre.ANIMATION, Genre.FAMILY, Genre.DRAMA, Genre.MUSICAL), 8.5f, 8.8f, "Великолепный анимационный мюзикл о львёнке Симбе, который после трагической гибели отца вынужден покинуть своё королевство. Повзрослев, он должен вернуться, чтобы занять своё законное место. Эта история о взрослении, ответственности и круговороте жизни стала одной из самых любимых в истории анимации.",
            "https://m.media-amazon.com/images/M/MV5BYTYxNGMyZTYtMjE3MS00MzNjLWFjNmYtMDk3N2FmM2JiM2M1XkEyXkFqcGdeQXVyNjY5NDU4NzI@._V1_FMjpg_UY3000_.jpg", 2, 3),

        Movie(36, "Могила светлячков", 1988, 88, "12+",
            setOf(Genre.ANIMATION, Genre.DRAMA, Genre.WAR), 8.5f, 8.2f, "Трогательная и печальная анимационная драма о брате и сестре, пытающихся выжить в Японии во время Второй мировой войны после смерти матери. Фильм показывает войну глазами детей и рассказывает о невинности, потерях и хрупкости жизни.",
            "https://m.media-amazon.com/images/M/MV5BZmY2NjUzNDQtNTgxNC00M2Q4LTljOWQtMjNjNDBjNWUxNmJlXkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_FMjpg_UY3000_.jpg"),

        Movie(37, "Отступники", 2006, 151, "16+",
            setOf(Genre.CRIME, Genre.DRAMA, Genre.THRILLER), 8.5f, 8.5f, "Напряжённый криминальный триллер о полицейском, внедрившемся в ирландскую мафию, и гангстере, проникшем в полицию. Когда обе стороны начинают подозревать о наличии крота, начинается опасная игра на выживание. Фильм о двойной жизни, предательстве и том, как стирается грань между копами и бандитами.",
            "https://m.media-amazon.com/images/M/MV5BMTI1MTY2OTIxNV5BMl5BanBnXkFtZTYwNjQ4NjY3._V1_FMjpg_UY3000_.jpg", 4, 1),

        Movie(38, "Одержимость", 2014, 106, "16+",
            setOf(Genre.DRAMA), 8.5f, 8.4f, "Напряжённая драма о молодом и амбициозном барабанщике Эндрю, который готов на всё ради совершенства. Его жёсткий наставник Теренс Флетчер испытывает его на прочность, размывая границы между мотивацией и жестокостью. Фильм о цене гениальности, одержимости искусством и том, как далеко можно зайти в погоне за величием.",
            "https://m.media-amazon.com/images/M/MV5BOTA5NDZlZGUtMjAxOS00YTRkLTkwYmMtYWQ0NWEwZDZiNjEzXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UY3000_.jpg", 3, 1),

        Movie(39, "Харакири", 1962, 133, "16+",
            setOf(Genre.DRAMA, Genre.MYSTERY), 8.6f, 8.2f, "После падения своего клана ронин Хансиро Цугумо приходит в поместье рода Ии, прося разрешения совершить ритуальное самоубийство — харакири — на их земле. Самураи клана Ии, уверенные, что он просто ищет подаяния или хочет их запугать, решают преподать ему урок. Но вскоре они понимают, что недооценили гостя: за молчаливой решительностью Цугумо скрывается нечто куда более опасное...",
            "https://m.media-amazon.com/images/M/MV5BYjBmYTQ1NjItZWU5MS00YjI0LTg2OTYtYmFkN2JkMmNiNWVkXkEyXkFqcGdeQXVyMTMxMTY0OTQ@._V1_FMjpg_UY3000_.jpg"),

        Movie(40, "Американская история X", 1998, 119, "16+",
            setOf(Genre.CRIME, Genre.DRAMA), 8.5f, 8.3f, "Мощная драма о бывшем неонацисте Дереке, который после тюрьмы пытается уберечь младшего брата от повторения своих ошибок. Фильм исследует природу ненависти, цикл насилия и возможность искупления, показывая, как предрассудки могут разрушать жизни.",
            "https://m.media-amazon.com/images/M/MV5BZTRjMTdkMzctYWI1OS00ZmZkLWJhN2YtOGE3OTVhNTAwZTBhXkEyXkFqcGc@._V1_.jpg"),

        Movie(41, "Престиж", 2006, 130, "12+",
            setOf(Genre.DRAMA, Genre.MYSTERY, Genre.SCI_FI, Genre.THRILLER), 8.5f, 8.5f, "Загадочная история о соперничестве двух иллюзионистов викторианской эпохи, чья конкуренция превращается в опасную одержимость. Их борьба за звание лучшего фокусника приводит к неожиданным и шокирующим последствиям. Фильм об иллюзиях, жертвах и цене настоящего искусства.",
            "https://m.media-amazon.com/images/M/MV5BMjA4NDI0MTIxNF5BMl5BanBnXkFtZTYwNTM0MzY2._V1_FMjpg_UY3000_.jpg"),

        Movie(42, "Леон", 1994, 110, "16+",
            setOf(Genre.ACTION, Genre.CRIME, Genre.DRAMA, Genre.THRILLER), 8.5f, 8.7f, "Трогательный и жёсткий криминальный триллер о профессиональном киллере Леоне, который неожиданно берёт под опеку 12-летнюю Матильду после убийства её семьи. Их необычная дружба меняет обоих, но прошлое настигает их. Фильм о спасении, мести и неожиданных связях между людьми.",
            "https://m.media-amazon.com/images/M/MV5BODllNWE0MmEtYjUwZi00ZjY3LThmNmQtZjZlMjI2YTZjYmQ0XkEyXkFqcGdeQXVyNTc1NTQxODI@._V1_FMjpg_UY3000_.jpg"),

        Movie(43, "Человек-паук: Паутина вселенных", 2023, 140, "6+",
            setOf(Genre.ANIMATION, Genre.ADVENTURE, Genre.ACTION, Genre.FAMILY, Genre.FANTASY), 8.5f, 8.4f, "Яркий анимационный супергеройский фильм о подростке Майлзе Моралесе, который становится Человеком-пауком в своей вселенной. Когда он сталкивается с другими Пауками из параллельных миров, ему предстоит спасти мультивселенную. Фильм о принятии себя, ответственности и том, что любой может надеть маску.",
            "https://m.media-amazon.com/images/M/MV5BNThiZjA3MjItZGY5Ni00ZmJhLWEwN2EtOTBlYTA4Y2E0M2ZmXkEyXkFqcGc@._V1_.jpg"),

        Movie(44, "Касабланка", 1942, 102, "6+",
            setOf(Genre.DRAMA, Genre.ROMANCE, Genre.WAR), 8.5f, 8.0f, "Вечная классика о владельце ночного клуба Рике, который в военной Касабланке сталкивается с прошлой любовью — Ильзой. Теперь он должен решить: помочь ей и её мужу бежать от нацистов или думать только о себе. Фильм о любви, жертвенности и невозможных выборах в трудные времена.",
            "https://m.media-amazon.com/images/M/MV5BY2IzZGY2YmEtYzljNS00NTM5LTgwMzUtMzM1NjQ4NGI0OTk0XkEyXkFqcGdeQXVyNDYyMDk5MTU@._V1_FMjpg_UY3000_.jpg", 3, 0),

        Movie(45, "Подозрительные лица", 1995, 106 , "16+",
            setOf(Genre.CRIME, Genre.DRAMA, Genre.MYSTERY, Genre.THRILLER), 8.5f, 7.8f, "Захватывающий криминальный триллер о группе преступников, собранных загадочным Кейзером Созе для особого задания. Когда операция идёт не по плану, начинается череда неожиданных событий. Фильм с культовым финалом о доверии, обмане и том, что не всё то, что кажется очевидным, является правдой.",
            "https://m.media-amazon.com/images/M/MV5BYTViNjMyNmUtNDFkNC00ZDRlLThmMDUtZDU2YWE4NGI2ZjVmXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UX1000_.jpg", 2, 0),

        Movie(46, "1+1", 2011, 112 , "14+",
            setOf(Genre.DRAMA, Genre.COMEDY), 8.5f, 8.9f, "Трогательная комедия-драма о богатом парализованном аристократе Филиппе, который нанимает в помощники бывшего заключённого Дрисса. Их неожиданная дружба меняет жизни обоих, показывая, что настоящая поддержка может прийти оттуда, откуда её не ждёшь. Фильм о преодолении стереотипов, радости жизни и силе человеческих отношений.",
            "https://m.media-amazon.com/images/M/MV5BMTYxNDA3MDQwNl5BMl5BanBnXkFtZTcwNTU4Mzc1Nw@@._V1_FMjpg_UX1024_.jpg", 0, 0),

        Movie(47, "Новый кинотеатр «Парадизо»", 1988, 174, "16+",
            setOf(Genre.DRAMA, Genre.ROMANCE), 8.5f, 8.0f, "Ностальгическая драма о мальчике Сальваторе, который находит вторую семью в местном кинотеатре и его эксцентричном операторе Альфредо. Фильм о магии кино, первой любви и том, как детские воспоминания формируют нас на всю жизнь. История, которая заставит вас смеяться и плакать одновременно.",
            "https://m.media-amazon.com/images/M/MV5BMTljNzc4YWEtYTZlMS00ODMyLWIwMTAtNWQxY2VkMDEwYTk5XkEyXkFqcGc@._V1_.jpg", 1, 1),

        Movie(48, "Чужой", 1979, 117 , "18+",
            setOf(Genre.HORROR, Genre.SCI_FI), 8.5f, 8.1f, "Космический хоррор о команде грузового корабля «Ностромо», которая обнаруживает на заброшенном судне таинственные яйца. Когда один из паразитов проникает на борт, экипаж понимает — они не просто в опасности, они стали добычей. Фильм о страхе перед неизвестным, где в темноте космоса скрывается идеальный хищник.",
            "https://m.media-amazon.com/images/M/MV5BOGQzZTBjMjQtOTVmMS00NGE5LWEyYmMtOGQ1ZGZjNmRkYjFhXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_FMjpg_UX1024_.jpg", 1, 0),

        Movie(49, "Новые времена", 1936, 87  , "0+",
            setOf(Genre.COMEDY, Genre.DRAMA, Genre.ROMANCE), 8.5f, 8.1f, "Трогательная комедия о маленьком человеке, пытающемся выжить в мире промышленной механизации. Чарли Чаплин в своей последней роли Бродяги показывает, как сохранить человечность, когда общество превращает людей в винтики системы. Фильм о надежде, любви и сопротивлении бессмысленной гонке за «прогрессом».",
            "https://m.media-amazon.com/images/M/MV5BYjJiZjMzYzktNjU0NS00OTkxLWEwYzItYzdhYWJjN2QzMTRlL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UX1024_.jpg", 0, 0),

        Movie(50, "Окно во двор", 1954, 112  , "12+",
            setOf(Genre.DRAMA, Genre.MYSTERY, Genre.THRILLER), 8.5f, 8.0f, "Напряжённый триллер о фотографе-инвалиде, который, наблюдая за соседями, начинает подозревать, что стал свидетелем убийства. Но сможет ли он доказать это, не выходя из квартиры? Фильм о любопытстве, паранойе и том, как легко переступить грань между наблюдением и вмешательством.",
            "https://m.media-amazon.com/images/M/MV5BNGUxYWM3M2MtMGM3Mi00ZmRiLWE0NGQtZjE5ODI2OTJhNTU0XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_FMjpg_UY3000_.jpg", 0, 0),

        Movie(51, "Однажды на Диком Западе", 1968, 166  , "12+",
            setOf(Genre.DRAMA, Genre.WESTERN), 8.5f, 8.0f, "Эпический вестерн о четырёх незнакомцах, чьи судьбы переплетаются вокруг строительства железной дороги. Среди них — загадочная женщина, мстительный бандит, убийца с гармоникой и жестокий наёмник. Фильм о мести, судьбе и музыке, которая становится полноправным персонажем истории.",
            "https://m.media-amazon.com/images/M/MV5BZjYyNGY1MDEtN2I1MC00MGVhLTljZTYtODQ1NzQ0ODc2NzZlXkEyXkFqcGc@._V1_.jpg", 0, 0),

        Movie(52, "Джанго освобожденный", 2012, 165  , "18+",
            setOf(Genre.DRAMA, Genre.COMEDY, Genre.WESTERN), 8.5f, 8.2f, "Провокационный спагетти-вестерн о рабе-невольнике, который вместе с охотником за головами отправляется на поиски своей жены. Их путь лежит через плантации, где царит жестокость, а каждый шаг может стать последним. Фильм о свободе, мести и том, что иногда нужно взять судьбу в свои руки.",
            "https://m.media-amazon.com/images/M/MV5BMjIyNTQ5NjQ1OV5BMl5BanBnXkFtZTcwODg1MDU4OA@@._V1_FMjpg_UY3000_.jpg", 2, 2),
        Movie(53, "Огни большого города", 1931, 87  , "0+",
            setOf(Genre.DRAMA, Genre.ROMANCE, Genre.COMEDY), 8.5f, 8.5f, "Трогательная немая комедия о Бродяге, который влюбляется в слепую цветочницу и готов на всё, чтобы оплатить операцию, которая вернёт ей зрение. Фильм о самоотверженности, иллюзиях и том, что настоящее чудо — это способность любить вопреки всему.",
            "https://m.media-amazon.com/images/M/MV5BY2I4MmM1N2EtM2YzOS00OWUzLTkzYzctNDc5NDg2N2IyODJmXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UX1024_.jpg", 0, 0),

        Movie(54, "Апокалипсис сегодня", 1979, 147  , "18+",
            setOf(Genre.DRAMA, Genre.MYSTERY, Genre.WAR), 8.4f, 8.1f, "Галлюциногенное путешествие в самое сердце тьмы: капитан Уиллард отправляется в джунгли Камбоджи, чтобы найти и ликвидировать сошедшего с ума полковника Курца. Фильм о безумии войны, где граница между цивилизацией и варварством стирается навсегда.",
            "https://m.media-amazon.com/images/M/MV5BZDhiMTljYjYtODc1Yy00MmEwLTg2OTYtYmE1YTRmNDE4MmEwXkEyXkFqcGc@._V1_.jpg", 2, 3),

        Movie(55, "Дюна: Часть вторая", 2024, 166  , "12+",
            setOf(Genre.ACTION, Genre.ADVENTURE, Genre.DRAMA, Genre.SCI_FI), 8.5f, 8.2f, "Эпичное продолжение истории Пола Атрейдеса, который ведёт фременов в войне против дома Харконненов. Чем ближе он к мести, тем больше становится похож на того, кого боялся — мессию, способного погрузить вселенную в священную войну. Фильм о власти, судьбе и экологии далёкой пустынной планеты.",
            "https://m.media-amazon.com/images/M/MV5BYjNmMjUxYzEtNzgxOC00NGJjLWI1MmMtYThkMDU2NjE4ZWIxXkEyXkFqcGc@._V1_.jpg", 2, 0),

        Movie(56, "Помни", 2000, 113 , "16+",
            setOf(Genre.MYSTERY, Genre.THRILLER), 8.4f, 7.9f, "Детектив-головоломка о человеке с потерей памяти, который с помощью татуировок и фотографий пытается найти убийцу жены. Но чем ближе он к разгадке, тем больше вопросов возникает. Фильм о том, как далеко можно зайти в поисках правды, когда не веришь даже себе.",
            "https://m.media-amazon.com/images/M/MV5BZTcyNjk1MjgtOWI3Mi00YzQwLWI5MTktMzY4ZmI2NDAyNzYzXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UX1024_.jpg", 0, 0),

        Movie(57, "ВАЛЛИ", 2008, 98  , "0+",
            setOf(Genre.ADVENTURE, Genre.FAMILY, Genre.ANIMATION, Genre.SCI_FI), 8.4f, 8.4f, "Очаровательная анимационная история о последнем роботе на опустевшей Земле, который 700 лет убирал мусор, мечтая о любви. Когда он встречает современный космический зонд Еву, начинается приключение, способное изменить судьбу человечества. Фильм о надежде, экологии и силе воображения.",
            "https://m.media-amazon.com/images/M/MV5BMjExMTg5OTU0NF5BMl5BanBnXkFtZTcwMjMxMzMzMw@@._V1_FMjpg_UX1024_.jpg", 1, 1),

        Movie(58, "Индиана Джонс: В поисках утраченного ковчега", 1981, 115, "0+",
            setOf(Genre.ADVENTURE, Genre.ACTION), 8.4f, 8.0f, "Захватывающее приключение археолога-авантюриста Индианы Джонса, который отправляется на поиски библейского Ковчега Завета, способного дать невероятную власть. На его пути — древние ловушки, коварные нацисты и собственная боязнь змей. Фильм о том, что иногда важнее знаний оказываются смекалка и кнут.",
            "https://m.media-amazon.com/images/M/MV5BNTU2ODkyY2MtMjU1NC00NjE1LWEzYjgtMWQ3MzRhMTE0NDc0XkEyXkFqcGdeQXVyMjM4MzQ4OTQ@._V1_FMjpg_UX1024_.jpg", 5, 0),

        Movie(59, "Жизнь других", 2006, 137, "16+",
            setOf(Genre.DRAMA, Genre.MYSTERY, Genre.THRILLER), 8.4f, 8.1f, "Пронзительная драма о сотруднике Штази, который, наблюдая за жизнью писателя и его возлюбленной, начинает сомневаться в своей работе. Чем больше он погружается в их мир, тем сильнее меняется его собственная система ценностей. Фильм о власти искусства над человеческой душой и том, как один человек может противостоять целой системе.",
            "https://m.media-amazon.com/images/M/MV5BNmQyNmJjM2ItNTQzYi00ZjMxLWFjMDYtZjUyN2YwZDk5YWQ2XkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_FMjpg_UX1024_.jpg", 1, 0),

        Movie(60, "Мстители: Война бесконечности", 2018, 149, "16+",
            setOf(Genre.ACTION, Genre.ADVENTURE, Genre.SCI_FI), 8.4f, 8.1f, "Грандиозное столкновение всех супергероев Marvel с могущественным Таносом, который хочет уничтожить половину вселенной. Разбросанные по разным уголкам космоса, герои должны объединиться, чтобы остановить неизбежное. Фильм о жертвенности, где даже самые сильные могут проиграть.",
            "https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_FMjpg_UX1024_.jpg", 0, 0),

        Movie(61, "Сансет бульвар", 1950, 110, "16+",
            setOf(Genre.DRAMA), 8.4f, 8.0f, "Мрачная ирония Голливуда: стареющая звезда немого кино Норма Десмонд заманивает в свой мир молодого сценариста, надеясь вернуть былую славу. Чем дальше заходит их странные отношения, тем очевиднее становится — время нельзя обмануть. Фильм о цене славы и иллюзиях, которые могут разрушить жизнь.",
            "https://m.media-amazon.com/images/M/MV5BMTU0NTkyNzYwMF5BMl5BanBnXkFtZTgwMDU0NDk5MTI@._V1_.jpg", 3, 4),

        Movie(62, "Человек-паук: Через Вселенные", 2018, 117, "6+",
            setOf(Genre.ANIMATION, Genre.ACTION, Genre.SUPERHERO,Genre.ADVENTURE, Genre.COMEDY), 8.4f, 8.2f, "Яркий анимационный шедевр о подростке Майлзе Моралесе, который случайно обретает паучьи способности и встречает других Человеков-пауков из параллельных вселенных. Вместе им предстоит остановить угрозу, способную разрушить мультивселенную. Фильм о взрослении, ответственности и том, что любой может носить маску — даже ты.",
            "https://m.media-amazon.com/images/M/MV5BMjMwNDkxMTgzOF5BMl5BanBnXkFtZTgwNTkwNTQ3NjM@._V1_FMjpg_UX1024_.jpg", 1, 1),

        Movie(63, "Тропы славы", 1957, 88, "16+",
            setOf(Genre.DRAMA, Genre.WAR), 8.4f, 8.1f, "Жесткая военная драма о французских солдатах во время Первой мировой войны, которых командование отправляет на верную смерть в бессмысленную атаку. Когда они отказываются идти, начинается показательный суд. Фильм Кубрика о бессмысленности войны, трусости генералов и цене человеческой жизни.",
            "https://m.media-amazon.com/images/M/MV5BNmQ2NmI2ODYtMDQzNS00NzQyLTkzZjgtZmZlYTQ5MTc1OWU3XkEyXkFqcGc@._V1_.jpg", 0, 0),

        Movie(64, "Свидетель обвинения", 1957, 116, "16+",
            setOf(Genre.DRAMA, Genre.CRIME, Genre.MYSTERY, Genre.THRILLER), 8.4f, 8.2f, "Юридическая драма о пожилом адвокате, берущемся за, казалось бы, безнадёжное дело — защиту клиента, обвиняемого в убийстве состоятельной женщины. По мере разбирательства раскрываются неожиданные детали, а показания главной свидетельницы вносят новые повороты в процесс.\n" +
                    "Фильм мастерски исследует тему субъективности правосудия, где каждое новое доказательство может изменить всю картину происшедшего. Это история о профессиональной чести, человеческой хитрости и том, как истина иногда оказывается сложнее, чем кажется на первый взгляд.",
            "https://m.media-amazon.com/images/M/MV5BNWY4ODYyYTUtOTg4Zi00ZDIxLTgzMjAtYzA3ZjllOWI0ZDBlXkEyXkFqcGc@._V1_.jpg", 0, 1),

        Movie(65, "Сияние", 1980, 146, "18+",
            setOf(Genre.DRAMA, Genre.HORROR), 8.4f, 7.8f, "Психологический хоррор о писателе Джеке Торренсе, который с семьёй становится смотрителем пустынного горного отеля. Изоляция, сверхъестественные явления и его собственное безумие превращают зимовку в кошмар. Фильм о том, как одиночество и творческий кризис могут сломать даже сильного человека.",
            "https://m.media-amazon.com/images/M/MV5BZWFlYmY2MGEtZjVkYS00YzU4LTg0YjQtYzY1ZGE3NTA5NGQxXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_FMjpg_UX1024_.jpg", 0, 0),

        Movie(66, "Великий диктатор", 1940, 125, "6+",
            setOf(Genre.DRAMA, Genre.WAR, Genre.COMEDY), 8.4f, 8.1f, "Сатирическая комедия Чаплина о безумном диктаторе Аденоиде Хинкеле. Параллельно рассказывается история еврейского парикмахера, случайно оказавшегося его двойником. Фильм, смело высмеивающий фашизм, с самой пронзительной финальной речью в истории кино.",
            "https://m.media-amazon.com/images/M/MV5BMmExYWJjNTktNGUyZS00ODhmLTkxYzAtNWIzOGEyMGNiMmUwXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UX1024_.jpg", 0, 0),

        Movie(67, "12-я неудача", 2023, 147, "12+",
            setOf(Genre.DRAMA, Genre.BIOGRAPHY), 8.4f, 7.9f, "Фильм рассказывает историю Маноджа Кумара Шармы, который преодолевает огромные трудности, чтобы стать офицером индийской полиции. Фильм основан на реальных событиях и показывает путь Маноджа из деревни, где его семья жила в нищете, к достижению цели. Вдохновляющая история Маноджа, который не сдаётся после нескольких провалов на экзаменах, заставляет задуматься о силе воли и упорстве. ",
            "https://m.media-amazon.com/images/M/MV5BNTE3OTIxZDYtNjA0NC00N2YxLTg1NGQtOTYxNmZkMDkwOWNjXkEyXkFqcGc@._V1_.jpg", 0, 0),

        Movie(68, "Чужие", 1986, 137, "16+",
            setOf(Genre.HORROR, Genre.SCI_FI, Genre.ACTION, Genre.ADVENTURE), 8.4f, 8.1f, "Эпичный сиквел «Чужого», где Рипли возвращается на планету LV-426 с отрядом морпехов, чтобы выяснить судьбу колонистов. Вместо ответов они находят целое гнездо ксеноморфов. Фильм Джеймса Кэмерона превращает космический ужас в напряжённый боевик о материнстве и выживании против всех шансов.",
            "https://m.media-amazon.com/images/M/MV5BZjIyNGJhYzYtN2I1My00OTVhLWEyMzItZTVjNDMzOTVkYWViXkEyXkFqcGc@._V1_.jpg", 2, 0),

        Movie(69, "Бесславные ублюдки", 2009, 153, "18+",
            setOf(Genre.DRAMA, Genre.WAR, Genre.COMEDY), 8.4f, 8.0f, "Военный фильм Квентина Тарантино, в котором рассказывается о группе американских солдат. Их необычная миссия — посеять страх среди нацистов. Фильм насыщен острыми диалогами, неожиданными сюжетными поворотами и характерным для Тарантино стилем с элементами черного юмора. Это история о смелости, сопротивлении и силе личных убеждений в тяжелые времена.",
            "https://m.media-amazon.com/images/M/MV5BOTJiNDEzOWYtMTVjOC00ZjlmLWE0NGMtZmE1OWVmZDQ2OWJhXkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_FMjpg_UX1024_.jpg", 1, 1),

        Movie(70, "Темный рыцарь: Возрождение легенды", 2012, 164, "12+",
            setOf(Genre.DRAMA, Genre.ACTION, Genre.CRIME, Genre.SUPERHERO, Genre.THRILLER), 8.4f, 8.2f, "Заключительная часть культовой трилогии о Бэтмене режиссера Кристофера Нолана. Здесь Брюс Уэйн сталкивается с новыми опасностями и врагами, которые ставят под угрозу город Готэм. Фильм сочетает в себе масштабные экшн-сцены, глубокую драму и философские вопросы о справедливости, жертве и возрождении. Это история о том, как легенды рождаются из самых трудных испытаний.",
            "https://m.media-amazon.com/images/M/MV5BMTk4ODQzNDY3Ml5BMl5BanBnXkFtZTcwODA0NTM4Nw@@._V1_FMjpg_UX1024_.jpg", 0, 0),

        Movie(71, "Тайна Коко", 2017, 105, "12+",
            setOf(Genre.ANIMATION, Genre.ADVENTURE, Genre.FAMILY, Genre.MYSTERY, Genre.DRAMA), 8.4f, 8.7f, "Трогательная анимационная лента от студии Pixar, рассказывающая о мальчике Мигеле, который мечтает стать музыкантом, несмотря на запрет в семье. Путешествуя в красочный и волшебный мир мёртвых, он открывает семейные тайны и понимает важность памяти и любви. Фильм затрагивает темы традиций, семейных уз и поиска своего места в жизни, наполнен музыкой и теплом.",
            "https://m.media-amazon.com/images/M/MV5BYjQ5NjM0Y2YtNjZkNC00ZDhkLWJjMWItN2QyNzFkMDE3ZjAxXkEyXkFqcGdeQXVyODIxMzk5NjA@._V1_FMjpg_UX1024_.jpg", 2, 1),

        Movie(72, "Амадей", 1984, 160, "18+",
            setOf(Genre.DRAMA, Genre.BIOGRAPHY), 8.4f, 8.2f, "Историческая драма, рассказывающая о жизни и творчестве великого композитора Вольфганга Амадея Моцарта через призму отношений с коллегой и соперником Антонио Сальери. Фильм глубоко раскрывает тему гения, зависти и творческого вдохновения, показывая, как сложными бывают судьбы творческих людей. Атмосфера XVIII века, великолепная музыка и эмоциональная игра актеров делают этот фильм классикой",
            "https://m.media-amazon.com/images/M/MV5BNWJlNzUzNGMtYTAwMS00ZjI2LWFmNWQtODcxNWUxODA5YmU1XkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_FMjpg_UX1024_.jpg", 8, 4),

        Movie(73, "История игрушек", 1995, 81, "6+",
            setOf(Genre.DRAMA, Genre.ANIMATION, Genre.ADVENTURE, Genre.FAMILY, Genre.COMEDY), 8.3f, 7.9f, "Первая полнометражная анимация от Pixar, которая подарила миру живые игрушки, оживающие, когда рядом нет людей. История дружбы и верности между ковбоем Вуди и космонавтом Баззом Лайтером наполнена юмором, трогательными моментами и приключениями. Фильм рассказывает о важности принятия перемен и настоящей дружбы, будучи любимым и для детей, и для взрослых.",
            "https://m.media-amazon.com/images/M/MV5BMDU2ZWJlMjktMTRhMy00ZTA5LWEzNDgtYmNmZTEwZTViZWJkXkEyXkFqcGdeQXVyNDQ2OTk4MzI@._V1_FMjpg_UX1024_.jpg", 1, 0),

        Movie(74, "Умница Уилл Хантинг", 1997, 126, "16+",
            setOf(Genre.DRAMA, Genre.ROMANCE), 8.3f, 8.1f, "Драма о молодом гении по имени Уилл Хантинг, работающем уборщиком в Массачусетском университете. Его уникальные способности распознаются преподавателями, которые пытаются помочь ему раскрыть свой потенциал и справиться с внутренними проблемами. Фильм исследует темы самоопределения, личных страхов и силы настоящей дружбы и любви, а также показывает путь к взрослой жизни.",
            "https://m.media-amazon.com/images/M/MV5BOTI0MzcxMTYtZDVkMy00NjY1LTgyMTYtZmUxN2M3NmQ2NWJhXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_FMjpg_UX1024_.jpg", 2, 1),

        Movie(75, "Мстители: Финал", 2019, 181, "16+",
            setOf(Genre.ADVENTURE, Genre.SUPERHERO, Genre.ACTION, Genre.SCI_FI), 8.4f, 7.9f, "Завершающая часть грандиозной серии фильмов Marvel, где любимые супергерои объединяются, чтобы остановить могущественного врага и спасти вселенную. Фильм сочетает масштабный экшен с глубокими эмоциональными моментами, раскрывает судьбы героев и их жертвенность. Это эпическая история о дружбе, надежде и ответственности, которой поклонники ждали долгие годы.",
            "https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_FMjpg_UX1024_.jpg", 0, 0),

        Movie(76, "Олдбой", 2003, 120, "18+",
            setOf(Genre.DRAMA, Genre.ACTION, Genre.MYSTERY, Genre.THRILLER), 8.3f, 8.1f, "Психологический триллер с элементами драмы и мистики о человеке, который внезапно оказывается заперт на много лет без объяснений. Его выход из заточения запускает цепь событий, приводящих к неожиданным открытиям. Фильм исследует темы мести, судьбы и человеческой природы, обладает напряжённой атмосферой и глубоким смыслом, заставляя задуматься о цене прошлого.",
            "https://m.media-amazon.com/images/M/MV5BMTI3NTQyMzU5M15BMl5BanBnXkFtZTcwMTM2MjgyMQ@@._V1_FMjpg_UX1024_.jpg", 0, 0),

        Movie(77, "Доктор Стрейнджлав, или Как я научился не волноваться и полюбил атомную бомбу", 1964, 95, "18+",
            setOf(Genre.COMEDY, Genre.WAR), 8.3f, 8.0f, "Черная комедия режиссера Стэнли Кубрика, сатирически высмеивающая страхи и паранойю времен холодной войны и ядерной угрозы. Фильм показывает абсурдность военной политики и опасности случайностей, которые могут привести к катастрофе.",
            "https://m.media-amazon.com/images/M/MV5BY2VlMzhmMzAtNGQyOC00ZTMzLWEzMzUtYjE5YzY0ZTk0ZmE5XkEyXkFqcGc@._V1_.jpg", 0, 0),

        Movie(78, "Подводная лодка", 1981, 149, "16+",
            setOf(Genre.DRAMA, Genre.WAR), 8.4f, 8.1f, "Напряженная военная драма, разворачивающаяся в замкнутом пространстве немецкой подлодки времен Второй мировой. Экипаж сталкивается не только с вражескими кораблями, но и с собственными страхами, моральными дилеммами и нарастающим безумием.",
            "https://m.media-amazon.com/images/M/MV5BOGZhZDIzNWMtNjkxMS00MDQ1LThkMTYtZWQzYWU3MWMxMGU5XkEyXkFqcGdeQXVyNjc1NTYyMjg@._V1_FMjpg_UX1024_.jpg", 0, 0),

        Movie(79, "Храброе сердце", 1995, 178, "16+",
            setOf(Genre.DRAMA, Genre.BIOGRAPHY, Genre.WAR), 8.3f, 8.3f, "Эпическая история шотландского борца за свободу Уильяма Уоллеса, поднявшего восстание против английского владычества. Его личная трагедия перерастает в борьбу за независимость целого народа. Фильм о мужестве, предательстве и цене, которую приходится платить за идеалы.",
            "https://m.media-amazon.com/images/M/MV5BMzkzMmU0YTYtOWM3My00YzBmLWI0YzctOGYyNTkwMWE5MTJkXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UX1024_.jpg", 5, 1),

        Movie(80, "Красота по-американски", 1999, 122, "16+",
            setOf(Genre.DRAMA), 8.3f, 8.0f, "Язвительная сатира на американскую мечту, где внешне благополучная семья скрывает целый клубок неврозов и нереализованных желаний.",
            "https://m.media-amazon.com/images/M/MV5BNTBmZWJkNjctNDhiNC00MGE2LWEwOTctZTk5OGVhMWMyNmVhXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UX1024_.jpg", 5, 3),

        Movie(81, "Принцесса Мононоке", 1997, 133, "12+",
            setOf(Genre.ANIMATION, Genre.ADVENTURE, Genre.FANTASY), 8.3f, 8.3f, "Эпическая анимационная притча о противостоянии природы и цивилизации. Раненый принц оказывается втянут в конфликт между лесными духами и людьми, добывающими железо. Фильм, где нет однозначных злодеев, а каждая сторона отстаивает свою правду.",
            "https://m.media-amazon.com/images/M/MV5BNTZkYmI0MmEtNGFlZC00OWZjLWFjMmItMjk1OWZkOWJiZGVjXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UX1024_.jpg", 0, 0),

        Movie(82, "Рай и ад", 1963, 143, "16+",
            setOf(Genre.DRAMA, Genre.CRIME, Genre.MYSTERY, Genre.THRILLER), 8.4f, 8.1f, "Детективная драма о похищении ребенка, где богатый бизнесмен оказывается перед мучительным выбором: заплатить выкуп за сына своего шофера или сохранить деньги. Фильм Куросавы исследует природу классового неравенства и человеческой жестокости.",
            "https://m.media-amazon.com/images/M/MV5BOTFmOTNjYjUtMDA2MC00ZTJiLThiYzktNDdjNzQwMjNkN2NmXkEyXkFqcGc@._V1_.jpg", 0, 0),

        Movie(83, "Твоё имя", 2016, 106, "12+",
            setOf(Genre.ANIMATION, Genre.DRAMA, Genre.ROMANCE, Genre.FANTASY), 8.4f, 8.4f, "Романтическая фантазия о парне и девушке, которые начинают необъяснимым образом меняться телами. Их странная связь оказывается связана с таинственным природным явлением. Визуально потрясающая история о судьбе, времени и силе человеческой памяти.",
            "https://m.media-amazon.com/images/M/MV5BODRmZDVmNzUtZDA4ZC00NjhkLWI2M2UtN2M0ZDIzNDcxYThjL2ltYWdlXkEyXkFqcGdeQXVyNTk0MzMzODA@._V1_FMjpg_UX1024_.jpg", 0, 0),

        Movie(84, "Три идиота", 2009, 170, "16+",
            setOf(Genre.DRAMA, Genre.COMEDY), 8.4f, 8.1f, "Жизнеутверждающая комедия о трех студентах инженерного колледжа, бросающих вызов консервативной системе образования. Их дружба и нестандартный подход к жизни помогают преодолеть давление общества. Фильм, смешно и трогательно показывающий, что успех — не в оценках, а в страсти к своему делу.",
            "https://m.media-amazon.com/images/M/MV5BNTkyOGVjMGEtNmQzZi00NzFlLTlhOWQtODYyMDc2ZGJmYzFhXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UX1024_.jpg", 0, 0),

        Movie(85, "Джокер", 2019, 122, "18+",
            setOf(Genre.DRAMA, Genre.CRIME, Genre.THRILLER), 8.3f, 8.0f, "Мрачный портрет Артура Флека, неудачливого комика, чья жизнь в грязном Готэме постепенно катится в пропасть. Социальное неравенство, психическое заболевание и жестокость города превращают его в того, кого мы знаем как главного врага Бэтмена.",
            "https://m.media-amazon.com/images/M/MV5BNGVjNWI4ZGUtNzE0MS00YTJmLWE0ZDctN2ZiYTk2YmI3NTYyXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_FMjpg_UX1024_.jpg", 2, 2),

        Movie(86, "Однажды в Америке", 1984, 229, "16+",
            setOf(Genre.DRAMA, Genre.CRIME), 8.3f, 8.3f, "Гангстерская сага, охватывающая несколько десятилетий жизни друзей-преступников. От уличных мальчишек до владельцев подпольных империй — их путь полон денег, крови, предательства и несбывшихся мечтаний. Фильм о цене, которую приходится платить за власть.",
            "https://m.media-amazon.com/images/M/MV5BMGFkNWI4MTMtNGQ0OC00MWVmLTk3MTktOGYxN2Y2YWVkZWE2XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UX1024_.jpg", 0, 0),

        Movie(87, "Капернаум", 2018, 126, "18+",
            setOf(Genre.DRAMA), 8.4f, 8.2f, "Пронзительная драма о 12-летнем мальчике, который подаёт в суд на родителей за то, что они его родили. Через его историю режиссёр показывает жизнь маргиналов в Бейруте — детский труд, нищету и борьбу за выживание. Фильм снят с почти документальной достоверностью, а главную роль играет настоящий сирийский беженец. Это крик о помощи поколения детей, лишённых детства, и одновременно — история невероятной стойкости человеческого духа.",
            "https://m.media-amazon.com/images/M/MV5BYzEyMzQ1OTktZTljZi00OWQzLWE2ZmUtZjQyNzBjYjE1NTc0XkEyXkFqcGc@._V1_.jpg", 0, 0),

        Movie(88, "Поющие под дождем", 1952, 103, "12+",
            setOf(Genre.COMEDY, Genre.MUSICAL, Genre.ROMANCE), 8.3f, 8.0f, "Классический мюзикл о Голливуде эпохи перехода от немого кино к звуковому. История кинозвезды, столкнувшейся с вызовами новой эры, и влюблённого в неё актёра. Фильм, где каждая песня и танец — праздник кинематографа.",
            "https://m.media-amazon.com/images/M/MV5BZDRjNGViMjQtOThlMi00MTA3LThkYzQtNzJkYjBkMGE0YzE1XkEyXkFqcGdeQXVyNDYyMDk5MTU@._V1_FMjpg_UX1024_.jpg", 0, 1),

        Movie(89, "Иди и смотри", 1985, 142, "16+",
            setOf(Genre.DRAMA, Genre.WAR, Genre.THRILLER), 8.3f, 8.3f, "Жесткая военная драма о белорусском мальчике, ставшем свидетелем ужасов нацистской оккупации. Фильм, снятый с документальной достоверностью, показывает войну без романтики — только боль, страх и необратимые потери.",
            "https://m.media-amazon.com/images/M/MV5BZDQ5ZTZkYTUtYTlhZC00NjdiLWEyYzYtZWI1MzFiMzAyYTBjXkEyXkFqcGc@._V1_.jpg", 0, 0),

        Movie(90, "Реквием по мечте", 2000, 102, "18+",
            setOf(Genre.DRAMA), 8.3f, 8.0f, "Мрачная драма о четырёх людях, чьи жизни разрушаются под воздействием разных форм зависимости. Их мечты о лучшей жизни постепенно превращаются в кошмар. Визуально мощное кино о том, как быстро иллюзии могут затянуть на дно.",
            "https://m.media-amazon.com/images/M/MV5BOTdiNzJlOWUtNWMwNS00NmFlLWI0YTEtZmI3YjIzZWUyY2Y3XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UX1024_.jpg", 0, 0),

        Movie(91, "Звездные войны: Эпизод 6 - Возвращение Джедая", 1983, 131, "12+",
            setOf(Genre.ADVENTURE, Genre.SCI_FI), 8.3f, 8.2f, "Завершение оригинальной трилогии: Люк Скайуокер сталкивается с Дартом Вейдером в решающей битве, пока Повстанцы атакуют новую Звезду Смерти. Фильм о выборе между светом и тьмой, где даже в самом тёмном сердце может остаться искра добра.",
            "https://m.media-amazon.com/images/M/MV5BOWZlMjFiYzgtMTUzNC00Y2IzLTk1NTMtZmNhMTczNTk0ODk1XkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_FMjpg_UX1024_.jpg", 1, 0),

        Movie(92, "История игрушек: Большой побег", 2010, 103, "0+",
            setOf(Genre.ANIMATION, Genre.ADVENTURE, Genre.COMEDY, Genre.FAMILY), 8.3f, 7.9f, "Анимационное приключение, где игрушки оказываются в детском саду, из которого нужно срочно сбежать. Новые друзья, опасные враги и неожиданные открытия ждут Базза, Вуди и компанию.",
            "https://m.media-amazon.com/images/M/MV5BMTgxOTY4Mjc0MF5BMl5BanBnXkFtZTcwNTA4MDQyMw@@._V1_FMjpg_UX1024_.jpg", 2, 1),

        Movie(93, "Возмутительный класс не прошел экзамен", 1975, 95, "12+",
            setOf(Genre.COMEDY), 8.7f, 6.1f, "В частной школе, где родители исправно платят за обучение, живёт сплочённая компания из ленивых и избалованных старшеклассников. Они давно обжились здесь, как одна большая «семья», а работница школы Анна Хафиз опекает их, словно родных детей. Но их беззаботной жизни угрожает приход нового директора. Несмотря на добрый нрав, он твёрдо намерен навести порядок в школе. Однако старшеклассники не собираются сдаваться — и вскоре директор становится главной мишенью их проделок и насмешек.",
            "https://m.media-amazon.com/images/M/MV5BZmY3MjVhMmQtOTcwYy00ZjcyLWFiZDgtN2JiODVjNjQzYWQyXkEyXkFqcGc@._V1_.jpg", 0, 0),

        Movie(94, "Охота", 2012, 115, "16+",
            setOf(Genre.DRAMA), 8.3f, 7.9f, "Психологическая драма о воспитателе детского сада, чья жизнь рушится из-за ложного обвинения. Фильм исследует тему коллективной истерии и того, как легко разрушить репутацию человека.",
            "https://m.media-amazon.com/images/M/MV5BMTg2NDg3ODg4NF5BMl5BanBnXkFtZTcwNzk3NTc3Nw@@._V1_FMjpg_UX1024_.jpg", 0, 0),

        Movie(95, "Жить", 1952, 143, "18+",
            setOf(Genre.DRAMA), 8.3f, 8.1f, "Драма Куросавы о чиновнике, узнавшем, что ему осталось жить несколько месяцев. Осознание смертности заставляет его по-новому взглянуть на свою жизнь и сделать то, что действительно важно.",
            "https://m.media-amazon.com/images/M/MV5BMTFlMWIxMTItMTNhOC00NWI5LTg3ZmEtYzY5ZGY0YTA5ZmFlXkEyXkFqcGc@._V1_.jpg", 0, 0),

        Movie(96, "Вечное сияние чистого разума", 2004, 108, "16+",
            setOf(Genre.DRAMA, Genre.ROMANCE, Genre.SCI_FI), 8.3f, 8.0f, "Фантастическая мелодрама о паре, решившей стереть друг друга из памяти после расставания. Но когда процесс уже начат, герой понимает, что не хочет терять эти воспоминания. Фильм о том, что даже болезненные переживания делают нас теми, кто мы есть.",
            "https://m.media-amazon.com/images/M/MV5BMTY4NzcwODg3Nl5BMl5BanBnXkFtZTcwNTEwOTMyMw@@._V1_FMjpg_UX1024_.jpg", 1, 0),

        Movie(97, "2001 год: Космическая одиссея", 1968, 149, "12+",
            setOf(Genre.ADVENTURE, Genre.SCI_FI), 8.3f, 7.9f, "Визуально ошеломляющий философский эпос о прогрессе человечества — от первых орудий до межпланетных путешествий. Когда экипаж корабля Discovery One сталкивается с загадочным черным монолитом и бунтом искусственного интеллекта HAL 9000, зритель отправляется в психоделическое путешествие за пределы времени и пространства.",
            "https://m.media-amazon.com/images/M/MV5BMmNlYzRiNDctZWNhMi00MzI4LThkZTctMTUzMmZkMmFmNThmXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UX1024_.jpg", 1, 0),

        Movie(98, "Пожары", 2010, 131, "16+",
            setOf(Genre.DRAMA, Genre.MYSTERY, Genre.WAR), 8.3f, 8.1f, "Мистическая драма о писателе, который после автомобильной аварии оказывается в странном городке, где жители одержимы коллективным написанием книги. По мере погружения в их мир граница между реальностью и вымыслом начинает стираться. Фильм-притча о творчестве как форме безумия и коллективной памяти.",
            "https://m.media-amazon.com/images/M/MV5BODE4OWNmM2YtMmYyYy00OTM5LTg0MTgtNjBiYTA2NjJhZTZjXkEyXkFqcGc@._V1_.jpg", 0, 0),

        Movie(99, "Бешеные псы", 1992, 99, "18+",
            setOf(Genre.CRIME, Genre.THRILLER), 8.3f, 8.1f, "Дебютный шедевр Тарантино о провалившемся ограблении ювелирного магазина. Группа преступников, не знающих настоящих имен друг друга, оказывается в ловушке на складе, где подозрения и напряжение нарастают с каждой минутой. Фильм, перевернувший жанр криминального кино, с фирменными диалогами и неожиданными поворотами.",
            "https://m.media-amazon.com/images/M/MV5BMmMzYjg4NDctYWY0Mi00OGViLWIzMTMtYWNlZGY5ZDJmYjk3XkEyXkFqcGc@._V1_.jpg", 0, 0),

        Movie(100, "Квартира", 1960, 125, "12+",
            setOf(Genre.DRAMA, Genre.COMEDY, Genre.ROMANCE), 8.3f, 8.0f, "Ироничная трагикомедия о скромном клерке, который предоставляет свою квартиру начальству для любовных встреч, надеясь на продвижение по службе. Его жизнь усложняется, когда он влюбляется в лифтершу, оказывающуюся любовницей его босса. Оскароносная сатира на корпоративную мораль и одиночество в большом городе.",
            "https://m.media-amazon.com/images/M/MV5BNzkwODFjNzItMmMwNi00MTU5LWE2MzktM2M4ZDczZGM1MmViXkEyXkFqcGdeQXVyNDY2MTk1ODk@._V1_FMjpg_UX1024_.jpg", 5, 3),

        Movie(101, "Лоуренс Аравийский", 1962, 227, "12+",
            setOf(Genre.DRAMA, Genre.ADVENTURE, Genre.BIOGRAPHY, Genre.WAR), 8.3f, 8.0f, "Грандиозная историческая эпопея о британском офицере Т.Э. Лоуренсе, который во время Первой мировой войны объединяет враждующие арабские племена против Османской империи. Фильм о колониализме, самопожертвовании и том, как человек может потерять себя в созданной им легенде.",
            "https://m.media-amazon.com/images/M/MV5BYWY5ZjhjNGYtZmI2Ny00ODM0LWFkNzgtZmI1YzA2N2MxMzA0XkEyXkFqcGdeQXVyNjUwNzk3NDc@._V1_FMjpg_UX1024_.jpg", 7, 4),

        Movie(102, "Лицо со шрамом", 1983, 170, "18+",
            setOf(Genre.DRAMA, Genre.CRIME), 8.3f, 8.2f, "Яркая криминальная сага о кубинском беженце Тони Монтане, который начинает с мытья посуды в Майами, а заканчивает во главе наркоимперии. Его стремительный взлет и падение под аккомпанемент музыки Джорджио Мородер стали эталоном гангстерского кино 1980-х. Фильм о темной стороне американской мечты.",
            "https://m.media-amazon.com/images/M/MV5BNjdjNGQ4NDEtNTEwYS00MTgxLTliYzQtYzE2ZDRiZjFhZmNlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UX1024_.jpg", 0, 0),
        )
    var movieById = movieList.associateBy { it.id }
}