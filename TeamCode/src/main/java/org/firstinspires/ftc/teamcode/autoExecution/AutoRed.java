package org.firstinspires.ftc.teamcode.autoExecution;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


import org.firstinspires.ftc.teamcode.auto.AutoActionHandler;


import org.firstinspires.ftc.teamcode.botParts.Robot;
import org.firstinspires.ftc.teamcode.util.MathHelper;
import org.firstinspires.ftc.teamcode.util.TeleSingle;

import static org.firstinspires.ftc.teamcode.auto.AutoActions.BACK;
import static org.firstinspires.ftc.teamcode.auto.AutoActions.FORWARD;
import static org.firstinspires.ftc.teamcode.auto.AutoActions.INTAKE;
import static org.firstinspires.ftc.teamcode.auto.AutoActions.INTO;
import static org.firstinspires.ftc.teamcode.auto.AutoActions.LAUNCH;
import static org.firstinspires.ftc.teamcode.auto.AutoActions.LEFT;
import static org.firstinspires.ftc.teamcode.auto.AutoActions.MOVE;
import static org.firstinspires.ftc.teamcode.auto.AutoActions.RIGHT;
import static org.firstinspires.ftc.teamcode.auto.AutoActions.STOP;
import static org.firstinspires.ftc.teamcode.auto.AutoActions.STOPINT;
import static org.firstinspires.ftc.teamcode.auto.AutoActions.STOPOUT;
import static org.firstinspires.ftc.teamcode.auto.AutoActions.TURNLEFT;
import static org.firstinspires.ftc.teamcode.auto.AutoActions.WAIT;
import static org.firstinspires.ftc.teamcode.auto.AutoActions.CLOSE;






//import org.firstinspires.ftc.teamcode.bot.Robot;


@Autonomous
public class AutoRed extends LinearOpMode {
    Robot robot;
    AutoActionHandler actionHandler;


    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Robot(hardwareMap, telemetry);


        TeleSingle.init(telemetry);


        actionHandler = new AutoActionHandler(robot, telemetry);


        //  actionHandler.add(WAIT,false,1);
        actionHandler.add(BACK,false,.85);
        actionHandler.add(STOP,false);
//        actionHandler.add(BACK,false,1);
        actionHandler.add(LAUNCH, false, 1092);

        actionHandler.add(INTO, false);
        actionHandler.add(CLOSE, false);
        actionHandler.add(STOPOUT, false);

        actionHandler.add(TURNLEFT,false,.23 );
        actionHandler.add(FORWARD,false,.8);
        actionHandler.add(STOP,false);
//        actionHandler.add(INTAKE, false);
//        actionHandler.add(STOPINT, false);



//        actionHandler.add(MOVE,false, 0, 0, 20);




        //actionHandler.add(MOVE,false, MathHelper.tilesToMM(.25), MathHelper.tilesToMM(-.25), 300);
        //        actionHandler.add(WAIT,false,0.25);
//        actionHandler.add(MOVE,false, MathHelper.tilesToMM(1), MathHelper.tilesToMM(1), 120);
//        actionHandler.add(WAIT,false,0.25);
//        actionHandler.add(MOVE,false, MathHelper.tilesToMM(0.5), MathHelper.tilesToMM(0.5), -240);




//        actionHandler.add(MOVE,false, 0, MathHelper.tilesToMM(2), 0);


        actionHandler.init();


        waitForStart();


        while (opModeIsActive()){
            actionHandler.run();


            //robot.positionTelemetry();


            telemetry.update();
        }
    }
}
