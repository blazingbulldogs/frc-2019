/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class Wait extends Command {
  private int waitUntil = 0;
  private int ticksSeen = 0;

  public Wait(int ticks) {
    waitUntil = ticks;
  }

  @Override
  protected void execute() {
    super.execute();
    ticksSeen++;
  }

  @Override
  protected boolean isFinished() {
    return ticksSeen >= waitUntil;
  }

  @Override
  public void end() {
    ticksSeen = 0;
  }

  @Override
  protected void interrupted() {
    end();
  }
}
