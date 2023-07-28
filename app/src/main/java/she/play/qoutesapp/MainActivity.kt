package she.play.qoutesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import she.play.qoutesapp.screens.QuoteDetail
import she.play.qoutesapp.screens.QuoteListScreen
import she.play.qoutesapp.ui.theme.QoutesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            DataManager.loadAssetsFromFile(applicationContext)
        }
        setContent {
            App()
        }
    }
}

@Composable
fun App(){
        if (DataManager.isDataLoaded.value){
            if(DataManager.currentPages.value==Pages.LISTING){
            QuoteListScreen(data = DataManager.data) {
                DataManager.switchPages(it)
            }}
            else{
                DataManager?.currentQuote?.let { QuoteDetail(quote = it) }
            }
        }else{
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize(1f)
            )
            {
                Text(text = "Loading...",
                style = MaterialTheme.typography.h6
                )
            }
        }
}
enum class Pages{
    LISTING,
    DETAIL
}