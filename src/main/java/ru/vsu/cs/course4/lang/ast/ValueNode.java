package ru.vsu.cs.course4.lang.ast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValueNode implements ExprNode {
    private String str;
    private Object value;

    public ValueNode(String str) {
        this.str = str;
        if (str.equals("true") || str.equals("false")) {
            this.value = Boolean.valueOf(str);
        } else if (str.startsWith("\"") && str.endsWith("\"") || str.startsWith("'") && str.endsWith("'")) {
            this.value = str.substring(1, str.length() - 1);
        } else {
            try {
                if (str.contains(".")) {
                    this.value = Double.parseDouble(str);
                } else {
                    this.value = Integer.parseInt(str);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid value: " + str);
            }
        }
    }

    @Override
    public String toString() {
        return str;
    }

    public Object getValue() {
        return value;
    }
}