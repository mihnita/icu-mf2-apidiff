package icu.message2;

class FunctionContext {
    FunctionName getCalledFunctionName();
    UMFBidiOption getDirection();
    String getID();
    Locale getLocale();
    FunctionContext withLocale(Locale loc);
}
