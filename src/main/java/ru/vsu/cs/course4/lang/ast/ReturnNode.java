package ru.vsu.cs.course4.lang.ast;

import java.util.ArrayList;
import java.util.Collection;

public class ReturnNode implements StmtNode {
    private ExprNode expr;

    public ReturnNode(ExprNode expr) {
        this.expr = expr;
    }

    @Override
    public Collection<AstNode> childs() {
        Collection<AstNode> children = new ArrayList<>();
        if (expr != null) { children.add(expr); }
        return children;
    }

    @Override
    public String toString() {
        return "return";
    }

    public ExprNode getExpr() {
        return expr;
    }
}
