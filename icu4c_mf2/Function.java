package icu.message2;

interface Function {
    LocalPointer<FunctionValue> call(FunctionContext context, FunctionValue operand, FunctionOptions options);
}
