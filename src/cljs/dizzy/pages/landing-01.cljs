(ns dizzy.pages.landing-01)

(defn landing-page-01 []
  [:div#landing-wrap
    [:div.align-center
     [:img {:src "img/dizzy-logo.jpg"}]]
    [:div.content.flex-row
     [:div.flex-row-item
      [:img {:src "img/01/dizzy-1.jpg"
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
     [:form {:action ""}
      [:input {:class "input-text"
               :type "text"
               :name "token"}]
      [:br]
      [:input {:class "input-submit"
               :type "submit"
               :value "UNLOCK WEB FEATURE"}]]]])
