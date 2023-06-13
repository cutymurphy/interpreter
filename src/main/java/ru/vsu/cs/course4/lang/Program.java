package ru.vsu.cs.course4.lang;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

import ru.vsu.cs.course4.lang.intepreter.Interpreter;
import ru.vsu.cs.course4.lang.ast.AstNode;
import ru.vsu.cs.course4.lang.intepreter.Scope;

public class Program {
    public static void main(String[] args) throws Exception {
        Reader input = args.length > 0 ? new FileReader(args[0]) : new InputStreamReader(System.in);
        Parser parser = new Parser(input);

        AstNode result = parser.start();

        boolean printTree = false;
        for (String arg : args) {
            if (arg.equals("-ast") || arg.equals("-a") || arg.equals("-print") || arg.equals("-tree")) {
                printTree = true;
                break;
            }
        }

        if (printTree) {
            result.printTree(System.out);
        }

        Scope scope = new Scope(null);
        Interpreter.exec(result, scope);
    }
}
