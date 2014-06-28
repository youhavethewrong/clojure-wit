(ns clojure-wit.core-test
  (:require [clojure.test :refer :all]
            [clojure-wit.core :refer :all]
            [clojure.data.json :as json]))

(deftest entities
  (testing "Should get several Wit entities back"
    (is (< 10
           (count
            (get-entities
             (System/getenv "WIT_ACCESS_TOKEN")))))))

(deftest intents
  (testing "Should get several Wit intents back"
    (is (< 10
           (count
            (get-intents
             (System/getenv "WIT_ACCESS_TOKEN")))))))

(deftest hi
  (testing "Just says hi to wit.ai."
    (is (< 2
           (count
            (json/read-str
             (:body
              (clojure-wit.core/wit-api
               (System/getenv "WIT_ACCESS_TOKEN")
               :get "/message?q=hello" ""))
             :key-fn keyword))))))
