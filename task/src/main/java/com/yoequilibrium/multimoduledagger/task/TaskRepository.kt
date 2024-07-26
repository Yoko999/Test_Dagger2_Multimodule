package com.yoequilibrium.multimoduledagger.task

import com.yoequilibrium.multimoduledagger.data.Database
import com.yoequilibrium.multimoduledagger.network.TaskApi

/**
 * Created by yo on 26.07.2024
 * (с) Рождественская В., 2024
 *  ООО "Технологии и Сервис" (ТД Впрок)
 */
class TaskRepository(
    private val database: Database,
    private val taskApi: TaskApi
) {
}