package firebase_ml.data

import android.content.Context
import android.net.Uri
import android.util.Log
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer
import firebase_ml.domain.FirebaseMLUseCase
import io.reactivex.Single
import non_core.lib.Result
import java.io.File
import java.io.IOException
import javax.inject.Inject

class FirebaseUseCaseImpl @Inject constructor(
    private val context: Context
) : FirebaseMLUseCase {
    override fun getFirebaseMLScanning(imageFile: File): Single<Result<String>> {
        val detector = FirebaseVision.getInstance()
            .onDeviceTextRecognizer

        // Code for Barcode scanning
        val options = FirebaseVisionBarcodeDetectorOptions.Builder()
            .setBarcodeFormats(
                FirebaseVisionBarcode.FORMAT_CODE_128
            )
            .build()
        val firebaseVisionImage = imageFromPath(context = context, file = imageFile)
        return Single.create<Result<String>> { emitter ->
            firebaseVisionImage?.let {
                detector.processImage(firebaseVisionImage)
                    .addOnSuccessListener { firebaseVisionText ->
                        // Task completed successfully
                        Log.d("FirebaseUseCaseImpl", "On success : ${firebaseVisionText.text}")
                        // Code for Barcode scanning
                        val detector = FirebaseVision.getInstance()
                            .getVisionBarcodeDetector(options)
                        detector.detectInImage(firebaseVisionImage).addOnSuccessListener {
                            it.forEach { barcode ->
                                Log.d(
                                    "FirebaseUseCaseImpl",
                                    "Barcode On success : ${barcode.rawValue}"
                                )
                            }
                        }
                        // Log.d("FirebaseUseCaseImpl", "Blocks : ${firebaseVisionText.textBlocks}")
                        emitter.onSuccess(Result.withValue(firebaseVisionText.text))
                    }
                    .addOnFailureListener { e ->
                        // Task failed with an exception
                        Log.d("FirebaseUseCaseImpl", "On fail : ${e.localizedMessage}")
                        emitter.onSuccess(
                            Result.withError(
                                FirebaseMLError(
                                    "Firebase ML error ${e.localizedMessage}",
                                    null
                                )
                            )
                        )
                    }
            } ?: emitter.onSuccess(
                Result.withError(
                    FirebaseMLError(
                        "Unable to create vision image",
                        null
                    )
                )
            )
        }.onErrorReturn {
            Result.withError(FirebaseMLError("Firebase ML unknown error", it))
        }
    }

    private fun imageFromPath(context: Context, file: File): FirebaseVisionImage? {
        var image: FirebaseVisionImage? = null
        try {
            image = FirebaseVisionImage.fromFilePath(context, Uri.fromFile(file))
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return image
    }
}
