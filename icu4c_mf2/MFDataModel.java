package icu.message2.data_model;

type FunctionName = String;
type VariableName = String;

class Binding {
    Binding();
    Binding(VariableName v, Expression e);

    Expression getValue();
    VariableName getVariable();
    static Binding input(String variableName, Expression rhs);
    boolean isLocal();
}

class Expression {
    Expression();

    std::vector<Option> getAttributes();
    Operand getOperand();
    Operator getOperator();
    boolean isFunctionCall();
    boolean isStandaloneAnnotation();

    class Builder {
        Builder();

        Builder addAttribute(String key, Operand value);
        Expression build();
        Builder setOperand(Operand rAnd);
        Builder setOperator(Operator rAtor);
    }
}

class Key {
    Key();
    Key(Literal lit);

    Literal asLiteral();
    boolean isWildcard();
}

class Literal {
    Literal();
    Literal(boolean q, String s);

    boolean isQuoted();
    String quoted();
    String unquoted();
}

class Markup {
    Markup();

    std::vector<Option> getAttributes();
    String getName();
    std::vector<Option> getOptions();
    boolean isClose();
    boolean isOpen();
    boolean isStandalone();

    class Builder {
        Builder();

        Builder addAttribute(String key, Operand value);
        Builder addOption(String key, Operand value);
        Markup build();
        Builder setClose();
        Builder setName(String n);
        Builder setOpen();
        Builder setStandalone();
    }
}

class MFDataModel {
    MFDataModel();

    std::vector<Binding> getLocalVariables();
    Pattern getPattern();
    std::vector<VariableName> getSelectors();
    std::vector<Variant> getVariants();

    class Builder {
        Builder();

        Builder addBinding(Binding b);
        Builder addSelector(VariableName selector);
        Builder addVariant(SelectorKeys keys, Pattern pattern);
        MFDataModel build();
        Builder setPattern(Pattern pattern);
    }
}

class Operand {
    Operand();
    Operand(Literal l);
    Operand(String v);

    Literal asLiteral();
    String asVariable();
    boolean isLiteral();
    boolean isNull();
    boolean isVariable();
}

class Operator {
    Operator();

    FunctionName getFunctionName();
    std::vector<Option> getOptions();

    class Builder {
        Builder();

        Builder addOption(String key, Operand value);
        Operator build();
        Builder setFunctionName(FunctionName func);
    }
}

class Option {
    Option();
    Option(String n, Operand r);

    String getName();
    Operand getValue();
}

class Pattern {
    Pattern();

    Iterator begin();
    Iterator end();

    class Builder {
        Builder();

        Builder add(Expression part);
        Builder add(Markup part);
        Builder add(String part);
        Pattern build();
    }

    class Iterator {
        std::variant<String, Expression, Markup> operator*();
        Iterator operator++();
    }
}

class SelectorKeys {
    SelectorKeys();

    std::vector<Key> getKeys();

    class Builder {
        Builder();

        Builder add(Key key);
        SelectorKeys build();
    }
}

class Variant {
    Variant();
    Variant(SelectorKeys keys, Pattern pattern);

    SelectorKeys getKeys();
    Pattern getPattern();
}
