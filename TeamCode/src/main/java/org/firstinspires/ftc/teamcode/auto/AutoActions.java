package org.firstinspires.ftc.teamcode.auto;
import com.qualcomm.robotcore.util.ElapsedTime;


import org.firstinspires.ftc.teamcode.botParts.Robot;
import org.firstinspires.ftc.teamcode.auto.PIDController;
import org.firstinspires.ftc.teamcode.util.MathHelper;
import org.firstinspires.ftc.teamcode.util.TeleSingle;
import com.qualcomm.robotcore.hardware.DcMotor;




/*import static org.firstinspires.ftc.teamcode.control.cv.Camera.SPIKE_ZONE;
import static org.firstinspires.ftc.teamcode.control.presets.AutoPresets.centerBackDropPos;
import static org.firstinspires.ftc.teamcode.control.presets.AutoPresets.centerSpikePos;
import static org.firstinspires.ftc.teamcode.control.presets.AutoPresets.leftBackDropPos;
import static org.firstinspires.ftc.teamcode.control.presets.AutoPresets.leftSpikePos;
import static org.firstinspires.ftc.teamcode.control.presets.AutoPresets.rightBackDropPos;
import static org.firstinspires.ftc.teamcode.control.presets.AutoPresets.rightSpikePos;*/






public class AutoActions {


    private Robot robot;


    // identities
    public static final int DONE = -1;
    public static final int MOVE = 0;
    public static final int WAIT = 1;
    public static final int LAUNCH = 2;
    public static final int STOPOUT = 3;
    public static final int INTAKE = 4;
    public static final int STOPINT = 5;
    public static final int INTO = 6;
    public static final int CLOSE = 7;
    public static final int FORWARD = 8;
    public static final int BACK = 9;

    public static final int LEFT = 10;
    public static final int RIGHT = 11;
    public static final int TURNLEFT = 12;
    public static final int TURNRIGHT = 13;
    public static final int STOP = 14;

//        public static final int GRABBER = 2;
//        public static final int ARM = 3;


    private int identity;
    private boolean async;
    private boolean currentAction = false;
    private boolean endAction;


    private ElapsedTime timer;


    private String description;


    private double x;
    private double y;
    private double heading; // in degrees
    private double launchVel;


    private double waitTime;
    private double driveTime;
    private double rotTime;


    private int value;
    private int value2;


    private PIDController xPID;
    private PIDController yPID;
    private PIDController rotPID;


    private double[] pidOutput = new double[] {0,0,0};




    public AutoActions(int id, boolean async, Robot robot){
        this.async = async;
        init(id, robot);
    }


    //Used for id's: MOVE
    public AutoActions(int id, boolean async, Robot robot, double x, double y, double heading){
        this.async = async;
        this.x = x;
        this.y = y;
        this.heading = heading;


        xPID = new PIDController(this.x, false);
        yPID = new PIDController(this.y, false);
        rotPID = new PIDController(this.heading, true);


        init(id, robot);
    }


    //Used for id's: WAIT, LAUNCH, STOP, INTAKE, STOPINT, INTO, CLOSE
    public AutoActions(int id, boolean async, Robot robot, double value){
        this.async = async;
        if (id == WAIT) waitTime = value;
        if (id == FORWARD) driveTime = value;
        if (id == BACK) driveTime = value;
        if (id == RIGHT) driveTime = value;
        if (id == LEFT) driveTime = value;
        if (id == TURNRIGHT || id == TURNLEFT) rotTime = value;
        if (id == LAUNCH) launchVel = value;



        init(id, robot);
    }





    //Used for id's: ARM
//        public AutoActions(int id, boolean async, Robot robot, int value){
//            this.async = async;
//            if (id == ARM) this.value = value;
//            init(id, robot);
//        }


    //Used for id's: GRABBER
//        public AutoActions(int id, boolean async, Robot robot, int value, int  value2){
//            this.async = async;
//            if (id == GRABBER) {
//                this.value = value;
//                this.value2 = value2;
//            }
//            init(id, robot);
//        }


    private void init(int id, Robot robot) {
        this.identity = id;
        this.robot = robot;
        timer = new ElapsedTime();
    }


    /**
     * Driving the rob
     */
    private void moveTo(){
        initAction();


        double[] currentPos = robot.odo.getPosition();


        double PIDRampLimit = timer.seconds() * 3;


        TeleSingle.tele.clear();
        //TeleSingle.tele.addLine("X---------------|");
        double outputX = MathHelper.clamp(xPID.getPIDOutput(currentPos[0]), -PIDRampLimit, PIDRampLimit);
        //TeleSingle.tele.addLine("Y---------------|");
        double outputY = MathHelper.clamp(yPID.getPIDOutput(currentPos[1]), -PIDRampLimit, PIDRampLimit);
        //TeleSingle.tele.addLine("ROT-------------|");
        double outputRot = MathHelper.clamp(rotPID.getPIDOutput(currentPos[2]), -PIDRampLimit, PIDRampLimit);
        TeleSingle.tele.update();


        pidOutput = new double[] {outputX, -outputY, outputRot};


        boolean hasArrived = xPID.hasArrived() && yPID.hasArrived() && rotPID.hasArrived();


        if (!hasArrived) robot.drive.calculateDrivePowers(outputX, -outputY, outputRot);
        else robot.drive.calculateDrivePowers(0, 0, 0);


        boolean timeOut = timer.milliseconds() > 10000;
        endAction = hasArrived || timeOut;
    }




