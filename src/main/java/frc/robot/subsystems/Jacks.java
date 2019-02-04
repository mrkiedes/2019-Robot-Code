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
import frc.robot.RobotMap;
import frc.robot.commands.LiftJacks;

/**
 * Add your docs here.
 */
public class Jacks extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private CANTalon1989 motor;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
  }

  public void driveForward(CANTalon1989 motor, double speed) {
    this.motor = motor;
    motor.set(speed);
  }

  public boolean checkLimitSwitch(DigitalInput limitSwitch) {
    if(limitSwitch.get()) {
      return false;
    } else {
      return true;
    }
  }

  public void moveJacks(CANTalon1989 motor, double speed) {
    this.motor = motor;
    motor.set(speed);
  }

  public void stop() {
    motor.set(0);
  }

}
