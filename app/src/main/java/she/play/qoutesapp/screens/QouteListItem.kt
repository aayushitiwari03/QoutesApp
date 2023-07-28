package she.play.qoutesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import she.play.qoutesapp.model.Quote


@Composable
fun QuoteListItem(quote: Quote,onClick:(quote: Quote)->Unit){
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .clickable { onClick(quote) }
            .padding(8.dp)
    ){
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
           Image(
               imageVector = Icons.Filled.FormatQuote,
               colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(androidx.compose.ui.graphics.Color.White),
               alignment = Alignment.TopStart,
               contentDescription ="Quote",
               modifier = Modifier
                   .size(48.dp)
                   .rotate(180f)
                   .background(androidx.compose.ui.graphics.Color.Black)
           )
            Spacer(modifier = Modifier.padding(4.dp))
            Column(modifier = Modifier.weight(3f)) {
                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(0.dp,0.dp,0.dp,8.dp)
                )
                Box(modifier = Modifier
                    .background(Color(0xFFEEEEEE))
                    .fillMaxWidth(.4f)
                    .height(1.dp)
                )
                Text(text = quote.author,
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.Thin,
                    modifier = Modifier.padding(top = 4.dp)

                )
            }
        }
    }
}



