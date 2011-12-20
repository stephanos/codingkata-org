package org.codingkata.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @author Stephan
 */
public class Logger extends PrintStream {

    private PrintStream systemOut;

    public Logger (PrintStream orig) throws FileNotFoundException {

        super (new FileOutputStream("target/log.txt"));
        systemOut = orig;
        System.setOut(this);
    }

    @Override
    public void print(boolean b) {
        super.print(b);
	systemOut.print(b);
    }

    @Override
    public void print(char c) {
	super.print(c);
	systemOut.print(c);
    }

    @Override
    public void print(char s[]) {
	super.print(s);
	systemOut.print(s);
    }

    @Override
    public void print(String s) {
        super.print(s);
	systemOut.print(s);
    }

    @Override
    public void println() {
        super.println();
        systemOut.println();
    }

    @Override
    public void println(boolean x) {
	super.println(x);
        systemOut.println(x);
    }

    @Override
    public void println(char x) {
	super.println(x);
        systemOut.println(x);
    }

    @Override
    public void println(int x) {
	super.println(x);
        systemOut.println(x);
    }

    @Override
    public void println(long x) {
	super.println(x);
        systemOut.println(x);
    }

    @Override
    public void println(float x) {
	super.println(x);
        systemOut.println(x);
    }

    @Override
    public void println(double x) {
	super.println(x);
        systemOut.println(x);
    }

    @Override
    public void println(char x[]) {
	super.println(x);
        systemOut.println(x);
    }

    @Override
    public void println(String x) {
	super.print(x);
        super.println ();
        systemOut.print(x);
        systemOut.println ();
    }

    @Override
    public void println(Object x) {
        super.println(x);
        systemOut.println(x);
    }

}
