## MessageFormatter

`MessageFormatter` seems close enough, needs some cleanup around BiDi stuff.

There is a `UMFBidiContext` in `MessageFormatter.java`,
and `UMFBidiIsolationStrategy`, `UMFBidiIsolationStyle`, `UMFBidiOption`, `UMFDirectionality` in `Directionality.java`.
Feels a bit much.

## FormattedMessage

OK as is.

## MessageArguments

OK as is.

It is pretty much a `std::map<String, Formattable>`, Java uses `Map<String, ?>`, same thing.

## Big ticket itmems

### Custom functions and function registry

MFFunctionRegistry

Main class to unify.

### Data model

