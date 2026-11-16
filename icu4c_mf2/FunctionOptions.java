package icu.message2;

type FunctionOptionsMap = std::map<String, FunctionValue>;

class FunctionOptions {
    FunctionOptions();

    FunctionOptionsMap getOptions();
    FunctionOptions mergeOptions(FunctionOptions other);
}
