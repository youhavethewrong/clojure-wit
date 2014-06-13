(ns clojure-wit.core-test
  (:require [clojure.test :refer :all]
            [clojure-wit.core :refer :all]))

(deftest get-hi
  (testing "Wit should say hi back."
    (is (= true
           (.contains (clojure-wit.core/say-hi (System/getenv "WIT_ACCESS_TOKEN")) "hello")))))
