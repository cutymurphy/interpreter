package ru.vsu.cs.course4.lang.ast;

public class DoWhileNode extends WhileNode {
    public DoWhileNode(ExprNode condition, StmtNode statement) {
        super(condition, statement);
    }

    @Override
    public String toString() {
        return "do while";
    }
}
