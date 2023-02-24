package com.example.jetpackcatalog.ui.theme


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.jetpackcatalog.R


@Composable
fun MyConfirmationDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Dialog(onDismissRequest = {onDismiss()}) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White)) {
                MyTitleDialog(text = "Phone Rightone", modifier = Modifier.padding(24.dp))
                Divider(Modifier.fillMaxWidth().padding(8.dp), Color.LightGray)
                var status by remember { mutableStateOf("")}
                MyRadioButtonList(status) { status = it }
                Divider(Modifier.fillMaxWidth().padding(8.dp), Color.LightGray)
                Row(Modifier.align(Alignment.End).padding(8.dp)) {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "CANCEL")
                    }
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "OK")
                        
                    }
                    
                }

            }
        }
    }
}


@Composable
fun MyCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(24.dp)
            ) {
                MyTitleDialog(text = "Set backup account")
                AccountItem("ejemplo1@gmail.com", R.drawable.avatar)
                AccountItem("ejemplo2@gmail.com", R.drawable.avatar)
                AccountItem("Anadir nueva cuenta", R.drawable.add)
            }
        }
    }
}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text = email,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun MyTitleDialog(text: String, modifier: Modifier = Modifier.padding(12.dp)) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )

}


@Composable
fun MySimpleCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show)
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = (DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            ))
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Ejemplo de texto en el dialogo Simple")
                Text(text = "Buen ejemplo para obligar al usuario a actualizar")
                Text(text = "No puede clickear fuera o atras")

            }
        }
}


/*  Variables que hay que crear para el AlertDialog
*   var show by remember {mutableStateOf(false) }
*   MyAlertDialog(show = show , onDismiss = {show = false}, onConfirm = {Log.i("Pablo", "Click en confirmar")})
*/
@Composable
fun MyAlertDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {

    if (show) {
        AlertDialog(onDismissRequest = { onDismiss() },
            title = { Text(text = "Titulo") },
            text = { Text(text = "Esta es la descripcion del dialogo") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "confirmButton")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "dismissButton")

                }
            }
        )
    }
}

