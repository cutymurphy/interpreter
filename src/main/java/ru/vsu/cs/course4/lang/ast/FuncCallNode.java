package ru.vsu.cs.course4.lang.ast;

import java.util.ArrayList;
import java.util.Collection;

public class FuncCallNode implements ExprNode, StmtNode {
    private IdentNode name;
    private StmtNode params;

    public FuncCallNode(IdentNode name, StmtNode params) {
        this.name = name;
        this.params = params;
    }

    @Override
    public String toString() {
        return "call";
    }

    @Override
    public Collection<AstNode> childs() {
        Collection<AstNode> children = new ArrayList<>();
        children.add(name);
        if (params != null) { children.add(params); }
        return children;
    }

    public IdentNode getName() { return name; }
    public StmtNode getParams() { return params; }
}
