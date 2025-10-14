package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

public class Launcher {
    private DcMotor flyWheel;
    private Servo launchServo;
    private PIDController control = new PIDController();

    public Launcher(HardwareMap hardwareMap, Telemetry telemetry){
        flyWheel = hardwareMap.get(DcMotor.class, "Flywheel");
        launchServo = hardwareMap.get(Servo.class, "Launch Servo");
        control.setP(0);
        control.setI(0);
        control.setD(0);
    }
    public void launchArtifact(double spinUp, Button launch, double x, double y, MecanumDrive drive, InternalMeasurementUnit imu, Camera camera, int tagID){
        AprilTagDetection tag = camera.tagProcessor.getDetections().get(tagID);
        if(spinUp>0.5){
            drive.calculateDrivePowers(x, y, control.pidOutput(imu.heading(AngleUnit.DEGREES) + CamServo.robotBearing, imu.heading(AngleUnit.DEGREES)));
            flyWheel.setPower(tag.ftcPose.bearing/200);
        }else{
            flyWheel.setPower(0);
        }
        if(launch.pressing()){
            launchServo.setPosition(1);
            launchServo.setPosition(0);
        }
    }
}
