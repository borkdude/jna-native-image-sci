## JNA + Clojure + SCI example

Compile a program that uses JNA to native-image and allow dynamic evaluation using [SCI](https://github.com/babashka/sci).

## Usage

```sh
clojure -T:build uber
./compile.sh
./target/jna -e '(let [clib (com.sun.jna.NativeLibrary/getInstance "c") cos-fn (.getFunction clib "cos")] (.invoke cos-fn Double/TYPE (into-array Object [42.0])))'
```

Config files are from https://github.com/oracle/graalvm-reachability-metadata/blob/master/metadata/net.java.dev.jna/jna/5.8.0/resource-config.json.
