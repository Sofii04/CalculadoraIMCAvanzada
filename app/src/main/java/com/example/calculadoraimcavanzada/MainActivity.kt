package com.example.calculadoraimcavanzada

// Importamos Bundle para iniciar la actividad principal
import android.os.Bundle

// Importamos ComponentActivity y setContent para usar Jetpack Compose
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

// Importamos Image para mostrar el logo
import androidx.compose.foundation.Image

// Importamos Box, Column, Spacer y otras herramientas de layout
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

// Importamos RoundedCornerShape para esquinas redondeadas
import androidx.compose.foundation.shape.RoundedCornerShape

// Importamos Button, Card y Text para la interfaz
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text

// Importamos Composable
import androidx.compose.runtime.Composable

// Importamos alineación y modificadores
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

// Importamos Brush y Color para el degradado y colores
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// Importamos painterResource para cargar la imagen desde drawable
import androidx.compose.ui.res.painterResource

// Importamos estilos de texto
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

// Importamos tamaños y medidas
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Activity principal de la app
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PantallaCaratulaElegante()
        }
    }
}

// Esta función crea la pantalla de carátula elegante
@Composable
fun PantallaCaratulaElegante() {

    // Box nos permite poner un fondo y luego colocar contenido encima
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                // Fondo degradado con colores inspirados en el logo
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

        // Tarjeta principal para dar un look más limpio y elegante
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = 0.92f)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ) {

            // Columna que organiza todo verticalmente
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(28.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                // Logo de la universidad
                Image(
                    painter = painterResource(id = R.drawable.logo_ur),
                    contentDescription = "Logo Universitario Rumiñahui",
                    modifier = Modifier.size(110.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Nombre de la universidad
                Text(
                    text = "Universitario Rumiñahui",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF0D47A1),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Texto de estudiante
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

                // Texto de materia
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

                // Botón de inicio
                Button(
                    onClick = {
                        // Más adelante este botón nos llevará a la siguiente pantalla
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