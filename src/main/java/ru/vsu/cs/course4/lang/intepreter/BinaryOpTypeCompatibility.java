package ru.vsu.cs.course4.lang.intepreter;

public class BinaryOpTypeCompatibility {

    public static Object mul(Object leftValue, Object rightValue) throws InterpreterException {
        if (leftValue instanceof Integer && rightValue instanceof Integer) {
            return (Integer) leftValue * (Integer) rightValue;
        } else if (leftValue instanceof Double && rightValue instanceof Double) {
            return (Double) leftValue * (Double) rightValue;
        } else if (leftValue instanceof Integer && rightValue instanceof Double) {
            return (Integer) leftValue * (Double) rightValue;
        } else if (leftValue instanceof Double && rightValue instanceof Integer) {
            return (Double) leftValue * (Integer) rightValue;
        }
        throw new InterpreterException("The operation cannot be performed.");
    }

    public static Object div(Object leftValue, Object rightValue) throws InterpreterException {
        if (leftValue instanceof Integer && rightValue instanceof Integer) {
            return (Integer) leftValue / (Integer) rightValue;
        } else if (leftValue instanceof Double && rightValue instanceof Double) {
            return (Double) leftValue / (Double) rightValue;
        } else if (leftValue instanceof Integer && rightValue instanceof Double) {
            return (Integer) leftValue / (Double) rightValue;
        } else if (leftValue instanceof Double && rightValue instanceof Integer) {
            return (Double) leftValue / (Integer) rightValue;
        }
        throw new InterpreterException("The operation cannot be performed.");
    }

    public static Object mod(Object leftValue, Object rightValue) throws InterpreterException {
        if (leftValue instanceof Integer && rightValue instanceof Integer) {
            return (Integer) leftValue % (Integer) rightValue;
        } else if (leftValue instanceof Double && rightValue instanceof Double) {
            return (Double) leftValue % (Double) rightValue;
        } else if (leftValue instanceof Integer && rightValue instanceof Double) {
            return (Integer) leftValue % (Double) rightValue;
        } else if (leftValue instanceof Double && rightValue instanceof Integer) {
            return (Double) leftValue % (Integer) rightValue;
        }
        throw new InterpreterException("The operation cannot be performed.");
    }

    public static Object add(Object leftValue, Object rightValue) throws InterpreterException {

        if (leftValue instanceof Integer && rightValue instanceof Integer) {
            return (Integer) leftValue + (Integer) rightValue;
        } else if (leftValue instanceof Double && rightValue instanceof Double) {
            return (Double) leftValue + (Double) rightValue;
        } else if (leftValue instanceof Integer && rightValue instanceof Double) {
            return (Integer) leftValue + (Double) rightValue;
        } else if (leftValue instanceof Double && rightValue instanceof Integer) {
            return (Double) leftValue + (Integer) rightValue;

        } else if (leftValue instanceof String && rightValue instanceof String) {
            return leftValue + (String) rightValue;

        } else if (leftValue instanceof Integer && rightValue instanceof String) {
            return leftValue + (String) rightValue;
        } else if (leftValue instanceof String && rightValue instanceof Integer) {
            return (String) leftValue + rightValue;
        } else if (leftValue instanceof Double && rightValue instanceof String) {
            return leftValue + (String) rightValue;
        } else if (leftValue instanceof String && rightValue instanceof Double) {
            return (String) leftValue + rightValue;
        }

        throw new InterpreterException("The operation cannot be performed.");
    }

    public static Object sub(Object leftValue, Object rightValue) throws InterpreterException {
        if (leftValue instanceof Integer && rightValue instanceof Integer) {
            return (Integer) leftValue - (Integer) rightValue;
        } else if (leftValue instanceof Double && rightValue instanceof Double) {
            return (Double) leftValue - (Double) rightValue;
        } else if (leftValue instanceof Integer && rightValue instanceof Double) {
            return (Integer) leftValue - (Double) rightValue;
        } else if (leftValue instanceof Double && rightValue instanceof Integer) {
            return (Double) leftValue - (Integer) rightValue;
        }
        throw new InterpreterException("The operation cannot be performed.");
    }

