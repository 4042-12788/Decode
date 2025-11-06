package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp
public class Tele extends LinearOpMode {
    Robot robot;
    Controller gp1;
    Controller gp2;
    public int allianceTag = 20;
    //for blue, for red its 24

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Robot(hardwareMap, telemetry);

        gp1 = new Controller(gamepad1);
        gp2 = new Controller(gamepad2);

        waitForStart();
        telemetry.addLine("Initializing");
        telemetry.update();
        robot.imu.startingHeading = robot.imu.heading(AngleUnit.RADIANS);

        while (opModeIsActive()){
            gp1.update();
            gp2.update();

            //-------------------------------------------------------------------------------------
            //                                  GAMEPAD 1
            //-------------------------------------------------------------------------------------

            robot.drive.FieldOrientedDrive(-gp1.left_stick_x, -gp1.left_stick_y, gp1.right_stick_x, robot.imu);

            //-------------------------------------------------------------------------------------
            //                                  GAMEPAD 2
            //-------------------------------------------------------------------------------------
            robot.launcher.launchArtifact(gp2.right_trigger, gp2.x,-gp1.left_stick_x,-gp1.left_stick_y, robot.drive, robot.imu, robot.cam, allianceTag);
            robot.intake.intake(gp2.left_trigger, gp2.left_bumper.pressing());
            //-------------------------------------------------------------------------------------
            //                                  AUTOMATIC
            //-------------------------------------------------------------------------------------
            robot.cameraServo.trackAprilTag(allianceTag, robot.cam);
            //-------------------------------------------------------------------------------------
            //                                  TELEMETRY
            //-------------------------------------------------------------------------------------

            telemetry.update();
        }
    }
}