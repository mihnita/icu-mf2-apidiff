# MessageFormat 2 Pseudo-Header Generation Summary

## Goal

The ICU4C (C++) and ICU4J (Java) implementations of Unicode MessageFormat 2 expose different API shapes
and language conventions. To make side-by-side comparison straightforward, this task generated unified,
Java-like "pseudo-header" files in two folders:

- `icu4c_mf2/` (13 files for C++)
- `icu4j_mf2/` (12 files for Java)

---

## What Was Inspected & Filtered

### C++ (`icu4c`)
- **Included**:
  - All public / technology-preview headers under `icu4c/source/i18n/unicode/messageformat2*.h`
    (`messageformat2.h`, `messageformat2_arguments.h`, `messageformat2_data_model.h`,
    `messageformat2_data_model_names.h`, `messageformat2_formattable.h`, `messageformat2_function_registry.h`).
  - The 4 MessageFormat 2 bidi enums referenced by those headers and defined in `icu4c/source/common/unicode/ubidi.h`
    (`UMFBidiIsolationStrategy`, `UMFBidiIsolationStyle`, `UMFBidiOption`, `UMFDirectionality`).
- **Excluded**:
  - All internal implementation headers directly in `icu4c/source/i18n/` outside `unicode/`
    (`messageformat2_allocation.h`, `messageformat2_checker.h`, `messageformat2_errors.h`,
    `messageformat2_evaluation.h`, `messageformat2_function_registry_internal.h`,
    `messageformat2_macros.h`, `messageformat2_parser.h`, `messageformat2_serializer.h`).
  - Internal-only declarations inside the public headers: `OptionMap`, `Matcher`, `PatternPart`,
    `UMarkupType`, and `toStdVector` in `messageformat2_data_model.h`; `ResolvedFunctionOption`
    in `messageformat2_formattable.h`; and `MessageFormatter::getNormalizedPattern()`
    (`@internal ... ICU internal only`) in `messageformat2.h`.
  - All `private`, `protected`, and `friend` members.

### Java (`icu4j`)
- **Included**:
  - All public (including `@draft` and `@Deprecated` technology-preview) classes, interfaces,
    and enums in `icu4j/main/core/src/main/java/com/ibm/icu/message2/`.
  - `MFDataModel.Markup.Kind`: although declared without the `public` keyword in `MFDataModel.java`,
    it is exposed in `Markup`'s public field and constructor signatures and was included for completeness.
- **Excluded**:
  - All 9 package-private classes (`DateTimeFunctionFactory`, `InputSource`, `MFDataModelFormatter`,
    `MFDataModelValidator`, `NumberFunctionFactory`, `OptUtils`, `StringUtils`, `StringView`, `TextFunctionFactory`).
  - All `private` and package-private constructors, fields, methods, and inner classes.

---

## How Signatures Were Normalized

To remove language-specific noise while keeping real API differences visible:

1. **Headers & Imports**:
   - Used `package icu.message2;` (and `package icu.message2.data_model;` for `MFDataModel.java`)
     for C++, and `package com.ibm.icu.message2;` for Java.
   - Omitted all `import` / `#include` directives, comments, Javadoc/Doxygen blocks, and annotations
     (`@Deprecated`, `@Override`, `@SuppressWarnings`).
2. **Modifiers**:
   - Stripped visibility and language-specific modifiers (`public`, `final`, `abstract`, `default`,
     `const`, `virtual`, `explicit`, `override`, `noexcept`, `U_I18N_API*`, and `static` on nested types).
   - Kept `static` on methods, `class` / `interface` / `enum`, domain `extends` / `implements`, and `throws`.
3. **C++ Specifics**:
   - Kept native C++ type names (`UnicodeString`, `UBool`, `int32_t`, `std::vector<T>`, `LocalPointer<T>`, etc.)
     and kept `UErrorCode` and `UParseError` parameters.
   - Stripped `&`, `&&`, and nullable object `*` pointers; represented pointer-plus-length array parameters/returns as `T[]`.
   - Omitted C++ memory and value-semantics boilerplate: destructors (`~Foo`), copy/move constructors, `operator=`,
     `swap`, map-ordering operators (`operator<`, `operator==`), and ICU base classes (`UObject`, `UMemory`).
   - Represented pure-abstract C++ classes (`Function`, `FormattableObject`) as `interface`, and C++
     `typedef` / `using` aliases as `type Name = ...;`.
4. **Member Ordering**:
   - Inside every type, declarations are grouped in a fixed order so diffs align cleanly:
     1. Enum constants (kept in declaration order)
     2. Fields (alphabetical)
     3. Constructors (alphabetical by parameter list)
     4. Methods (alphabetical by method name, then parameter list)
     5. Nested types (alphabetical by type name)

---

## Generated Files & Mapping

Shared concepts use identical filenames across both folders so they can be compared directly:

| Concept               | C++ (`icu4c_mf2/`)                                                                     | Java (`icu4j_mf2/`)                                                                   |
|-----------------------|----------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------|
| Main formatter        | `MessageFormatter.java`                                                                | `MessageFormatter.java`                                                               |
| Data model            | `MFDataModel.java`                                                                     | `MFDataModel.java`                                                                    |
| Function registry     | `MFFunctionRegistry.java`                                                              | `MFFunctionRegistry.java`                                                             |
| Custom function       | `Function.java`                                                                        | `Function.java`                                                                       |
| Formatted output      | `FormattedMessage.java`                                                                | `FormattedMessage.java`                                                               |
| Bidi / Directionality | `Directionality.java`                                                                  | `Directionality.java`                                                                 |
| Arguments & values    | `MessageArguments.java`, `Formattable.java`, `FormattableObject.java`, `DateInfo.java` | *(uses `Map<String, ?>` and `Object`)*                                                |
| Function plumbing     | `FunctionContext.java`, `FunctionOptions.java`, `FunctionValue.java`                   | `FunctionFactory.java`, `FormattedPlaceholder.java`, `PlainStringFormattedValue.java` |
| Parser / Serializer   | *(integrated into `MessageFormatter.Builder` / `getPattern()`)*                        | `MFParser.java`, `MFSerializer.java`, `MFParseException.java`                         |

## Comparing the Two Folders

Run a directory diff from the repository root:

```sh
diff -u icu4c_mf2 icu4j_mf2
```

Or open `icu4c_mf2` and `icu4j_mf2` side-by-side in any visual diff tool (such as Meld, Beyond Compare, or VS Code).
