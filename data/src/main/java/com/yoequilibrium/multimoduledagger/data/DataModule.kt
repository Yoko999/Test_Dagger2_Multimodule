package com.yoequilibrium.multimoduledagger.data

import android.content.Context
import com.yoequilibrium.multimoduledagger.core.FileManager
import dagger.Module
import dagger.Provides

/**
 * Created by yo on 25.07.2024
 *
 *  Даггер-модуль имеет смысл создавать как можно ближе к объектам, которые он будет провайдить.
 *  В нашем случае мы создаем его там, где лежит Database - в модуле data.
 */
@Module
class DataModule {
    @Provides
    fun provideDatabase(context: Context, fileManager: FileManager) = Database(context,fileManager)
}