package org.firstinspires.ftc.teamcode.botParts;

<<<<<<< HEAD
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Launcher{
private DcMotor flyWheel;
    public Launcher(HardwareMap hardwareMap, Telemetry telemetry){
        flyWheel = hardwareMap.get(DcMotor.class, " flyWheel");


    }
    public void launchArtifact(double rTrig, Button rbump, Button farlauch){
        if(rTrig>0.05){
           flyWheel.setPower(0.8);
=======
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.logging.Handler;

public class Launcher {
    DcMotorEx flyWheel;
    public Launcher(HardwareMap hardwareMap, Telemetry telemetry){
        flyWheel = hardwareMap.get(DcMotorEx.class, "flyWheel");
    }

    public void launchArtifact(double rTrig, Button rbump, Button farlauch, double range) {
        if (rTrig > 0.05) {
            flyWheel.setVelocity((13.04876 * range) + 637.11234);
>>>>>>> ffee39083e46610bcda865d1784e21521bdea0cb
        } else if (rbump.pressing()) {
            flyWheel.setPower(-1);
        } else {
            flyWheel.setPower(0);
        }
        if (farlauch.pressing()) {
            flyWheel.setPower(1);
        }
    }
<<<<<<< HEAD
//    public double getFlywheelVelocity(){
//        return flyWheel.getVelocity();
//    }
    public double getFlywheelPower(){
        return flyWheel.getPower();
    }
    public void launchArtifact(){
        flyWheel.setPower(.8);
    }
    public void stop(){
        flyWheel.setPower(0);
    }

=======

    public double getFlywheelVelocity() {
        return flyWheel.getVelocity();
    }

    public double getFlywheelPower() {
        return flyWheel.getPower();
    }
}
>>>>>>> ffee39083e46610bcda865d1784e21521bdea0cb
    // motor power one is 1820 velocity

//    public void launchArtifact(double spinUp, Button launch, double x, double y, MecanumDrive drive, InertialMeasurementUnit imu, Camera camera, int tagID){
//        AprilTagDetection tag = camera.tagProcessor.getDetections().get(tagID);
//        if(spinUp>0.5){
//            drive.calculateDrivePowers(x, y, control.pidOutput(imu.heading(AngleUnit.DEGREES) + CamServo.robotBearing, imu.heading(AngleUnit.DEGREES)));
//            flyWheel.setPower(tag.ftcPose.bearing/200);
//        }else{
//            flyWheel.setPower(0);
//        }
//        if(launch.pressing()){
//            launchServo.setPosition(1);
//            launchServo.setPosition(0);
//        }
//    }

