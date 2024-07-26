package com.yoequilibrium.multimoduledagger.task

/**
 * Created by yo on 26.07.2024

Когда мы будем создавать компонент TaskComponent, нам надо будет откуда-то взять готовую реализацию TaskComponentDependencies.

Для этого нам надо от App класса получить AppComponent в виде TaskComponentDependencies. И т.к. нам это сделать в модуле task (который не знает про App класс), то мы создаем интерфейс для App:
 */
interface TaskComponentDependenciesProvider {
    fun getTaskComponentDependencies(): TaskComponentDependencies
}