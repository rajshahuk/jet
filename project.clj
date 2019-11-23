(def jetty-version "9.4.24.v20191120")
(defproject com.twelvenines/jet "0.0.1"
  :description "Jetty9 ring server adapter with WebSocket support"
  :url "https://github.com/rajshahuk/jet"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/core.async "0.5.527"]
                 [org.eclipse.jetty/jetty-server ~jetty-version]
                 [org.eclipse.jetty.http2/http2-server ~jetty-version]
                 [org.eclipse.jetty.websocket/websocket-server ~jetty-version]
                 [org.eclipse.jetty.websocket/websocket-servlet ~jetty-version]
                 [org.eclipse.jetty.websocket/websocket-client ~jetty-version]
                 [org.eclipse.jetty/jetty-client ~jetty-version]
                 [org.eclipse.jetty/jetty-alpn-server ~jetty-version]
                 [org.eclipse.jetty.alpn/alpn-api "1.1.3.v20160715"]
                 [org.eclipse.jetty.http2/http2-common ~jetty-version]
                 ;; [org.eclipse.jetty.http2/http2-http-client-transport ~jetty-version]
                 ;; [org.eclipse.jetty.http2/http2-client ~jetty-version]
                 ;; [org.eclipse.jetty/jetty-alpn-client ~jetty-version]
                 [cheshire "5.9.0"]]
  :repositories {"sonatype" {:url "http://oss.sonatype.org/content/repositories/releases"
                             :snapshots false
                             :releases {:checksum :fail :update :always}}
                 "sonatype-snapshots" {:url "http://oss.sonatype.org/content/repositories/snapshots"
                                       :snapshots true
                                       :releases {:checksum :fail :update :always}}}
  :profiles {:master {:dependencies [[org.clojure/clojure "1.9.0-master-SNAPSHOT"]]}
             :dev  {:dependencies [[ring/ring-core "1.8.0"
                                    :exclusions [javax.servlet/servlet-api]]
                                   [ring/ring-servlet "1.8.0"
                                    :exclusions [javax.servlet/servlet-api]]
                                   [codox "0.10.7"]
                                   [org.slf4j/slf4j-log4j12 "1.7.29"]]}}
  :jar-exclusions [#"log4j.properties"]
  :aliases {"all" ["with-profile" "dev:dev,1.5:dev,1.6:dev,1.7:dev,master"]}
  :codox {:src-dir-uri "https://github.com/mpenet/jet/blob/master/"
          :src-linenum-anchor-prefix "L"
          :output-dir "doc"
          :defaults {:doc/format :markdown}}
  :source-paths ["src/clj"]
  :java-source-paths ["src/java"]
  :global-vars {*warn-on-reflection* true})
