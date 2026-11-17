package org.firstinspires.ftc.teamcode.test_modes;

import com.pedropathing.drivetrain.DrivePowers;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.ManualDrive;
import com.pedropathing.math.Pose;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.pedro.Constants;

import java.util.Locale;

@TeleOp(name = "Pedro: Manual driving", group = "PedroPathing")
public class ExampleTeleOp extends OpMode {
    private Follower follower;

    @Override
    public void init() {
        follower = Constants.create(hardwareMap);
    }

    @Override
    public void loop() {
        // Robot-centric - https://pedropathing.com/docs/pathing/guide/teleop-usage#robot-centric-teleop
        /*follower.manual(
                -gamepad1.left_stick_y,
                -gamepad1.left_stick_x,
                -gamepad1.right_stick_x
        );*/

        // Field-centric - https://pedropathing.com/docs/pathing/guide/teleop-usage#field-centric-driving
        DrivePowers powers = ManualDrive.fieldCentric(
                -gamepad1.left_stick_y,
                -gamepad1.left_stick_x,
                -gamepad1.right_stick_x,
                follower.pose().heading()
        );
        follower.manual(powers);
        // ManualDrive.driveOrHold(follower, powers);

        follower.update();

        // Telemetry position
        Pose robotPose = follower.pose();
        telemetry.addData("Robot X", toRoundedString(robotPose.x()));
        telemetry.addData("Robot Y", toRoundedString(robotPose.y()));
        telemetry.addData("Robot Heading", toRoundedString(Math.toDegrees(robotPose.heading())));
    }

    private String toRoundedString(double value) {
        return String.format(Locale.ENGLISH, "%.3f", value);
    }
}
