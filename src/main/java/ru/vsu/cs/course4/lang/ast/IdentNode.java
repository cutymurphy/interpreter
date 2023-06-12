package ru.vsu.cs.course4.lang.ast;

public class IdentNode implements ExprNode {
    private String name;

    public IdentNode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}
