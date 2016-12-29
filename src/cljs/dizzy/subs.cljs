(ns dizzy.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :active-page
 (fn [db _]
   (:active-page db)))

(re-frame/reg-sub
  :show-error-message?
  (fn [db _]
    (:show-error-message db)))
