package com.ibm.icu.message2;

class PlainStringFormattedValue implements FormattedValue {
    PlainStringFormattedValue(String value);

    <A extends Appendable> A appendTo(A appendable);
    char charAt(int index);
    int length();
    boolean nextPosition(ConstrainedFieldPosition cfpos);
    CharSequence subSequence(int start, int end);
    AttributedCharacterIterator toCharacterIterator();
    String toString();
}
