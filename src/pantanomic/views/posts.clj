(ns pantanomic.views.posts
  (:use [hiccup.core :only [html h]]
        [hiccup.page-helpers :only [doctype]]
        [hiccup.form-helpers :only [form-to label text-area submit-button]])
  (:require [pantanomic.views.layout :as layout]))

(defn post-form []
  [:div {:id "post-form" :class "sixteen columns alpha omega"}
   (form-to [:post "/"]
            (label "post" "What do you want to post?")
            (text-area "post")
            (submit-button "post!"))])

(defn display-posts [posts]
  [:div {:id "posts sixteen columns alpha omega"}
   (map
    (fn [post] [:h2 {:class "post"} (h (:body post))])
    posts)])

(defn index [posts]
  (layout/common "pantanomic"
                 (post-form)
                 [:div {:class "clear"}]
                 (display-posts posts)))
