package com.example.timer.instagramUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.Key.Companion.Tab
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.timer.Highlights
import com.example.timer.ImageWithTexts
import com.example.timer.R
import kotlin.math.min

@Composable
fun ProfileScreen(navController: NavController) {
    var selectedTabIndex by remember{
        mutableStateOf(0)
    }
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(top = 42.dp)){
        TopBar(name = "siliconbytes.mboya", modifier = Modifier.padding(10.dp), navController = navController)
        Spacer(modifier = Modifier.padding(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
        HighlightSection(
            modifier = Modifier,
            highlights = listOf(
                Highlights(
                    image = painterResource(id = R.drawable.youtube),
                    highlight = "YouTube"
                ),
                Highlights(
                    image = painterResource(id = R.drawable.qa),
                    highlight = "Question & Answer"
                ),
                Highlights(
                    image = painterResource(id = R.drawable.discord),
                    highlight = "Discord"
                ),
                Highlights(
                    image = painterResource(id = R.drawable.telegram),
                    highlight = "Telegram"
                ),
                Highlights(
                    image = painterResource(id = R.drawable.youtube),
                    highlight = "YouTube"
                ),
                Highlights(
                    image = painterResource(id = R.drawable.youtube),
                    highlight = "YouTube"
                ),
                Highlights(
                    image = painterResource(id = R.drawable.youtube),
                    highlight = "YouTube"
                ),
                Highlights(
                    image = painterResource(id = R.drawable.youtube),
                    highlight = "YouTube"
                ),
                Highlights(
                    image = painterResource(id = R.drawable.youtube),
                    highlight = "YouTube"
                )
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(
            imageWithTexts = listOf(
                ImageWithTexts(
                     painterResource(id = R.drawable.ic_grid),
                    text = "Posts"
                ),
                ImageWithTexts(
                     painterResource(id = R.drawable.ic_reels),
                    text = "Reels"
                ),
                ImageWithTexts(
                     painterResource(id = R.drawable.ic_igtv),
                    text = "IGTV"
                ),
                ImageWithTexts(
                     painterResource(id = R.drawable.profile),
                    text = "Tagged"
                )
            ),
            onTabSelected = {
                selectedTabIndex = it
            })
             when(selectedTabIndex){
                0 -> PostSection(
                    posts = listOf(
                        painterResource(id = R.drawable.kmm),
                        painterResource(id = R.drawable.intermediate_dev),
                        painterResource(id = R.drawable.master_logical_thinking),
                        painterResource(id = R.drawable.bad_habits),
                        painterResource(id = R.drawable.learn_coding_fast)
                    ), modifier = Modifier.fillMaxWidth())
            }

        {

        }
    }
}

@Composable
fun TopBar(
    navController: NavController,
    name: String,
    modifier: Modifier = Modifier
) {
    Row (
        verticalAlignment =  Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth() 
    ){
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
                .clickable {
                    navController.navigate("main_screen")
                }
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight =  FontWeight.Bold,
            fontSize = 20.sp)
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column (modifier = modifier.fillMaxWidth()){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ){
            RoundImage(image = painterResource(id = R.drawable.philipp), modifier = Modifier
                .size(100.dp)
                .weight(3f))
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        }
        ProfileDescription(
            displayName = "Enock Koech",
            description = "Android Developer\n" +
                    "2 years of coding experience\n" +
                    "Want an app? send me an email",
            url = "github.com/ekoechmboya",
            followedBy = listOf("Mishertalita", "Plcoding"),
            otherCount = 20
        )
    }
}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(painter = image, contentDescription = "Profile Image",
    modifier = modifier
        .aspectRatio(1f, matchHeightConstraintsFirst = true)
        .border(
            width = 1.dp,
            color = Color.LightGray,
            shape = CircleShape
        )
        .padding(3.dp)
        .clip(CircleShape)
    )
}

@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ){
        ProfileStat(numberText = "200", text = "Posts")
        Spacer(modifier = Modifier.width(10.dp))
        ProfileStat(numberText = "100K", text = "Followers")
        Spacer(modifier = Modifier.width(10.dp))
        ProfileStat(numberText = "59", text = "Following")
    }
}

@Composable
fun ProfileStat(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        Text(text = numberText, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
    
}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ){
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        if(followedBy.isNotEmpty()){
            Text(
                text= buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size -1){
                        append(",")}
                    }
                    if(otherCount> 2){
                        append(" and ")
                        pushStyle(boldStyle)
                        append("${otherCount-2} others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
    
}

@Composable
fun ButtonSection(modifier: Modifier = Modifier) {
    val minwidth = 95.dp
    val height = 30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ){
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minwidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minwidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minwidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minwidth)
                .height(height)
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ){
        if(text != null){
            Text( 
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        if (icon != null){
            Icon(imageVector = icon, contentDescription = null, tint = Color.Black)
        }
    }
}

@Composable
fun HighlightSection(
    modifier: Modifier,
    highlights: List<Highlights>
) {
    LazyRow(modifier = modifier){
        items(highlights.size){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end = 15.dp)
            ) {
                RoundImage(image = highlights[it].image,
                    modifier = Modifier.size(70.dp))
                Text(text = highlights[it].highlight,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center)
            }
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithTexts: List<ImageWithTexts>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        contentColor = Color.Black,
        modifier = modifier
        ) {
        imageWithTexts.forEachIndexed { index, item ->
            androidx.compose.material3.Tab(selected = selectedTabIndex == 0,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }) {
                Icon(painter = item.Image, contentDescription = item.text,
                    tint = if(selectedTabIndex == 0) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }


    }
}

@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier.scale(1.01f)
    ){
        items(posts.size){
            Image(
                painter = posts[it],
                contentDescription = "Posts",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
                )
        }
    }
}