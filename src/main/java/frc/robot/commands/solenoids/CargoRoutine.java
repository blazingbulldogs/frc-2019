/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.solenoids;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.Wait;

public class CargoRoutine extends CommandGroup {
  /**
   * Sequence of commands to dump cargo
   */
  public CargoRoutine() {

    addSequential(new HatchPush());

    addSequential(new Wait(0.25));

    addSequential(new CargoDump());

    addSequential(new Wait(0.5));

    addParallel(new CargoReset());
    addSequential(new HatchPull());

  }

}
