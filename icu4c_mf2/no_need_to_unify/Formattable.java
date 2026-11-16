package icu.message2;

class Formattable {
    Formattable();
    Formattable(DateInfo d);
    Formattable(double d);
    Formattable(Formattable[] arr, int len);
    Formattable(FormattableObject obj);
    Formattable(long i);
    Formattable(String s);

    icu::Formattable asICUFormattable();
    static Formattable forDecimal(std::string_view number);
    Formattable[] getArray(int count, );
    DateInfo getDate();
    double getDouble();
    long getInt64();
    long getInt64Value();
    int getLong();
    FormattableObject getObject();
    String getString();
    UFormattableType getType();
    boolean isNumeric();
}
