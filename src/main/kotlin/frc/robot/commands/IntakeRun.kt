
package frc.robot.commands
import edu.wpi.first.wpilibj2.command.CommandBase
import edu.wpi.first.wpilibj2.command.button.CommandXboxController
import frc.robot.subsystems.ExampleSubsystem
import frc.robot.subsystems.DriveSubsystem
import frc.robot.subsystems.IntakeSubsystem

class IntakeRun(
    private val subsystem: IntakeSubsystem
):CommandBase() {
    
    init {
        addRequirements(subsystem)
    }

    override fun initialize(){} 

    override fun execute(){
        subsystem.IntakeRun(1.0)
    }

    override fun end(interrupted: Boolean) {}

    override fun isFinished(): Boolean {
        return true
    }
}
