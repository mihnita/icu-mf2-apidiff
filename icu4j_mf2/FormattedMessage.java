package com.ibm.icu.message2;

class FormattedMessage implements FormattedValue {
    FormattedMessage();

    <A extends Appendable> A appendTo(A appendable);
    char charAt(int index);
    int length();
    boolean nextPosition(ConstrainedFieldPosition cfpos);
    CharSequence subSequence(int start, int end);
    AttributedCharacterIterator toCharacterIterator();
}
