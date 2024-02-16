package com.example.expensetracker.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.expensetracker.components.TableRow
import com.example.expensetracker.ui.theme.BackgroundElevated
import com.example.expensetracker.ui.theme.Shapes
import com.example.expensetracker.ui.theme.TopAppBarBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Add(navController:NavController){
    Scaffold (
        topBar = {
            MediumTopAppBar(title = { Text(text ="Add") }, colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = TopAppBarBackground) )
        },
        content = {innerPadding->
            Column( modifier= Modifier.padding(innerPadding)){
                Column(modifier= Modifier
                    .padding(16.dp)
                    .clip(Shapes.large)
                    .background(BackgroundElevated)
                    .fillMaxWidth()

                ) {
                    TableRow(label = "Amount")
                    Divider()
                    TableRow(label = "Recurrence")
                    Divider()
                    TableRow(label = "Date")
                    Divider()
                    TableRow(label = "Note")
                    Divider()
                    TableRow(label = "Category")

                }
            }
        }
    )
}