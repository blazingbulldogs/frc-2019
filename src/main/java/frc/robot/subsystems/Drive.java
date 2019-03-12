/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
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

  public MecanumDrive robotDrive;

  private final Logger logger = new Logger();
  // Motor controllers
  public final WPI_VictorSPX victorRearRight = new WPI_VictorSPX(RobotMap.victorRearRight);
  public final WPI_VictorSPX victorRearLeft = new WPI_VictorSPX(RobotMap.victorRearLeft);
  public final WPI_TalonSRX talonFrontRight = new WPI_TalonSRX(RobotMap.talonFrontRight);
  public final WPI_TalonSRX talonFrontLeft = new WPI_TalonSRX(RobotMap.talonFrontLeft);

  /**
   * Set up motors and robot drive.
   */
  public Drive() {
    talonFrontLeft.set(ControlMode.PercentOutput, 0);
    talonFrontRight.set(ControlMode.PercentOutput, 0);
    victorRearLeft.set(ControlMode.PercentOutput, 0);
    victorRearRight.set(ControlMode.PercentOutput, 0);

    robotDrive = new MecanumDrive(talonFrontLeft, victorRearLeft, talonFrontRight, victorRearRight);

    Logger.tab.add("Mecanum Drive Train", robotDrive)
    .withSize(4, 2)
    .withPosition(0, 0)
    .withWidget(BuiltInWidgets.kMecanumDrive);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new ExampleCommand());

  }

  @Override
  public void periodic() {
    final DriveJoystick joystick = OperatorInput.driveJoystick;

    final double x = joystick.getScaledAxis(JoystickPorts.leftXAxis);
    final double y = -joystick.getScaledAxis(JoystickPorts.leftYAxis);
    final double z = joystick.getScaledAxis(JoystickPorts.rightXAxis);

    logger.logJoystick(joystick);
    robotDrive.driveCartesian(x, y, z);
  }

  public void stop() {
    robotDrive.driveCartesian(0, 0, 0);
  }
}
