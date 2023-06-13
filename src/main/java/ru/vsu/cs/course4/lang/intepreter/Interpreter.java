package ru.vsu.cs.course4.lang.intepreter;

import ru.vsu.cs.course4.lang.ast.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Interpreter {
    private static final Map<String, Object> runtimeMethodsAndFields;

    static {
        runtimeMethodsAndFields = new HashMap<>();

        Class<Runtime> cls = Runtime.class;
        for (Method m : cls.getDeclaredMethods()) {
            runtimeMethodsAndFields.put(m.getName(), m);
        }

        for (Field f : cls.getFields()) {
            runtimeMethodsAndFields.put(f.getName(), f);
        }
    }

    public static Object exec(AstNode node, Scope scope) throws InterpreterException {
        if (node instanceof AssignNode) {
            return exec((AssignNode)  node, scope);
        } else if (node instanceof BinaryOpNode) {
            return exec((BinaryOpNode)  node, scope);
        } else if (node instanceof DoWhileNode) {
            return exec((DoWhileNode)  node, scope);
        } else if (node instanceof ForNode) {
            return exec((ForNode)  node, scope);
        } else if (node instanceof FuncCallNode) {
            return exec((FuncCallNode)  node, scope);
        } else if (node instanceof FuncNode) {
            return exec((FuncNode)  node, scope);
        } else if (node instanceof IdentNode) {
            return exec((IdentNode)  node, scope);
        } else if (node instanceof IfNode) {
            return exec((IfNode)  node, scope);
        } else if (node instanceof ReturnNode) {
            return exec((ReturnNode)  node, scope);
        } else if (node instanceof StmtListNode) {
            return exec((StmtListNode)  node, scope);
        } else if (node instanceof ValueNode) {
            return exec((ValueNode)  node, scope);
        } else if (node instanceof WhileNode) {
            return exec((WhileNode)  node, scope);
        }
        return null;
    }

    public static boolean toBoolean(Object o) {
        return (Boolean) o;
    }

    public static Object exec(AssignNode node, Scope scope) throws InterpreterException {
        Object value = exec(node.getExpr(), scope);
        scope.addVar(node.getIdent().getName(), value);
        return null;
    }

    public static Object exec(BinaryOpNode node, Scope scope) throws InterpreterException {

        Object leftValue = exec(node.getArg1(), scope);
        Object rightValue = exec(node.getArg2(), scope);
        BinaryOpNode.BinOp op = node.getOp();

        return switch (op) {
            case MUL -> BinaryOpTypeCompatibility.mul(leftValue, rightValue);
            case DIV -> BinaryOpTypeCompatibility.div(leftValue, rightValue);
            case MOD -> BinaryOpTypeCompatibility.mod(leftValue, rightValue);
            case ADD -> BinaryOpTypeCompatibility.add(leftValue, rightValue);
            case SUB -> BinaryOpTypeCompatibility.sub(leftValue, rightValue);
            case LT -> BinaryOpTypeCompatibility.lt(leftValue, rightValue);
            case GT -> BinaryOpTypeCompatibility.gt(leftValue, rightValue);
            case LE -> BinaryOpTypeCompatibility.le(leftValue, rightValue);
            case GE -> BinaryOpTypeCompatibility.ge(leftValue, rightValue);
            case UNEQUALS -> BinaryOpTypeCompatibility.unequals(leftValue, rightValue);
            case EQUALS -> BinaryOpTypeCompatibility.equals(leftValue, rightValue);
            case AND -> BinaryOpTypeCompatibility.and(leftValue, rightValue);
            case OR -> BinaryOpTypeCompatibility.or(leftValue, rightValue);
        };
    }

    public static Object exec(DoWhileNode node, Scope scope) throws InterpreterException {
        Scope newDoWhileScope = new Scope(scope);
        do {
            exec(node.getStatement(), newDoWhileScope);
            Object conditionValue = exec(node.getCondition(), newDoWhileScope);
            if (!toBoolean(conditionValue)) {
                break;
            }
        } while (true);

        return null;
    }

    public static Object exec(ForNode node, Scope scope) throws InterpreterException {
        Scope newForScope = new Scope(scope);
        exec(node.getInitialization(), newForScope);

        while (toBoolean(exec(node.getTermination(), newForScope))) {
            exec(node.getStatement(), newForScope);
            exec(node.getIncrement(), newForScope);
        }

        return null;
    }

    public static Object exec(FuncCallNode node, Scope scope) throws InterpreterException {

        Object object = exec(node.getName(), scope);

        if (object instanceof FuncNode) {
            FuncNode function = (FuncNode) object;

            StmtNode params = function.getParams();
            int paramsLength = params.childs().size();
            StmtNode args = node.getParams();
            int argsLength = args.childs().size();

            if (paramsLength < argsLength) {
                throw new InterpreterException("Function call with wrong number of arguments: " + node.getName().getName());
            }
            Scope newScope = new Scope(scope);

            int i = 0;
            while (i < paramsLength) {
                Object argValue = (i < argsLength) ? exec(args.get(i), newScope) : null;
                newScope.addVar(params.get(i).toString(), argValue);
                i++;
            }
            StmtListNode stmts = (StmtListNode) function.getStatements();

            try {
                exec(stmts, newScope);
                return null;
            } catch (ReturnValue rv) {
                return rv.getValue();
            }

        } else if (object instanceof Method) {
            Method method = (Method) object;
            try {
                StmtNode params = node.getParams();
                int paramsLength = params.childs().size();
                Object[] arrayOfArgs = new Object[paramsLength];
                for (int i = 0; i < paramsLength; i++) {
                    arrayOfArgs[i] = exec(params.get(i), scope);
                }
                return method.invoke(null, arrayOfArgs);
            } catch (Exception e) {
                throw new InterpreterException("Error invoking runtime function: " + node.getName().getName());
            }

        } else if (object instanceof Field) {
            Field field = (Field) object;
            try {
                return field.get(null);
            } catch (Exception e) {
                throw new InterpreterException("Error while returning field");
            }

        } else {
            throw new InterpreterException("Error while calling Func" + object);
        }
    }

    public static Object exec(FuncNode node, Scope scope) throws InterpreterException {
        scope.addVar(node.getName().getName(), node);
        return node.getName();
    }

    public static Object exec(IdentNode node, Scope scope) throws InterpreterException {
        try {
            return scope.findVar(node.getName());
        } catch (InterpreterException e) {
            Object obj = runtimeMethodsAndFields.get(node.getName());
            if (obj != null) {
                return obj;
            }
            throw new InterpreterException("Didn't find anything");
        }
    }

    public static Object exec(IfNode node, Scope scope) throws InterpreterException {
        Object value = exec(node.getCondition(), scope);
        Scope newIfScope = new Scope(scope);
        if (toBoolean(value)) {
            exec(node.getThenStmt(), newIfScope);
        } else {
            exec(node.getElseStmt(), newIfScope);
        }
        return null;
    }

    public static Object exec(ReturnNode node, Scope scope) throws InterpreterException {
        Object returnExpr = exec(node.getExpr(), scope);
        throw new ReturnValue(returnExpr);
    }

    public static Object exec(StmtListNode node, Scope scope) throws InterpreterException {
        scope = new Scope(scope);
        for (StmtNode stmt: node.getStmts()) {
            exec(stmt, scope);
        }
        return "end";
    }

    public static Object exec(ValueNode node, Scope scope) throws InterpreterException {
        return node.getValue();
    }

    public static Object exec(WhileNode node, Scope scope) throws InterpreterException {
        Scope newWhileScope = new Scope(scope);
        while (toBoolean(exec(node.getCondition(), newWhileScope))) {
            exec(node.getStatement(), newWhileScope);
        }
        return null;
    }

}
