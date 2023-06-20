
package frc.robot.commands
import edu.wpi.first.wpilibj2.command.CommandBase
import edu.wpi.first.wpilibj2.command.button.CommandXboxController
import frc.robot.subsystems.ExampleSubsystem
import frc.robot.subsystems.DriveSubsystem
import frc.robot.subsystems.IntakeSubsystem

class IntakeSetSpeed(
    private val subsystem: IntakeSubsystem,
    private val xbox: CommandXboxController
    
):CommandBase(){
    
    init {
        addRequirements(subsystem)
    }

    override fun initialize(){} 

    override fun execute(){
        subsystem.motor.set(xbox.getRawAxis(4))
    }


    private fun changeSpeed {
        
    }

    override fun end(interrupted: Boolean) {}

    override fun isFinished(): Boolean {
        return true
    }
}
