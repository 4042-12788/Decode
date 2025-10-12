package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class FlyWheel{
    private DcMotor flyWheel;
    PIDController control = new PIDController();
    public  FlyWheel(HardwareMap hardwareMap){
        flyWheel = hardwareMap.get(DcMotor.class, "Flywheel");
    }
    public void launchArtifact(boolean gp1a, double x, double y, MecanumDrive drive, InternalMeasurementUnit imu){
        if(gp1a){
            drive.calculateDrivePowers(x, y, control.pidOutput(imu.heading(AngleUnit.DEGREES) + CamServo.robotBearing, imu.heading(AngleUnit.DEGREES)));
            flyWheel.setPower(Camera.aprilTagRange/200);
        }else{
            flyWheel.setPower(0);
        }
    }
}
