package com.ibm.icu.message2;

interface Function {
    FormattedPlaceholder format(Object toFormat, Map<String, ?> variableOptions);
    String formatToString(Object toFormat, Map<String, ?> variableOptions);
    List<String> matches(Object value, List<String> keys, Map<String, ?> variableOptions);
}
