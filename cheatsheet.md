# Optional Cheatsheet

### 1. Create `null` Optional
```java
Optional<String> stringOptional = Optional.empty();
```

### 2. Create Optional from a `Value`
```java
Optional<String> nameOptional = Optional.of("SomeName");
```   
or   
```java
String name = "SomeName";
Optional<String> nameOptional = Optional.of(name);
```


### 3. Create Optional of `nullable` Objects
```java
String name = null;
Optional<String> nameOptional = Optional.ofNullable(name);
```

### 4. Create Optional of `Objects`
```java
Customer customer = new Customer();
Optional<Customer> customerOptional = Optional.ofNullable(customer);
``` 

