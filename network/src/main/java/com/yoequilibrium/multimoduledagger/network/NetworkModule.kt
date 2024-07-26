package com.yoequilibrium.multimoduledagger.network

import dagger.Module
import dagger.Provides

/**
 * Created by yo on 26.07.2024
 * (с) Рождественская В., 2024
 *  ООО "Технологии и Сервис" (ТД Впрок)
 */
@Module
class NetworkModule {
    @Provides
    fun provideTaskApi():TaskApi{
        return object :TaskApi{}
    }
}