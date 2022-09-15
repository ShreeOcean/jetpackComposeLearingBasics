package com.ocean.androidworkshopgdg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ocean.androidworkshopgdg.ui.theme.AndroidWorkShopGDGTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.saveable.rememberSaveable

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
private fun MyApp() {

//    var shouldShowOnboarding by remember { mutableStateOf(true) }
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    if (shouldShowOnboarding) {
        OnBoardingScreen(onContinueClicked = { shouldShowOnboarding = false })
    } else {
        Greetings()
    }
}

@Composable
private fun OnBoardingScreen(onContinueClicked: () -> Unit) {
    // TODO: This state should be hoisted
//    var shouldShowOnboarding by remember { mutableStateOf(true) }
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the Basics Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked //{ shouldShowOnboarding = false }
            ) {
                Text("Continue")
            }
        }
    }
}
@Composable
private fun Greetings(names: List<String> = List(1000){"$it"}) { //todo: names: List<String> = listOf("World", "Compose")
//    Column(modifier = Modifier.padding(vertical = 4.dp)) {
//        for (name in names) {
//            Greeting(name = name)
//        }
//    }
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)){
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}
@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    AndroidWorkShopGDGTheme {
        OnBoardingScreen(onContinueClicked = {})//todo: Do nothing on click.
    }
}
@Composable
fun Greeting(name: String) {

    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello, ")
                Text(text = name)
            }
            OutlinedButton(
                onClick = { expanded.value = !expanded.value }
            ) {
                Text(if (expanded.value) "Show less" else "Show more")
            }
        }

    }
}
//@Preview(showBackground = true, name = "Text preview")
@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    AndroidWorkShopGDGTheme {
        Greetings()
//        Greeting("Android")
//        Greeting( "World")
//        MyApp()
    }
}


//@Composable
//private fun MyApp(names: List<String> = listOf("World", "Compose")) {
//    Column(modifier = Modifier.padding(vertical = 4.dp)) {
//        for (name in names) {
//            Greeting(name = name)
//        }
//    }
//}
