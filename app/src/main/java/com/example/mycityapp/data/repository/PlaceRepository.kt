package com.example.mycityapp.data.repository

import com.example.mycityapp.R
import com.example.mycityapp.data.models.Category
import com.example.mycityapp.data.models.Place

class PlaceRepository {
    private val categories = listOf(
        Category(
            id = 1,
            name = "Рестораны",
            places = listOf(
                Place(
                    1,
                    "Баклажан",
                    "Семейный ресторан, где готовят традиционные блюда восточной кухни: варят шурпу, подают оджахури и хинкали.",
                    "Выборгское шоссе, 78",
                    R.drawable.baklazhan
                ),
                Place(
                    2,
                    "8956",
                    "Кафе с хот-догами - проект блогера-миллионника Олега Григорьева.",
                    "ул. Марата, 23",
                    R.drawable.oblomoff
                ),
                Place(
                    3,
                    "Ферма Бенуа",
                    "Большой семейный ресторан на севере Санкт-Петербурга с разнообразным меню",
                    "Тихорецкий пр., 17Г",
                    R.drawable.fermabenua
                )
            )
        ),
        Category(
            id = 2,
            name = "ВУЗы",
            places = listOf(
                Place(
                    4,
                    "СПбГЭТУ \"ЛЭТИ\"",
                    "Российское техническое высшее учебное заведение, основанное в 1886 году и специализирующееся в области электротехники.",
                    "ул. Профессора Попова, 5",
                    R.drawable.leti
                ),
                Place(
                    5,
                    "СПбПУ",
                    "Высшее учебное заведение в Санкт-Петербурге, основанное в 1899 году. Имеет статус национального исследовательского университета.",
                    "Политехническая ул., 29",
                    R.drawable.spbpu
                ),
                Place(
                    6,
                    "ИТМО",
                    "Комплексный научно-образовательный центр мирового уровня.",
                    "Кронверкский пр., 49",
                    R.drawable.itmo
                )
            )
        ),
        Category(
            id = 3,
            name = "Спортзалы",
            places = listOf(
                Place(
                    7,
                    "NEVA 33",
                    "Функциональный тренинг, тяжёлая атлетика, гимнастика и самая неповторимая атмосфера в центре Санкт-Петербурга.",
                    "Курская ул., 28/32",
                    R.drawable.neva33
                ),
                Place(
                    8,
                    "Sportlife",
                    "Сеть фитнес-клубов Sport Life предлагает клиентам доступный и удобный фитнес для всей семьи.",
                    "ул. Белы Куна, 3",
                    R.drawable.sportlife
                ),
                Place(
                    9,
                    "Gravity Sport",
                    "Спортивно-оздоровительный центр с большим выбором групповых и индивидуальных занятий.",
                    "Сантьяго-де-Куба, 6",
                    R.drawable.gravity
                )
            )
        ),

    )

    fun getCategories(): List<Category> = categories

    fun getCategoryById(categoryId: Int): Category = categories.find{it.id == categoryId} ?: categories[0]

    fun getPlacesByCategoryId(categoryId: Int): List<Place> =
        categories.find{it.id == categoryId}?.places?: emptyList()
}