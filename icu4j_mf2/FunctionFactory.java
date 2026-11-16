package com.ibm.icu.message2;

interface FunctionFactory {
    Function create(Locale locale, Map<String, ?> fixedOptions);
}
