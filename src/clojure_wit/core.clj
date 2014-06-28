(ns clojure-wit.core
  (:require  [clj-http.client :as client]
             [clojure.data.json :as json]))

(def wit-url "https://api.wit.ai")

(defn jsonify
  "Convert a string to JSON."
  [json]
  (json/read-str json :key-fn keyword))

(defn wit-api
  "Make HTTP calls against the wit.ai HTTP API."
  [token method path body]
  (client/request
   {:method method
    :url (str wit-url path )
    :headers {"Authorization"
              (str "Bearer " token)}
    :body body}))

(defn get-intents
  "Get the current intents registered with Wit."
  [token]
  (:body ( wit-api token :get "/intents" nil))) 

(defn get-entities
  "Get the current entities registered with Wit."
  [token]
  (:body ( wit-api token :get "/entities" nil))) 
