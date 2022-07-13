package com.berghachi.movieapp.screens.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.berghachi.movieapp.model.getMovies
import com.berghachi.movieapp.widgets.MovieRow

@Composable
fun DetailScreen(navController: NavController, movieId: String?) {

    val movie = getMovies().firstOrNull { it.id == movieId }
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.LightGray, elevation = 5.dp) {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow back",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
            }
            Spacer(modifier = Modifier.width(100.dp))
            Text(text = "Details Movies")

        }
    }) {
        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                movie?.let { it1 -> MovieRow(movie = it1) }
                Divider()
                Text(text = "Movies Images")

                movie?.images?.let {
                    HorizontalImageScroll(it)
                }

            }
        }
    }


}

@Composable
private fun HorizontalImageScroll(list: List<String>) {
    LazyRow {
        items(list) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = 5.dp
            ) {
                AsyncImage(model = image, contentDescription = null,contentScale = ContentScale.Crop)
            }
        }
    }
}