package org.firstinspires.ftc.teamcode.botParts;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Storage {
    private DcMotor storageMotor;
    public Storage(HardwareMap hardwareMap, Telemetry telemetry){
        storageMotor = hardwareMap.get(DcMotor.class, "Storage");
    }
    public void store(boolean forward, boolean backward){
        if (forward){
            storageMotor.setPower(-1);
        } else if (backward) {
            storageMotor.setPower(1);
        } else {
            storageMotor.setPower(0);
        }
    }
}
