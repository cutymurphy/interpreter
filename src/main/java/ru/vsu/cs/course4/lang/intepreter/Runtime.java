package ru.vsu.cs.course4.lang.intepreter;

import java.util.Scanner;

public class Runtime {
    public static final double PI = Math.PI;
    public static final double E = Math.E;
    private static final Scanner scanner = new Scanner(System.in);

    public static String input() {
        return scanner.nextLine();
    }

    public static void print(Object o) {
        System.out.print(o);
    }

    public static void println(Object o) {
        System.out.println(o);
    }

    public static Integer toInt(Object o) {
        return Integer.valueOf(o.toString());
    }

    public static Double toDouble(Object o) {
        return Double.valueOf(o.toString());
    }

    public static String toString(Object o) {
        return String.valueOf(o);
    }

    public static Boolean toBoolean(Object o) {
        return Boolean.valueOf(o.toString());
    }

    public static Object abs(Object o) {
        if (o instanceof Integer) {
            return Math.abs(toInt(o));
        } else if (o instanceof Double) {
            return Math.abs((Double) o);
        } else {
            throw new IllegalArgumentException("Wrong type!");
        }
    }
    public static Object sin(Object o) {
        if (o instanceof Double) {
            return Math.sin((Double) o);
        } else {
            throw new IllegalArgumentException("Wrong type!");
        }
    }

    public static Object cos(Object o) {
        if (o instanceof Double) {
            return Math.cos((Double) o);
        } else {
            throw new IllegalArgumentException("Wrong type!");
        }
    }

    public static Object tan(Object o) {
        if (o instanceof Double) {
            return Math.tan((Double) o);
        } else {
            throw new IllegalArgumentException("Wrong type!");
        }
    }

    public static Object ctan(Object o) {
        if (o instanceof Double) {
            return 1.0 / Math.tan((Double) o);
        } else {
            throw new IllegalArgumentException("Wrong type!");
        }
    }

    public static Object pow(Object a, Object b) {
        if (a instanceof Double && b instanceof Integer) {
            return Math.pow((Double) a, (Integer) b);
        } else {
            throw new IllegalArgumentException("Wrong type!");
        }
    }

    public static Object sqrt(Object o) {
        if (o instanceof Double) {
            return Math.sqrt((Double) o);
        } else if (o instanceof Integer) {
            return Math.sqrt((Integer) o);
        } else {
            throw new IllegalArgumentException("Wrong type!");
        }
    }

    public static Object cbrt(Object o) {
        if (o instanceof Double) {
            return Math.cbrt((Double) o);
        } else {
            throw new IllegalArgumentException("Wrong type!");
        }
    }

    public static Object floor(Object o) {
        if (o instanceof Double) {
            return Math.floor((Double) o);
        } else {
            throw new IllegalArgumentException("Wrong type!");
        }
    }

    public static Object ceil(Object o) {
        if (o instanceof Double) {
            return Math.ceil((Double) o);
        } else {
            throw new IllegalArgumentException("Wrong type!");
        }
    }

    public static Object max(Object a, Object b) {
        if (a instanceof Integer && b instanceof Integer) {
            return Math.max((Integer) a, (Integer) b);
        } else if (a instanceof Double && b instanceof Double) {
            return Math.max((Double) a, (Double) b);
        } else {
            throw new IllegalArgumentException("Wrong type!");
        }
    }

    public static Object min(Object a, Object b) {
        if (a instanceof Integer && b instanceof Integer) {
            return Math.min((Integer) a, (Integer) b);
        } else if (a instanceof Double && b instanceof Double) {
            return Math.min((Double) a, (Double) b);
        } else {
            throw new IllegalArgumentException("Wrong type!");
        }
    }

    public static Object log(Object o) {
        if (o instanceof Double) {
            return Math.log((Double) o);
        } else {
            throw new IllegalArgumentException("Wrong type!");
        }
    }

    public static Object log10(Object o) {
        if (o instanceof Double) {
            return Math.log10((Double) o);
        } else {
            throw new IllegalArgumentException("Wrong type!");
        }
    }
}