    /**
     * waits out timer until timer is greater than or equal to the parameter wait time
     */
    private void waiting() {
        initAction();


        robot.drive.calculateDrivePowers(0,0,0);


        endAction = timer.milliseconds() > (waitTime * 1000);
    }

    private void launch(){
        initAction();
        robot.launcher.launchArtifact(launchVel);

        endAction = timer.milliseconds() > (5 * 1000);
    }
    private void endOuttake(){
        initAction();
        robot.launcher.stop();
        endAction = timer.milliseconds() > (5 * 1000);
    }

    private void intake(){
        initAction();
        robot.intake.intake();
        endAction = timer.milliseconds() > (5 * 1000);
    }
    private void stopIntake(){
        initAction();
        robot.intake.stop();
        endAction = timer.milliseconds() > (5 * 1000);
    }

    private void intoOut(){
        initAction();
        robot.intakeServo.close();
        endAction = timer.milliseconds() > (1 * 1000);
    }
    private void closeOut(){
        initAction();
        robot.intakeServo.open();
        endAction = timer.milliseconds() > (1 * 1000);

    }
    private void TurnRight(){
        initAction();
        robot.drive.setDrivePowers(1,1,1,1);
        endAction = timer.milliseconds() > (rotTime * 1000);

    }
    private void TurnLeft(){
        initAction();
        robot.drive.setDrivePowers(-1,-1,-1,-1);
        endAction = timer.milliseconds() > (rotTime * 1000);

    }
    private void Left(){
        initAction();
        robot.drive.setDrivePowers(-1,1,1,-1);
        endAction = timer.milliseconds() > (driveTime * 1000);

    }
    private void Right(){
        initAction();
        robot.drive.setDrivePowers(1,-1,-1,1);
        endAction = timer.milliseconds() > (driveTime * 1000);

    }
    private void Forward(){
        initAction();
        robot.drive.setDrivePowers(1,1,-1,-1);
        endAction = timer.milliseconds() > (driveTime * 1000);

    }
    private void Back(){
        initAction();
        robot.drive.setDrivePowers(-1,-1,1,1);
        endAction = timer.milliseconds() > (driveTime * 1000);

    }
    private void stop(){
        initAction();
        robot.drive.setDrivePowers(0,0,0,0);
        endAction = timer.milliseconds() > (.5 * 1000);
    }

//        private void armPos() {
//            if (!currentAction) robot.arm.setAutoMove(value);
//
//            initAction();
//
//            endAction = robot.arm.autoMove();
//        }
//        //Sets grabber and grabberRot to specified state and ends when both reach their target position
//
//        private void grabberState() {
//            initAction();
//
//            robot.grabber.setGrabberState(value == 1, value2);
//
//            endAction = true;
//        }


    private void setEndAutoState(){
        robot.shutOff();
    }


    /**
     * @return whether or not this action has been completed
     */
    public boolean isFinished(){
        return endAction;
    }


    /**
     * determines the action and what this specific action will do.
     */
    public void runAction(){
        switch (identity){
            case DONE:
                setEndAutoState();
                break;
            case MOVE:
                moveTo();
                break;
            case WAIT:
                waiting();
                break;
            case LAUNCH:
                launch();
                break;
            case STOPOUT:
                endOuttake();
                break;
            case INTAKE:
                intake();
                break;
            case STOPINT:
                stopIntake();
                break;
            case INTO:
                intoOut();
                break;
            case CLOSE:
                closeOut();
                break;
            case FORWARD:
                Forward();
                break;
            case BACK:
                Back();
                break;
            case LEFT:
                Left();
                break;
            case RIGHT:
                Right();
                break;
            case TURNLEFT:
                TurnLeft();
                break;
            case TURNRIGHT:
                TurnRight();
                break;
            case STOP:
                stop();
                break;



//                case GRABBER:
//                    grabberState();
//                    break;
//                case ARM:
//                    armPos();
//                    break;
        }
    }


    /**
     * helper method to get telemetry text
     */
    public String getDescription() {
        String description = "id: " + identity + "; ";
        switch (identity){
            case DONE:
                description += "Done!";
                break;
            case MOVE:
                description += "Moving to target pos: {"+x+", "+y+", "+heading+"}";
                if (currentAction) description += "; PID output: {"
                        + MathHelper.round100(pidOutput[0]) + ", "
                        + MathHelper.round100(pidOutput[1]) + ", "
                        + MathHelper.round100(pidOutput[2]) + "}";
                break;
            case WAIT:
                description += "Waiting for "
                        + (currentAction ? MathHelper.round100(timer.milliseconds() / 1000) : 0)
                        +  " / " + waitTime + " seconds.";
                break;
//                case GRABBER:
//                    description += "Setting Grabber Open: " + (value == 1) + " | Rot State: " + value2;
//                    break;
//                case ARM:
//                    description += "Moving Arm to PosID: " + value;
//                    break;
        }


        return description;
    }


    public int getIdentity() { return identity; }
    public boolean getAsync() { return async; }


    private void initAction(){
        if (!currentAction){
            timer.reset();
            currentAction = true;
        }
    }


//    private void checkXSign(){
//        if (!robot.RED)
//            this.x *= -1;
//
//    }
//
//    public int getTimer() {
//        return (int) (timer.milliseconds() / 1000);
//    }
}
