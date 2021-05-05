package xyz.teamgravity.gradientcard

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import xyz.teamgravity.gradientcard.ui.theme.GradientCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GradientCardTheme {
                GradientCard(
                    resourceId = R.drawable.pic,
                    title = "Tupac Shakur riding"
                ) {
                    startActivity(Intent(applicationContext, EditTextActivity::class.java))
                }
            }
        }
    }
}