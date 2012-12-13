(ns pantanomic.models.post
  (:require [clojure.java.jdbc :as sql]))

(defn all []
  (sql/with-connection (System/getenv "DATABASE_URL")
    (sql/with-query-results results
      ["select * from posts order by id desc"]
      (into [] results))))

(defn create [post]
  (sql/with-connection (System/getenv "DATABASE_URL")
    (sql/insert-values :posts [:body] [post])))

