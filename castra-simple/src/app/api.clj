(ns app.api
  (:require [castra.core :refer [defrpc]]))

(defrpc get-state []
  {:random (rand-int 100)})

(defrpc add-numbers [& nums]
  (println nums)
  (apply + (map #(Integer/parseInt %) nums)))
