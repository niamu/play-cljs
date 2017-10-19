(set-env!
 :resource-paths #{"src"}
 :dependencies '[[org.clojure/clojurescript "1.9.908" :scope "provided"]
                 [org.clojure/core.async "0.3.443"]]
 :repositories (conj (get-env :repositories)
                     ["clojars" {:url "https://clojars.org/repo/"
                                 :username (System/getenv "CLOJARS_USER")
                                 :password (System/getenv "CLOJARS_PASS")}]))

(task-options! pom {:project 'com.niamu/play-cljs
                    :version "0.10.2"
                    :description "A ClojureScript game library"
                    :url "https://github.com/niamu/play-cljs"
                    :license {"Public Domain" "http://unlicense.org/UNLICENSE"}}
               push {:repo "clojars"})

(deftask local []
  (comp (pom) (jar) (install)))

(deftask deploy []
  (comp (pom) (jar) (push)))
