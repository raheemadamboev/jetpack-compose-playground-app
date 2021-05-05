package xyz.teamgravity.gradientcard

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import xyz.teamgravity.gradientcard.ui.theme.GradientCardTheme

class EditTextActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GradientCardTheme {

                val scaffoldState = rememberScaffoldState()

                var textFieldState by remember { mutableStateOf("") }

                val scope = rememberCoroutineScope()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(30.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {

                        TextField(
                            value = textFieldState,
                            label = {
                                Text(text = "Enter your name")
                            }, onValueChange = {
                                textFieldState = it
                            },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(onClick = {
                            scope.launch {
                                scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState")
                            }
                        }) {
                            Text(text = "Please greet me")
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(onClick = {
                            startActivity(Intent(applicationContext, ConstraintActivity::class.java))
                        }) {
                            Text(text = "Go Constraint Activity")
                        }
                    }
                }
            }
        }
    }
}