package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.algorithm.Foresight;
import com.pedropathing.revhub.drivetrains.Mecanum;
import com.pedropathing.revhub.localizers.PinpointLocalizer;
import com.pedropathing.tuning.autotune.Procedure;
import com.pedropathing.tuning.autotune.Tuner;

import org.firstinspires.ftc.teamcode.pedro.procedures.ForesightTuner;
import org.firstinspires.ftc.teamcode.pedro.procedures.MecanumTuner;
import org.firstinspires.ftc.teamcode.pedro.procedures.PinpointTuner;
import org.firstinspires.ftc.teamcode.pedro.procedures.Tests;

public class Tuning {
    /**
     * <a href="https://pedropathing.com/docs/pathing/tuning/drivetrain/mecanum">PedroPathing Mecanum drivetrain configuration</a>
     *
     * @return The Mecanum tuner
     */
    @Tuner
    public static Procedure mecanumTuner() {
        return new MecanumTuner();
    }

    /**
     * <a href="https://pedropathing.com/docs/pathing/tuning/localization/pinpoint">PedroPathing Pinpoint localization configuration</a>
     *
     * @return The Pinpoint tuner
     */
    @Tuner
    public static Procedure pinpointTuner() {
        return new PinpointTuner();
    }

    /**
     * <a href="https://pedropathing.com/docs/pathing/tuning/foresight">PedroPathing Foresight configuration</a>
     *
     * @return The Foresight tuner
     */
    /*@Tuner
    public static Procedure foresightTuner() {
        return new ForesightTuner(
                (hardwareMap) -> new PinpointLocalizer(hardwareMap, Constants.localizerConfig),
                (hardwareMap) -> new Mecanum(hardwareMap, Constants.drivetrainConfig)
        );
    }*/

    @Tuner
    public static Procedure tests() {
        return new Tests(
                hardwareMap -> new Mecanum(hardwareMap, Constants.drivetrainConfig),
                null, // (hardwareMap -> new PinpointLocalizer(hardwareMap, Constants.localizerConfig)),
                null // () -> new Foresight(Constants.foresightConfig)
        );
    }
}