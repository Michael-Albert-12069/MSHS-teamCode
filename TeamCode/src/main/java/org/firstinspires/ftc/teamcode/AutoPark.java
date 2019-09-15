
package org.firstinspires.ftc.teamcode;

/**
 * Created by michaelalbert on 10/15/17.
 */
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by michaelalbert on 10/14/17.
 */
@Autonomous(name = "Michael - Auto. Park", group = "Autonomous")
public class AutoPark extends LinearOpMode {
    private DcMotor leftmotor;
    private DcMotor rightmotor;
    private Servo armclaw;
    private int targetposition;

    @Override
    public void runOpMode() throws InterruptedException {

        leftmotor = hardwareMap.dcMotor.get("leftmotor");
        rightmotor = hardwareMap.dcMotor.get("rightmotor");
        leftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armclaw = hardwareMap.servo.get("armclaw");
        leftmotor.setDirection(DcMotor.Direction.REVERSE);


        waitForStart();

        double DRIVE_POWER = -.5;
        driveForward(DRIVE_POWER, 500);
        turnLeft(DRIVE_POWER, 500);
        driveForward(DRIVE_POWER, 250);
        double ZERO_SPEED = 00.00;
        stopDrive(ZERO_SPEED, 300);

    }

    public void closeServo(){
        armclaw.setPosition(0.33);
    }
    public void openServo(){
        armclaw.setPosition(0.05);
    }
    private void driveForward(double power, long time) throws InterruptedException {
        leftmotor.setPower(power);
        rightmotor.setPower(power);
        Thread.sleep(time);

    }
    private void turnLeft(double power, long time) throws InterruptedException {
        leftmotor.setPower(-power);
        rightmotor.setPower(power);
        Thread.sleep(time);
    }
    public void turnRight(double power, long time) throws InterruptedException {
        leftmotor.setPower(power);
        rightmotor.setPower(-power);
        Thread.sleep(time);
    }
    private void stopDrive(double power, long time) throws InterruptedException {
        leftmotor.setPower(power);
        rightmotor.setPower(power);
        Thread.sleep(time);
    }
}