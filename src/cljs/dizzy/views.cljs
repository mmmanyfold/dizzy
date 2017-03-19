(ns dizzy.views
    (:require [re-frame.core :as re-frame]
              [dizzy.issue-01.home :refer [issue-01-home]]
              [dizzy.issue-01.features :refer [issue-01-features]]
              [dizzy.issue-01.interview :refer [issue-01-interview]]))


;; landing

(defn landing-page []
  [issue-01-home])

;; feature

(defn features-page []
  [issue-01-features])

;; interview

(defn interview-page []
  [issue-01-interview])

;; main

(defn- pages [page-name]
  (case page-name
    :landing-page [landing-page]
    :features-page [features-page]
    :interview-page [interview-page]
    [:div]))

(defn show-page [page-name]
  [pages page-name])

(defn main-page []
  (let [active-page (re-frame/subscribe [:active-page])]
    (fn []
      [show-page @active-page])))
