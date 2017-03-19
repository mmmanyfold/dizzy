(ns dizzy.events
    (:require [re-frame.core :as re-frame]
              [dizzy.db :as db]
              [ajax.core :refer [POST]]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
 :set-active-page
 (fn [db [_ active-page]]
   (assoc db :active-page active-page)))

(re-frame/reg-event-db
  :post-secret-token
  (fn [db [_ token]]
    (POST "https://mmmanyfold-api.herokuapp.com/api/secret"
          {:response-format :json
           :keywords?       true
           :params          {:token token}
           :handler         #(re-frame/dispatch [:post-secret-token-success %])})
    db))

(re-frame/reg-event-db
  :post-secret-token-success
  (fn [db [_ res]]
    (re-frame/dispatch [:set-active-page :features-page])
    db))
