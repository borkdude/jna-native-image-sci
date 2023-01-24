(ns com.phronemophobic.native-image.jna
  (:require
   [sci.core :as sci])
  (:gen-class))

(set! *warn-on-reflection* true)

(def ctx (delay (sci/init {:classes {'com.sun.jna.Function (Class/forName "com.sun.jna.Function")
                                     'com.sun.jna.NativeLibrary (Class/forName "com.sun.jna.NativeLibrary")
                                     'java.lang.Double Double}
                           :imports {'Double 'java.lang.Double}})))

(defn -main [& [_e expr]]
  ;; example expression
  '(let [clib (com.sun.jna.NativeLibrary/getInstance "c")
         cos-fn (.getFunction clib "cos")]
     (.invoke cos-fn Double/TYPE (into-array Object [42.0])))
  (let [ctx @ctx]
    (prn (sci/eval-string* ctx expr))))

