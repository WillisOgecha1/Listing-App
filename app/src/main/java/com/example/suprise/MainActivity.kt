package com.example.suprise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.suprise.ui.theme.SUPRISETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SUPRISETheme {
                // A surface container using the 'background' color from the theme
               PlayButton()
            }
        }
    }
}

@Composable
fun PlayButton() {

    var name by remember {
        mutableStateOf("")
    }
    var names by remember {
        mutableStateOf(listOf<String>())
    }
    Box {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),

            ) {
            Row(
                modifier = Modifier,
            ) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { text -> name = text },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(2.dp))
                Button(onClick = {
                    if (name.isNotBlank()) {
                        names = names + name
                        name = ""
                    }
                }) {
                    Text(text = "Add")

                }

            }
            LazyColumn() {
                items(names) { currentName ->

                    Text(
                        text = currentName,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp)
                    )
                }
            }

        }
        FloatingActionButton(onClick = { names = emptyList() },

            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.BottomEnd)
               
              ) {
            Icon(Icons.Default.Delete, contentDescription = "Delete" )

            
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SUPRISETheme {
        PlayButton()
    }
}