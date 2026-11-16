package com.ibm.icu.message2;

enum Directionality {
    UNKNOWN,
    LTR,
    RTL,
    AUTO,
    INHERIT;

    static Directionality of(Locale locale);
}
