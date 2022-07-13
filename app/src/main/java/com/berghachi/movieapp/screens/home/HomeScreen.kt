package com.berghachi.movieapp.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.berghachi.movieapp.model.Movie
import com.berghachi.movieapp.model.getMovies
import com.berghachi.movieapp.navigation.MovieScreens
import com.berghachi.movieapp.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController) {


    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.LightGray, elevation = 5.dp) {
            Text(text = "Movies")

        }
    }) {
        MainContent(navController)
    }

}


@Composable
fun MainContent(
    navController: NavController,
    moviesList: List<Movie> = getMovies()
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(moviesList) { movie ->
                MovieRow(movie) {
                    navController.navigate(route = MovieScreens.DetailScreen.name+"/${movie.id}")
                }
            }
        }
    }

}



