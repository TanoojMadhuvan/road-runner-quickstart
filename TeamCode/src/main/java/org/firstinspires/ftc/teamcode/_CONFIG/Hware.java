package org.firstinspires.ftc.teamcode._CONFIG;

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Hware {
    public Motor frontRight, frontLeft, backRight, backLeft;
    public Motor intake;
    public DcMotor horizontal1,horizontal2;
    public DcMotor vertical1, vertical2;
    public ServoEx vRot1, vRot2,clawRot,pR,pL, claw, vClaw;
    HardwareMap hardwareMap;

    public Hware() {
        hardwareMap = null;
    }
     public void initialize(HardwareMap hwMap){
        hardwareMap = hwMap;
        frontRight = new Motor(hardwareMap, "frontRight", Motor.GoBILDA.RPM_312);
        backRight = new Motor(hardwareMap, "backRight", Motor.GoBILDA.RPM_312);
        frontLeft = new Motor(hardwareMap, "frontLeft", Motor.GoBILDA.RPM_312);
        backLeft = new Motor(hardwareMap, "backLeft", Motor.GoBILDA.RPM_312);

         //intake = new Motor(hardwareMap, "intake", Motor.GoBILDA.RPM_312);


        horizontal1 = hardwareMap.get(DcMotor.class, "h1");
        horizontal2 = hardwareMap.get(DcMotor.class, "h2");
        vertical1 = hardwareMap.get(DcMotor.class, "v1");
        vertical2 = hardwareMap.get(DcMotor.class, "v2");
        pR = new SimpleServo(hardwareMap, "pR", 0, 240);
        pL = new SimpleServo(hardwareMap, "pL", 0, 240);
        claw= new SimpleServo(hardwareMap, "claw", 0, 240);
        vRot1= new SimpleServo(hardwareMap, "vRot1", 0, 240);
        vRot2= new SimpleServo(hardwareMap, "vRot2", 0, 240);
        clawRot= new SimpleServo(hardwareMap, "clawRot", 0, 240);
        vClaw= new SimpleServo(hardwareMap, "vClaw", 0, 240);

         // intake.setInverted(true);




        frontRight.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);



        horizontal1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        horizontal2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        horizontal1.setDirection(DcMotorSimple.Direction.REVERSE);

        horizontal1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        horizontal2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        vertical1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        vertical2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        horizontal1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        horizontal2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        vertical1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        vertical2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);





     }


}
