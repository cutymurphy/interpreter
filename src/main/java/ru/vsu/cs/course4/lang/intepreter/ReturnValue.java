package ru.vsu.cs.course4.lang.intepreter;

public class ReturnValue extends InterpreterException {
    private final Object value;

    public ReturnValue(Object value) {
        super(null);
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
