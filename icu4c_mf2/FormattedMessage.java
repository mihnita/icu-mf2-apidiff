package icu.message2;

class FormattedMessage implements FormattedValue {
    FormattedMessage();

    Appendable appendTo(Appendable appendable);
    char16_t charAt(int index);
    int length();
    boolean nextPosition(ConstrainedFieldPosition cfpos);
    StringPiece subSequence(int start, int end);
    CharacterIterator toCharacterIterator();
    String toString();
    String toTempString();
}
