package com.example.calculadoraimcavanzada

// Importamos Bundle para iniciar la actividad principal de Android
import android.os.Bundle

// Importamos ComponentActivity y setContent para usar Jetpack Compose
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

// Importamos Image para mostrar el logo de la universidad
import androidx.compose.foundation.Image

// Importamos herramientas para fondo y diseño
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

// Importamos forma redondeada para tarjetas y botones
import androidx.compose.foundation.shape.RoundedCornerShape

// Importamos componentes visuales de Material Design 3
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text

// Importamos Composable para crear pantallas con Jetpack Compose
import androidx.compose.runtime.Composable

// Importamos alineación y modificadores
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

// Importamos Brush y Color para crear el degradado
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// Importamos painterResource para cargar imágenes desde drawable
import androidx.compose.ui.res.painterResource

// Importamos estilos de texto
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

// Importamos unidades de tamaño
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

// Activity principal de la app
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContent permite mostrar la interfaz creada con Jetpack Compose
        setContent {
            // Temporalmente mostramos el formulario para probar el Commit 3
            // Luego volveremos a usar navegación para ir desde la carátula al formulario
            PantallaFormulario()
        }
    }
}

// Esta función crea la pantalla de carátula elegante
@Composable
fun PantallaCaratulaElegante() {

    // Box permite colocar un fondo y luego contenido encima
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                // Fondo degradado inspirado en los colores del logo
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFF5A623), // Naranja
                        Color(0xFF62D2C6), // Verde agua
                        Color(0xFF0D47A1)  // Azul fuerte
                    )
                )
            )
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {

        // Card crea una tarjeta elegante sobre el fondo degradado
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = 0.92f)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ) {

            // Column organiza los elementos de la carátula de forma vertical
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(28.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                // Imagen del logo guardada en res/drawable/logo_ur.png
                Image(
                    painter = painterResource(id = R.drawable.logo_ur),
                    contentDescription = "Logo Universitario Rumiñahui",
                    modifier = Modifier.size(110.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Nombre de la institución
                Text(
                    text = "Universitario Rumiñahui",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF0D47A1),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Datos de la estudiante
                Text(
                    text = "Estudiante:",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0D47A1)
                )

                Text(
                    text = "Acosta Sofia",
                    fontSize = 18.sp,
                    color = Color(0xFF333333),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Datos de la materia
                Text(
                    text = "Materia:",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0D47A1)
                )

                Text(
                    text = "Aplicaciones Móviles",
                    fontSize = 18.sp,
                    color = Color(0xFF333333),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(18.dp))

                // Nombre del proyecto
                Text(
                    text = "Calculadora de IMC\nAvanzada Multipantalla",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFF57C00),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(30.dp))

                // Botón de inicio, por ahora sin navegación
                Button(
                    onClick = {
                        // Más adelante este botón llevará a la pantalla del formulario
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF0D47A1),
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Iniciar",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

// Esta pantalla será el formulario donde el usuario ingresará sus datos
// Esta pantalla será el formulario donde el usuario ingresará sus datos
// Esta pantalla será el formulario donde el usuario ingresará sus datos
@Composable
fun PantallaFormulario() {

    // Estado para guardar el nombre que escribe el usuario
    var nombre by remember { mutableStateOf("") }

    // Estado para guardar el peso que escribe el usuario
    var peso by remember { mutableStateOf("") }

    // Estado para guardar la altura que escribe el usuario
    var altura by remember { mutableStateOf("") }

    // Estado para mostrar mensajes de error
    var mensajeError by remember { mutableStateOf("") }

    // Box permite colocar el fondo degradado y encima la tarjeta
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFF5A623), // Naranja
                        Color(0xFF62D2C6), // Verde agua
                        Color(0xFF0D47A1)  // Azul fuerte
                    )
                )
            )
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {

        // Tarjeta blanca elegante para contener el formulario
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = 0.92f)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(28.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Calculadora de IMC",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF0D47A1)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Campo para ingresar el nombre del usuario
                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Nombre del usuario") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Campo para ingresar el peso en kilogramos
                OutlinedTextField(
                    value = peso,
                    onValueChange = { peso = it },
                    label = { Text("Peso en kilogramos") },
                    placeholder = { Text("Ejemplo: 60") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Campo para ingresar la altura en metros
                OutlinedTextField(
                    value = altura,
                    onValueChange = { altura = it },
                    label = { Text("Altura en metros") },
                    placeholder = { Text("Ejemplo: 1.60") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Si existe un error, se muestra en rojo
                if (mensajeError.isNotEmpty()) {
                    Text(
                        text = mensajeError,
                        color = Color.Red,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                }

                Button(
                    onClick = {
                        // Convertimos peso y altura a números decimales
                        val pesoNumero = peso.toDoubleOrNull()
                        val alturaNumero = altura.toDoubleOrNull()

                        // Validamos que los campos no estén vacíos
                        if (nombre.isBlank() || peso.isBlank() || altura.isBlank()) {
                            mensajeError = "Por favor, ingresa valores válidos."
                            return@Button
                        }

                        // Validamos que peso y altura sean números
                        if (pesoNumero == null || alturaNumero == null) {
                            mensajeError = "Por favor, ingresa valores válidos."
                            return@Button
                        }

                        // Validamos que peso y altura sean mayores a cero
                        if (pesoNumero <= 0 || alturaNumero <= 0) {
                            mensajeError = "Por favor, ingresa valores válidos."
                            return@Button
                        }

                        // Si todo está correcto, quitamos el mensaje de error
                        mensajeError = ""
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF0D47A1),
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Calcular",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}