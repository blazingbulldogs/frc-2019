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

  private Wait wait1 = new Wait(7);
  private Wait wait2 = new Wait(15);
  private Wait wait3 = new Wait(15);

  public CargoRoutine() {
    setTimeout(3.0);

    addSequential(new HatchPush());

    addSequential(wait1);

    addSequential(new CargoDump());

    addSequential(wait2);

    addSequential(new HatchPull());
    addSequential(wait3);
    addSequential(new CargoReset());
  }

  private void reset(){
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
