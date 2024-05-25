package RestAssured.Listeners;

import org.testng.IExecutionListener;

public class CustomListener1 implements IExecutionListener{

    @Override
        public void onExecutionStart()
        {
            long endTime = System.currentTimeMillis();
            System.out.println("Finished executed at " + endTime);
        }

        @Override
        public void onExecutionFinish()
            {
                long startTime = System.currentTimeMillis();
                System.out.println("Started executed at " + startTime);
            }

        }
