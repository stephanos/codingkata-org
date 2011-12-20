package org.codingkata;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.jasypt.util.text.BasicTextEncryptor;

public class Codec {

    public static String scorefn = "score";

    private static BasicTextEncryptor strEncryptor(String sic) {
        BasicTextEncryptor crypt = new BasicTextEncryptor();
        crypt.setPassword(calcPass(sic));
        return crypt;
    }

    private static String calcPass(String sic) {
        String pass = "";
        String base = "ThizIsAVeryLongPassword,IsureHopeNobody(!)WillFigureItOut:-)";
        for (int i = 0; i < base.length(); i++) {
            char c = base.charAt(i);
            if (i < sic.length()) {
                char ic = (char) (((((int)c) + ((int)sic.charAt(i))) % 90) + 32);
                pass += new Character(ic);
            } else {
                pass += c;
            }
        }
        return pass;
    }

    private static String _encode(double score, String sic) {

        // convert to base
        String encScore1 =
                Base64.encodeBase64String(Double.toString(score).getBytes());
        //System.out.println("enc1: " + encScore1);

        // put in a pattern
        String encScore2 = StringUtils.join(encScore1.toString().split(""), ":");
        //System.out.println("enc2: " + encScore2);

        // encrypt the string
        String encScore3 = strEncryptor(sic).encrypt(encScore2);
        //System.out.println("enc3: " + encScore3);

        return String.valueOf(encScore3);
    }

    public static String encode(double score, String sic) {
        return _encode(score, sic);
    }

    private static double _decode(String score, String sic) {

        // decrypt the string
        String decScore1 = strEncryptor(sic).decrypt(score);
        //System.out.println("dec1: " + decScore1);

        // remove the pattern
        String decScore2 = decScore1.replaceAll(":", "");
        //System.out.println("dec2: " + decScore2);

        // convert
        double decScore3 = Double.parseDouble(
                new String(Base64.decodeBase64(decScore2.getBytes())));

        //System.out.println("dec3: " + decScore3);

        return decScore3;
    }

    public static double decode(String score, String sic) {
        return _decode(score, sic);
    }
}
