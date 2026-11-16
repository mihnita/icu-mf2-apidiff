package icu.message2;

class FunctionContext {
    FunctionName getCalledFunctionName();
    UMFBidiOption getDirection();
    UnicodeString getID();
    Locale getLocale();
    FunctionContext withLocale(Locale loc);
}
