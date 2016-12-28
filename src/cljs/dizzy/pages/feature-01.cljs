(ns dizzy.pages.feature-01
  (:require [reagent.core :as reagent :refer [atom]]
            [cljsjs.jquery]))

(defonce og-img "../img/01/LC_BonusFeatures.jpg")
(defonce hover1 "../img/01/LC_Hover1.jpg")
(defonce hover2 "../img/01/LC_Hover2.jpg")
(defonce hover3 "../img/01/LC_Hover3.jpg")
(defonce hover4 "../img/01/LC_Hover4.jpg")

(defonce image-state (atom og-img))

(defn feature-page-01 []
  (reagent/create-class
    {:component-did-mount
     (fn []
      (.rwdImageMaps (js/$ "img[usemap]")))
     :reagent-render
     (fn []
      [:div#feature-wrap.align-center
       [:img.image-map-cover {:src @image-state
                              :useMap "#image-map"}]
       [:map {:name "image-map"}
        [:area {:shape "poly"
                :href "#"
                :coords "234,149,336,128,380,140,411,134,548,173,580,145,613,170,631,222,618,275,584,318,528,350,448,404,360,423,282,393,208,319,145,264,126,200,144,141,183,111,198,139"
                :onMouseOver #(reset! image-state hover1)
                :onMouseOut #(reset! image-state og-img)}]
        [:area {:shape "poly"
                :href "#"
                :coords "817,108,826,137,892,147,963,126,1007,141,1043,132,1115,166,1185,178,1206,151,1216,144,1248,180,1258,227,1247,274,1213,320,1156,350,1079,405,993,423,913,389,839,317,779,270,752,221,766,151"
                :onMouseOver #(reset! image-state hover2)
                :onMouseOut #(reset! image-state og-img)}]
        [:area {:shape "poly"
                :href "#"
                :coords "187,482,203,517,263,522,332,502,382,516,413,506,502,542,561,551,584,521,625,564,626,628,593,684,528,724,449,779,364,797,275,761,207,695,132,611,143,516"
                :onMouseOver #(reset! image-state hover3)
                :onMouseOut #(reset! image-state og-img)}]
        [:area {:shape "poly"
                :href "#"
                :coords "815,482,858,525,958,504,1010,518,1044,509,1146,550,1208,524,1255,564,1259,609,1232,674,1158,725,1079,778,992,798,909,761,835,695,762,617,762,533"
                :onMouseOver #(reset! image-state hover4)
                :onMouseOut #(reset! image-state og-img)}]]])}))
