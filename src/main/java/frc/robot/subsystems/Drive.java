/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import frc.robot.OperatorInput;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.structures.Config;
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
  public final Spark talonFrontLeft = new Spark(RobotMap.talonFrontLeft);
  public final Spark talonRearLeft = new Spark(RobotMap.talonRearLeft);
  SpeedControllerGroup leftSparks = new SpeedControllerGroup(talonFrontLeft, talonRearLeft);

  public final Spark talonFrontRight = new Spark(RobotMap.talonFrontRight);
  public final Spark talonRearRight = new Spark(RobotMap.talonRearRight);
  SpeedControllerGroup rightSparks = new SpeedControllerGroup(talonFrontRight, talonRearRight);
  /**
   * Set up motors and robot drive.
   */
  public Drive() {
    // talonFrontLeft.set(ControlMode.PercentOutput, 0);
    // talonFrontRight.set(ControlMode.PercentOutput, 0);
    // talonRearLeft.set(ControlMode.PercentOutput, 0);
    // talonRearRight.set(ControlMode.PercentOutput, 0);

    robotDrive = new DifferentialDrive(leftSparks, rightSparks);

    Logger.tab
      .add("Mecanum Drive Train", robotDrive)
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
    double angle = 0;
    boolean gyroDrive = false;

    if (Config.gyroSubsystemEnabled) {
      final Gyro gyro = Robot.gyroSubsystem;
      angle = gyro.ahrs.getAngle();
      gyroDrive = gyro.gyroDrive;
    }

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
