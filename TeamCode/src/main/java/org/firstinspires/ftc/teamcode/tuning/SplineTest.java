package org.firstinspires.ftc.teamcode.tuning;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.TankDrive;

public final class SplineTest extends LinearOpMode {

    public class PrintSomething implements Action{
        private int val = 0;

        public PrintSomething(){

        }

        public PrintSomething(int value){
            val = value;
        }


        public boolean run(@NonNull TelemetryPacket packet){
            telemetry.addLine("Action Actually Actioning: " + val);
            telemetry.update();
            val ++;
            return val < 10;
        }

        public Action printSomething(){
            return new PrintSomething(val);
        }
    }

    public class PrintSomethingElse implements Action{
        private int val = 0;
        public boolean run(@NonNull TelemetryPacket packet){
            telemetry.addLine("New Actioning: " + val);
            telemetry.update();
            val ++;
            return val < 10;
        }

        public Action printSomethingElse(){
            return new PrintSomethingElse();
        }
    }

    @Override
    public void runOpMode() throws InterruptedException {

        telemetry.addLine("Inside");
        telemetry.update();

        Pose2d beginPose = new Pose2d(0, 0, 0);
        if (TuningOpModes.DRIVE_CLASS.equals(MecanumDrive.class)) {
            telemetry.addLine("Inside Actual");
            telemetry.update();
            MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);

            telemetry.addLine("Mecanum instantiated");
            telemetry.update();

            waitForStart();

            telemetry.addLine("Started");
            telemetry.update();

            PrintSomething pdemo1 = new PrintSomething();
            PrintSomethingElse pdemo2 = new PrintSomethingElse();

            Actions.runBlocking(
                    drive.actionBuilder(beginPose).lineToX(37).build()

            );

            telemetry.addLine("Done");
            telemetry.update();

        }
        else if (false && TuningOpModes.DRIVE_CLASS.equals(MecanumDrive.class)) {
            telemetry.addLine("Inside 2");
            telemetry.update();
            MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);

            telemetry.addLine("Mecanum instantiated");
            telemetry.update();

            waitForStart();

            telemetry.addLine("Started");
            telemetry.update();

            Actions.runBlocking(
                drive.actionBuilder(beginPose)
                        .splineTo(new Vector2d(30, 30), Math.PI / 2)
                        .splineTo(new Vector2d(0, 60), Math.PI)
                        .build());

            telemetry.addLine("Done");
            telemetry.update();

        } else if (TuningOpModes.DRIVE_CLASS.equals(TankDrive.class)) {
            telemetry.addLine("Should not be here");
            telemetry.update();
            TankDrive drive = new TankDrive(hardwareMap, beginPose);

            waitForStart();

            Actions.runBlocking(
                    drive.actionBuilder(beginPose)
                            .splineTo(new Vector2d(30, 30), Math.PI / 2)
                            .splineTo(new Vector2d(0, 60), Math.PI)
                            .build());
        } else {
            throw new RuntimeException();
        }

        telemetry.addLine("Completed");
        telemetry.update();
    }
}
