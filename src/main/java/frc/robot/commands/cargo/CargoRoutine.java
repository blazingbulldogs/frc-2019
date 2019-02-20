/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.cargo;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.Wait;
import frc.robot.commands.hatch.HatchPull;
import frc.robot.commands.hatch.HatchPush;

public class CargoRoutine extends CommandGroup {
  /**
   * Sequence of commands to dump cargo.
   */
  public CargoRoutine() {
    setTimeout(3.0);

    addSequential(new HatchPush());

    addSequential(new Wait(7));

    addSequential(new CargoDump());

    addSequential(new Wait(15));

    addSequential(new HatchPull());
    addSequential(new Wait(25));
    addSequential(new CargoReset());
    
  }
}
