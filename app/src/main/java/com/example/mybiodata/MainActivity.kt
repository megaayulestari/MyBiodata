package com.example.mybiodata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mybiodata.ui.theme.MyBiodataTheme
import com.example.mybiodata.model.Mybiodata
import com.example.mybiodata.data.Datasource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBiodataTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyBiodataApp()
                }
            }
        }
    }
}
@Composable
fun MyBiodataApp() {
    MyBiodataList(
        mybiodataList = Datasource().loadMybiodata(),
    )
}

@Composable
fun MyBiodataCard(mybiodata: Mybiodata, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(mybiodata.imageResourceId),
                contentDescription = stringResource(mybiodata.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = LocalContext.current.getString(mybiodata.stringResourceId),
                modifier = Modifier.padding(18.dp),
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = LocalContext.current.getString(mybiodata.stringResourceId2),
                modifier = Modifier.padding(18.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun MyBiodataList(mybiodataList: List<Mybiodata>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(mybiodataList) {mybiodata ->
            MyBiodataCard(
                mybiodata = mybiodata,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Preview
@Composable
private fun MyBiodataCardPreview() {
    MyBiodataCard(Mybiodata(R.string.nama1, R.string.alamat1, R.drawable.image1))
}
