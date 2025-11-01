package com.example.inputpengguna

import androidx.annotation.Dimension
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormDataDiri(modifier: Modifier) {
    var textName by remember { mutableStateOf(value="") }
    var textAlamat by remember { mutableStateOf(value="") }
    var textJK by remember { mutableStateOf(value = "") }

    var name by remember { mutableStateOf(value = "") }
    var alamat by remember { mutableStateOf(value = "") }
    var jenis by remember { mutableStateOf(value = "") }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")
    val statusPerkawinan: List<String> = listOf("Janda", "Lajang", "Duda")

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFCD73E8)
                    ),
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = "Formulir Pendaftaran",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                }
            }
        }
            Spacer(modifier = Modifier.height(16.dp))

    }



            ElevatedCard (
                elevation= CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier
                    .height(950.dp)
                    .width(380.dp)
            ){
                Column  (modifier = Modifier.padding(horizontal = 5.dp, vertical = 15.dp)) {
                    OutlinedTextField(
                        value = textName,
                        singleLine = true,
                        shape = MaterialTheme.shapes.large,
                        modifier = Modifier.width(width = 250.dp),
                        label = { Text("Nama Lengkap") },
                        onValueChange = {
                            textName = it
                        }
                    )
                    Row {
                        gender.forEach { item ->
                            Row(
                                modifier = Modifier.selectable(
                                    selected = textJK == item,
                                    onClick = { textJK = item }
                                ), verticalAlignment = Alignment.CenterVertically) {
                                RadioButton(
                                    selected = textJK == item,
                                    onClick = {
                                        textJK = item
                                    })
                                Text(text = item)
                            }
                        }
                    }
                    OutlinedTextField(
                        value = textAlamat,
                        singleLine = true,
                        modifier = Modifier.width(width = 250.dp),
                        label = { Text(text = "Alamat Lengkap") },
                        onValueChange = {
                            textAlamat = it
                        }
                    )
                    Button(
                        modifier = Modifier.fillMaxWidth(fraction = 1f),
                        enabled = textAlamat.isNotEmpty(),
                        onClick = {
                            name = textName
                            jenis = textJK
                            alamat = textAlamat
                        }) {
                        Text(text = stringResource(R.string.submit))
                    }
                }
            }
        }


