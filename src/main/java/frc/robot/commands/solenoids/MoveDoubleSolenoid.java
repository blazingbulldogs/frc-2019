/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.solenoids;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.InstantCommand;
  
public class MoveDoubleSolenoid extends InstantCommand {
  private DoubleSolenoid sol;
  private Value val;

  /**
   * Move a double solenoid.
   */
  public MoveDoubleSolenoid(DoubleSolenoid toMove, Value value) {
    super();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    sol = toMove;
    val = value;
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    sol.set(val);
  }

}
