package com.tuapp.miperfilusuarioapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tuapp.miperfilusuarioapp.ui.theme.MiPerfilUsuarioAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiPerfilUsuarioAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UserProfile()
                }
            }
        }
    }
}

@Composable
fun UserProfile() {
    val nombre = remember { mutableStateOf("Nombre: Hector Anibal Lopez Lopez") }
    val edad = remember { mutableStateOf("Edad: 40 años") }
    val profesion = remember { mutableStateOf("Profesión: Estudiante Ingeniería de Software") }
    val ciudad = remember { mutableStateOf("Ciudad: Rionegro - Antioquia") }

    val nuevoNombre = remember { mutableStateOf("") }
    val nuevaEdad = remember { mutableStateOf("") }
    val nuevaProfesion = remember { mutableStateOf("") }
    val nuevaCiudad = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = nombre.value,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.Underline,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = edad.value,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.Underline,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = profesion.value,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.Underline,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = ciudad.value,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.Underline,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = nuevoNombre.value,
            onValueChange = { nuevoNombre.value = it },
            label = { Text("Nuevo Nombre") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = nuevaEdad.value,
            onValueChange = { nuevaEdad.value = it },
            label = { Text("Nueva Edad") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = nuevaProfesion.value,
            onValueChange = { nuevaProfesion.value = it },
            label = { Text("Nueva Profesión") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = nuevaCiudad.value,
            onValueChange = { nuevaCiudad.value = it },
            label = { Text("Nueva Ciudad") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            nombre.value = "Nombre: ${nuevoNombre.value}"
            edad.value = "Edad: ${nuevaEdad.value}"
            profesion.value = "Profesión: ${nuevaProfesion.value}"
            ciudad.value = "Ciudad: ${nuevaCiudad.value}"
        }) {
            Text(text = "Actualizar Información")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfilePreview() {
    MiPerfilUsuarioAppTheme {
        UserProfile()
    }
}
