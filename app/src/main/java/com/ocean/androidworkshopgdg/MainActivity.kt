package com.ocean.androidworkshopgdg

import android.media.MediaCodec
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ocean.androidworkshopgdg.ui.theme.AndroidWorkShopGDGTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val isOnBoarding = mutableStateOf(true)

        setContent {
            /** AndroidWorkShopGDGTheme is a way to style Composable functions. */
            AndroidWorkShopGDGTheme {
                MyApp()
                //todo: A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    Column {
//                        Greeting("Android")
//                        Greeting("Google")
//                        Greeting("iOS")
//                    }

//                    if (isOnBoarding.value){
//                        page1() //todo: declare the onlick fun
//                    }

//                }
            }
        }

    }
}

@Composable
fun page1(onClicked: () -> Unit){

//    Surface {
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text("Welcome to the Basics Codelab!")
//            Button(
//                modifier = Modifier
//                    .padding(vertical = 24.dp),
//                onClick = onContinueClicked
//            ) {
//                Text("Continue")
//            }
//        }
//    }
}

@Composable
fun Greeting(name: String) {
    Surface(color = MaterialTheme.colors.primary) {
        Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
        Column(modifier = Modifier.padding(24.dp)) {
//        Text("First row")
//        Text("Second row")
        }
    }


//    val expanded = remember{ mutableStateOf(false)}
//    Surface(
//        color = MaterialTheme.colors.primary,
//        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
//    ) {
//        Row(modifier = Modifier.padding(20.dp)) {
//            Column(modifier = Modifier
//                .weight(1f)
//                .padding(bottom = if (expanded.value) 48.dp else 0.dp)) {
//                Text(text = "Hello, ")
//                Text(text = name)
//            }
//            OutlinedButton(
//                onClick = { /* TODO */
//                    expanded.value = !expanded.value
//                }
//            ) {
//                Text(if(expanded.value)"Show less" else "Show more")
//            }
//        }
//    }
}

@Preview(showBackground = true, name = "Text preview")
@Composable
fun DefaultPreview() {
    AndroidWorkShopGDGTheme {
//        Greeting("Android")
        MyApp()
    }
}

@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        Greeting("Android")
    }
}
