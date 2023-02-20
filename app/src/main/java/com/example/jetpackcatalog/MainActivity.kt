package com.example.jetpackcatalog

import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcatalog.ui.theme.CheckInfo
import com.example.jetpackcatalog.ui.theme.JetPackCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    // Val para los checklist
//                    val myOptions = getOptions(listOf("Pablo", "Ejemplo", "Daniela", "Loki"))
                    var selected by rememberSaveable {
                        mutableStateOf("Opcion 1")
                    }

                    Column() {


//                        MyRadioButtonList(selected) { selected = it }
//                        MyTriStatusCheckBox()

                        // CheckBoxAdvance
//                        myOptions.forEach {
//                            MyCheckBoxAdvance(it)
//                        }
//                    }
//                    var myText by remember { mutableStateOf(value = "Ejemplo") }
//                    MyTextField(myText) { myText = it }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackCatalogTheme {
        MyRadioButton()
    }
}

@Composable
fun MyRadioButtonList(opciones:String, onItemSelected: (String) -> Unit) {

    Column(Modifier.fillMaxWidth()) {
        Row {
            RadioButton(selected = opciones == "Opcion 1", onClick = {onItemSelected("Opcion 1")})
            Text(text = "Opcion 1")
        }
        Row() {
            RadioButton(selected = opciones == "Opcion 2", onClick = {onItemSelected("Opcion 2")})
            Text(text = "Opcion 2")
        }
        Row {
            RadioButton(selected = opciones == "Opcion 3", onClick = {onItemSelected("Opcion 3")})
            Text(text = "Opcion 3")
        }
        Row {
            RadioButton(selected = opciones == "Opcion 4", onClick = {onItemSelected("Opcion 4")})
            Text(text = "Opcion 4")
        }
    }
}

@Composable
fun MyRadioButton() {
    Row(Modifier.fillMaxWidth()) {
        RadioButton(
            selected = true, onClick = { }, enabled = false, colors = RadioButtonDefaults.colors(
                selectedColor = Blue, unselectedColor = Yellow, disabledColor = Green
            )
        )
        Text(text = "Pikachu")
    }
}

@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(title = it,
            selected = status,
            onCheckedChange = { myNewStatus -> status = myNewStatus })
    }
}

@Composable
fun MyCheckBoxAdvance(checkInfo: CheckInfo) {

    Row(Modifier.padding(8.dp)) {
        Checkbox(checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}

@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable { mutableStateOf(false) }
    Row(Modifier.padding(8.dp)) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Ejemplo check")
    }
}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable { mutableStateOf(true) }

    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Blue, uncheckedColor = DarkGray, checkmarkColor = White

        )
    )
}

@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(true) }

    Switch(
        checked = state, onCheckedChange = { state = !state }, colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            checkedThumbColor = Color.Green,
            uncheckedTrackColor = Color.Red,
            checkedTrackColor = Color.Green
        )
    )
}

@Composable
fun MyProgressBarAdvance() {

    var circularLoading by rememberSaveable { mutableStateOf(value = 0.5f) }

    var showLoading by rememberSaveable {
        mutableStateOf(false)

    }
    Column(
        Modifier
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(
                progress = circularLoading, color = Color.LightGray, strokeWidth = 3.dp
            )
            LinearProgressIndicator(
                progress = circularLoading,
                modifier = Modifier.padding(top = 32.dp),
                color = Color.DarkGray,
                backgroundColor = Color.LightGray
            )
            Row(
                Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = { circularLoading += 0.1f }, Modifier.padding(8.dp)) {
                    Text(text = "Incrementar", modifier = Modifier.padding(8.dp))
                }
                Button(onClick = { circularLoading -= 0.1f }) {
                    Text(text = "Reducir", modifier = Modifier.padding(8.dp))
                }
            }
            Button(onClick = { showLoading = false }) {
                Text(text = "Ocultar ProgressBar")

            }
        }

        Button(onClick = { showLoading = !showLoading }) {

            Text(text = "Cargar ProgressBar")
        }
    }
}

@Composable
fun MyProgressBar() {
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = Color.LightGray, strokeWidth = 3.dp)
        LinearProgressIndicator(
            modifier = Modifier.padding(top = 32.dp),
            color = Color.DarkGray,
            backgroundColor = Color.LightGray
        )
    }

}

@Composable
fun MyIcon() {
    Icon(
        imageVector = Icons.Rounded.StarHalf,
        contentDescription = "IconStar",
        tint = Color.Blue,
        modifier = Modifier.border(2.dp, Color.LightGray)
    )

}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Ejemplo de imagen",
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.LightGray, CircleShape)
    )
}

@Composable
fun MyImageView() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Ejemplo de imagen",
        alpha = 0.5f
    )
}

@Composable
fun MyTextFieldOutlined() {

    var myText by remember {
        mutableStateOf(value = "")
    }

    OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        modifier = Modifier.padding(24.dp),
        label = { Text(text = "Usuario") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta, unfocusedBorderColor = Color.Blue
        )
    )
}

@Composable
fun MyTextFieldAdvance() {
    var myText by remember { mutableStateOf("") }

    TextField(value = myText, onValueChange = {
        myText = if (it.contains("a")) {
            it.replace("a", "")
        } else {
            it
        }
    }, label = { Text(text = "Introducir usuario") })

}

@Composable
fun MyTextField(name: String, onValueChanged: (String) -> Unit) {

    TextField(value = name, onValueChange = { onValueChanged(it) })
}

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es el ejemplo")
        Text(text = "Esto es otro ejemplo", color = Color.Blue)
        Text(
            text = "Esto es otro ejemplo", color = Color.Red, fontWeight = FontWeight.ExtraBold
        )
        Text(text = "Esto es otro ejemplo", color = Color.Red, fontWeight = FontWeight.Light)
        Text(
            text = "Esto es otro ejemplo",
            color = Color.Red,
            style = TextStyle(fontFamily = FontFamily.Cursive)
        )
        Text(
            text = "Esto es otro ejemplo",
            color = Color.Red,
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )


    }

}

@Composable
fun MyButton() {

    var enabled by rememberSaveable {
        mutableStateOf(true)
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { enabled = false }, enabled = enabled, colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue, contentColor = Color.White
            )
        ) {
            Text(text = "Pulsar")
        }

        OutlinedButton(
            onClick = { enabled = false },
            enabled = enabled,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "PulsarOut")
        }

        TextButton(onClick = {}) {
            Text(text = "TextButton")

        }
    }
}