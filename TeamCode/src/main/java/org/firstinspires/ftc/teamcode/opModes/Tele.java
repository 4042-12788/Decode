package org.firstinspires.ftc.teamcode.opModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.gamepads.Controller;
import org.firstinspires.ftc.teamcode.botParts.Robot;
import org.firstinspires.ftc.teamcode.util.HardwareSingle;
import org.firstinspires.ftc.teamcode.util.MathHelper;
import org.firstinspires.ftc.teamcode.util.TeleSingle;

@TeleOp
public class Tele extends LinearOpMode {
    private double dpadMaxWeight = 0.4;
    private double[] dpadCurrentWeight = new double[] {0, 0};
    private double dpadWeightChangeRate = 0.1;


    Robot robot;
    Controller gp1;
    Controller gp2;

    public int allianceTag = 20;
    //for blue, for red its 24

    @Override
    public void runOpMode() throws InterruptedException {
        TeleSingle.init(telemetry);
        HardwareSingle.init(hardwareMap);
        robot = new Robot(hardwareMap, telemetry);

        gp1 = new Controller(gamepad1);
        gp2 = new Controller(gamepad2);

        waitForStart();
        telemetry.addLine("Initializing");
        telemetry.update();
        robot.imu.setStartingHeading();

        while (opModeIsActive()) {
            gp1.update();
            gp2.update();

            //-------------------------------------------------------------------------------------
            //                                  GAMEPAD 1
            //-------------------------------------------------------------------------------------

            double[] input = getInput();
            //robot.drive.FieldOrientedDrive(gp1.left_stick_x,gp1.left_stick_y,gp1.right_stick_x, robot.imu);
            robot.drive.calculateDrivePowers(gp1.left_stick_x,gp1.left_stick_y,gp1.right_stick_x);
            //-------------------------------------------------------------------------------------
            //                                  GAMEPAD 2
            //-------------------------------------------------------------------------------------
            //robot.launcher.launchArtifact(gp2.right_trigger, gp2.x,-gp1.left_stick_x,-gp1.left_stick_y, robot.drive, robot.imu, robot.cam, allianceTag);
            robot.launcher.launchArtifact(gp2.right_trigger, gp2.right_bumper, gp2.b);
            robot.intake.intake(gp2.left_trigger, gp2.left_bumper.pressing());
            if (gp2.x.pressing()){
                robot.intakeServo.close();
            }else{

                robot.intakeServo.open();
            }
            //-------------------------------------------------------------------------------------
            //                                  AUTOMATIC
            //-------------------------------------------------------------------------------------
            //robot.cameraServo.trackAprilTag(allianceTag, robot.cam);
            //-------------------------------------------------------------------------------------
            //                                  TELEMETRY
            //-------------------------------------------------------------------------------------
            //telemetry.addData("velocity: ",robot.launcher.getFlywheelVelocity());
            telemetry.addData("Power: ", robot.launcher.getFlywheelPower());
            telemetry.update();
        }
    }
    private double[] getInput() {
        if (gp1.dpad_right.pressing()) dpadCurrentWeight[0] = MathHelper.clamp(
                dpadCurrentWeight[0] + dpadWeightChangeRate, -dpadMaxWeight, dpadMaxWeight);
        else if (gp1.dpad_left.pressing()) dpadCurrentWeight[0] = MathHelper.clamp(
                dpadCurrentWeight[0] - dpadWeightChangeRate, -dpadMaxWeight, dpadMaxWeight);
        else {
            double startSign = Math.signum(dpadCurrentWeight[0]);
            dpadCurrentWeight[0] -= dpadWeightChangeRate * startSign;
            if (Math.signum(dpadCurrentWeight[0]) != startSign) dpadCurrentWeight[0] = 0;
        }


        if (gp1.dpad_up.pressing()) dpadCurrentWeight[1] = MathHelper.clamp(
                dpadCurrentWeight[1] + dpadWeightChangeRate, -dpadMaxWeight, dpadMaxWeight);
        else if (gp1.dpad_down.pressing()) dpadCurrentWeight[1] = MathHelper.clamp(
                dpadCurrentWeight[1] - dpadWeightChangeRate, -dpadMaxWeight, dpadMaxWeight);
        else {
            double startSign = Math.signum(dpadCurrentWeight[1]);
            dpadCurrentWeight[1] -= dpadWeightChangeRate * startSign;
            if (Math.signum(dpadCurrentWeight[1]) != startSign) dpadCurrentWeight[1] = 0;
        }

        double xInput = MathHelper.clamp(gp1.left_stick_x + dpadCurrentWeight[0], -1f, 1f);
        double yInput = MathHelper.clamp(gp1.left_stick_y - dpadCurrentWeight[1], -1f, 1f);

//        double xInput = MathHelper.clamp(
//                gp1.left_stick_x
//                        + (gp1.dpad_right.pressing() ? dpadCurrentWeight[0] : 0)
//                        - (gp1.dpad_left.pressing() ? dpadCurrentWeight[0] : 0),
//                -1f,
//                1f
//        );
//        double yInput = MathHelper.clamp(
//                gp1.left_stick_y
//                        - (gp1.dpad_up.pressing() ? dpadCurrentWeight[1] : 0)
//                        + (gp1.dpad_down.pressing() ? dpadCurrentWeight[1] : 0),
//                -1f,
//                1f
//        );
        double rotInput = gp1.right_stick_x;

        return new double[] {xInput, yInput, rotInput};
    }
}