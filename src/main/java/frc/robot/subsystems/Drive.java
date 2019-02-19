/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import frc.robot.OperatorInput;
import frc.robot.RobotMap;
import frc.robot.structures.DriveJoystick;
import frc.robot.structures.JoystickPorts;
import frc.robot.structures.Logger;

/**
 * Driving subsystem that controls motors.
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public DifferentialDrive robotDrive;

  private final Logger logger = new Logger();

  // Motor controllers
  public final Spark sparkFrontLeft = new Spark(RobotMap.sparkFrontLeft);
  public final Spark sparkRearLeft = new Spark(RobotMap.sparkRearLeft);
  SpeedControllerGroup leftSparks = new SpeedControllerGroup(sparkFrontLeft, sparkRearLeft);

  public final Spark sparkFrontRight = new Spark(RobotMap.sparkFrontRight);
  public final Spark sparkRearRight = new Spark(RobotMap.sparkRearRight);
  SpeedControllerGroup rightSparks = new SpeedControllerGroup(sparkFrontRight, sparkRearRight);
  /**
   * Set up motors and robot drive.
   */
  public Drive() {
    robotDrive = new DifferentialDrive(leftSparks, rightSparks);

    Logger.tab
      .add("Differential Drive Train", robotDrive)
      .withSize(4, 2)
      .withPosition(0, 0)
      .withWidget(BuiltInWidgets.kDifferentialDrive);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new ExampleCommand());
  }

  @Override
  public void periodic() {
    final DriveJoystick joystick = OperatorInput.driveJoystick;

    final double y = -joystick.getScaledAxis(JoystickPorts.leftYAxis);
    final double z = joystick.getScaledAxis(JoystickPorts.rightXAxis);

    logger.logJoystick(joystick);

    robotDrive.arcadeDrive(y, z);
  }

  public void stop() {
    robotDrive.arcadeDrive(0, 0);
  }
}
