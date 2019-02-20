/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.jetson.JetsonPowerDefault;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;

/**
 * Add your docs here.
 */
public class Jetson extends Subsystem {
  public final Relay relay = new Relay(RobotMap.jetsonRelay);

  /*
    kOff - Turns both relay outputs off
    kForward - Sets the relay to forward (M+ @ 12V, M- @ GND)
    kReverse - Sets the relay to reverse (M+ @ GND, M- @ 12V)
    kOn - Sets both relay outputs on (M+ @ 12V, M- @ 12V).
  */

  public void powerDefault(){
    relay.set(Value.kOff);
  }

  public void powerOn(){
    relay.set(Value.kForward);
  }

  public void powerCycle(){
    relay.set(Value.kReverse);
  }


  @Override
  public void initDefaultCommand() {
     setDefaultCommand(new JetsonPowerDefault());
  }
}
