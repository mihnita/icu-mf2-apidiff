package icu.message2.data_model;

type FunctionName = UnicodeString;
type VariableName = UnicodeString;

class Binding {
    Binding();
    Binding(VariableName v, Expression e);

    Expression getValue();
    VariableName getVariable();
    static Binding input(UnicodeString variableName, Expression rhs, UErrorCode errorCode);
    UBool isLocal();
}

class Expression {
    Expression();

    std::vector<Option> getAttributes();
    Operand getOperand();
    Operator getOperator(UErrorCode status);
    UBool isFunctionCall();
    UBool isStandaloneAnnotation();

    class Builder {
        Builder(UErrorCode status);

        Builder addAttribute(UnicodeString key, Operand value, UErrorCode status);
        Expression build(UErrorCode status);
        Builder setOperand(Operand rAnd);
        Builder setOperator(Operator rAtor);
    }
}

class Key {
    Key();
    Key(Literal lit);

    Literal asLiteral();
    UBool isWildcard();
}

class Literal {
    Literal();
    Literal(UBool q, UnicodeString s);

    UBool isQuoted();
    UnicodeString quoted();
    UnicodeString unquoted();
}

class Markup {
    Markup();

    std::vector<Option> getAttributes();
    UnicodeString getName();
    std::vector<Option> getOptions();
    UBool isClose();
    UBool isOpen();
    UBool isStandalone();

    class Builder {
        Builder(UErrorCode status);

        Builder addAttribute(UnicodeString key, Operand value, UErrorCode status);
        Builder addOption(UnicodeString key, Operand value, UErrorCode status);
        Markup build(UErrorCode status);
        Builder setClose();
        Builder setName(UnicodeString n);
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
        Builder(UErrorCode status);

        Builder addBinding(Binding b, UErrorCode status);
        Builder addSelector(VariableName selector, UErrorCode errorCode);
        Builder addVariant(SelectorKeys keys, Pattern pattern, UErrorCode errorCode);
        MFDataModel build(UErrorCode status);
        Builder setPattern(Pattern pattern);
    }
}

class Operand {
    Operand();
    Operand(Literal l);
    Operand(UnicodeString v);

    Literal asLiteral();
    UnicodeString asVariable();
    UBool isLiteral();
    UBool isNull();
    UBool isVariable();
}

class Operator {
    Operator();

    FunctionName getFunctionName();
    std::vector<Option> getOptions();

    class Builder {
        Builder(UErrorCode status);

        Builder addOption(UnicodeString key, Operand value, UErrorCode status);
        Operator build(UErrorCode status);
        Builder setFunctionName(FunctionName func);
    }
}

class Option {
    Option();
    Option(UnicodeString n, Operand r);

    UnicodeString getName();
    Operand getValue();
}

class Pattern {
    Pattern();

    Iterator begin();
    Iterator end();

    class Builder {
        Builder(UErrorCode status);

        Builder add(Expression part, UErrorCode status);
        Builder add(Markup part, UErrorCode status);
        Builder add(UnicodeString part, UErrorCode status);
        Pattern build(UErrorCode status);
    }

    class Iterator {
        std::variant<UnicodeString, Expression, Markup> operator*();
        Iterator operator++();
    }
}

class SelectorKeys {
    SelectorKeys();

    std::vector<Key> getKeys();

    class Builder {
        Builder(UErrorCode status);

        Builder add(Key key, UErrorCode status);
        SelectorKeys build(UErrorCode status);
    }
}

class Variant {
    Variant();
    Variant(SelectorKeys keys, Pattern pattern);

    SelectorKeys getKeys();
    Pattern getPattern();
}
