package com.yoequilibrium.multimoduledagger.task

/**
 * Created by yo on 26.07.2024
 * (с) Рождественская В., 2024
 *  ООО "Технологии и Сервис" (ТД Впрок)
 *
 *  от него нужно, чтобы он умел предоставлять TaskComponent (т.е. реализацию первого интерфейса)
 */
interface TaskComponentProvider {
    fun getTaskComponent(): TaskComponent
}