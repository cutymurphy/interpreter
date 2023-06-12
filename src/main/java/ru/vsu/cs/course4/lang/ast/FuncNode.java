package ru.vsu.cs.course4.lang.ast;

import java.util.ArrayList;
import java.util.Collection;

public class FuncNode implements StmtNode {
    private IdentNode name;
    private StmtNode params;
    private StmtNode stmts;

    public FuncNode(IdentNode name, StmtNode params, StmtNode stmts) {
        this.name = name;
        this.params = params;
        this.stmts = stmts;
    }

    @Override
    public String toString() {
        return "function";
    }

    @Override
    public Collection<AstNode> childs() {
        Collection<AstNode> children = new ArrayList<>();
        children.add(name);
        if (params != null) { children.add(params); }
        children.add(stmts);
        return children;
    }

    public IdentNode getName() { return name; }
    public StmtNode getParams() { return params; }
    public StmtNode getStatements() { return stmts; }
}
