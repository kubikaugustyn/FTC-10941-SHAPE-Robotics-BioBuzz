/* Copyright (c) 2024 Miriam Sinton-Remes. All rights reserved. */

package org.firstinspires.ftc.teamcode.test_modes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/*
 * This OpMode illustrates using edge detection on a gamepad.
 *
 * Simply checking the state of a gamepad button each time could result in triggering an effect
 * multiple times. Edge detection ensures that you only detect one button press, regardless of how
 * long the button is held.
 *
 * There are two main types of edge detection. Rising edge detection will trigger when a button is
 * first pressed. Falling edge detection will trigger when the button is released.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list.
 */

@TeleOp(name = "Concept: Gamepad Edge Detection", group = "Concept")
@Disabled
public class ConceptGamepadEdgeDetection extends LinearOpMode {

    @Override
    public void runOpMode() {
        // Wait for the DS start button to be pressed
        waitForStart();

        while (opModeIsActive()) {
            // Update the telemetry
            telemetryButtonData();

            // Wait 2 seconds before doing another check
            sleep(2000);
        }
    }

    public void telemetryButtonData() {
        // Add the status of the Gamepad 1 Left Bumper
        telemetry.addData("Gamepad 1 Left Bumper Pressed", gamepad1.leftBumperWasPressed());
        telemetry.addData("Gamepad 1 Left Bumper Released", gamepad1.leftBumperWasReleased());
        telemetry.addData("Gamepad 1 Left Bumper Status", gamepad1.left_bumper);

        // Add an empty line to separate the buttons in telemetry
        telemetry.addLine();

        // Add the status of the Gamepad 1 Right Bumper
        telemetry.addData("Gamepad 1 Right Bumper Pressed", gamepad1.rightBumperWasPressed());
        telemetry.addData("Gamepad 1 Right Bumper Released", gamepad1.rightBumperWasReleased());
        telemetry.addData("Gamepad 1 Right Bumper Status", gamepad1.right_bumper);

        // Add an empty line to separate the buttons in telemetry
        telemetry.addLine();

        // Add the status of the Gamepad 1 Left trigger
        telemetry.addData("Gamepad 1 Left Trigger Pressed", gamepad1.leftTriggerWasPressed());
        telemetry.addData("Gamepad 1 Left Trigger Released", gamepad1.leftTriggerWasReleased());
        telemetry.addData("Gamepad 1 Left Trigger Status", gamepad1.left_trigger_pressed);

        // Add an empty line to separate the buttons in telemetry
        telemetry.addLine();

        // Add the status of the Gamepad 1 Right trigger
        telemetry.addData("Gamepad 1 Right Trigger Pressed", gamepad1.rightTriggerWasPressed());
        telemetry.addData("Gamepad 1 Right Trigger Released", gamepad1.rightTriggerWasReleased());
        telemetry.addData("Gamepad 1 Right Trigger Status", gamepad1.right_trigger_pressed);

        // Add a note that the telemetry is only updated every 2 seconds
        telemetry.addLine("\nTelemetry is updated every 2 seconds.");

        // Update the telemetry on the DS screen
        telemetry.update();
    }
}
