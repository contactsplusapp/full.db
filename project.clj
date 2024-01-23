(defproject fullcontact/full.db "1.0.8"
  :description "DB sugar (Korma + hikariCP + core.async)."
  :url "https://github.com/contactsplusapp/full.db"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo}
  :repositories [["fullcontact" {:url "https://contactsplus.jfrog.io/artifactory/repo"}]
                 ["releases" {:url "https://contactsplus.jfrog.io/artifactory/libs-release-local"}]
                 ["snapshots" {:url "https://contactsplus.jfrog.io/artifactory/libs-snapshot-local"}]]
  :deploy-repositories [["releases" {:url "https://contactsplus.jfrog.io/artifactory/libs-release-local" :sign-releases false}]
                        ["snapshots" {:url "https://contactsplus.jfrog.io/artifactory/libs-snapshot-local" :sign-releases false}]]
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [korma "0.4.3"]
                 [hikari-cp "2.14.0"]
                 [fullcontact/full.core "1.1.3" :exclusions [org.clojure/clojurescript]]
                 [fullcontact/full.metrics "0.13.1"]
                 [fullcontact/full.async "1.1.1"]
                 [org.liquibase/liquibase-core "3.5.3"]
                 [com.mattbertolini/liquibase-slf4j "2.0.0"
                  :exclusions [org.slf4j/slf4j-api org.yaml/snakeyaml]]]
  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag" "--no-sign"]
                  ["deploy"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]])
