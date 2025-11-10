
package org.firstinspires.ftc.teamcode.botParts;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class IntakeServo {
    private Servo IntakeServo;
    private boolean state = true;

    public IntakeServo(HardwareMap hardwareMap, Telemetry telemetry){
        IntakeServo = hardwareMap.get(Servo.class, " Intake Servo");


    }
//    public void nextState(){
//        if(state == true) {
//            IntakeServo.setDirection(Servo.Direction.REVERSE);
//            IntakeServo.setPosition(0);
//            state = false;
//        }
//        if(state == false){
//            IntakeServo.setDirection(Servo.Direction.FORWARD);
//            IntakeServo.setPosition(0.7);
//            state = true;
//        }
//
//    }


    public void open(){
        //IntakeServo.setDirection(Servo.Direction.REVERSE);
        IntakeServo.setPosition(0.34);
    }
    public void close(){
        //IntakeServo.setDirection(Servo.Direction.FORWARD);
        IntakeServo.setPosition(0.68);
    }
}


