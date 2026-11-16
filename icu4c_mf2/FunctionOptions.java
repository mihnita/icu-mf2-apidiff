package icu.message2;

type FunctionOptionsMap = std::map<UnicodeString, FunctionValue>;

class FunctionOptions {
    FunctionOptions();

    FunctionOptionsMap getOptions();
    FunctionOptions mergeOptions(FunctionOptions other, UErrorCode status);
}
