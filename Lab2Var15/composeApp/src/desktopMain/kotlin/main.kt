import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    val bloc = TimeElapsedBloc()

    Window(onCloseRequest = ::exitApplication) {
        MaterialTheme {
            Surface {
                TimeElapsedScreen(bloc)
            }
        }
    }

    // Stop the BLoC when the application is closed
    Runtime.getRuntime().addShutdownHook(Thread {
        bloc.stop()
    })
}