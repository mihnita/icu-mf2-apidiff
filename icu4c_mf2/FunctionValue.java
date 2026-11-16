package icu.message2;

class FunctionValue {
    String formatToString();
    UMFDirectionality getDirection();
    UMFBidiOption getDirectionAnnotation();
    String getFallback();
    FunctionName getFunctionName();
    FunctionOptions getResolvedOptions();
    boolean isNullOperand();
    boolean isSelectable();
    void selectKeys(String[] keys, int keysLen, int[] prefs, int prefsLen);
    Formattable unwrap();
}
