package com.example.mybiodata.data
import com.example.mybiodata.R
import com.example.mybiodata.model.Mybiodata

class Datasource(){
    fun loadMybiodata(): List<Mybiodata> {
        return listOf<Mybiodata>(
            Mybiodata(R.string.nama1, R.string.alamat1, R.drawable.image1),
            Mybiodata(R.string.nama2, R.string.alamat2, R.drawable.image2),
            Mybiodata(R.string.nama3, R.string.alamat3, R.drawable.image3),
            Mybiodata(R.string.nama4, R.string.alamat4, R.drawable.image4)
        )
    }
}
