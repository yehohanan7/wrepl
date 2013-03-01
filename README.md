# wrepl

A leiningen plugin to start a repl which responds to http post requests. 

## Usage
### Starting wrepl
lein wrepl [port]

### Connecting to wrepl
you can evaluate clojure expressions by POSTING the expression to http://localhost:port/wrepl/eval 

## Installing
wrepl is published in [clojars](https://clojars.org/wrepl) 

to youse wrepl, update your project.clj like below 
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
