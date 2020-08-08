package com.example.qrscannercameraxzxing

import android.graphics.ImageFormat.YUV_420_888
import android.os.Build
import android.util.Log
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.zxing.BarcodeFormat
import com.google.zxing.DecodeHintType
import com.google.zxing.MultiFormatReader

private val TAG = QrCodeAnalyzer::class.java.simpleName

class QrCodeAnalyzer : ImageAnalysis.Analyzer {

    private val yuvFormats = mutableListOf(YUV_420_888)

    private val reader = MultiFormatReader().apply {
        val map = mapOf(
            DecodeHintType.POSSIBLE_FORMATS to arrayListOf(BarcodeFormat.QR_CODE)
        )
        setHints(map)
    }

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            yuvFormats.addAll(listOf(YUV_420_888, YUV_420_888))
        }
    }

    override fun analyze(image: ImageProxy) {
        if (image.format !in yuvFormats) {
            Log.e(TAG, "Expected YUV, now = ${image.format}")
            return
        }
    }

}
