package ru.vsu.cs.course4.lang.intepreter;

public class InterpreterException extends Exception {
    public InterpreterException(String message) {
        super(message);
    }

    public InterpreterException(String message, Throwable cause) {
        super(message, cause);
    }
}
