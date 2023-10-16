package coded.alchemy.quotable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import coded.alchemy.quotable.compose.QuotableApp
import coded.alchemy.quotable.ui.theme.QuotableTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotableTheme {
                QuotableApp()
            }
        }
    }
}
