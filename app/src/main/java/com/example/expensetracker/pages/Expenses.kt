package com.example.expensetracker.pages
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import  androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.expensetracker.ui.theme.TopAppBarBackground

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Expenses(navController: NavController,name:String){
    Scaffold (
        topBar = {
            MediumTopAppBar(title = { Text(text =name)}, colors =TopAppBarDefaults.mediumTopAppBarColors(containerColor = TopAppBarBackground) )
        },
        content = {innerPAdding->
            Column( modifier=Modifier.padding(innerPAdding)){
                Text("Hello $name")
            }
        }
    )
}