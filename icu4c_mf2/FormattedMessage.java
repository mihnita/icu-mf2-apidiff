package icu.message2;

class FormattedMessage implements FormattedValue {
    FormattedMessage(UErrorCode status);

    Appendable appendTo(Appendable appendable, UErrorCode status);
    char16_t charAt(int32_t index, UErrorCode status);
    int32_t length(UErrorCode status);
    UBool nextPosition(ConstrainedFieldPosition cfpos, UErrorCode status);
    StringPiece subSequence(int32_t start, int32_t end, UErrorCode status);
    CharacterIterator toCharacterIterator(UErrorCode status);
    UnicodeString toString(UErrorCode status);
    UnicodeString toTempString(UErrorCode status);
}
