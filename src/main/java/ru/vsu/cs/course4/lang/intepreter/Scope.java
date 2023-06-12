    package ru.vsu.cs.course4.lang.intepreter;

    import java.util.HashMap;
    import java.util.Map;

    public class Scope { //работа с областями видимости в интерпретаторе
        // Object = Integer, Double, String, Boolean, null, FuncNode, BuiltInObj
        private Map<String, Object> vars = new HashMap<>(); //хранит переменные в текущей области видимости в виде отображения
        private Scope parentScope;

        public Scope (Scope parentScope) {
            this.parentScope = parentScope;
        }

        public Object findVar(String name) throws InterpreterException { //ищет переменную по имени в текущей и родительских областях видимости
            Scope curr = this;
            while (curr != null) {
                if (curr.vars.containsKey(name)) {
                    return curr.vars.get(name);
                } else {
                    curr = curr.parentScope;
                }
            }
            throw new InterpreterException(String.format("Variable %s not found", name));
        }

        //добавляет переменную с указанным именем и значением в текущую или родительскую область видимости.
        // Если переменная уже существует, ее значение будет обновлено
        public void addVar(String name, Object value) {
            Scope curr = this;
            while (curr != null) {
                if (curr.vars.containsKey(name)) {
                    curr.vars.put(name, value);
                    return;
                } else {
                    curr = curr.parentScope;
                }
            }
            this.vars.put(name, value);
        }
    }

