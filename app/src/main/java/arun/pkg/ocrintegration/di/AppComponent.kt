package arun.pkg.ocrintegration.di

import android.content.Context
import arun.pkg.ocrintegration.OCRApplication
import arun.pkg.ocrintegration.main.di.MainFragmentModule
import opencv.data.di.OpenCVModule
import core.di.CoreModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import firebase_ml.data.di.FirebaseMLModule
import javax.inject.Singleton

/**
 * Dagger App component declaration
 */
@Component(
    modules = [AndroidSupportInjectionModule::class,
        MainFragmentModule::class,
        CoreModule::class,
        OpenCVModule::class
    ]
)
@Singleton
interface AppComponent : AndroidInjector<OCRApplication> {

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun setContext(context: Context): Builder
    }
}