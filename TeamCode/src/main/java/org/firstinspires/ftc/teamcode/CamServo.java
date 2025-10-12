package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class CamServo {
    final int blueGoalTag = 20;
    final int redGoalTag = 24;
    int allianceColorTag;
    Servo cameraServo;
    public static double robotBearing;
    public CamServo(HardwareMap hardwareMap){
        cameraServo = hardwareMap.get(Servo.class, " Cam Servo");
    }
    public void runCamServo(boolean RED) {
        if(RED){
            allianceColorTag = redGoalTag;
        } else if (!RED) {
            allianceColorTag = blueGoalTag;
        }
        cameraServo.setPosition(0.5);
        //moves the servo to face an apriltag so that the bearing is 0

        if(Camera.aprilTagBearing != 0 ) {
            if(!Camera.tagProcessor.getDetections().isEmpty() && Camera.aprilTagID == allianceColorTag){
                if(cameraServo.getPosition() + (Camera.aprilTagBearing/180) >= 0||cameraServo.getPosition() + (Camera.aprilTagBearing/180)<1) {
                    cameraServo.setPosition(cameraServo.getPosition() + (Camera.aprilTagBearing/180));
                } else if (Camera.aprilTagBearing>0) {
                    cameraServo.setPosition(1);
                }else {
                    cameraServo.setPosition(0);
                }
            }else {
                cameraServo.setPosition(0);
                if (Camera.tagProcessor.getDetections().isEmpty() && Camera.aprilTagID != allianceColorTag) {
                    cameraServo.setPosition(0.5);
                    if (Camera.tagProcessor.getDetections().isEmpty() && Camera.aprilTagID != allianceColorTag) {
                        cameraServo.setPosition(1);
                    }
                }
            }
        }
        robotBearing = ((cameraServo.getPosition() - 0.5) * 180) + Camera.aprilTagBearing;
    }
}