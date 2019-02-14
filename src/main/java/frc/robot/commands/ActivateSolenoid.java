/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class ActivateSolenoid extends InstantCommand {
  private Solenoid sol;

  /**
   * Activate a solenoid.
   */
  public ActivateSolenoid(Solenoid toActivate) {
    super();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

    sol = toActivate;
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    sol.set(true);
  }
}
