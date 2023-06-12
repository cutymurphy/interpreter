package ru.vsu.cs.course4.lang.ast;

import java.util.*;

public class ParamsListNode implements StmtNode {
    private List<ExprNode> list = null;

    public ParamsListNode(Collection<ExprNode> list) {
        this.list = new ArrayList<>();
        if (list != null) {
            this.list.addAll(list);
        }
    }

    public ParamsListNode(ExprNode ...list) {
        this(Arrays.asList(list));
    }

    @Override
    public Collection<? extends AstNode> childs() {
        return list;
    }

    @Override
    public String toString() {
        return "params";
    }

    public List<ExprNode> getList() {
        return Collections.unmodifiableList(list);
    }
}
