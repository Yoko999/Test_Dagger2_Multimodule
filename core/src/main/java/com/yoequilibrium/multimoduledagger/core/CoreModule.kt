package com.yoequilibrium.multimoduledagger.core

import dagger.Module
import dagger.Provides

/**
 * Created by yo on 26.07.2024
 * (с) Рождественская В., 2024
 *  ООО "Технологии и Сервис" (ТД Впрок)
 */
@Module
class CoreModule {
    @Provides
    fun provideFileManager() = FileManager()
}