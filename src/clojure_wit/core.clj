(ns clojure-wit.core
  (:require  [clj-http.client :as client]
             [clojure.data.json :as json]))

(def wit-url "https://api.wit.ai")

(defn wit-api
  "Make HTTP calls against the wit.ai HTTP API."
  [token method path body]
  (client/request
   {:method method
    :url (str wit-url path )
    :headers {"Authorization"
              (str "Bearer " token)}
    :body body}))

(defn say-hi
  "Just says hi to wit.ai."
  [token]
  (let [response (json/read-str
              (:body
               (wit-api token :get "/message?q=hello" ""))
              :key-fn keyword)]
    ((((response :outcome) :entities) :search_query) :value ))) 
