package com.example.f_aid.otherFeature

import android.content.Context
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.f_aid.ui.theme.Black
import com.example.f_aid.ui.theme.Blue3
import com.example.f_aid.ui.theme.White
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch


// Define the DataStore instance as an extension property
val Context.dataStore by preferencesDataStore(name = "settings")

object PreferencesKeys {
    val MY_INT_KEY = intPreferencesKey("my_int_key")
}
suspend fun saveIntValue(context: Context, value: Int) {
    context.dataStore.edit { preferences ->
        preferences[PreferencesKeys.MY_INT_KEY] = value
    }
}
fun readIntValue(context: Context): Flow<Int> {
    return context.dataStore.data.map { preferences ->
        preferences[PreferencesKeys.MY_INT_KEY] ?: 0
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WaterProgressBar() {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val intFlow = readIntValue(context).collectAsState(initial = 0)
    var myIntValue by remember { mutableIntStateOf(intFlow.value) }

    LaunchedEffect(intFlow.value) {
        myIntValue = intFlow.value
    }
    CircularProgressBar( myIntValue , number =14,scope,context, Blue3)

}


@Composable
private fun CircularProgressBar(
    percentage:Int,
    number: Int,
    scope:CoroutineScope,
    context:Context,
    color:Color,
    fontSize:TextUnit=24.sp,
    radius: Dp=50.dp ,

    strokeWidth:Dp=8.dp,
    animDuration: Int=100,
    animDelay:Int=0,

) {
var animationPlayed by remember {
    mutableStateOf(false)
}
    val curPercentage= animateIntAsState(
        targetValue = if(animationPlayed) percentage else 0,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay
        ), label = "water animation"
    )

    LaunchedEffect(key1 = true) {
        animationPlayed=true
    }

Box(contentAlignment = Alignment.Center,
    modifier = Modifier
        .background(color = White, shape = RoundedCornerShape(30.dp))
        .border(2.dp, color = Black, shape = RoundedCornerShape(30.dp))
        .size(radius * 3f)
        .clip(shape = RoundedCornerShape(30.dp))

){
//Image(painterResource(id = R.drawable.water_ima1),
//    contentDescription =null ,
//    contentScale = ContentScale.Crop,
//    alpha =0.7f)
    Canvas(modifier = Modifier.size(radius * 2f)) {
        drawArc(
            color = color,
            -90f,
            ((360/number)*curPercentage.value).toFloat(),
            useCenter=false,
            style= Stroke(strokeWidth.toPx(),cap= StrokeCap.Round)

        )
    }
    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()) {
        CountChangeButton(scope,percentage+1,context,"+")
        Text(text = (curPercentage.value).toString(),
            color = Color.Black,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .size(30.dp)
        )
        CountChangeButton(scope,percentage-1,context,"-")
    }

}
}

@Composable
fun CountChangeButton(scope: CoroutineScope, percentage: Int, context: Context, symbol: String) {
    Button(   onClick = {  scope.launch {
        saveIntValue(context, percentage ) } },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .padding(0.dp)
            .size(50.dp)
            .clip(shape = RectangleShape)
    ) {
        Text(text =symbol ,color=Color.Black,fontSize=24.sp,
            modifier = Modifier
                .padding(0.dp)
                //.background(Color.Blue)
         )
    }
}