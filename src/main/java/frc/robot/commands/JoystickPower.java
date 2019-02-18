/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.OperatorInput;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Add your docs here.
 */
public class JoystickPower extends InstantCommand {
  /**
   * Add your docs here.
   */
  boolean powerChange;
  public JoystickPower(boolean toSlow) {
    super();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    toSlow = powerChange;
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    if (powerChange = true){
      OperatorInput.power = 1;
    }
    if (powerChange = false){
      OperatorInput.power = 3;
    }
  }

}
