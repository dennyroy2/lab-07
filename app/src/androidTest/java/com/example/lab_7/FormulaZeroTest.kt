package com.example.lab_7

import org.junit.runner.RunWith
import org.junit.Rule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Test
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput


@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // add race location
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

    @Test
    fun add_driver_clear_then_go_back() {
        composeTestRule //go to drivers screen
            .onNodeWithTag("driverButton")
            .performClick()

        composeTestRule //make sure screen exists
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        composeTestRule //input driver
            .onNodeWithTag("driverInput")
            .performTextInput("lightning mcqueen")

        composeTestRule //click the button to add the driver
            .onNodeWithTag("addDriverButton")
            .performClick()

        composeTestRule //make sure driver exists
            .onNodeWithText("lightning mcqueen")
            .assertExists()

        composeTestRule //press back button
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()

    }
}