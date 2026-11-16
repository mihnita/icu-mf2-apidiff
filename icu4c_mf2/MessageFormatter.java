package icu.message2;

class MessageFormatter {
    FormattedMessage format(MessageArguments arguments, UErrorCode status);
    UnicodeString formatToString(MessageArguments arguments, UErrorCode status);
    MFDataModel getDataModel();
    Locale getLocale();
    UnicodeString getPattern();

    class Builder {
        Builder(UErrorCode status);

        MessageFormatter build(UErrorCode status);
        Builder setBidiContext(UMFBidiContext dir);
        Builder setBidiIsolationStrategy(UMFBidiIsolationStrategy strategy);
        Builder setBidiIsolationStyle(UMFBidiIsolationStyle style);
        Builder setDataModel(MFDataModel dataModel);
        Builder setErrorHandlingBehavior(UMFErrorHandlingBehavior type);
        Builder setFunctionRegistry(MFFunctionRegistry functionRegistry);
        Builder setLocale(Locale locale);
        Builder setPattern(UnicodeString pattern, UParseError parseError, UErrorCode status);
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
