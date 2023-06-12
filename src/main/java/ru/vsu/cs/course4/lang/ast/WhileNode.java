package ru.vsu.cs.course4.lang.ast;

import java.util.Arrays;
import java.util.Collection;

public class WhileNode implements StmtNode {
    private ExprNode condition;
    private StmtNode statement;

    public WhileNode(ExprNode condition, StmtNode statement) {
        this.condition = condition;
        this.statement = statement;
    }

    @Override
    public String toString() {
        return "while";
    }

    @Override
    public Collection<AstNode> childs() {
        return Arrays.asList(condition, statement);
    }

    public ExprNode getCondition() {
        return condition;
    }

    public StmtNode getStatement() { return statement; }
}
