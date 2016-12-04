(ns app.rpc
  (:require-macros
   [javelin.core :refer [defc defc=]])
  (:require
   [javelin.core]
   [castra.core :refer [mkremote]]))

(defc state {:random nil})
(defc error nil)
(defc loading [])

(defc= random-number (get state :random))

(def get-state
  (mkremote 'app.api/get-state state error loading))

(defc add-result nil)
(def add-numbers
  (mkremote 'app.api/add-numbers add-result error loading))

(defc upload-file-cell nil)
(def upload-file
  (mkremote 'app.api/upload-file upload-file-cell upload-file-cell upload-file-cell))

(defn init []
  (get-state)
  (js/setInterval get-state 1000))
