package com.yoequilibrium.multimoduledagger.task

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yoequilibrium.multimoduledagger.data.Database
import javax.inject.Inject

/**
 * Created by yo on 26.07.2024
 * (с) Рождественская В., 2024
 *  ООО "Технологии и Сервис" (ТД Впрок)
 */
class TaskFragment:Fragment() {
    @Inject
    lateinit var taskRepository: TaskRepository
    //@Inject lateinit var database: Database

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tasks, container, false)
    }

    /**Нам при получении компонента надо вместо App и AppComponent (которые видны только в модуле app), использовать другие классы/интерфейсы, которые видны и в app и в task. Тогда фрагмент сможет с ними работать. Для этого мы в модуле task создадим 2 интерфейса.
     *
     * теперь Мы все также получаем Application объект через context.applicationContext. Но теперь мы этот класс приводим не к App (из app), а к TaskComponentProvider (из task). А от него уже получаем компонент, но не как AppComponent (из app), а как TaskComponent (из task). И далее выполняем инджект.*/
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as TaskComponentProvider)
            .getTaskComponent()
            .injectTasksFragment(this)
    }
}