(ns dizzy.pages.landing-01
  (:require [re-frame.core :as re-frame]
            [reagent.validation :refer [has-value?]]))

(defonce input-state (atom nil))

;(add-watch input-state
;           :watcher
;           (fn [_ _ old-state new-state]
;               (js/console.log "-- atom changed --")
;               (js/console.log new-state)))

(defn submit-action []
  (if (has-value? @input-state)
    (re-frame/dispatch [:post-secret-token @input-state])))

(defn landing-page-01 []
  [:div#landing-wrap
   [:div.align-center
    [:img {:src "img/dizzy-logo.jpg"}]]
   [:div.content.flex-row
    [:div.flex-row-item
     [:img {:src   "img/01/dizzy-1.jpg"
            :width "100%"}]]
    [:div.flex-row-item
     [:div.flex-col
      [:div
       [:h4 "DIZZY MAGAZINE ISSUE 1"]
       [:p "60 pages Full Color"
        [:br] "Featuring: Ellen Berkenblit, Jessica Butler, Livia Charman, Jos Demme, Kayla Ephros, Raque Ford, Patrick Morales, Princess Nokia, Reika Pia Soleimanpour, Diamond Stingly, Rirkrit Tiravanija, Haley Wollens, and Bernadette"]]
      [:div.pay
       [:p "$15.00"]
       [:button "paypal placeholder"]]]]]
   [:div.unlock.align-center
    [:div.form
     [:input {:class        "input-text"
              :type         "text"
              :name         "token"
              :on-key-press #(when (and (= (.-charCode %) 13)
                                        (has-value? (-> % .-target .-value)))
                               (submit-action))
              :on-change    #(reset! input-state (.toLowerCase (-> % .-target .-value)))}]
     [:br]
     [:button.submit
      {:on-click submit-action}
      "UNLOCK WEB FEATURE"]]]])