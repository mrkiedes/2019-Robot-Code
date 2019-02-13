/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.CANTalon1989;
import frc.robot.Robot;

public class MoveJacksOnButton extends Command {

  CANTalon1989 jack1;
  CANTalon1989 jack2;
  double jack1Speed;
  double jack2Speed;

  public MoveJacksOnButton(CANTalon1989 jack1, CANTalon1989 jack2, double jack1Speed, double jack2Speed) {
    // Use requires() here to declare subsystem dependencies
    this.jack1 = jack1;
    this.jack2 = jack2;
    this.jack1Speed = jack1Speed;
    this.jack2Speed = jack2Speed;
    requires(Robot.jacks);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.jacks.moveJacksOnButton(jack1, jack2, jack1Speed, jack2Speed);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.jacks.stopJacks();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
