package com.yoequilibrium.multimoduledagger

import android.content.Context
import com.yoequilibrium.multimoduledagger.core.CoreModule
import com.yoequilibrium.multimoduledagger.data.DataModule
import com.yoequilibrium.multimoduledagger.task.TaskComponent
import dagger.BindsInstance
import dagger.Component

/**
 * Created by yo on 25.07.2024
 *
 *  Переходим к компоненту. В каком модуле он должен находиться?
 *
 * Давайте исходить из задач компонента. Он создает объекты и инджектит их в Activity. Для этого компонент должен находиться в модуле, из которого видны:
 * - Activity, в которое инджектим
 * - создаваемые объекты, которые инджектим
 *
 * модуль app для компонента вполне годится. Этот модуль знает и про объекты из модуля data (т.к. мы прописали dependencies) и про TasksActivity, куда надо инджектить. В модуле app компонент будет иметь доступ ко всем необходимым объектам.
 *
 * Кроме того, есть рекомендация от гугла: компонент надо создавать в том модуле, где находится объект, куда компонент будет инджектить. Мы инджектим в TasksAcivity. Оно находится в модуле app. Значит и компонент должен быть в этом модуле.
 *
 *
 *
 * Вместо использования AppComponent мы создадим для модуля task отдельный компонент. У нас два варианта: сделать этот компонент саб-компонентом для AppComponent или отдельным компонентом (не саб).
 */
@Component(modules = [DataModule::class, CoreModule::class/*, NetworkModule::class, TaskModule::class*/])
interface AppComponent/*:TaskComponent*/ {
    //fun injectTasksActivity(tasksActivity: TasksActivity)
    //override fun injectTasksFragment(tasksFragment: TaskFragment)

    /**Метод injectTasksFragment в компоненте больше не нужен, т.к. компонент не будет инджектить во фрагмент.
     * Компонент будет создавать сабкомпонент. Поэтому добавляем соответствующий метод createTaskComponent.
     *
     *Несмотря на то, что интерфейс сабкомпонента TaskComponent находится в модуле task, его реализация находится в модуле app, внутри класса компонента.
     * А значит, создание всех объектов до сих пор происходит в app модуле.
     * Т.е. создание сабкомпонента в отдельном модуле (task) не переносит код создания объектов в этот модуль.
     * Объекты сабкомпонента создаются в том же модуле (app), где находится компонент-родитель.
     * */
    fun createTaskComponent(): TaskComponent

    @Component.Factory
    interface AppComponentFactory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}