/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.cargo;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Robot;
import frc.robot.commands.solenoids.MoveDoubleSolenoid;

public class CargoDump extends MoveDoubleSolenoid {
  /**
   * Push Cargo Solenoid
   */
  public CargoDump(){
    super();
    requires(Robot.cargoSubsystem);
  }
  
  protected DoubleSolenoid sol() {
    return Robot.cargoSubsystem.solenoid;
  }

  protected Value val() {
    return Value.kReverse;
  }
}
