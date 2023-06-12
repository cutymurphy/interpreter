package ru.vsu.cs.course4.lang.ast;

import java.util.Arrays;
import java.util.Collection;

public class IfNode implements StmtNode {
    private ExprNode condition;
    private StmtNode thenStmt;
    private StmtNode elseStmt;

    public IfNode(ExprNode condition, StmtNode thenStmt, StmtNode elseStmt) {
        this.condition = condition;
        this.thenStmt = thenStmt;
        this.elseStmt = elseStmt;
    }

    @Override
    public String toString() {
        return "if";
    }

    @Override
    public Collection<AstNode> childs() {
        if (elseStmt == null) {
            return Arrays.asList(condition, thenStmt);
        }
        return Arrays.asList(condition, thenStmt, elseStmt);
    }

    public ExprNode getCondition() {
        return condition;
    }
    public StmtNode getThenStmt() { return thenStmt; }
    public StmtNode getElseStmt() { return elseStmt; }
}
