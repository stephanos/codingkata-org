package org.codingkata;

import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * Abstract base class for every kata task
 * @author stephanos
 */
public abstract class KataCommonTask {

    /*======= FIELDS =======*/
    private KataResult result;

    /*======= SETUP =======*/
    public KataCommonTask() {
        init();
    }

    /*======= PUBLIC METHODS =======*/
    public abstract void start();

    public void printResult() {
        result.print();
        writePointFile();
    }

    public void finish() {
        result.setFinishedOn(System.nanoTime());
        result.setCustomIntroMsg(customIntroMsg());
        result.setCustomSuccessMsg(customSuccessMsg());
    }

    /*======= PROTECTED METHODS =======*/
    protected void init() {
        result = new KataResult();
    }

    protected void writePointFile() {

        if (result.getPoints() != -1) {

            // read signature (project's artifact id)
            String sic = "";
            try {
                DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(new File("pom.xml"));
                doc.getDocumentElement().normalize();
                Node root = doc.getDocumentElement();
                for (int i = 0; i < root.getChildNodes().getLength(); i++) {
                    Node n = root.getChildNodes().item(i);
                    if (n.getNodeName().equals("artifactId")) {
                        sic = n.getTextContent();
                        break;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(KataCommonTask.class.getName()).log(Level.SEVERE,
                        "Could not read pom.xml to generate score file.", ex);
                return;
            }

            // calc score
            String score = "";
            try {
            score = Codec.encode(result.getPoints(), sic);
            } catch (Exception ex) {
                Logger.getLogger(KataCommonTask.class.getName()).log(Level.SEVERE,
                        "Could not calculate score.", ex);
            }

            // save score to file
            try {
                FileOutputStream fos = new FileOutputStream("target/" + Codec.scorefn);
                IOUtils.write(score, fos);
            } catch (Exception ex) {
                Logger.getLogger(KataCommonTask.class.getName()).log(Level.SEVERE,
                        "Could save score to file.", ex);
            }
        }
    }

    protected String customSuccessMsg() {
        return "";
    }

    protected String customIntroMsg() {
        return "";
    }

    protected void optimized(String msg) {
        result.setCustomResult(msg);
    }

    protected boolean validate(Object expectation, Object actual, Object... inputs) {

        boolean equal = isEqual(expectation, actual);

        if (!equal) {
            result.addValidation(new KataValidate(equal,
                    expectation.toString(), actual.toString(), inputs));
        } else {
            result.addValidation(new KataValidate(true));
        }

        return equal;
    }

    protected boolean isEqual(Object expectation, Object actual) {

        return expectation.equals(actual);
    }

    protected void started() {
        result.setStartedOn(System.nanoTime());
    }

    /*======= GET/SET =======*/
    public KataResult getResult() {
        return result;
    }
}
