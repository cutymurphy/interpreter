package ru.vsu.cs.course4.lang.ast;

import java.util.ArrayList;
import java.util.Collection;

public class ForNode implements StmtNode {
    private AssignNode initialization;
    private ExprNode termination;
    private AssignNode increment;
    private StmtNode statement;

    public ForNode(AssignNode init, ExprNode cond, AssignNode step, StmtNode forStmt) {
        this.initialization = init;
        this.termination = cond;
        this.increment = step;
        this.statement = forStmt;
    }

    @Override
    public String toString() {
        return "for";
    }

    @Override
    public Collection<AstNode> childs() {
        Collection<AstNode> children = new ArrayList<>();
        if (initialization != null) { children.add(initialization); }
        if (termination != null) { children.add(termination); }
        if (increment != null) { children.add(increment); }
        children.add(statement);
        return children;
    }

    public AssignNode getInitialization() { return initialization; }
    public ExprNode getTermination() { return termination; }
    public AssignNode getIncrement() { return increment; }
    public StmtNode getStatement() { return statement; }
}
