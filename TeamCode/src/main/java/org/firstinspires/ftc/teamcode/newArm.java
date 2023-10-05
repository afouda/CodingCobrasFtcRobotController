package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

@TeleOp (name = "newArm")
public class newArm extends LinearOpMode {

    private DcMotor arm = null;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        waitForStart();

        //moving arm
        double InitialPower = 0.0;
        double armStepUp = -0.005;
        double armStepDown = 0.005;

        arm = hardwareMap.get(DcMotor.class, "arm");
        arm.setDirection((DcMotorSimple.Direction.FORWARD));

        while (true) {

            if (gamepad2.dpad_up == true) {
                arm.setPower(armStepUp);
                armStepUp += armStepUp;

                telemetry.addData("Arm power up", arm.getPower());
                telemetry.addData("Game pad up", gamepad2.dpad_up);

            } else if (gamepad2.dpad_down == true) {

                arm.setPower(armStepDown);
                armStepDown += armStepDown;
                telemetry.addData("Arm power down", arm.getPower());
                telemetry.addData("Game pad down", gamepad2.dpad_down);
            } else {

                arm.setPower(0);
                armStepUp = -0.005;
                armStepDown = 0.005;
                telemetry.addData("Arm power up", arm.getPower());
                telemetry.addData("Game pad down", gamepad2.dpad_down);
                telemetry.addData("Game pad up", gamepad2.dpad_up);
            }


            telemetry.update();
        }

       /* while (true) {
            if (gamepad2.dpad_up == true) {
                arm.setPower(InitialPower + armStepUp);
                armStepUp += armStepUp;

                telemetry.addData("Arm power up", arm.getPower());
                telemetry.addData("Game pad up", gamepad2.dpad_up);
                telemetry.update();
            } else {
                arm.setPower(0);
                telemetry.addData("Game pad up", gamepad2.dpad_up);
                telemetry.update();
            }

            if (gamepad2.dpad_down == true) {
                arm.setPower(InitialPower + armStepDown);
                armStepDown += armStepDown;


                telemetry.addData("Arm power down", arm.getPower());
                telemetry.addData("Game pad down", gamepad2.dpad_down);
                telemetry.update();
            } else {
                arm.setPower(0);
                telemetry.addData("Game pad down", gamepad2.dpad_down);
                telemetry.update();
            }
        }*/
    }
}
