package com.example.quotesfamous.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "quote") // Asociando a la tabla Si no existe la crea
data class QuoteEntity (
    @PrimaryKey
    @SerializedName("id") //Permite que este dato pueda viajar a traves de otras capas o por la red
    var id: Int = 0,
    @SerializedName("quote")
    var quote: String = "",
    @SerializedName("author")
    var author: String = "",
)

//serializar
//Deserializar