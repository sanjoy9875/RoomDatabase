package com.example.roomdatabase.views

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.roomdatabase.R
import com.example.roomdatabase.jdo.RecurringInfoJDO
import com.example.roomdatabase.viewmodel.RecurringViewModel
import org.threeten.bp.LocalDate

class MainActivity3 : ComponentActivity() {

    object value{
        var weeklyValue = "(on Thursday's)"
        var monthlyValue = "(on the last Thursday)"
        var annuallyValue = "(on April 29)"
        const val weekdaysValue = "(Mon - Fri)"
    }

    object items{
        const val do_not_repeat = "Don't repeat"
        const val daily = "Daily"
        const val weekly = "Weekly "
        const val monthly = "Monthly "
        const val annually = "Annually "
        const val weekdays = "Weekdays only "
    }

    private val recurringViewModel by lazy {
        ViewModelProvider(this).get(RecurringViewModel::class.java)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        value.weeklyValue = recurringViewModel.weekly()
        value.monthlyValue = recurringViewModel.monthly()
        value.annuallyValue = recurringViewModel.annually()

        val recurringInfoJDO = RecurringInfoJDO()
        val date = LocalDate.now()

        setContent {
            Navigation(recurringInfoJDO,date)
        }
    }
}

@Composable
fun Navigation(recurringInfoJDO: RecurringInfoJDO,date: LocalDate){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "first_screen") {
        composable("first_screen") { FirstScreen(navController,recurringInfoJDO,date) }
        composable("second_screen") {
            val localDate = navController.previousBackStackEntry?.savedStateHandle?.get<LocalDate>("date")
            val recurringInfoJdo = navController.previousBackStackEntry?.savedStateHandle?.get<RecurringInfoJDO>("recurringInfoJDO")
            recurringInfoJdo?.let {
                localDate?.let {
                    SecondScreen(navController,recurringInfoJDO,date)
                }
            }
        }
    }
}

@Composable
fun FirstScreen(navController: NavController,recurringInfoJDO: RecurringInfoJDO,date: LocalDate){
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
        ){
        Text(text = "SEND",fontSize = 25.sp,modifier = Modifier.clickable {
            navController.currentBackStackEntry?.savedStateHandle?.set("recurringInfoJDO",recurringInfoJDO)
            navController.currentBackStackEntry?.savedStateHandle?.set("date",date)
            navController.navigate("second_screen")
        })
    }
}

@Composable
fun SecondScreen(navController: NavController,recurringInfoJDO: RecurringInfoJDO,date: LocalDate){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Spacer(modifier = Modifier.height(30.dp))
        header(text = "Recurring",navController)
        Spacer(modifier = Modifier.height(30.dp))

        Divider(color = Color.LightGray)

        Spacer(modifier = Modifier.height(35.dp))

        radioGroup(text = MainActivity3.items.do_not_repeat,"")
        radioGroup(text = MainActivity3.items.daily,"")
        radioGroup(text = MainActivity3.items.weekly, MainActivity3.value.weeklyValue)
        radioGroup(text = MainActivity3.items.monthly, MainActivity3.value.monthlyValue)
        radioGroup(text = MainActivity3.items.annually, MainActivity3.value.annuallyValue)
        radioGroup(text = MainActivity3.items.weekdays, MainActivity3.value.weekdaysValue)
        Text(text = "$recurringInfoJDO $date")
    }
}

@Composable
fun header(text: String,navController: NavController,modifier: Modifier = Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp)
    ) {

        Text(text = text,fontSize = 24.sp)
        Icon(
            painter = painterResource(id = R.drawable.ic_close),
            contentDescription = null,
            Modifier
                .scale(1.5f)
                .clickable {
                    navController.popBackStack()
                },
            tint = Color.Gray,
        )
    }
}

@Composable
fun radioGroup(text : String,value : String,modifier: Modifier = Modifier){

    val selectedItem = remember{
        mutableStateOf("")
    }

    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp)
    ){
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,){
            Text(text = text,fontSize = 24.sp)
            Text(text = value,fontSize = 18.sp)
        }

        RadioButton(
            selected = selectedItem.value == text,
            onClick = {
                selectedItem.value = text
                Log.d("TAG","$text")
            },
            colors = RadioButtonDefaults.colors(
                selectedColor = colorResource(R.color.radio_button_checked),
                unselectedColor = Color.Gray
            ),
            modifier = modifier.scale(1.6f)

        )

    }
    Spacer(modifier = modifier.height(40.dp))
}

