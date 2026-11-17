package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.algorithm.Foresight;
import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Matrix;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.Mecanum;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.PinpointConfig;
import com.pedropathing.revhub.localizers.PinpointLocalizer;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

/**
 * <a href="https://pedropathing.com/docs/pathing/tuning/constants">PedroPathing Constants</a>
 */
public class Constants {
    public static MecanumConfig drivetrainConfig = new MecanumConfig(c -> {
        c.frontLeftName.set("leftFront");
        c.frontRightName.set("rightFront");
        c.backLeftName.set("leftBack");
        c.backRightName.set("rightBack");

        c.frontLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.frontRightDirection.set(DcMotorSimple.Direction.FORWARD);
        c.backLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.backRightDirection.set(DcMotorSimple.Direction.FORWARD);
    });

    public static PinpointConfig localizerConfig = new PinpointConfig(c -> {
        c.name.set("pinpoint");
        c.podType.set(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);

        c.xPodOffset.set(5.0d);
        c.yPodOffset.set(7.0d);
        c.offsetUnits.set(DistanceUnit.INCH);

        c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);

        c.globalDistanceUnit.set(DistanceUnit.INCH);
        c.offsetUnits.set(DistanceUnit.INCH);
    });

    /*public static ForesightConfig foresightConfig = new ForesightConfig(c -> {
        Controller primaryTranslationalForward = Controller.proportional(0.1468530882999736);
        Controller secondaryTranslationalForward = Controller.proportional(0.054258292140051775);
        Controller primaryTranslationalLateral = Controller.proportional(0.24078572916772745);
        Controller secondaryTranslationalLateral = Controller.proportional(0.08896389301429687);

        c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
        c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

        c.coast.set(Controller.proportionalFeedforward(0.011817357777219768));
        c.brake.set(Controller.proportionalFeedforward(0.010044754110636803));

        c.headingFeedback.set(Controller.proportional(3.963522326998245));
        c.headingBrakeCoefficients.set(Vector2D.cartesian(0.04277180005209337, 0.015524659752405674));

        c.linearBrakeCoefficients.set(Matrix.diag(1.8926770804153725, 0.05919577675880877));
        c.quadraticBrakeCoefficients.set(Matrix.diag(-0.032075618719217366, 0.0014818441347056828));

        c.maxAchievableForwardVelocity.set(81.57179230965659);
        c.maxAchievableStrafeVelocity.set(68.32912105996647);
        c.naturalForwardDeceleration.set(47.50148685723234);
        c.naturalStrafeDeceleration.set(54.37283717784632);
    });*/

    public static Follower create(HardwareMap h) {
        return new Follower(
                new PinpointLocalizer(h, localizerConfig),
                new Mecanum(h, drivetrainConfig),
                null // new Foresight(foresightConfig)
        );
        // return null;
    }
}