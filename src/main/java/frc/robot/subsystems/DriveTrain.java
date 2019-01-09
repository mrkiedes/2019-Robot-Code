/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.CANTalon1989;
import frc.robot.JsScaled;
import frc.robot.commands.Drive;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  
  CANTalon1989 frontLeft;
  CANTalon1989 frontRight;
  CANTalon1989 backLeft;
  CANTalon1989 backRight;

  MecanumDrive mDrive;

  public DriveTrain(CANTalon1989 frontLeft, CANTalon1989 backLeft, CANTalon1989 frontRight, CANTalon1989 backRight) {
    this.frontLeft = frontLeft;
    this.backLeft = backLeft;
    this.frontRight = frontRight;
    this.backRight = backRight;
    mDrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
    mDrive.setSafetyEnabled(true);
  }


  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }

  public void drive(JsScaled joy) {
    double moveY = joy.sgetY();
    double moveX = -joy.sgetX();
    double moveTwist = -joy.sgetTwist();
    mDrive.driveCartesian(moveX, moveY, moveTwist);
  }

  public void stop() {
    frontLeft.set(0);
    frontRight.set(0);
    backLeft.set(0);
    backRight.set(0);
  }

}
