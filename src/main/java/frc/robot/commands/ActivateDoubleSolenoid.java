/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class ActivateDoubleSolenoid extends InstantCommand {
  private DoubleSolenoid sol;

  /**
   * Activate a solenoid.
   */
  public ActivateDoubleSolenoid(DoubleSolenoid toActivate) {
    super();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

    sol = toActivate;
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    sol.set(Value.kForward);
  }
}
