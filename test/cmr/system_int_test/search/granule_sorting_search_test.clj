(ns cmr.system-int-test.search.granule-sorting-search-test
  "Tests searching for collections using basic collection identifiers"
  (:require [clojure.test :refer :all]
            [clojure.string :as str]
            [cmr.system-int-test.utils.ingest-util :as ingest]
            [cmr.system-int-test.utils.search-util :as search]
            [cmr.system-int-test.utils.index-util :as index]
            [cmr.system-int-test.data2.collection :as dc]
            [cmr.system-int-test.data2.granule :as dg]
            [cmr.system-int-test.data2.core :as d]
            [cmr.search.services.messages.common-messages :as msg]))


(use-fixtures :each (ingest/reset-fixture "PROV1" "PROV2"))

(deftest invalid-sort-key-test
  (is (= {:status 422
          :errors [(msg/invalid-sort-key "foo" :granule)]}
         (search/find-refs :granule {:sort-key "foo"}))))

(deftest sorting-test
  (let [make-coll (fn [provider begin end]
                    (d/ingest provider
                              (dc/collection {:beginning-date-time (d/make-datetime begin)
                                              :ending-date-time (d/make-datetime end)})))
        make-gran (fn [coll begin end]
                    (d/ingest (:provider-id coll)
                              (dg/granule coll {:beginning-date-time (d/make-datetime begin)
                                                :ending-date-time (d/make-datetime end)})))
        c1 (make-coll "PROV1" 1 200)
        c2 (make-coll "PROV2" 1 200)

        g1 (make-gran c1 10 20)
        g2 (make-gran c1 14 24)
        g3 (make-gran c1 19 30)
        g4 (make-gran c1 24 35)
        g5 (make-gran c2 9 19)
        g6 (make-gran c2 15 25)
        g7 (make-gran c2 20 29)
        g8 (make-gran c2 25 36)
        g9 (make-gran c1 nil nil)
        g10 (make-gran c2 nil nil)
        g11 (make-gran c1 12 nil)
        g12 (make-gran c2 nil 22)]
    (index/flush-elastic-index)

    (testing "default sorting is by provider id and start date"
      (is (d/refs-match-order?
            [g1 g11 g2 g3 g4 g9 g5 g6 g7 g8 g10 g12]
            (search/find-refs :granule {:page-size 20}))))

    (testing "temporal start date"
      (are [sort-key items] (d/refs-match-order?
                              items
                              (search/find-refs :granule {:page-size 20
                                                          :sort-key sort-key}))
           "start_date" [g5 g1 g11 g2 g6 g3 g7 g4 g8 g9 g10 g12]
           "-start_date" [g8 g4 g7 g3 g6 g2 g11 g1 g5 g9 g10 g12]))

    (testing "temporal end date"
      (are [sort-key items] (d/refs-match-order?
                              items
                              (search/find-refs :granule {:page-size 20
                                                          :sort-key sort-key}))
           "end_date" [g5 g1 g12 g2 g6 g7 g3 g4 g8 g9 g10 g11]
           "-end_date" [g8 g4 g3 g7 g6 g2 g12 g1 g5 g9 g10 g11]))))

#_(deftest multiple-sort-key-test
  (let [c1 (make-coll "PROV1" "et10" 10 nil)
        c2 (make-coll "PROV1" "et20" 10 nil)
        c3 (make-coll "PROV1" "et30" 10 nil)
        c4 (make-coll "PROV1" "et40" 10 nil)

        c5 (make-coll "PROV2" "et10" 20 nil)
        c6 (make-coll "PROV2" "et20" 20 nil)
        c7 (make-coll "PROV2" "et30" 20 nil)
        c8 (make-coll "PROV2" "et40" 20 nil)]
    (index/flush-elastic-index)

    (are [sort-key items] (d/refs-match-order?
                            items
                            (search/find-refs :granule {:page-size 20
                                                        :sort-key sort-key}))
         ["entry_title" "start_date"] [c1 c5 c2 c6 c3 c7 c4 c8]
         ["entry_title" "-start_date"] [c5 c1 c6 c2 c7 c3 c8 c4]
         ["start_date" "entry_title"] [c1 c2 c3 c4 c5 c6 c7 c8]
         ["start_date" "-entry_title"] [c4 c3 c2 c1 c8 c7 c6 c5]
         ["-start_date" "entry_title"] [c5 c6 c7 c8 c1 c2 c3 c4])))
