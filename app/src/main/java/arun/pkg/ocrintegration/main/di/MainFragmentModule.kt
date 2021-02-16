package arun.pkg.ocrintegration.main.di

import androidx.lifecycle.ViewModel
import arun.pkg.ocrintegration.main.MainFragment
import arun.pkg.ocrintegration.main.MainViewModel
import core.ui.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Dagger module to provide MainViewModel functionality.
 */
@Module
interface MainViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}

@Module
interface MainFragmentModule {
    @ContributesAndroidInjector(modules = [MainViewModelModule::class])
    fun mainFragment(): MainFragment
}