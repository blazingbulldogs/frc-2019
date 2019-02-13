/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Solenoids extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public final DoubleSolenoid doubleSolenoid1 = new DoubleSolenoid(RobotMap.doubleSolenoid1, RobotMap.doubleSolenoid2);

  public Solenoids() {
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new SolenoidTime(randomSolenoid1));
  }

}
