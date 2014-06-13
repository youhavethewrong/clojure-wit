(ns clojure-wit.core-test
  (:require [clojure.test :refer :all]
            [clojure-wit.core :refer :all]))

(deftest a-test
  (testing "Nothing is truly nothing."
    (is (= 0 0))))
