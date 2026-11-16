package icu.message2;

class MessageFormatter {
    FormattedMessage format(MessageArguments arguments);
    String formatToString(MessageArguments arguments);
    MFDataModel getDataModel();
    Locale getLocale();
    String getPattern();

    class Builder {
        MessageFormatter build();
        Builder setBidiContext(UMFBidiContext dir);
        Builder setBidiIsolationStrategy(UMFBidiIsolationStrategy strategy);
        Builder setBidiIsolationStyle(UMFBidiIsolationStyle style);
        Builder setDataModel(MFDataModel dataModel);
        Builder setErrorHandlingBehavior(UMFErrorHandlingBehavior type);
        Builder setFunctionRegistry(MFFunctionRegistry functionRegistry);
        Builder setLocale(Locale locale);
        Builder setPattern(String pattern, UParseError parseError);
    }

    enum UMFBidiContext {
        U_MF_BIDI_CONTEXT_LTR,
        U_MF_BIDI_CONTEXT_RTL,
        U_MF_BIDI_CONTEXT_AUTO,
        U_MF_BIDI_CONTEXT_DEFAULT = U_MF_BIDI_CONTEXT_AUTO
    }

    enum UMFErrorHandlingBehavior {
        U_MF_BEST_EFFORT,
        U_MF_STRICT
    }
}
