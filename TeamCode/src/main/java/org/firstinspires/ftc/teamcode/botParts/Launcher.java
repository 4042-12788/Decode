package org.firstinspires.ftc.teamcode.botParts;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Launcher{
private DcMotorEx flyWheel;
//private PIDFCoefficients PIDF = new PIDFCoefficients(1,0,0,18);
    public Launcher(HardwareMap hardwareMap, Telemetry telemetry){
        flyWheel = hardwareMap.get(DcMotorEx.class, " flyWheel");
        flyWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //flyWheel.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER,PIDF);

    }
    public void launchArtifact(double rTrig, Button rbump, Button farlauch, double range){
        if(rTrig>0.05){
            //flyWheel.setPower(0.8);
            //flyWheel.setVelocity(1000);
            flyWheel.setVelocity((3.04876 * range) + 637.11234 + 80);
        } else if (rbump.pressing()) {
            flyWheel.setPower(-1);
        } else {
            flyWheel.setPower(0);
        }
        if (farlauch.pressing()){
            flyWheel.setPower(1);
        }
    }
    public double getFlywheelVelocity(){
        return flyWheel.getVelocity();
    }
    public double getFlywheelPower(){
        return flyWheel.getPower();
    }
    public void launchArtifact(double launchSpeed){
        flyWheel.setPower(launchSpeed);
    }
    public void stop(){
        flyWheel.setPower(0);
    }

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
}
