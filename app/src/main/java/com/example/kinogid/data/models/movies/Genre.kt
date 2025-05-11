package com.example.kinogid.data.models.movies

enum class Genre {
    ACTION{ override val displayingGenre = "Боевик" },
    ADVENTURE { override val displayingGenre = "Приключения" },
    ANIMATION { override val displayingGenre = "Мультфильм" },
    BIOGRAPHY { override val displayingGenre = "Биография" },
    COMEDY { override val displayingGenre = "Комедия" },
    CRIME { override val displayingGenre = "Криминал" },
    DOCUMENTARY { override val displayingGenre = "Документальный" },
    DRAMA { override val displayingGenre = "Драма" },
    FAMILY { override val displayingGenre = "Семейный" },
    FANTASY { override val displayingGenre = "Фэнтези" },
    HORROR { override val displayingGenre = "Ужасы" },
    MUSICAL { override val displayingGenre = "Мюзикл" },
    MYSTERY { override val displayingGenre = "Детектив" },
    ROMANCE { override val displayingGenre = "Мелодрама" },
    SCI_FI { override val displayingGenre = "Фантастика" },
    SPORT { override val displayingGenre = "Спорт" },
    SUPERHERO { override val displayingGenre = "Супергероика" },
    THRILLER { override val displayingGenre = "Триллер" },
    WAR { override val displayingGenre = "Военный" },
    WESTERN { override val displayingGenre = "Вестерн" };

    abstract val displayingGenre: String
}