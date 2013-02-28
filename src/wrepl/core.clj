(ns wrepl.core
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

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})

(compojure/defroutes app
  (compojure/POST "/eval" request (eval-clojure request))
  (compojure/GET "/" request
    (response/resource-response "public/index.html"))
  (compojure/GET "/products" [] (json-response [{:id "1" :name "Mac book pro" :price "$22112" :available "ok"}
                                                {:id "1" :name "Mac book pro" :price "$22112" :available "ok"}
                                                {:id "1" :name "Mac book pro" :price "$22112" :available "remove"}
                                                {:id "1" :name "Mac book pro" :price "$22112" :available "ok"}]))
  (route/resources "/"))


(defn -main []
  (prn "http://localhost:7777/ is active")
  (jetty/run-jetty app {:join? true :port 7777}))
