package huawei.ml.data.di

import dagger.Binds
import dagger.Module
import huawei.ml.data.HuaweiMLUseCaseImpl
import huawei.ml.domain.HuaweiMLUseCase

@Module
interface HuaweiMLModule {
    @Binds
    fun bindHuaweiMLUseCase(huaweiMLUseCaseImpl: HuaweiMLUseCaseImpl): HuaweiMLUseCase
}