(defproject pantanomic "0.1.0-SNAPSHOT"
  :description "Cool"
  :url "50.116.39.181"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
		 [org.clojure/java.jdbc "0.1.1"]
                 [postgresql/postgresql "8.4-702.jdbc4"]
                 [ring/ring-jetty-adapter "0.3.10"]
                 [compojure "0.6.4"]
		 [hiccup "0.3.6"]])
