(ns app.api
  (:require [castra.core :refer [defrpc]]))

(defrpc get-state []
  {:random (rand-int 100)})

(defrpc add-numbers [& nums]
  (println nums)
  (apply + (map #(Integer/parseInt %) nums)))

(defrpc upload-file [{:keys [size bytes name]}]
  (when (not (= (count bytes) size))
    (throw (ex-info "number of bytes uploaded doesn't match given file size.")))
  (println "File size:" size)
  (println "File name:" name)
  (println "First 10 bytes:" (take 10 bytes)))
