//package org.codingkata.test;
//
//import java.util.ArrayList;
//import java.util.List;
//import org.codingkata.IKataCommonTask;
//import org.codingkata.KataResult;
//import org.osgi.framework.BundleException;
//import org.osgi.framework.ServiceReference;
//import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;
//import org.springframework.osgi.test.platform.Platforms;
//
//public abstract class CommonIntegrationTest1
//        extends AbstractConfigurableBundleCreatorTests {
//
//    /*======= SETUP =======*/
//    @Override
//    protected void onSetUp() throws Exception {
//        super.onSetUp();
//    }
//
//    @Override
//    protected void onTearDown() throws Exception {
//        super.onTearDown();
//    }
//
//    @Override
//    protected String getPlatformName() {
//        return Platforms.EQUINOX;
//    }
//
//    /*======= PUBLIC METHODS =======*/
//    public void testOsgiPlatformStarts() {
//        //System.out.println ("0");
//        assertNotNull("OSGi didn't start properly!", bundleContext);
//    }
//
//    public void testKata() {
//
//        //System.out.println ("1");
//
//        ServiceReference ref = bundleContext.getServiceReference(getTaskName());
//        assertNotNull("Service Reference is null", ref);
//
//        //System.out.println ("2");
//
//        // lookup service
//        IKataCommonTask kataTask = (IKataCommonTask) bundleContext.getService(ref);
//        assertNotNull("Cannot start the kata task - did you modify the IntegrationTest.java file?", kataTask);
//
//        //System.out.println ("3");
//
//        // execute kata & assert
//        triggerKataFunc(kataTask);
//        assertKataFunc(kataTask);
//
//        //System.out.println ("4");
//
//        // cleanup
//        bundleContext.ungetService(ref);
//    }
//
//    @Override
//    public void runBare() throws Throwable {
//
//        try {
//            super.runBare();
//        } catch (Exception ex) {
//            if (ex instanceof BundleException) {
//                Exception customEx;
//                if (ex.getMessage().contains("/common-test-1.0")) {
//                    customEx = new RuntimeException(
//                            "The test libary could not be loaded"
//                            + " (common-test)"
//                            + " - did you modify the IntegrationTest.java or pom.xml file?");
//                } else if (ex.getMessage().contains("org.codingkata.unit.api")) {
//                    customEx = new RuntimeException(
//                            "The kata task libary could not be loaded"
//                            + " ($kataKey-task)"
//                            + " - did you modify the IntegrationTest.java or pom.xml file?");
//                } else if (ex.getMessage().contains("org.codingkata.unit")) {
//                    customEx = new RuntimeException(
//                            "Apparently no Kata solution was found"
//                            + " - did you create a class source file and implement the interface?"
//                            + " Also make sure that you didn't change the class name (MyKata)"
//                            + " or the package definition (org.codingkata.unit)!");
//                } else {
//                    customEx = new RuntimeException(
//                            "At least one library could not be loaded/is missing"
//                            + " - please read the detailed exception message(s) above"
//                            + " to try to find out what happened exactly!");
//                }
//                new KataResult(customEx).print();
//            }
//        }
//    }
//
//    /*======= PROTECTED METHODS =======*/
//    protected void triggerKataFunc(IKataCommonTask kataTask) {
//
//        RuntimeException ex;
//
//        // trigger service
//        try {
//            System.out.println("\n========================= DEBUG OUTPUT START ===============================");
//            kataTask.start();
//        } catch (RuntimeException e) {
//            ex = e;
//            kataTask.getResult().setException(e);
//            throw ex;
//        } finally {
//            System.out.println("========================== DEBUG OUTPUT END ================================");
//            kataTask.finish();
//            kataTask.printResult();
//        }
//    }
//
//    protected void assertKataFunc(IKataCommonTask kataTask) {
//
//        // assert service result
//        assertTrue(kataTask.getResult().isPassed());
//    }
//
//    protected List<String> loadNecessaryBundles() {
//
//        List<String> bundles = new ArrayList<String>(6);
//        bundles.add("org.springframework.osgi, cglib-nodep.osgi, 2.1.3-SNAPSHOT");
//        return bundles;
//    }
//
//    /*======= ABSTRACT PROTECTED METHODS =======*/
//    abstract protected String getTaskName();
//    // add abstract protected String getKataKey(); ??
//}
