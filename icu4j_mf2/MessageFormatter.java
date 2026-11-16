package com.ibm.icu.message2;

class MessageFormatter {
    static Builder builder();
    FormattedMessage format(Map<String, ?> arguments);
    String formatToString(Map<String, ?> arguments);
    BidiIsolation getBidiIsolation();
    MFDataModel.Message getDataModel();
    ErrorHandlingBehavior getErrorHandlingBehavior();
    Locale getLocale();
    String getPattern();

    enum BidiIsolation {
        NONE,
        DEFAULT
    }

    class Builder {
        MessageFormatter build();
        Builder setBidiIsolation(BidiIsolation bidiIsolation);
        Builder setDataModel(MFDataModel.Message dataModel);
        Builder setErrorHandlingBehavior(ErrorHandlingBehavior errorHandlingBehavior);
        Builder setFunctionRegistry(MFFunctionRegistry functionRegistry);
        Builder setLocale(Locale locale);
        Builder setPattern(String pattern);
    }

    enum ErrorHandlingBehavior {
        BEST_EFFORT,
        STRICT
    }
}
