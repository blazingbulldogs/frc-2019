/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.solenoids;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.Wait;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class CargoRoutine extends CommandGroup {
  private Wait wait1 = new Wait(7);
  private Wait wait2 = new Wait(15);
  private Wait wait3 = new Wait(15);

  /**
   * Sequence of commands to dump cargo.
   */
  public CargoRoutine() {
    setTimeout(3.0);
    requires(Robot.hatchSubsystem);
    requires(Robot.cargoSubsystem);

    // Push hatch
    addSequential(new MoveDoubleSolenoid(Robot.hatchSubsystem.solenoid, Value.kReverse));

    // Wait 7 ticks
    addSequential(wait1);

    // Dump cargo
    addSequential(new MoveDoubleSolenoid(Robot.cargoSubsystem.solenoid, Value.kReverse));

    // Wait 15 ticks
    addSequential(wait2);

    // Pull hatch
    addSequential(new MoveDoubleSolenoid(Robot.hatchSubsystem.solenoid, Value.kForward));

    // Wait 15 ticks
    addSequential(wait3);
    
    // Reset cargo
    addSequential(new MoveDoubleSolenoid(Robot.cargoSubsystem.solenoid, Value.kForward));
  }

  private void reset() {
    wait1.reset();
    wait2.reset();
    wait3.reset();
  }

  @Override
  protected void end() {
    super.end();
    System.out.println("CargoRoutine done");
    reset();
  }
}
