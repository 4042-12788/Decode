package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

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

        while (opModeIsActive()){
            gp1.update();
            gp2.update();

            //-------------------------------------------------------------------------------------
            //                                  GAMEPAD 1
            //-------------------------------------------------------------------------------------

            robot.drive.calculateDrivePowers(-gp1.left_stick_x, -gp1.left_stick_y, gp1.right_stick_x);

            //-------------------------------------------------------------------------------------
            //                                  GAMEPAD 2
            //-------------------------------------------------------------------------------------
            robot.launcher.launchArtifact(gp2.a.pressing(),-gp1.left_stick_x,-gp1.left_stick_y, robot.drive, robot.imu);
            robot.intake.intake(gp2.x.pressing(), gp2.b.pressing());
            //-------------------------------------------------------------------------------------
            //                                  AUTOMATIC
            //-------------------------------------------------------------------------------------
            //robot.cameraServo.runCamServo(RED);
            //-------------------------------------------------------------------------------------
            //                                  TELEMETRY
            //-------------------------------------------------------------------------------------

            telemetry.update();
        }
    }
}