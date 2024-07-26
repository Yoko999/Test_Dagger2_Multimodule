package com.yoequilibrium.multimoduledagger.task

import com.yoequilibrium.multimoduledagger.network.NetworkModule
import dagger.Subcomponent

/**
 * Created by yo on 26.07.2024
 * (с) Рождественская В., 2024
 *  ООО "Технологии и Сервис" (ТД Впрок)
 *
 *  от него нам нужно только, чтобы он умел инджектить в наш фрагмент
 *
 *
 *  В этот сабкомпонент мы вынесем создание объектов, которые нужны только фрагменту TasksFragment. В нашем случае - это объекты TaskRepository и TaskApi.
 *  А вот Database давайте считать общим объектом, который может понадобиться в других модулях. Поэтому его создание мы оставим в AppComponent.
 */
@Subcomponent(modules = [NetworkModule::class, TaskModule::class])
interface TaskComponent {
    fun injectTasksFragment(tasksFragment: TaskFragment)
}