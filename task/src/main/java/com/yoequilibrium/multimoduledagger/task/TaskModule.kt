package com.yoequilibrium.multimoduledagger.task

import com.yoequilibrium.multimoduledagger.data.Database
import com.yoequilibrium.multimoduledagger.network.TaskApi
import dagger.Module
import dagger.Provides

/**
 * Created by yo on 26.07.2024
 * (с) Рождественская В., 2024
 *  ООО "Технологии и Сервис" (ТД Впрок)
 */
@Module
class TaskModule {
    @Provides
    fun provideTaskRepository(database: Database, taskApi: TaskApi): TaskRepository {
        return TaskRepository(database, taskApi)
    }
}