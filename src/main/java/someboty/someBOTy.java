package someboty;

import someboty.Exceptions.TerminateException;
import someboty.Managers.CommandManager;
import someboty.Managers.FileManager;
import someboty.Managers.ResponseManager;
import someboty.Managers.taskManager;

// main class for the project
public class someBOTy {

    public someBOTy(String filePath) {
        // Initialize
        FileManager fileManager = new FileManager(filePath);
        taskManager taskManager = new taskManager(fileManager);
        CommandManager commandCenter = new CommandManager(taskManager);
        ResponseManager responseManager = new ResponseManager(commandCenter);

        ResponseManager.printGreeting();

        while (true) {
            try {
                // read input once
                responseManager.parseInput(); 

            } catch (TerminateException e) {
                // print farewell message and exit application.
                ResponseManager.printExitMessage();
                return;
            }
        }
    }

    public static void main(String[] args) { 
        String filePath = System.getProperty("user.dir");
        new someBOTy(filePath);
    }
}
