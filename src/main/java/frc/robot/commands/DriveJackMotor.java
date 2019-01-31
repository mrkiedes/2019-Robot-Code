/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.DigitalInput;

public class DriveJackMotor extends Command {

  DigitalInput limitSwitch;
  double speed;

  public DriveJackMotor(DigitalInput limitSwitch, double speed) {
    requires(Robot.jacks);
    this.limitSwitch = limitSwitch;
    this.speed = speed;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.jacks.driveForward(speed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.jacks.checkLimitSwitch(limitSwitch);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.jacks.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
