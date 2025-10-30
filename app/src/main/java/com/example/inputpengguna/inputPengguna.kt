package com.example.inputpengguna

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import java.lang.reflect.Modifier

@Composable
fun FormDataDiri(modifier: Modifier) {
    var textName by remember { mutableStateOf(value="") }
    var textAlamat by remember { mutableStateOf(value="") }
    var textJK by remember { mutableStateOf(value = "") }

    var name by remember { mutableStateOf(value = "") }
    var alamat by remember { mutableStateOf(value = "") }
    var jenis by remember { mutableStateOf(value = "") }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")

    Column(modifier= modifier.padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally)
        {
            OutlinedTextField(
                value = textName,
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.width(width = 250.dp),
                label = { Text(text =  "Nama Lengkap") },
                onValueChange =  {
                    textName = it
                }
            )
            Row {
                gender.forEach { item ->
                    Row(modifier = Modifier.selectable(
                        selected = textJK == item,
                        onClick = {textJK = item}
                    ), verticalArrangement = Alignment.CenterVertically) {
                        RadioButton(
                            selected = textJK == item,
                            onClick = {
                                textJK = item
                            })
                        Text(text = item)
                    }
                }
            }
        }
}