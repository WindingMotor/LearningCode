
package frc.robot.commands
import edu.wpi.first.wpilibj2.command.CommandBase
import edu.wpi.first.wpilibj2.command.button.CommandXboxController
import frc.robot.subsystems.ExampleSubsystem
import frc.robot.subsystems.DriveSubsystem

class XboxDrive(
    private val subsystem: DriveSubsystem,
    private val xbox: CommandXboxController
):CommandBase() {
    
    init {
        addRequirements(subsystem)
    }

    override fun initialize(){} 

    override fun execute(){
        subsystem.drive(xbox.getRawAxis(0), xbox.getRawAxis(1))
        
    }

    override fun end(interrupted: Boolean) {}

    override fun isFinished(): Boolean {
        return false
    }
}
