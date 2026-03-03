// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.SnowPlowConstants;
import frc.robot.subsystems.SnowPlowSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class LaunchSequenceCommand extends SequentialCommandGroup {
  /** Creates a new LaunchSequenceCommand. */
  public LaunchSequenceCommand(SnowPlowSubsystem m_intake) {
      addCommands(
        new SpinUpCommand(m_intake).withTimeout(SnowPlowConstants.kSpinUpSeconds),
        new LaunchCommand(m_intake));
   
  }

}