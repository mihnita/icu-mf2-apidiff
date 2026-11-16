package icu.message2;

class MFFunctionRegistry {
    UBool getDefaultFormatterNameByType(UnicodeString formatterType, FunctionName name);
    Function getFunction(FunctionName functionName);
    static MFFunctionRegistry getStandardFunctionsRegistry(UErrorCode status);

    class Builder {
        Builder(UErrorCode errorCode);

        Builder adoptFunction(FunctionName functionName, Function function, UErrorCode errorCode);
        MFFunctionRegistry build();
        Builder setDefaultFormatterNameByType(UnicodeString type, FunctionName functionName, UErrorCode errorCode);
    }
}
