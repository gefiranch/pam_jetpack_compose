package com.example.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.NumberFormat
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                PemesananTiketScreen()
            }
        }
    }
}

@Composable
fun PemesananTiketScreen() {
    val hargaTiket = 25000
    var jumlahTiket by remember { mutableStateOf(1) }
    val totalBayar = hargaTiket * jumlahTiket

    val formatRupiah =
        NumberFormat.getCurrencyInstance(Locale("id", "ID")).apply {
            maximumFractionDigits = 0
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Pemesanan Tiket", fontSize = 26.sp, fontWeight = FontWeight.Bold)
        Text("Pesan tiket dengan mudah!")
        Spacer(modifier = Modifier.height(24.dp))

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Harga Tiket", fontWeight = FontWeight.Bold)
                Text(
                    formatRupiah.format(hargaTiket),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
                Text("per tiket")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Jumlah Tiket", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            if (jumlahTiket > 1) jumlahTiket--
                        },
                        enabled = jumlahTiket > 1
                    ) {
                        Text("-", fontSize = 24.sp)
                    }

                    Spacer(modifier = Modifier.width(30.dp))
                    Text(
                        "$jumlahTiket",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(30.dp))

                    Button(onClick = { jumlahTiket++ }) {
                        Text("+", fontSize = 24.sp)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Total", fontWeight = FontWeight.Bold)
                Text(
                    formatRupiah.format(totalBayar),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { jumlahTiket = 1 }
        ) {
            Text("RESET")
        }
    }
}