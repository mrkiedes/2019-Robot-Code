/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.CANTalon1989;
import frc.robot.JsScaled;
import frc.robot.RobotMap;
import frc.robot.commands.*;

/**
 * Add your docs here.
 */
public class Jacks extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private CANTalon1989 motor;

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveJackMotor());
  }

  public void driveForward(CANTalon1989 motor, double speed) {
    this.motor = motor;
    motor.set(speed);
  }

  public void moveJacks(JsScaled joystick) {
    RobotMap.jackDrivenMotor.set(joystick.sgetY());
  }


  public boolean checkLimitSwitch(DigitalInput limitSwitch) {
    if(limitSwitch.get()) {
      return false;
    } else {
      return true;
    }
  }

  public void moveJacksAuto(CANTalon1989 motor, double speed) {
    this.motor = motor;
    motor.set(speed);
  }

  public void stopMotor() {
    motor.set(0);
  }

  public void moveJacksOnButton(CANTalon1989 jack1, CANTalon1989 jack2, double jack1Speed, double jack2Speed) {
    jack1.set(jack1Speed);
    jack2.set(jack2Speed);
  }

  public void stopJacks() {
    RobotMap.backJack.set(0);
    RobotMap.frontJack.set(0);
  }

}
