(ns dizzy.issue-01.home
  (:require [re-frame.core :as re-frame]
            [reagent.validation :refer [has-value?]]))

(defonce input-state (atom nil))

(defn submit-action []
  (if (has-value? @input-state)
    (re-frame/dispatch [:post-secret-token @input-state])))

(defn issue-01-home []
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
       [:h5 "DIZZY MAGAZINE ISSUE 1"]
       [:p "60 pages, Full Color, Edition of 500"]
       [:p "Featuring: Ellen Berkenblit, Jessica Butler, Livia Charman, Jos Howard Demme, Kayla Ephros, Raque Ford, Patrick Morales, Princess Nokia, Reika Soleimanpour, Diamond Stingily, Rirkrit Tiravanija, Haley Wollens, and Bernadette"]]
      [:div.pay
       [:p "$15.00"]
       [:form {:action "https://www.paypal.com/cgi-bin/webscr", :method "post", :target "_top"}
        [:input {:type "hidden", :name "cmd", :value "_s-xclick"}]
        [:input {:type "hidden", :name "hosted_button_id", :value "3FNDXL4G9ZZEE"}]
        [:input {:type "image", :src "https://www.paypalobjects.com/en_US/i/btn/btn_buynowCC_LG.gif", :name "submit", :alt "PayPal - The safer, easier way to pay online!"}]
        [:img {:src "https://www.paypalobjects.com/en_US/i/scr/pixel.gif", :width "1", :height "1"}]]]]]]
   [:div.unlock.align-center
    [:div.form
     [:input {:class        "input-text"
              :type         "text"
              :name         "token"
              :on-key-press #(when (and (= (.-charCode %) 13)
                                        (has-value? (-> % .-target .-value)))
                               (submit-action))
              :on-change    #(reset! input-state (->
                                                   (-> % .-target .-value)
                                                   .toLowerCase
                                                   .trim))}]
     [:br]
     [:button.submit
      {:on-click submit-action}
      "UNLOCK WEB FEATURE"]]]])