    public static Object lt(Object leftValue, Object rightValue) throws InterpreterException {
        if (leftValue instanceof Integer && rightValue instanceof Integer) {
            return (Integer) leftValue < (Integer) rightValue;
        } else if (leftValue instanceof Double && rightValue instanceof Double) {
            return (Double) leftValue < (Double) rightValue;
        } else if (leftValue instanceof Integer && rightValue instanceof Double) {
            return (Integer) leftValue < (Double) rightValue;
        } else if (leftValue instanceof Double && rightValue instanceof Integer) {
            return (Double) leftValue < (Integer) rightValue;
        }
        throw new InterpreterException("The operation cannot be performed.");
    }

    public static Object gt(Object leftValue, Object rightValue) throws InterpreterException {
        if (leftValue instanceof Integer && rightValue instanceof Integer) {
            return (Integer) leftValue > (Integer) rightValue;
        } else if (leftValue instanceof Double && rightValue instanceof Double) {
            return (Double) leftValue > (Double) rightValue;
        } else if (leftValue instanceof Integer && rightValue instanceof Double) {
            return (Integer) leftValue > (Double) rightValue;
        } else if (leftValue instanceof Double && rightValue instanceof Integer) {
            return (Double) leftValue > (Integer) rightValue;
        }
        throw new InterpreterException("The operation cannot be performed.");
    }

    public static Object le(Object leftValue, Object rightValue) throws InterpreterException {
        if (leftValue instanceof Integer && rightValue instanceof Integer) {
            return (Integer) leftValue <= (Integer) rightValue;
        } else if (leftValue instanceof Double && rightValue instanceof Double) {
            return (Double) leftValue <= (Double) rightValue;
        } else if (leftValue instanceof Integer && rightValue instanceof Double) {
            return (Integer) leftValue <= (Double) rightValue;
        } else if (leftValue instanceof Double && rightValue instanceof Integer) {
            return (Double) leftValue <= (Integer) rightValue;
        }
        throw new InterpreterException("The operation cannot be performed.");
    }

    public static Object ge(Object leftValue, Object rightValue) throws InterpreterException {
        if (leftValue instanceof Integer && rightValue instanceof Integer) {
            return (Integer) leftValue >= (Integer) rightValue;
        } else if (leftValue instanceof Double && rightValue instanceof Double) {
            return (Double) leftValue >= (Double) rightValue;
        } else if (leftValue instanceof Integer && rightValue instanceof Double) {
            return (Integer) leftValue >= (Double) rightValue;
        } else if (leftValue instanceof Double && rightValue instanceof Integer) {
            return (Double) leftValue >= (Integer) rightValue;
        }
        throw new InterpreterException("The operation cannot be performed.");
    }

    public static Object equals(Object leftValue, Object rightValue) throws InterpreterException {
        if (leftValue instanceof Integer && rightValue instanceof Integer
        || leftValue instanceof Double && rightValue instanceof Double
        || leftValue instanceof Integer && rightValue instanceof Double
        || leftValue instanceof Double && rightValue instanceof Integer
        || leftValue instanceof String && rightValue instanceof String
        || leftValue instanceof Boolean && rightValue instanceof Boolean) {
            return leftValue.equals(rightValue);
        }
        throw new InterpreterException("The operation cannot be performed.");
    }

    public static Object unequals(Object leftValue, Object rightValue) throws InterpreterException {
        if (leftValue instanceof Integer && rightValue instanceof Integer
        || leftValue instanceof Double && rightValue instanceof Double
        || leftValue instanceof Integer && rightValue instanceof Double
        || leftValue instanceof Double && rightValue instanceof Integer
        || leftValue instanceof String && rightValue instanceof String
        || leftValue instanceof Boolean && rightValue instanceof Boolean) {
            return !leftValue.equals(rightValue);
        }
        throw new InterpreterException("The operation cannot be performed.");
    }

    public static Object and(Object leftValue, Object rightValue) throws InterpreterException {
        if (leftValue instanceof Boolean && rightValue instanceof Boolean) {
            return (Boolean) leftValue && (Boolean) rightValue;
        }
        throw new InterpreterException("The operation cannot be performed.");
    }

    public static Object or(Object leftValue, Object rightValue) throws InterpreterException {
        if (leftValue instanceof Boolean && rightValue instanceof Boolean) {
            return (Boolean) leftValue || (Boolean) rightValue;
        }
        throw new InterpreterException("The operation cannot be performed.");
    }
}
