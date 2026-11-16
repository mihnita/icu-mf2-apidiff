package icu.message2;

class Formattable {
    Formattable();
    Formattable(DateInfo d);
    Formattable(double d);
    Formattable(Formattable[] arr, int32_t len);
    Formattable(FormattableObject obj);
    Formattable(int64_t i);
    Formattable(UnicodeString s);

    icu::Formattable asICUFormattable(UErrorCode status);
    static Formattable forDecimal(std::string_view number, UErrorCode status);
    Formattable[] getArray(int32_t count, UErrorCode status);
    DateInfo getDate(UErrorCode status);
    double getDouble(UErrorCode status);
    int64_t getInt64(UErrorCode status);
    int64_t getInt64Value(UErrorCode status);
    int32_t getLong(UErrorCode status);
    FormattableObject getObject(UErrorCode status);
    UnicodeString getString(UErrorCode status);
    UFormattableType getType();
    UBool isNumeric();
}
