(ns cmr.umm-spec.umm-to-xml-mappings.iso-smap
  "Defines mappings from UMM records into ISO SMAP XML."
  (:require [clojure.string :as str]
            [cmr.umm-spec.iso-keywords :as kws]
            [cmr.umm-spec.iso19115-2-util :as iso]
            [cmr.umm-spec.umm-to-xml-mappings.iso19115-2.tiling-system :as tiling]
            [cmr.umm-spec.xml.gen :refer :all]
            [cmr.umm-spec.util :as su :refer [with-default]]))

(def iso-smap-xml-namespaces
  {:xmlns:gmd "http://www.isotc211.org/2005/gmd"
   :xmlns:gco "http://www.isotc211.org/2005/gco"
   :xmlns:gmi "http://www.isotc211.org/2005/gmi"
   :xmlns:gml "http://www.opengis.net/gml/3.2"
   :xmlns:gmx "http://www.isotc211.org/2005/gmx"
   :xmlns:gsr "http://www.isotc211.org/2005/gsr"
   :xmlns:gss "http://www.isotc211.org/2005/gss"
   :xmlns:gts "http://www.isotc211.org/2005/gts"
   :xmlns:srv "http://www.isotc211.org/2005/srv"
   :xmlns:xlink "http://www.w3.org/1999/xlink"
   :xmlns:xsi "http://www.w3.org/2001/XMLSchema-instance"})

(defn- date-element
  "Returns ISO XML gmd:date element for given UMM DateType record."
  [umm-date]
  (let [type-code (get iso/iso-date-type-codes (:Type umm-date))
        date-value (:Date umm-date)]
    [:gmd:date
     [:gmd:CI_Date
      [:gmd:date
       [:gco:DateTime date-value]]
      [:gmd:dateType
       [:gmd:CI_DateTypeCode {:codeList (str (:ngdc iso/code-lists) "#CI_DateTypeCode")
                              :codeListValue type-code}
        type-code]]]]))

(defn- generate-collection-progress
  "Returns ISO SMAP CollectionProgress element from UMM-C collection c."
  [c]
  (when-let [collection-progress (:CollectionProgress c)]
    [:gmd:MD_ProgressCode
     {:codeList "http://www.isotc211.org/2005/resources/Codelist/gmxCodelists.xml#MD_ProgressCode"
      :codeListValue (str/lower-case collection-progress)}
     collection-progress]))

(defn- generate-spatial-extent
  "Returns ISO SMAP SpatialExtent content generator instructions"
  [spatial-extent]
  (for [br (get-in spatial-extent [:HorizontalSpatialDomain :Geometry :BoundingRectangles])]
    [:gmd:geographicElement
     [:gmd:EX_GeographicBoundingBox
      [:gmd:extentTypeCode
       [:gco:Boolean 1]]
      [:gmd:westBoundLongitude
       [:gco:Decimal (:WestBoundingCoordinate br)]]
      [:gmd:eastBoundLongitude
       [:gco:Decimal (:EastBoundingCoordinate br)]]
      [:gmd:southBoundLatitude
       [:gco:Decimal (:SouthBoundingCoordinate br)]]
      [:gmd:northBoundLatitude
       [:gco:Decimal (:NorthBoundingCoordinate br)]]]]))

(defn umm-c-to-iso-smap-xml
  "Returns ISO SMAP XML from UMM-C record c."
  [c]
  (xml
    [:gmd:DS_Series
     iso-smap-xml-namespaces
     [:gmd:composedOf {:gco:nilReason "inapplicable"}]
     [:gmd:seriesMetadata
      [:gmi:MI_Metadata
       [:gmd:language (char-string "eng")]
       [:gmd:contact {:xlink:href "#alaskaSARContact"}]
       [:gmd:dateStamp
        [:gco:Date "2013-01-02"]]
       [:gmd:identificationInfo
        [:gmd:MD_DataIdentification
         [:gmd:citation
          [:gmd:CI_Citation
           [:gmd:title (char-string "SMAP Level 1A Parsed Radar Instrument Telemetry")]
           ;; This is kind of bogus
           (when-let [some-date (first (:DataDates c))]
             (date-element some-date))
           [:gmd:identifier
            [:gmd:MD_Identifier
             [:gmd:code (char-string (:ShortName c))]
             [:gmd:description [:gco:CharacterString "The ECS Short Name"]]]]

           [:gmd:identifier
            [:gmd:MD_Identifier
             [:gmd:code (char-string (with-default (:Version c)))]
             [:gmd:description [:gco:CharacterString "The ECS Version ID"]]]]]]
         [:gmd:abstract (char-string (:Abstract c))]
         [:gmd:purpose {:gco:nilReason "missing"} (char-string (:Purpose c))]
         [:gmd:status (generate-collection-progress c)]
         (kws/generate-iso-smap-descriptive-keywords
           "theme" (map kws/science-keyword->iso-keyword-string (:ScienceKeywords c)))
         [:gmd:descriptiveKeywords
          [:gmd:MD_Keywords
           (for [platform (:Platforms c)]
             [:gmd:keyword
              (char-string (kws/smap-keyword-str platform))])
           (for [instrument (mapcat :Instruments (:Platforms c))]
             [:gmd:keyword
              (char-string (kws/smap-keyword-str instrument))])]]
         [:gmd:language (char-string (or (:DataLanguage c) "eng"))]
         [:gmd:extent
          [:gmd:EX_Extent
           (tiling/tiling-system-elements c)
           (generate-spatial-extent (:SpatialExtent c))
           (for [temporal (:TemporalExtents c)
                 rdt (:RangeDateTimes temporal)]
             [:gmd:temporalElement
              [:gmd:EX_TemporalExtent
               [:gmd:extent
                [:gml:TimePeriod {:gml:id (su/generate-id)}
                 [:gml:beginPosition (:BeginningDateTime rdt)]
                 [:gml:endPosition (su/nil-to-empty-string (:EndingDateTime rdt))]]]]])
           (for [temporal (:TemporalExtents c)
                 date (:SingleDateTimes temporal)]
             [:gmd:temporalElement
              [:gmd:EX_TemporalExtent
               [:gmd:extent
                [:gml:TimeInstant {:gml:id (su/generate-id)}
                 [:gml:timePosition date]]]]])]]]]
       [:gmd:identificationInfo
        [:gmd:MD_DataIdentification
         [:gmd:citation
          [:gmd:CI_Citation
           [:gmd:title (char-string "DataSetId")]
           (when-let [some-date (first (:DataDates c))]
             (date-element some-date))]]
         [:gmd:abstract (char-string "DataSetId")]
         [:gmd:aggregationInfo
          [:gmd:MD_AggregateInformation
           [:gmd:aggregateDataSetIdentifier
            [:gmd:MD_Identifier
             [:gmd:code (char-string (:EntryTitle c))]]]
           [:gmd:associationType
            [:gmd:DS_AssociationTypeCode {:codeList "http://www.isotc211.org/2005/resources/Codelist/gmxCodelists.xml#DS_AssociationTypeCode"
                                          :codeListValue "largerWorkCitation"}
             "largerWorkCitation"]]]]
         [:gmd:language (char-string "eng")]]]
       (for [date (drop 1 (:DataDates c))
             :let [description (str (:Type date) " date")]]
         [:gmd:identificationInfo
          [:gmd:MD_DataIdentification
           [:gmd:citation
            [:gmd:CI_Citation
             [:gmd:title (char-string description)]
             (date-element date)]]
           [:gmd:abstract (char-string description)]
           [:gmd:language (char-string "eng")]]])]]]))
