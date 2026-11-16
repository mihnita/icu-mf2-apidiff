package icu.message2;

class MFFunctionRegistry {
    boolean getDefaultFormatterNameByType(String formatterType, FunctionName name);
    Function getFunction(FunctionName functionName);
    static MFFunctionRegistry getStandardFunctionsRegistry();

    class Builder {
        Builder();
        Builder adoptFunction(FunctionName functionName, Function function);
        MFFunctionRegistry build();
        Builder setDefaultFormatterNameByType(String type, FunctionName functionName);
    }
}
