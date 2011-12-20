package org.codingkata.test;

import java.io.PrintStream;
import org.codingkata.IKataCommonSolution;
import org.codingkata.IKataCommonTask;
import org.codingkata.IKataSolvLoader;
import org.codingkata.KataResult;

public class CommonKataExecution {

    /*======= PUBLIC METHODS =======*/

    public IKataCommonTask executeKata() throws Exception {

        IKataCommonSolution kataSolv = null;
        IKataCommonTask kataTask = null;
        IKataSolvLoader kataSolvLoader = null;

        // overwrite default system.out (to log twice: a) console & b) file)
        PrintStream systemOut = System.out;
        PrintStream systemOutLog = null;
        systemOutLog = new Logger (systemOut);

        // load the kata task
        kataTask = loadTask();
        if (kataTask != null) {

            Exception customEx = null;

            // load solution
            try {
                Class classDefinition = Class.forName("org.codingkata.unit.internal.KataSolvLoader");
                kataSolvLoader = (IKataSolvLoader) classDefinition.newInstance();
                kataSolv = kataSolvLoader.load();
            } catch (Exception e) {
                customEx = e;
            }

            if (kataSolvLoader == null) {
                try {
                    Class classDefinition = Class.forName("org.codingkata.unit.MyKata");
                    kataSolv = (IKataCommonSolution) classDefinition.newInstance();
                } catch (Exception e) {
                    customEx = e;
                }
            }

            if (kataSolv == null) {
                // no solution found - give feedback to the user
                handleErrors(kataSolvLoader, customEx);
            } else {
                // execute the kata
                execute(kataTask, kataSolv);
            }
        }

        systemOutLog.close();

        return kataTask;
    }

    /*======= PROTECTED METHODS =======*/

    protected IKataCommonTask loadTask() {

        IKataCommonTask kataTask = null;

        // load task
        try {
            Class classDefinition = Class.forName("org.codingkata.unit.impl.KataTask");
            kataTask = (IKataCommonTask) classDefinition.newInstance();
        } catch (Exception e) {
            Exception customEx = e;
            new KataResult(customEx).print();
        }

        return kataTask;
    }

    protected void handleErrors(IKataSolvLoader kataSolvLoader, Exception customEx) {

        if (kataSolvLoader == null) {
            if (customEx instanceof ClassNotFoundException) {
                customEx = new RuntimeException(
                        "Apparently no kata solution was found."
                        + " Make sure that you didn't change the class name (MyKata)"
                        + " or the package definition (org.codingkata.unit)!");
            }
        } else {
            /*if (customEx instanceof ClassNotFoundException) {
            customEx = new RuntimeException("TODO");
            }*/
        }

        new KataResult(customEx).print();
    }

    protected void execute(IKataCommonTask kataTask, IKataCommonSolution kataSolv) {

        kataTask.setSolution(kataSolv);
        triggerKataFunc(kataTask);
    }

    protected void triggerKataFunc(IKataCommonTask kataTask) {

        // trigger service
        try {
            System.out.println("\n========================= DEBUG OUTPUT START ===============================");
            kataTask.start();
        } catch (Exception e) {
            kataTask.getResult().setException(e);
            throw new RuntimeException(e);
        } finally {
            System.out.println("========================== DEBUG OUTPUT END ================================");
            kataTask.finish();
            kataTask.printResult();
        }
    }
}
