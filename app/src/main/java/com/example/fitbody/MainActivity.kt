package com.example.fitbody

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fitbody.datasource.FitBodyActionRepo
import com.example.fitbody.model.FitBodyAction
import com.example.fitbody.ui.theme.FitBodyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitBodyTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    FitBodyApp()
                }
            }
        }
    }
}
@Composable
fun FitBodyApp(){
    Scaffold(topBar = { FitBodyTopAppBar()}) {
        FitBodyList(actions = FitBodyActionRepo.actionRepo)
    }

}

@Composable
fun FitBodyTopAppBar(modifier: Modifier =Modifier){
    Row(
        modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(R.drawable.topbar),
            contentDescription = null, modifier = Modifier
                .size(120.dp)
                .padding(18.dp)
                .clip(RoundedCornerShape(25.dp)),
            contentScale = ContentScale.Crop
        )
        Text(text = stringResource(R.string.topappbar), style = MaterialTheme.typography.h1)
    }
}
@Composable
fun FitBodyList(actions: List<FitBodyAction>, modifier: Modifier = Modifier){
    LazyColumn{
        items(actions){action ->
            FitBodyItem(action = action)
        }
    }
}
@Composable
fun FitBodyItem(action: FitBodyAction, modifier: Modifier = Modifier){
    var expanded by remember { mutableStateOf(false) }
    Card(modifier
        .padding(20.dp)) {
        Column(modifier = Modifier
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            ) {
            Text(text = stringResource(R.string.day,action.day.toString()),
            style = MaterialTheme.typography.h3)
            Text(text = stringResource(action.caption),style = MaterialTheme.typography.h1)
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(action.image), contentDescription = null,
            Modifier.border(1.dp, color = Color.Black))
            Row {
                Spacer(modifier = modifier.weight(1f))
                FitBodyItemButton(expanded = expanded, onClick = { expanded = !expanded })
            }
            if (expanded) {
                FitBodyItemDescription(action.description)
            }
        }

    }
}
@Composable
fun FitBodyItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
){
    IconButton(onClick = onClick) {
        Icon(imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = null )
    }
}
@Composable
fun FitBodyItemDescription(description: Int, modifier: Modifier = Modifier){
    Text(text = stringResource(description),
        style = MaterialTheme.typography.body1,
    modifier = Modifier.padding(bottom = 13.dp))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FitBodyTheme(darkTheme = false) {
        FitBodyApp()
    }
}
@Preview()
@Composable
fun BodyFitDark() {
    FitBodyTheme(darkTheme = true) {
        FitBodyApp()
    }
}