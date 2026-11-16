This project has C++ and Java implementations of similar functionality, the Unicode `MessageFormatter`.
But the APIs between C++ and Java look quite different.

Look at both implementations and generate a files with a common format, so that they can be easily compared.
Let's call this "pseudo-header" files.

The unified format should be similar to a Java interface: the class / package, methods signatures,
but no language speciffic modifiers (public, final, export, etc), and not method / class API documentation.

For example:
```
class MessageFormatter {
   static MessageFormatter.Builder builder();
   FormattedMessage format(Map<String,?> arguments);
   String formatToString(Map<String,?> arguments);
   MessageFormatter.BidiIsolation getBidiIsolation();
   MFDataModel.Message getDataModel();
}
```

Ignore non-public methods / classes / etc.

Create these pseudo-header files in 2 folders `icu4c_mf2` and `icu4j_mfc`, for C++ and Java respectively.

The C++ files to inspect are all the `messageformat2*` files in `icu4c/source/i18n/`
```sh
find  icu4c/source/i18n/  | grep messageformat2
```

The Java files to inspect are all in the `icu4j/main/core/src/main/java/com/ibm/icu/message2/` folder.

Ask question if something is unclear and you need to make decisions.

