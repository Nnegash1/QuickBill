package com.example.data.datasource.entites

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.ByteArrayOutputStream
import java.util.*


class InvoiceTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun clientToGson(invoice: Client): String {
        return gson.toJson(invoice)
    }

    @TypeConverter
    fun gsonToClient(invoice: String): Client {
        val objectType = object : TypeToken<Client>() {}.type
        return gson.fromJson(invoice, objectType)
    }


    @TypeConverter
    fun itemToGson(item: List<Item>): String {
        return gson.toJson(item)
    }

    @TypeConverter
    fun gsonToItem(item: String): List<Item> {
        val objectType = object : TypeToken<List<Item>>() {}.type
        return gson.fromJson(item, objectType)
    }

    @TypeConverter
    fun toDate(dateLong: Long?): Date? {
        return dateLong?.let { Date(it) }
    }

    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }

    /**
     * Converts [ByteArray] to [Bitmap].
     *
     * @param bytes to be converted
     * @return decoded [Bitmap]
     */
    @TypeConverter
    fun toBitmap(bytes: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }

    /**
     * Converts [Bitmap] to [ByteArray].
     *
     * @param bmp to be converted
     * @return [ByteArray]
     */
    @TypeConverter
    fun fromBitmap(bmp: Bitmap): ByteArray {
        val outputStream = ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.PNG, PNG_QUALITY, outputStream)
        return outputStream.toByteArray()
    }

    companion object {
        private const val PNG_QUALITY = 100
    }
}