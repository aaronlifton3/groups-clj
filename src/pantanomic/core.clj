(ns pantanomic.core
  (:use [compojure.core :only [defroutes]]
	      [hiccup.page-helpers :only [html5]])
  (:require [compojure.route :as route]
	    [compojure.handler :as handler]
	    [ring.adapter.jetty :as ring]
	    [pantanomic.controllers.posts]
	    [pantanomic.views.layout :as layout]))

(defroutes routes
  pantanomic.controllers.posts/routes
  (route/resources "/")
  (route/not-found (layout/four-oh-four)))

(def application (handler/site routes))

(defn start [port]
  (ring/run-jetty #'application {:port (or port 8080) :join? false}))

(defn -main []
  (let [port (Integer. (System/getenv "PORT"))]
    (start port)))