//package org.firstinspires.ftc.teamcode.autoExecution;
//
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//
//
//import org.firstinspires.ftc.teamcode.auto.AutoActionHandler;
//
//
//import org.firstinspires.ftc.teamcode.botParts.Robot;
//import org.firstinspires.ftc.teamcode.util.MathHelper;
//import org.firstinspires.ftc.teamcode.util.TeleSingle;
//import static org.firstinspires.ftc.teamcode.auto.AutoActions.MOVE;
//import static org.firstinspires.ftc.teamcode.auto.AutoActions.WAIT;
//
//
//
//
//
//
////import org.firstinspires.ftc.teamcode.bot.Robot;
//
//
//@Autonomous
//public class AutoTest extends LinearOpMode {
//    Robot robot;
//    AutoActionHandler actionHandler;
//
//
//    @Override
//    public void runOpMode() throws InterruptedException {
//        robot = new Robot(hardwareMap, telemetry);
//
//
//        TeleSingle.init(telemetry);
//
//
//        actionHandler = new AutoActionHandler(robot, telemetry);
//
//
//        actionHandler.add(WAIT,false,0.33);
////        actionHandler.add(MOVE,false, 0, 0, 20);
//
//
//
//
//        actionHandler.add(MOVE,false, MathHelper.tilesToMM(.25), MathHelper.tilesToMM(-.25), 300);
//        //        actionHandler.add(WAIT,false,0.25);
////        actionHandler.add(MOVE,false, MathHelper.tilesToMM(1), MathHelper.tilesToMM(1), 120);
////        actionHandler.add(WAIT,false,0.25);
////        actionHandler.add(MOVE,false, MathHelper.tilesToMM(0.5), MathHelper.tilesToMM(0.5), -240);
//
//
//
//
////        actionHandler.add(MOVE,false, 0, MathHelper.tilesToMM(2), 0);
//
//
//        actionHandler.init();
//
//
//        waitForStart();
//
//
//        while (opModeIsActive()){
//            actionHandler.run();
//
//
//            //robot.positionTelemetry();
//
//
//            telemetry.update();
//        }
//    }
//}
