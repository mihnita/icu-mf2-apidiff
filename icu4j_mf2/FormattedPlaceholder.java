package com.ibm.icu.message2;

class FormattedPlaceholder {
    FormattedPlaceholder(Object inputValue, FormattedValue formattedValue);
    FormattedPlaceholder(Object inputValue, FormattedValue formattedValue, Directionality directionality, boolean isolate);

    Directionality getDirectionality();
    FormattedValue getFormattedValue();
    Object getInput();
    boolean getIsolate();
    String toString();
}
