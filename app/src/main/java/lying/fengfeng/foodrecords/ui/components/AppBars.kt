package lying.fengfeng.foodrecords.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodRecordsTopBar(title: String) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(text = title)
        },
        modifier = Modifier.shadow(12.dp)
    )
}

@Composable
fun FoodRecordsBottomBar(
    navController: NavController,
    fabOnClick: () -> Unit
) {
    BottomAppBar(
        actions = {
            IconButton(onClick = {
                if (navController.currentBackStackEntry?.destination?.route != "home") {
                    navController.navigate("home")
                }
            }) {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = "Localized description"
                )
            }
            IconButton(onClick = {
                if (navController.currentBackStackEntry?.destination?.route != "list") {
                    navController.navigate("list")
                }
            }) {
                Icon(
                    Icons.AutoMirrored.Filled.List,
                    contentDescription = "Localized description",
                )
            }
            IconButton(onClick = {
                if (navController.currentBackStackEntry?.destination?.route != "settings") {
                    navController.navigate("settings")
                }
            }) {
                Icon(
                    Icons.Filled.Settings,
                    contentDescription = "Localized description",
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = fabOnClick,
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(Icons.Filled.Add, "Localized description")
            }
        },
        modifier = Modifier
    )
}