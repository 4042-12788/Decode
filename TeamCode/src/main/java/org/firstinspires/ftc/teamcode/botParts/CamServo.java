package org.firstinspires.ftc.teamcode.botParts;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

public class CamServo {
    Servo cameraServo;
    //public static double robotBearing;
    public CamServo(HardwareMap hardwareMap, Telemetry telemetry){
        cameraServo = hardwareMap.get(Servo.class, " Cam Servo");
    }
//    public void trackAprilTag(int allianceTag, Camera camera){
//        if(!camera.tagProcessor.getDetections().isEmpty());{
//            AprilTagDetection tag = camera.tagProcessor.getDetections().get(allianceTag);
//            double error = (tag.ftcPose.bearing + 40)/80;
//            double power = 0.4;
//            if(error>0.45 && error<0.55) power = 0;
//            cameraServo.setPower(power * error);
//        }
//    }

    int allianceColorTag;
    public void runCamServo(boolean RED) {

        if(RED){
            allianceColorTag = 24;
        } else if (!RED) {
            allianceColorTag = 20;
        }
        cameraServo.setPosition(0.5);
        //moves the servo to face an apriltag so that the bearing is 0

        if(Camera.aprilTagBearing()!= 0 ) {
            if(!Camera.tagProcessor.getDetections().isEmpty() && Camera.aprilTagID() == allianceColorTag){
                //if(((cameraServo.getPosition() - 0.5) * 90) + (Camera.aprilTagBearing()) >= 0||cameraServo.getPosition() + (Camera.aprilTagBearing()/180)<1) {
                    cameraServo.setPosition(cameraServo.getPosition() + (Camera.aprilTagBearing() + 90) / 90);
                //} else if (Camera.aprilTagBearing()>0) {
                    //cameraServo.setPosition(1);
                //}else {
                    //cameraServo.setPosition(0);
                //}
            }else {
                cameraServo.setPosition(0);
                if (Camera.tagProcessor.getDetections().isEmpty() && Camera.aprilTagID() != allianceColorTag) {
                    cameraServo.setPosition(0.5);
                    if (Camera.tagProcessor.getDetections().isEmpty() && Camera.aprilTagID() != allianceColorTag) {
                        cameraServo.setPosition(1);
                    }
                }
            }
        }
        //robotBearing = ((cameraServo.getPosition() - 0.5) * 180) + Camera.aprilTagBearing;
    }
}