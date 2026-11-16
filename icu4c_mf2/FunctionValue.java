package icu.message2;

class FunctionValue {
    UnicodeString formatToString(UErrorCode status);
    UMFDirectionality getDirection();
    UMFBidiOption getDirectionAnnotation();
    UnicodeString getFallback();
    FunctionName getFunctionName();
    FunctionOptions getResolvedOptions();
    UBool isNullOperand();
    UBool isSelectable();
    void selectKeys(UnicodeString[] keys, int32_t keysLen, int32_t[] prefs, int32_t prefsLen, UErrorCode status);
    Formattable unwrap();
}
