(defproject wrepl "0.2"
  :description "A clojure repl which responds to HTTP posts"
  :url "hhttps://github.com/yehohanan7/wrepl"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[compojure "1.1.1"]
                 [ring/ring-jetty-adapter "1.1.1"]
                 [clj-json/clj-json "0.5.1"]]

  :eval-in-leiningen true)
