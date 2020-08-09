package com.example.qrscannercameraxzxing

import android.os.Bundle
import android.os.PersistableBundle
import android.util.AndroidRuntimeException
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder
import kotlinx.android.synthetic.main.activity_create_qr.*

private val TAG = CreateQrActivity::class.java.simpleName

class CreateQrActivity : AppCompatActivity() {

    private val data = "https://www.google.com"
    private val size = 500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_qr)

        Toast.makeText(this, "CreateQrActivity !!!!!!!!!!!!!!!!!!!!!!!!", Toast.LENGTH_SHORT)

        try {
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.encodeBitmap(data, BarcodeFormat.QR_CODE, size, size)
            Log.d(TAG, barcodeEncoder.toString())
            Log.d(TAG, bitmap.toString())

            val imageQr = findViewById<ImageView>(R.id.imageView)
            imageQr.setImageBitmap(bitmap)
        } catch (e: WriterException) {
            throw AndroidRuntimeException("Barcode Error", e)
        }
    }

}