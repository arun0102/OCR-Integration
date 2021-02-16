package arun.pkg.ocrintegration.main

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import core.event.UiEvents
import firebase_ml.data.FirebaseMLError
import firebase_ml.domain.FirebaseMLUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import non_core.lib.Result
import noncore.error.Error
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val firebaseMLUseCase: FirebaseMLUseCase
) : ViewModel() {
    private val disposable: CompositeDisposable = CompositeDisposable()
    var imagePath: ObservableField<String> = ObservableField("")
    var firebaseResult: ObservableField<String>? = ObservableField("")
    var tesseractResult: ObservableField<String>? = ObservableField("")

    private val uiEvents = UiEvents<Event>()
    val events = uiEvents.stream()

    private var firebaseStartTime = 0L
    fun runFirebaseML(imageFile: File) {
        imagePath.set(imageFile.absolutePath)

        firebaseStartTime = System.currentTimeMillis()
        disposable += firebaseMLUseCase.getFirebaseMLScanning(imageFile)
            // .whileSubscribed { showProgress(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy { handleFirebaseResults(it) }
    }

    private fun handleFirebaseResults(result: Result<String>) {
        Log.d(
            "MainViewModel",
            "ML time : ${System.currentTimeMillis() - firebaseStartTime}"
        )
        when (result) {
            is Result.OnSuccess -> {
                firebaseResult?.set(
                    "Time Taken : ${System.currentTimeMillis() - firebaseStartTime} ms\n\n" +
                            "Results:\n ${result.data}"
                )
            }
            is Result.OnError -> handleError(result.error)
        }
    }

    private fun handleError(error: Error) {
        when (error) {
            is FirebaseMLError -> Log.d("MainViewModel", "Error Firebase ML : ${error.message}")
            else -> {
                Log.d("MainViewModel", "Unknown Error")
            }
        }
    }

    fun copyMediaFile(sourceFile: File, destFile: File) {
        disposable += Single.fromCallable { copyFile(sourceFile, destFile) }
            .subscribeOn(Schedulers.io())
            .doOnSuccess { runFirebaseML(destFile) }
            .subscribe()
    }

    /**
     * copies content from source file to destination file
     *
     * @param sourceFile
     * @param destFile
     * @throws IOException
     */
    @Throws(IOException::class)
    private fun copyFile(sourceFile: File, destFile: File): Boolean {
        if (!sourceFile.exists()) {
            return true
        }
        var source = FileInputStream(sourceFile).channel
        var destination = FileOutputStream(destFile).channel
        if (destination != null && source != null) {
            destination.transferFrom(source, 0, source.size())
        }
        source?.close()
        destination?.close()
        return true
    }

    fun onGalleryButtonClicked() {
        uiEvents.post(Event.OnClickGalleryButton)
    }

    fun onCameraButtonClicked() {
        uiEvents.post(Event.OnClickCameraButton)
    }

    /**
     * Events for this view model
     */
    sealed class Event {
        /**
         * Event emitted by [events] when the edit Profile is clicked
         */
        object OnClickGalleryButton : Event()
        object OnClickCameraButton : Event()
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
