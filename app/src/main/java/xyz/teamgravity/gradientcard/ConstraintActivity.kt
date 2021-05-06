package xyz.teamgravity.gradientcard

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import xyz.teamgravity.gradientcard.ui.theme.GradientCardTheme

class ConstraintActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val constraints = ConstraintSet {
                val greenBox = createRefFor("green_box")
                val redBox = createRefFor("red_box")
                val button = createRefFor("button")

                constrain(greenBox) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }

                constrain(redBox) {
                    top.linkTo(parent.top)
                    start.linkTo(greenBox.end)
                    end.linkTo(parent.end)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }

                createHorizontalChain(greenBox, redBox)

                constrain(button) {
                    top.linkTo(redBox.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }
            }

            GradientCardTheme {
                ConstraintLayout(
                    constraintSet = constraints,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color.Green)
                            .layoutId("green_box")
                    )

                    Box(
                        modifier = Modifier
                            .background(Color.Red)
                            .layoutId("red_box")
                    )

                    Button(
                        modifier = Modifier
                            .padding(16.dp)
                            .layoutId("button"),
                        onClick = {
                            startActivity(Intent(applicationContext, AnimationActivity::class.java))
                        }) {
                        Text(text = "Animation")
                    }
                }
            }
        }
    }
}