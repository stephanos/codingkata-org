#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package org.codingkata.unit.internal;

import org.codingkata.IKataCommonSolution;
import org.codingkata.IKataSolvLoader;

import org.python.core.PyException;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class KataSolvLoader implements IKataSolvLoader {

    private PyObject buildingClass;

    public IKataCommonSolution load() {

        IKataCommonSolution ret;

        try {
            PythonInterpreter interpreter = new PythonInterpreter();
            interpreter.execfile(ClassLoader.getSystemResourceAsStream("org/codingkata/unit/MyKata.py"));
            buildingClass = interpreter.get("MyKata");
            PyObject buildingObject = buildingClass.__call__();
            ret = (IKataCommonSolution) buildingObject.__tojava__(IKataCommonSolution.class);
        } catch (PyException e) {
            throw new RuntimeException(e);
        }

        return ret;
    }
}
