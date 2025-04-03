package com.fdegarne.look4it.techtest.ui.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fdegarne.look4it.techtest.R
import com.fdegarne.look4it.techtest.core.data.model.Challenge
import com.fdegarne.look4it.techtest.core.data.model.Location
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@Composable
fun FeedItem(
    challenge: Challenge,
    location: Location?
) {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 'à' HH:mm")
    Card {
        Box(
            modifier = Modifier
                .fillMaxWidth().aspectRatio(1f)
        ) {
            challenge.imageId?.let {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(it),
                    contentScale = ContentScale.Crop,
                    contentDescription = ""
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .align(Alignment.TopCenter)
                    .background(color = Color.Black.copy(alpha = 0.6f))
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 20.dp),
                    text = "${challenge.date?.format(formatter)}",
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 20.dp),
                    text = "#${location?.label}",
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .align(Alignment.BottomCenter)
                    .background(color = Color.Black.copy(alpha = 0.6f))
            ) {
                Icon(
                    modifier = Modifier.padding(10.dp)
                        .weight(1f),
                    painter = painterResource(R.drawable.ic_comment),
                    tint = Color.White,
                    contentDescription = null
                )

                Icon(
                    modifier = Modifier.padding(10.dp)
                        .weight(1f),
                    painter = painterResource(R.drawable.ic_like),
                    tint = Color.White,
                    contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
fun ShowFeedItem() {
    FeedItem(
        Challenge(
            id = 0,
            date = LocalDateTime.now(),
            locationId = 0,
            imageId = R.drawable.cinema
        ),
        Location(
            id = 0,
            title = "a cinema",
            label = "cinema"
        )
    )
}