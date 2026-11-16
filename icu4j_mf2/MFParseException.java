package com.ibm.icu.message2;

class MFParseException extends ParseException {
    MFParseException(String message, int errorOffset);

    String getMessage();
}
