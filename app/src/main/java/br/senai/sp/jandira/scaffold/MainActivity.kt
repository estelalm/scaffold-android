package br.senai.sp.jandira.scaffold

import android.annotation.SuppressLint
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material.icons.twotone.AccountCircle
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import br.senai.sp.jandira.scaffold.ui.theme.ScaffoldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Home()
                }
            }
        }
    }
}

data class Personagem(
    val id: Int,
    val nome: String,
    val descricao: String,
    val imagem : Int
)

val personagensList = listOf(
    Personagem(
        1,
        "Omori",
        "...",
        R.drawable.omori
    ),
    Personagem(
        2,
        "Aubrey",
        "...",
        R.drawable.aubrey
    ),
    Personagem(
        3,
        "Kel",
        "...",
        R.drawable.kel
    ),
    Personagem(
        4,
        "Hero",
        "...",
        R.drawable.hero
    ),
    Personagem(
        4,
        "Basil",
        "...",
        R.drawable.basil
    ),
        Personagem(4,
        "Mari",
        "...",
        R.drawable.mari
)
)

var Primary = 0xff391c5c
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home() {
    Scaffold (
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Icon(
                        modifier = Modifier.padding(18.dp),
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = "Ícone de casa",
                        tint = Color.White
                    )
                },
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Scaffold e AppBar",
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(Primary)
                ),
                actions = {
                    Icon(
                        modifier = Modifier.padding(18.dp),
                        imageVector = Icons.TwoTone.AccountCircle ,
                        contentDescription = "Ícone de usuário",
                        tint = Color.White
                    )
                }

           )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color(Primary),
                contentColor = Color.Black,

            ){
                Icon(Icons.Outlined.Home, contentDescription = null, tint = Color.White, modifier = Modifier.padding(start = 16.dp, end = 4.dp))
                Icon(Icons.Outlined.Favorite, contentDescription = null, tint = Color.White, modifier = Modifier.padding(4.dp))
                Icon(Icons.Outlined.Share, contentDescription = null, tint = Color.White, modifier = Modifier.padding(4.dp))
                Text(
                    text = "Personagens de 'Omori'",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth())
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                },
                containerColor = Color(Primary)
            ) {
                Icon(Icons.TwoTone.Star, contentDescription = "", tint = Color.White)
            }
        }
    ){innerPadding ->
        Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
        )
        {
            LazyColumn (
                modifier = Modifier
                    .fillMaxWidth(),
                contentPadding = PaddingValues(12.dp)
            ) {
                items(personagensList){ personagem ->
                    Cards(nome = personagem.nome, descricao = personagem.descricao, imagem = personagem.imagem)
                }
            }
        }
    }
}

@Composable
fun Cards(nome: String, descricao: String, imagem: Int) {
    Card(
        modifier = Modifier
            .height(150.dp)
            .border(BorderStroke(3.dp, Color.Black), RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .padding(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(8.dp)
    ){
        Row (
            modifier = Modifier
                .background(Color.Black)
                .padding(6.dp)
        ) {
            Card (
                modifier = Modifier
                    .fillMaxHeight()
                    .width(140.dp)
            ){
                Image(
                    painter = painterResource(id = imagem),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .background(Color.Gray)
                        .fillMaxSize()
                )
            }
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
            {
                Text(
                    text = nome,
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = descricao,
                    color= Color.White
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(4.dp))
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview() {
    ScaffoldTheme {
        Home()
    }
}