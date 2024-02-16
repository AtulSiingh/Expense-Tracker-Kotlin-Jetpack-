package com.example.expensetracker.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import  androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.expensetracker.components.TableRow
import com.example.expensetracker.ui.theme.BackgroundElevated
import com.example.expensetracker.ui.theme.TopAppBarBackground
import com.example.expensetracker.ui.theme.Shapes

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Settings(navController: NavController){
    Scaffold (
        topBar = {
            MediumTopAppBar(title = { Text(text ="Settings")}, colors =TopAppBarDefaults.mediumTopAppBarColors(containerColor = TopAppBarBackground) )
        },
        content = {innerPadding->
            Column( modifier=Modifier.padding(innerPadding)){
                Column(modifier= Modifier
                    .padding(16.dp)
                   .clip(Shapes.large)
                    .background(BackgroundElevated)
                    .fillMaxWidth()

                ) {
                    TableRow(label = "Categories",
                        modifier = Modifier.clickable {
                        navController.navigate("settings/categories")},
                        hasArrow = true, isDestructive = false,
                        )
                    Divider()
                    TableRow(label = "Erase All Data", isDestructive =true)

                }
            }
        }
    )
}