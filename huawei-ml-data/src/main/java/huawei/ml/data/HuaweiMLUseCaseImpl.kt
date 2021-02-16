package huawei.ml.data

import android.graphics.BitmapFactory
import android.util.Log
import com.huawei.hms.mlsdk.MLAnalyzerFactory
import com.huawei.hms.mlsdk.common.MLFrame
import com.huawei.hms.mlsdk.text.MLLocalTextSetting
import com.huawei.hms.mlsdk.text.MLText
import huawei.ml.domain.HuaweiMLUseCase
import io.reactivex.Single
import javax.inject.Inject

class HuaweiMLUseCaseImpl @Inject constructor() : HuaweiMLUseCase {
    override fun getHuaweiMLScanning(imagePath: String): Single<Result<String>> {
        return Single.create { emitter ->

            val setting = MLLocalTextSetting.Factory()
                .setOCRMode(MLLocalTextSetting.OCR_DETECT_MODE)
                .setLanguage("en")
                .create()

            val analyzer = MLAnalyzerFactory.getInstance()
                .getLocalTextAnalyzer(setting)

            try {
                val options = BitmapFactory.Options()
                options.inJustDecodeBounds = false
                options.inSampleSize = 1
                val bitmap = BitmapFactory.decodeFile(imagePath, options)

                val frame = MLFrame.fromBitmap(bitmap)
                val task = analyzer.asyncAnalyseFrame(frame)
                task.addOnSuccessListener {
                    analyzer.release()
                    Log.e(
                        "HuaweiMLUseCaseImpl",
                        "HuaweiMLUseCaseImpl data: ${getTextFromResponse(it)}"
                    )
                }.addOnFailureListener {
                    Log.e(
                        "HuaweiMLUseCaseImpl",
                        "HuaweiMLUseCaseImpl exception occurred : ${it.localizedMessage}"
                    )
                }
            } catch (e: Exception) {
                Log.e("HuaweiMLUseCaseImpl", e.message)
            }
        }
    }

    private fun getTextFromResponse(mlText: MLText): String {
        var result = ""
        val blocks = mlText.blocks
        for (block in blocks) {
            for (line in block.contents) {
                result += line.stringValue + "\n"

            }
        }
        return result
    }
}
