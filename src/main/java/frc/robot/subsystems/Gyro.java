/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.OperatorInput;
import frc.robot.structures.JoystickPorts;

public class Gyro extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public AHRS ahrs;
  public boolean gyroDrive = false;

  /**
   * NavX gyroscope.
   */
  public Gyro() {
    ahrs = new AHRS(SerialPort.Port.kUSB1);

    Shuffleboard.getTab("Driving").add("Gyro", ahrs).withWidget(BuiltInWidgets.kGyro);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  public void periodic() {
    gyroDrive = OperatorInput.driveJoystick.getRawButtonPressed(JoystickPorts.bButton);
  }
}
