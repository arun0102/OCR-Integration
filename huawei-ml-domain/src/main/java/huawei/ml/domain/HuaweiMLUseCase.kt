package huawei.ml.domain

import io.reactivex.Single

interface HuaweiMLUseCase {
    fun getHuaweiMLScanning(imagePath: String): Single<Result<String>>
}
