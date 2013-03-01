(ns leiningen.wrepl
  (:require [compojure.route :as route]
            [compojure.core :as compojure]
            [ring.util.response :as response]
            [ring.adapter.jetty :as jetty]
            [clj-json.core :as json]))


(defn eval-clojure [request]
  (try
    (let [expr (read-string (slurp (:body request)))]
      (pr-str (eval expr)))
    (catch Throwable t
      (str "ERROR: " t))))

(defn response [data]
  {:status 200
   :headers {"Content-Type" "text/plain"
             "Access-Control-Allow-Origin" "*"
             "Access-Control-Allow-Methods" "POST, GET, OPTIONS"
             "Access-Control-Max-Age" "1000"
             "Access-Control-Allow-Headers" "Content-Type"}
   :body data})


(compojure/defroutes app
  (compojure/POST "/wrepl/eval" request (response (eval-clojure request)))
  (compojure/GET "/" request
    (str "Wrepl!"))
  (route/resources "/"))

(defn run-repl [port]
  (prn "Staring wRepl on port " port)
  (jetty/run-jetty app {:join? true :port port})
  )

(defn wrepl [project & args]
  (if-let [port (first args)]
    (run-repl (Integer. port))
    (run-repl 7777))
  )

