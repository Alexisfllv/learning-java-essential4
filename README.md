## 🧠 Java - Predicate

- `Predicate<T>` es una **interfaz funcional** que representa una función con:
- Entrada: un solo valor de tipo `T`
- Salida: `boolean`

### ✅ Ejemplo básico

```java

Predicate<Integer> mayorQue10 = x -> x > 10;

boolean res = mayorQue10.test(15); // true

```

  ### 🔗 Métodos útiles

- `.and()`: combina con otro `Predicate` usando lógica AND.
- `.or()`: lógica OR.
- `.negate()`: invierte el resultado.
### 🔍 Ejemplo combinado

```java

Predicate<Integer> p1 = x -> x > 10;

Predicate<Integer> p2 = x -> x < 20;

Predicate<Integer> combinado = p1.and(p2);

boolean resultado = combinado.test(15); // true

```
### 🧩 Para dos argumentos → usa `BiPredicate<T, U>`

```java

BiPredicate<Integer, Integer> mayor = (a, b) -> a > b;

mayor.test(5, 3); // true

```
## 🧠 Java - Predicate (Resumen)

`Predicate<T>` es una interfaz funcional con un método `boolean test(T t)`.
### 🔧 Métodos clave

- `and(Predicate other)` → `true` si ambos son `true`.

- `or(Predicate other)` → `true` si al menos uno es `true`.

- `negate()` → invierte el resultado (`true` ⇄ `false`).

- `isEqual(Object targetRef)` → compara con un valor fijo.

### 🧪 Ejemplos

```java
Predicate<Integer> gt10 = x -> x > 10;
Predicate<Integer> lt20 = x -> x < 20;


gt10.and(lt20).test(15); // true

gt10.or(lt20).test(5); // true

gt10.negate().test(5); // true

Predicate.isEqual("hello").test("hello"); // true
```

---
## 🔧 Java - Function<T, R> (Resumen)

`Function<T, R>` es una interfaz funcional que:

- Recibe un valor de tipo `T`
- Retorna un valor de tipo `R`

### 🧪 Ejemplo básico

```java
Function<Integer, String> intToStr = x -> "Valor: " + x;
String res = intToStr.apply(5); // "Valor: 5"
```

### 🔗 Métodos clave

- `apply(T t)` → ejecuta la función
- `compose(Function before)` → primero `before`, luego `this`
- `andThen(Function after)` → primero `this`, luego `after`
- `identity()` → devuelve una función que retorna su input
### 🔄 Orden de ejecución

```java
Function<Integer, Integer> suma = x -> x + 1;
Function<Integer, Integer> duplica = x -> x * 2;
duplica.compose(suma).apply(3); // (3 + 1) * 2 = 8
suma.andThen(duplica).apply(3); // (3 + 1) * 2 = 8
```

📌 `compose`: primero la que pasas → `f(g(x))`
📌 `andThen`: primero la actual → `g(f(x))`

### 🪞 identity()

```java
Function<String, String> misma = Function.identity();
misma.apply("Hola"); // "Hola"
```

# 🧠 Java Lambdas, Consumer y Supplier (Resumen)

## 🔹 Lambda Expressions
- Son funciones anónimas.
- Sintaxis: `(parametros) -> expresión_o_bloque`

```java
x -> x * x // Una sola expresión
(x, y) -> x + y // Varios parámetros
() -> 42 // Sin parámetros

```
## 🔸 Functional Interfaces
- Interfaces con un solo método abstracto.
- Ejemplos comunes: `Consumer`, `Supplier`, `Predicate`, `Function`.

## 🔹 Consumer

- Recibe un valor de tipo `T` y **no retorna nada**.
- Se usa con `.accept(valor)`.
```java

Consumer<String> imprimir = x -> System.out.println("Hola " + x);
imprimir.accept("Mundo"); // Imprime: Hola Mundo

```

---
## 🔹 Supplier
- **No recibe nada**, pero retorna un valor de tipo `T`.
- Se usa con `.get()`.
```java
Supplier<String> saludar = () -> "Hola desde Supplier";
System.out.println(saludar.get()); // Imprime: Hola desde Supplier
```

---
## 🧪 Mini ejemplo combinado

```java
Consumer<Integer> doble = n -> System.out.println(n * 2);
Supplier<Integer> generarNumero = () -> 10;
doble.accept(generarNumero.get()); // Imprime: 20
```

---
## ✅ Uso común
- `Consumer`: imprimir, registrar, actualizar estados.
- `Supplier`: generar datos, valores por defecto, recursos.
