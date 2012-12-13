(ns pantanomic.models.migration
  (:require [clojure.java.jdbc :as sql]))

(defn create-posts []
  (sql/with-connection (System/getenv "DATABASE_URL")
    (sql/create-table :posts
                      [:id :serial "PRIMARY KEY"]
                      [:body :varchar "NOT NULL"]
                      [:created_at :timestamp "NOT NULL" "DEFAULT 
CURRENT_TIMESTAMP"]
                      [:parent :integer "DEFAULT 0"])))

(defn -main []
  (print "Migrating database...") (flush)
  (create-posts)
  (println " done"))
