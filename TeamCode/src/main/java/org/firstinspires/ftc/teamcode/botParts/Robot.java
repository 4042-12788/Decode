package org.firstinspires.ftc.teamcode.botParts;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Odometry.Odometry;
//import org.firstinspires.ftc.teamcode.Odometry.Odometry;

public class Robot {
    public HardwareMap hardwareMap;
    public Telemetry telemetry;
    public MecanumDrive drive;
    public Launcher launcher;
    //public CamServo cameraServo;
    public Intake intake;
    public InertialMeasurementUnit imu;
<<<<<<< HEAD
    //public Camera cam;
    public Odometry odo;
=======
    public Camera cam;
    //public Odometry odo;
>>>>>>> ffee39083e46610bcda865d1784e21521bdea0cb
    public IntakeServo intakeServo;

    public Robot(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        drive = new MecanumDrive(hardwareMap, telemetry);
        launcher = new Launcher(hardwareMap, telemetry);
        //cameraServo = new CamServo(hardwareMap, telemetry);
        intake = new Intake(hardwareMap, telemetry);
        imu = new InertialMeasurementUnit(hardwareMap, telemetry);
        cam = new Camera(hardwareMap, telemetry);
        //odo = new Odometry(hardwareMap, telemetry);
        intakeServo = new IntakeServo(hardwareMap, telemetry);
    }
    public void shutOff(){
        drive.calculateDrivePowers(0,0,0);
    }
}