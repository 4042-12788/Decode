package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

public class InternalMeasurementUnit {
    private IMU imu;
    public  InternalMeasurementUnit(HardwareMap hardwareMap){
        imu = hardwareMap.get(IMU.class,"imu");
        RevHubOrientationOnRobot revOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.RIGHT
        );
        imu.initialize(new IMU.Parameters(revOrientation));
    }
    public double heading(){
        return imu.getRobotYawPitchRollAngles().getYaw();
    }
}
