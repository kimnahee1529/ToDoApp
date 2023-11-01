package com.nhkim.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nhkim.todoapp.ui.theme.ToDoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopLevel()
                }
            }
        }
    }
}

@Composable
fun TopLevel() {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDo(
    toDoData: ToDoData,
    onToggle: (key: Int, checked: Boolean) -> Unit = { _, _ -> }
) {
    var isEditing by remember { mutableStateOf(true) }
    Card(
        modifier = Modifier.padding(4.dp),
    ) {

    //    Row(
    //        verticalAlignment = Alignment.CenterVertically
    //    ){
    //        Text(
    //            text = toDoData.text,
    //            modifier = Modifier.weight(1f)
    //        )
    //        Text(
    //            text = "완료"
    //        )
    //        Checkbox(
    //            checked = toDoData.done,
    //            onCheckedChange = { checked ->
    //                onToggle(toDoData.key, checked)
    //            }
    //        )
    //        Button(onClick = { /*TODO*/ }) {
    //            Text(text = "수정")
    //        }
    //
    //        Spacer(modifier = Modifier.size(4.dp))
    //
    //        Button(onClick = { /*TODO*/ }) {
    //            Text(text = "삭제")
    //        }

        Crossfade(targetState = isEditing, label = "") {
            when(it) {
                false -> {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = toDoData.text,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = "완료"
                        )
                        Checkbox(
                            checked = toDoData.done,
                            onCheckedChange = { checked ->
                                onToggle(toDoData.key, checked)
                            }
                        )
                        Button(onClick = { /*TODO*/ }) {
                            Text(text = "수정")
                        }

                        Spacer(modifier = Modifier.size(4.dp))

                        Button(onClick = { /*TODO*/ }) {
                            Text(text = "삭제")
                        }
                }
            }

                true -> {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        OutlinedTextField(
                            value = toDoData.text,
                            onValueChange = {},
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Button(onClick = {}) {
                            Text(text = "완료")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToDoAppTheme {
        TopLevel()
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoPreview() {
    ToDoAppTheme {
        ToDo(ToDoData(1, "nice", true))
    }
}


data class ToDoData(
    val key: Int,
    val text: String,
    val done: Boolean = false
)