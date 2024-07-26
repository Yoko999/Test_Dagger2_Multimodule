package com.yoequilibrium.multimoduledagger

import android.content.Context
import com.yoequilibrium.multimoduledagger.core.CoreModule
import com.yoequilibrium.multimoduledagger.data.DataModule
import com.yoequilibrium.multimoduledagger.data.Database
import com.yoequilibrium.multimoduledagger.network.NetworkModule
import com.yoequilibrium.multimoduledagger.task.TaskComponent
import com.yoequilibrium.multimoduledagger.task.TaskFragment
import com.yoequilibrium.multimoduledagger.task.TaskModule

/**
 * Created by yo on 26.07.2024
 * (с) Рождественская В., 2024
 *  ООО "Технологии и Сервис" (ТД Впрок)
 *
 *  Ручная реализация компонента....
 */
class MyAppComponent(private val context: Context): AppComponent {
    private val dataModule = DataModule()
    private val coreModule = CoreModule()

    /*private val networkModule = NetworkModule()
    private val taskModule = TaskModule()*/

    fun getDatabase(): Database {
        return dataModule.provideDatabase(context, coreModule.provideFileManager())
    }

    /**Чтобы компонент смог создать Database, он должен в метод provideDatabase передать объект FileManager. Но в модуле app мы ничего не знаем про FileManager, потому что модуль app не знает про core.
    Это важный для понимания момент. Если app знает про data, а data знает про core, это не значит, что app знает про core.
    Это правило действует, если мы используем implementation, когда объявляем зависимости модулей. Но есть и другие варианты. Можно зависимость модуля data от модуля core оформить так:
    api project(path: ':core')

    Вместо implementation мы можем использовать api. В этом случае все модули, знающие про модуль data, автоматически будут знать и про модуль core. Но Я буду использовать только implementation зависимости. Чтобы компонент смог работать с FileManager, нам надо добавлять зависимость app от core:
    implementation project(path: ':core')
     */
    /*override fun injectTasksActivity(tasksActivity: TasksActivity) {
        tasksActivity.database = dataModule.provideDatabase(context, coreModule.provideFileManager())
    }*/

    override fun createTaskComponent(): TaskComponent {
        return MyTaskComponent(this)
    }

    /**Если фрагмент просто использует репозиторий, то компоненту его приходится собирать. Для этого ему нужны TaskApi, Database и FileManager.
     * Поэтому app зависит от data, network и core.*/
    /*override fun injectTasksFragment(tasksFragment: TaskFragment) {
        tasksFragment.taskRepository = taskModule.provideTaskRepository(
            dataModule.provideDatabase(context, coreModule.provideFileManager()),
            networkModule.provideTaskApi()
        )
        //dataModule.provideDatabase(context, coreModule.provideFileManager())
    }*/

    /**В даггере класс сабкомпонента генерируется внутри класса компонента-родителя. Мы делаем так же.
     * У сабкомпонента есть доступ к компоненту-родителю. Именно так сабкомпонент получает Database для создания репозитория.
     * Если бы даггер создал класс сабкомпонента в модуле task, то такой сабкомпонент просто не смог бы использовать свой родительский компонент из модуля app для получения объектов. */
    private class MyTaskComponent(
        private val myAppComponent: MyAppComponent,
        private val networkModule: NetworkModule = NetworkModule(),
        private val taskModule: TaskModule = TaskModule()) : TaskComponent {

        override fun injectTasksFragment(tasksFragment: TaskFragment) {
            tasksFragment.taskRepository = taskModule.provideTaskRepository(myAppComponent.getDatabase(), networkModule.provideTaskApi())
        }
    }
}