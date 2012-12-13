(ns pantanomic.controllers.posts
  (:use [compojure.core :only [defroutes GET POST]])
  (:require [clojure.string :as str]
            [ring.util.response :as ring]
            [pantanomic.views.posts :as view]
            [pantanomic.models.post :as model]))

(defn index []
  (view/index (model/all)))

(defn create [params]
  (let [post (:post params)]
    (when-not (str/blank? post)
      (model/create post)))
  (ring/redirect "/"))

(defroutes routes
  (GET  "/" [] (index))
  (POST "/" {params :params} (create params)))

