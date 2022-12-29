package com.example.fitbody.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.fitbody.R

val Forum = FontFamily(
    Font(R.font.forum_regular,FontWeight.Normal)
)
val Zendots = FontFamily(
    Font(R.font.zendots_regular,FontWeight.Normal)
)
// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = Zendots,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp
    ),
    h3 = TextStyle(
        fontFamily = Zendots,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    ),
    body1 = TextStyle(
        fontFamily = Forum,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp
    )

)