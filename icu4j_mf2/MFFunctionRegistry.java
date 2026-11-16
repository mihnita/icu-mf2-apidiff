package com.ibm.icu.message2;

class MFFunctionRegistry {
    static Builder builder();
    String getDefaultFunctionNameForType(Class<?> clazz);
    Set<Class<?>> getDefaultFunctionTypes();
    FunctionFactory getFunction(String functionName);
    Set<String> getFunctionNames();
    static MFFunctionRegistry getStandardFunctionsRegistry();

    class Builder {
        Builder addAll(MFFunctionRegistry functionRegistry);
        MFFunctionRegistry build();
        Builder clearDefaultFunctionNames();
        Builder clearFunctions();
        Builder removeDefaultFunctionNameForType(Class<?> clazz);
        Builder removeFunction(String functionName);
        Builder setDefaultFunctionNameForType(Class<?> clazz, String functionName);
        Builder setFunction(String functionName, FunctionFactory functionFactory);
    }
}
