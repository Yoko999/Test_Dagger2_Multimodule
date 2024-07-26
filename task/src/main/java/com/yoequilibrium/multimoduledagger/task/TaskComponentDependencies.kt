package com.yoequilibrium.multimoduledagger.task

import com.yoequilibrium.multimoduledagger.data.Database

/**
 * Created by yo on 26.07.2024
 * (с) Рождественская В., 2024
 *  ООО "Технологии и Сервис" (ТД Впрок)
 */
interface TaskComponentDependencies {
    fun getDatabase(): Database
}