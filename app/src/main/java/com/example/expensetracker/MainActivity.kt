package com.example.expensetracker

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Scaffold
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.ui.theme.ExpenseTrackerTheme
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.expensetracker.pages.Add
import com.example.expensetracker.pages.Expenses
import com.example.expensetracker.pages.Settings

import com.example.expensetracker.ui.theme.TopAppBarBackground

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpenseTrackerTheme {
                val showBottomBar =true;
                val navController = rememberNavController()
                val backStackEntry = navController.currentBackStackEntryAsState()
               Scaffold (
                   bottomBar={
                      if(showBottomBar){
                          NavigationBar(containerColor = TopAppBarBackground) {
                              NavigationBarItem(
                                  selected = backStackEntry.value?.destination?.route=="expense",
                                  onClick = {navController.navigate("expenses")},
                                  label={
                                      Text(text = "Expenses")

                                  },
                                  icon={
                                      Icon(
                                          painterResource(id=R.drawable.upload), contentDescription = "upload")
                                  }
                              )
                              NavigationBarItem(
                                  selected = backStackEntry.value?.destination?.route=="reports",
                                  onClick = {navController.navigate("reports")},
                                  label={
                                      Text(text = "reports")
                                  },
                                  icon={
                                      Icon(
                                          painterResource(id=R.drawable.bar_chart), contentDescription = "reports")
                                  }
                              )
                              NavigationBarItem(
                                  selected = backStackEntry.value?.destination?.route=="add",
                                  onClick = {navController.navigate("add")},
                                  label={
                                      Text(text = "add")
                                  },
                                  icon={
                                      Icon(
                                          painterResource(id=R.drawable.add_button), contentDescription = "add")
                                  }
                              )
                              NavigationBarItem(
                                  selected = backStackEntry.value?.destination?.route=="settings",
                                  onClick = {navController.navigate("settings")},
                                  label={
                                      Text(text = "settings")
                                  },
                                  icon={
                                      Icon(
                                          painterResource(id=R.drawable.settings), contentDescription = "upload")
                                  }
                              )
                          }
                      }
                   },
                   content = { innerPadding->
                       NavHost(navController = navController, startDestination ="expenses",){
                           composable("expenses"){
                               Surface(
                                   modifier = Modifier
                                       .fillMaxSize()
                                       .padding(innerPadding)
                               )
                               { Expenses(navController = navController, name ="Expenses" )
                               }
                           }

                           composable("reports"){
                               Surface(
                                   modifier = Modifier
                                       .fillMaxSize()
                                       .padding(innerPadding)
                               )
                               { Greeting(name = "reports")
                               }
                           }
                           composable("add"){
                               Surface(
                                   modifier = Modifier
                                       .fillMaxSize()
                                       .padding(innerPadding)
                               )
                               { Add(navController)
                               }
                           }
                           composable("settings"){
                               Surface(
                                   modifier = Modifier
                                       .fillMaxSize()
                                       .padding(innerPadding)
                               )
                               { Settings(navController = navController)
                               }
                           }
                           composable("settings/categories"){
                               Surface(
                                   modifier = Modifier
                                       .fillMaxSize()
                                       .padding(innerPadding)
                               )
                               { Greeting(name="Categories")
                               }
                           }

                       }
                   }
               )
            }
        }
    }


    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!"
        )
    }

    @Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
    @Composable
    fun GreetingPreview() {
        ExpenseTrackerTheme {
            Surface {
                Greeting("Android")
            }

        }
    }
}