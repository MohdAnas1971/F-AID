package com.example.f_aid.scanner

import android.content.Context
import android.graphics.Bitmap
import androidx.compose.runtime.MutableState
import com.google.android.gms.vision.Frame
import com.google.android.gms.vision.text.TextRecognizer


fun processImageForTextRecognition(
    image: Bitmap, context: Context, recognizedText: MutableState<String?>
) {


    val recognizer = TextRecognizer.Builder(context).build()
    val frame = Frame.Builder().setBitmap(image).build()

    val textBlocks = recognizer.detect(frame)

    if (textBlocks.size() != 0) {
        val stringBuilder = StringBuilder()
        for (i in 0 until textBlocks.size()) {
            val textBlock = textBlocks.valueAt(i)
            stringBuilder.append(textBlock.value)
            stringBuilder.append("\n")
        }
        recognizedText.value = stringBuilder.toString()
    } else {
        recognizedText.value = "No text detected"
    }

    recognizer.release()
}

