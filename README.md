# wrepl

A Leiningen plugin to start a REPL which responds to HTTP POST requests. 

## Usage
### Starting wrepl
lein wrepl [port]

### Connecting to wrepl
You can evaluate Clojure expressions by POSTing the expression to http://localhost:port/wrepl/eval 

## Installing
wrepl is published in [clojars](https://clojars.org/wrepl) 

To use wrepl, update your project.clj as shown below:

```clojure  
(defproject yourproject "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]]
  
  :plugins [[wrepl/wrepl "0.3"]]) 
  
```

## License

Copyright © 2013 FIXME

Distributed under the Eclipse Public License, the same as Clojure.
