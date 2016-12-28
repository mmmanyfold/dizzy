(ns dizzy.views
    (:require [re-frame.core :as re-frame]
              [dizzy.pages.landing-01 :refer [landing-page-01]]
              [dizzy.pages.feature-01 :refer [feature-page-01]]))


;; landing

(defn landing-page []
  [:div
    [landing-page-01]
    [:a {:href "#/feature"} "go to feature"]])

;; feature

(defn feature-page []
  [feature-page-01])

;; main

(defn- pages [page-name]
  (case page-name
    :landing-page [landing-page]
    :feature-page [feature-page]
    [:div]))

(defn show-page [page-name]
  [pages page-name])

(defn main-page []
  (let [active-page (re-frame/subscribe [:active-page])]
    (fn []
      [show-page @active-page])))
