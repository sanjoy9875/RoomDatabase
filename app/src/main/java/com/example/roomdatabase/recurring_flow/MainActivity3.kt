package com.example.roomdatabase.recurring_flow

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.roomdatabase.R
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.util.*

class MainActivity3 : ComponentActivity() {

    object newStr{
        var str = ""
        var freq = ""
        var wkst = ""
        var until = ""
        var byDay = ""
    }

    object value{
        const val do_not_repeat = ""
        const val daily = ""
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        value.weeklyValue = recurringViewModel.weekly()
        value.monthlyValue = recurringViewModel.monthly()
        value.annuallyValue = recurringViewModel.annually()

//        val recurringInfoJDO = RecurringInfoJDO()
//        recurringInfoJDO.endDate = recurringViewModel.endDate()

        val str = "FREQ=DAILY;WKST=SU;UNTIL=20211113T235959Z"
        recurringViewModel.getRRulesString(str)

        setContent {
            Navigation(recurringViewModel)
        }
    }
}

@Composable
fun Navigation(recurringViewModel: RecurringViewModel){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "first_screen") {
        composable("first_screen") { FirstScreen(navController,recurringViewModel) }
        composable("second_screen") {
//            val recurringInfoJdo = navController.previousBackStackEntry?.savedStateHandle?.get<RecurringViewModel>("recurringViewModel")
//            recurringInfoJdo?.let {
//
//            }
            SecondScreen(navController,recurringViewModel)
        }
    }
}

@Composable
fun FirstScreen(navController: NavController,recurringViewModel: RecurringViewModel){
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
        ){
        Text(text = "SEND",fontSize = 25.sp,modifier = Modifier.clickable {
//            navController.currentBackStackEntry?.savedStateHandle?.set("recurringViewModel",recurringViewModel)
            navController.navigate("second_screen")
        })
    }
}

@Composable
fun SecondScreen(navController: NavController,recurringViewModel: RecurringViewModel){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Spacer(modifier = Modifier.height(30.dp))
        header(text = "Recurring",navController)
        Spacer(modifier = Modifier.height(30.dp))

        Divider(color = Color.LightGray)

        Spacer(modifier = Modifier.height(35.dp))

        val item = listOf<String>(
            MainActivity3.items.do_not_repeat,
            MainActivity3.items.daily,
            MainActivity3.items.weekly,
            MainActivity3.items.monthly,
            MainActivity3.items.annually,
            MainActivity3.items.weekdays,
        )

        val values = listOf<String>(
            MainActivity3.value.do_not_repeat,
            MainActivity3.value.daily,
            MainActivity3.value.weeklyValue,
            MainActivity3.value.monthlyValue,
            MainActivity3.value.annuallyValue,
            MainActivity3.value.weekdaysValue,
        )

        radioGroup(item,values,recurringViewModel)

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
fun radioGroup(items : List<String>,
               value : List<String>,
               recurringViewModel: RecurringViewModel,
               modifier: Modifier = Modifier){


            val selectedItem = remember {
                mutableStateOf("")
            }

    Column(modifier = modifier
            .fillMaxWidth()) {

        for (i in 0..5) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(text = items[i], fontSize = 24.sp)
                    Text(text = value[i], fontSize = 18.sp)
                }

                RadioButton(
                    selected = selectedItem.value == items[i],
                    onClick = {
                        selectedItem.value = items[i]

                      when(i){
                          0 ->
                            MainActivity3.newStr.str =  recurringViewModel.getRRulesString("")
                          1 ->
                              MainActivity3.newStr.apply {
                                  freq = "DAILY"
                                  wkst = "SU"
                                  until = recurringViewModel.until
                                  str = recurringViewModel.getRRulesString("FREQ=$freq;WKST=$wkst;UNTIL=$until")
                              }

                          2 ->
                              MainActivity3.newStr.apply {
                                  freq = "WEEKLY"
                                  wkst = "SU"
                                  until = recurringViewModel.until
                                  str = recurringViewModel.getRRulesString("FREQ=$freq;WKST=$wkst;UNTIL=$until")
                              }

                          3 ->
                              MainActivity3.newStr.apply {
                                  freq = "MONTHLY"
                                  wkst = "SU"
                                  until = recurringViewModel.until
                                  str = recurringViewModel.getRRulesString("FREQ=$freq;WKST=$wkst;UNTIL=$until")
                              }
                          4 ->
                              MainActivity3.newStr.str = recurringViewModel.getRRulesString("")
                          5 ->
                              MainActivity3.newStr.apply {
                                  freq = "WEEKLY"
                                  wkst = "SU"
                                  byDay = when(recurringViewModel.day){
                                      "sunday" -> "SU"
                                      "monday" -> "MO"
                                      "tuesday" -> "TU"
                                      "wednesday" -> "WE"
                                      "thursday" -> "TH"
                                      "friday" -> "FR"
                                      else -> "SA"
                                  }
                                  until = recurringViewModel.until
                                  str = recurringViewModel.getRRulesString("FREQ=$freq;WKST=$wkst;BYDAY=$byDay;UNTIL=$until")
                              }
                      }
                        Log.d("TAG", MainActivity3.newStr.str)

                    },
                    colors = RadioButtonDefaults.colors(
                        Color(R.color.radio_button_checked),
                    ),
                    modifier = modifier.scale(1.6f)
                )

            }
            Spacer(modifier = modifier.height(40.dp))
        }

    }
}



