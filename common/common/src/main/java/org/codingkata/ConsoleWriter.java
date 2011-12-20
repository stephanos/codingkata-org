package org.codingkata;

/**
 * Writes kata results nicely to the console
 * @author Stephan
 */
public class ConsoleWriter {

    final int maxlength = 76;
    final int cut = maxlength - 3;

    public void print(KataResult r) {

        if (r.getException() != null) {
            r.getException().printStackTrace(System.out);
        }

        System.out.println(header() + results(r) + footer());
    }

    private String header() {

        return "\n"
                + " ############################################################################\n"
                + " #############               _ _           _        _           #############\n"
                + " #############    __ ___  __| (_)_ _  __ _| |____ _| |_ __ _    #############\n"
                + " #############   / _/ _ \\/ _` | | ' \\/ _` | / / _` |  _/ _` |   #############\n"
                + " #############   \\__\\___/\\__,_|_|_||_\\__, |_\\_\\__,_|\\__\\__,_|   #############\n"
                + " #############                       |___/                      #############\n"
                + " #############                                 CODINGKATA.ORG   #############\n"
                + " ############################################################################\n"
                + fillRow();
    }

    private String footer() {

        return fillRow()
                + " ############################################################################\n";
    }

    private String results(KataResult r) {

        String res = "";

        String introMsg = r.getCustomIntroMsg();
        if (!introMsg.isEmpty()) {
            res += fillRow(introMsg);
            res += fillRow();
        }

        if (r.getValidations().size() > 0) {

            // gather statistics
            int cpassed = 0;
            int total = r.getValidations().size();
            for (KataValidate v : r.getValidations()) {
                cpassed += v.isPassed() ? 1 : 0;
            }
            int cfailed = total - cpassed;

            if (cfailed == 0) {
                // print congratulations
                res += fillRow("Kata solved.");
                res += fillRow("Well done, kohai!");

                String sucMsg = r.getCustomSuccessMsg();
                if (!sucMsg.isEmpty()) {
                    res += fillRow();
                    res += fillRow(sucMsg);
                }
            } else {
                // print summary
                res += fillRow("TESTS (total: " + total + ", passed: " + cpassed + "):");
                res += fillRow();

                // print each test
                int c = 1;
                String maxIdent = "    ";
                int maxdigits = new Integer(r.getValidations().size()).toString().length();

                for (KataValidate v : r.getValidations()) {

                    String ind = maxIdent.substring(0, maxdigits - new Long(c).toString().length());
                    String ind2 = maxIdent.substring(0, maxdigits) + "   ";
                    String prefix = "(" + ind + c + ")";

                    if (!v.isPassed()) {
                        String expect = prefix + " EXPECTED '" + v.getExpect() + "'";
                        String input = !v.getInput().isEmpty() ? " FOR " + v.getInput() : "";
                        String actual = " GOT '" + v.getActual() + "'";

                        String r1 = "", r2 = "", r3 = "";

                        if (expect.length() + input.length() + actual.length() > maxlength - 4) {
                            r1 = expect;
                            if (ind2.length() + input.length() + actual.length() > maxlength - 7) {
                                r2 = input;
                                r3 = actual.replaceAll("GOT ", "GOT  ");
                            } else {
                                r2 = input + actual;
                            }
                        } else {
                            r1 = expect + input + actual;
                        }

                        if (r2.isEmpty()) {
                            res += fillRow(r1);
                            if (!r3.isEmpty()) {
                                res += fillRow(ind2 + "   " + r3);
                            }
                        } else if (r3.isEmpty()) {
                            res += fillRow(r1);
                            res += fillRow(ind2 + "   " + r2);
                        } else {
                            res += fillRow(r1);
                            res += fillRow(ind2 + "   " + r2);
                            res += fillRow(ind2 + "   " + r3);
                        }
                    }
                    c++;
                }
            }

        } else if (!r.getCustomResult().isEmpty()) {
            res += fillRow(r.getCustomResult());
        } else if (r.getException() != null) {

            Exception e = r.getException();

            res += fillRow("EXCEPTION of TYPE");
            res += fillRow("  '" + e.getClass() + "'");
            res += fillRow("with MESSAGE");
            res += fillRow("  " + e.getMessage() + "");
            res += fillRow("was thrown!");

        } else {
            res += fillRow("Nothing to report.");
        }

        return res;
    }

    private String fillRow() {
        return fillRow("");
    }

    private String fillRow(String text) {

        String res = "";
        int length = text.length();

        if (length >= cut) {// || text.contains("\n") || text.contains("\r")) {
            int count = 0;
            String pre = "";
            String post = text;
            int end = Math.min(cut, length);
            while (count < end) {
                char c = post.charAt(0);
                post = post.substring(1);
                if (c == '\n' || c == '\r' || count == text.substring(0, end).lastIndexOf(" ")) {
                    break;
                } else {
                    pre += c;
                    count++;
                }
            }
            if (pre.trim().length() > 0) {
                res += printRow(pre);
            }
            if (post.trim().length() > 0) {
                res += fillRow("  " + post);
            }
        } else {
            res += printRow(text.replaceAll("\n", "").replaceAll("\r", ""));
        }

        return res;
    }

    private String printRow(String text) {

        String res = " # " + text;
        int length = res.length();
        for (int i = 0; i < (maxlength - length) - 1; i++) {
            res += " ";
        }
        res += " #\n";
        return res;
    }
}
