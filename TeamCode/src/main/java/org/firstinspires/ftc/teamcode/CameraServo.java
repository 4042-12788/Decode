package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.Servo;

public class CameraServo{
    final int blueGoalTag = 20;
    final int redGoalTag = 24;
    int allianceColorTag;
    Servo cameraServo;
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
                if(cameraServo.getPosition() + (Camera.aprilTagBearing/180) >= 0) {
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
    }
}