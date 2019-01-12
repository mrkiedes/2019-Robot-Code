/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.command_group;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveJackMotor;
import frc.robot.commands.LiftJacks;

public class AutoLift extends CommandGroup {
  /**
   * Add your docs here.
   */
  public AutoLift() {
    requires(Robot.jacks);
    requires(Robot.driveTrain);

    double liftTime = 3;
    double speed = 0.5;

    addParallel(new LiftJacks(RobotMap.frontRightJack, RobotMap.frontLeftJack, speed), liftTime);
    addParallel(new LiftJacks(RobotMap.backLeftJack, RobotMap.backRightJack, speed), liftTime);
    addSequential(new DriveJackMotor(RobotMap.frontJackLimitSwitch));
    addSequential(new LiftJacks(RobotMap.frontRightJack, RobotMap.frontLeftJack, -speed), liftTime);
    addParallel(new DriveJackMotor(RobotMap.backJackLimitSwitch));
    addSequential(new LiftJacks(RobotMap.backRightJack, RobotMap.backLeftJack, -speed), liftTime);
  }
}
