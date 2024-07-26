package com.yoequilibrium.multimoduledagger.task

import com.yoequilibrium.multimoduledagger.network.NetworkModule

/**
 * Created by yo on 26.07.2024
 * (с) Рождественская В., 2024
 *  ООО "Технологии и Сервис" (ТД Впрок)
 */
class MyTaskComponent(
    private val taskComponentDependencies: TaskComponentDependencies
):TaskComponent {
    private val networkModule: NetworkModule = NetworkModule()
    private val taskModule: TaskModule = TaskModule()

    override fun injectTasksFragment(tasksFragment: TaskFragment) {
        tasksFragment.taskRepository = taskModule.provideTaskRepository(
            taskComponentDependencies.getDatabase(), networkModule.provideTaskApi())
    }
}