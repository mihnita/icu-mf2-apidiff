package com.ibm.icu.message2;

class MFDataModel {
    class Attribute {
        String name;
        LiteralOrVariableRef value;

        Attribute(String name, LiteralOrVariableRef value);
    }

    class CatchallKey implements LiteralOrCatchallKey {
        CatchallKey();

        static boolean isCatchAll(String key);
    }

    interface Declaration {
    }

    interface Expression extends PatternPart {
    }

    class FunctionExpression implements Expression {
        List<Attribute> attributes;
        FunctionRef function;

        FunctionExpression(FunctionRef function, List<Attribute> attributes);
    }

    class FunctionRef {
        String name;
        Map<String, Option> options;

        FunctionRef(String name, Map<String, Option> options);
    }

    class InputDeclaration implements Declaration {
        String name;
        VariableExpression value;

        InputDeclaration(String name, VariableExpression value);
    }

    class Literal implements LiteralOrVariableRef, LiteralOrCatchallKey {
        String value;

        Literal(String value);
    }

    class LiteralExpression implements Expression {
        Literal arg;
        List<Attribute> attributes;
        FunctionRef function;

        LiteralExpression(Literal arg, FunctionRef function, List<Attribute> attributes);
    }

    interface LiteralOrCatchallKey {
    }

    interface LiteralOrVariableRef {
    }

    class LocalDeclaration implements Declaration {
        String name;
        Expression value;

        LocalDeclaration(String name, Expression value);
    }

    class Markup implements Expression {
        List<Attribute> attributes;
        Kind kind;
        String name;
        Map<String, Option> options;

        Markup(Kind kind, String name, Map<String, Option> options, List<Attribute> attributes);

        enum Kind {
            OPEN,
            CLOSE,
            STANDALONE
        }
    }

    interface Message {
    }

    class Option {
        String name;
        LiteralOrVariableRef value;

        Option(String name, LiteralOrVariableRef value);
    }

    class Pattern {
        List<PatternPart> parts;
    }

    class PatternMessage implements Message {
        List<Declaration> declarations;
        Pattern pattern;

        PatternMessage(List<Declaration> declarations, Pattern pattern);
    }

    interface PatternPart {
    }

    class SelectMessage implements Message {
        List<Declaration> declarations;
        List<Expression> selectors;
        List<Variant> variants;

        SelectMessage(List<Declaration> declarations, List<Expression> selectors, List<Variant> variants);
    }

    class StringPart implements PatternPart {
        String value;
    }

    class VariableExpression implements Expression {
        VariableRef arg;
        List<Attribute> attributes;
        FunctionRef function;

        VariableExpression(VariableRef arg, FunctionRef function, List<Attribute> attributes);
    }

    class VariableRef implements LiteralOrVariableRef {
        String name;

        VariableRef(String name);
    }

    class Variant implements LiteralOrCatchallKey {
        List<LiteralOrCatchallKey> keys;
        Pattern value;

        Variant(List<LiteralOrCatchallKey> keys, Pattern value);
    }
}
