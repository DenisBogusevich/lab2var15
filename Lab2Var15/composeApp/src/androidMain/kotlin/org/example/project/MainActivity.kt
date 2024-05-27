package org.example.project

import TimeElapsedBloc
import TimeElapsedScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface

class MainActivity : ComponentActivity() {
    private val bloc = TimeElapsedBloc()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    TimeElapsedScreen(bloc)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        bloc.stop()
    }
}