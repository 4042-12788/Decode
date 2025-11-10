package org.firstinspires.ftc.teamcode.botParts;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class InertialMeasurementUnit {
    private IMU imu;
    public double startingHeading;
    public InertialMeasurementUnit(HardwareMap hardwareMap, Telemetry telemetry){
        imu = hardwareMap.get(IMU.class,"imu");
        RevHubOrientationOnRobot revOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
                RevHubOrientationOnRobot.UsbFacingDirection.UP
        );
        imu.initialize(new IMU.Parameters(revOrientation));
    }
    public double heading(AngleUnit angleUnit){
        if(angleUnit == AngleUnit.RADIANS) {
            return (imu.getRobotYawPitchRollAngles().getYaw(angleUnit) - startingHeading);
        } else {
            return (imu.getRobotYawPitchRollAngles().getYaw(angleUnit) - Math.toDegrees(startingHeading));
        }

    }
    public void setStartingHeading(){
        startingHeading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
    }
}

