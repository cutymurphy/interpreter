package ru.vsu.cs.course4.lang.ast;

import java.util.Arrays;
import java.util.Collection;

public class AssignNode implements StmtNode {
    private IdentNode ident;
    private ExprNode expr;

    public AssignNode(IdentNode ident, ExprNode expr) {
        this.ident = ident;
        this.expr = expr;
    }

    @Override
    public Collection<AstNode> childs() {
        return Arrays.asList(ident, expr);
    }

    @Override
    public String toString() {
        return "=";
    }

    public IdentNode getIdent() {
        return ident;
    }

    public ExprNode getExpr() {
        return expr;
    }
}
