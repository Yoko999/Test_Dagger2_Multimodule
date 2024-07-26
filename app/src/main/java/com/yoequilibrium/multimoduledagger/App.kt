package com.yoequilibrium.multimoduledagger

import android.app.Application
import com.yoequilibrium.multimoduledagger.task.TaskComponent
import com.yoequilibrium.multimoduledagger.task.TaskComponentProvider

/**
 * Created by yo on 25.07.2024
 * (с) Рождественская В., 2024
 *  ООО "Технологии и Сервис" (ТД Впрок)
 */
public class App:Application(), TaskComponentProvider {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
        //appComponent = MyAppComponent(this)
    }

    /**<s>Он теперь предоставляет appComponent в виде TaskComponent</s>
     *  Класс App продолжит наследовать TaskComponentProvider, чтобы фрагмент из модуля task мог получить TaskComponent.
     *  Но если раньше под видом интерфейса TaskComponent мы получали компонент AppComponent, то теперь мы будем получать сабкомпонент TaskComponent:*/
    override fun getTaskComponent(): TaskComponent =
        appComponent.createTaskComponent()
}