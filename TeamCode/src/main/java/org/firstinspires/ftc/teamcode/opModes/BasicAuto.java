package org.firstinspires.ftc.teamcode.opModes;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.botParts.Robot;

@Autonomous
public class BasicAuto extends LinearOpMode{
    ElapsedTime AutoTimer;
    Robot robot;
    @Override
    public void runOpMode() throws InterruptedException{
        robot = new Robot(hardwareMap, telemetry);
        AutoTimer = new ElapsedTime();
        while (AutoTimer.seconds()<27){}
        robot.drive.calculateDrivePowers(1,0,0);
        while (AutoTimer.seconds()<28){}
        robot.drive.calculateDrivePowers(0,0,0);
    }
}