package org.firstinspires.ftc.teamcode.botParts;

public void launchArtifact(double rTrig, Button rbump, Button farlauch){
        if(rTrig>0.05){
           flyWheel.setPower(0.8);
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
