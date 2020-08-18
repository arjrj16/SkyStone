package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

public class Week1Hardware {
    public DcMotor leftDrive = null; //motors
    public DcMotor rightDrive = null;

    public DistanceSensor sensorRange; //REV2mDistance

    public ColorSensor sensorColor; //REVColorDistance
    //if you want distance functionality add:    public DistanceSensor sensorDistance;

    public DigitalChannel digitalTouch; //RevTouchSensor

    HardwareMap hwMap           =  null; //sets up hardware map
    private ElapsedTime period  = new ElapsedTime(); //starts time elapse

    public Week1Hardware () {} //empyty constructor

    public void init (HardwareMap ahwMap)
    {
        hwMap = ahwMap; //initialize hwMap

        //motor assignments:
        leftDrive = hwMap.get(DcMotor.class, "motor_l");
        rightDrive = hwMap.get(DcMotor.class, "motor_r");

        sensorColor = hwMap.get(ColorSensor.class, "color_distance_sensor");

        sensorRange = hwMap.get(DistanceSensor.class, "distance_sensor");

        digitalTouch = hwMap.get(DigitalChannel.class, "touch_sensor");
        digitalTouch.setMode(DigitalChannel.Mode.INPUT); //just needed for it to run correctly

        //set motor direction
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE); //is this correct? I am not entirely sure which is supposed to go forward and backward
        //seems like they should both go forward and backward so it doesnt make a ton of sense.

        // Set motor power - don't want it to randomly spin up on start.
        leftDrive.setPower(0);
        rightDrive.setPower(0);

       //motor encoders:
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

}
