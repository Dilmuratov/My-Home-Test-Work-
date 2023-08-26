package com.example.myhome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myhome.ui.theme.MyHomeTheme
import com.example.myhome.ui.theme.TabColorTwo

@Composable
fun TabScreenOne() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        RecyclerView(listOfFirstScreen())
    }
}

@Composable
fun TabScreenTwo() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        RecyclerView(names = listOfSecondScreen())
    }
}

@Composable
fun RecyclerView(names: List<String>) {
    LazyColumn(
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        items(items = names) { name ->
            ListItem(name = name)
        }
    }
}

@Composable
fun ListItem(name: String) {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxSize()
        ) {
            Row {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Course")
                    Text(
                        text = name, style = MaterialTheme.typography.h4.copy(
                            fontWeight = FontWeight.ExtraBold
                        )
                    )
                }

                OutlinedButton(onClick = { /*TODO*/ }) {
                    Text(text = "Show more")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyHomeTheme {
        ListItem(name = "1")
    }
}

private fun listOfFirstScreen(): List<String> {
    return List(20) { "${2 * it}" }
}

private fun listOfSecondScreen(): List<String> {
    return List(20) { "${2 * it + 1}" }
}

