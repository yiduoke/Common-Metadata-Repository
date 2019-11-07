;; WARNING: This file was generated from umm-c-json-schema.json. Do not manually modify.
(ns cmr.umm-spec.models.umm-collection-models
   "Defines UMM-C clojure records."
 (:require [cmr.common.dev.record-pretty-printer :as record-pretty-printer]))

(defrecord UMM-C
  [
   ;; Information required to properly cite the collection in professional scientific literature.
   ;; This element provides information for constructing a citation for the item itself, and is not
   ;; designed for listing bibliographic references of scientific research articles arising from
   ;; search results. A list of references related to the research results should be in the
   ;; Publication Reference element.
   CollectionCitations

   ;; Controlled hierarchical keywords used to specify the spatial location of the collection. The
   ;; controlled vocabulary for spatial keywords is maintained in the Keyword Management System
   ;; (KMS). The Spatial Keyword hierarchy includes one or more of the following layers: Category
   ;; (e.g., Continent), Type (e.g. Africa), Subregion1 (e.g., Central Africa), Subregion2 (e.g.,
   ;; Cameroon), and Subregion3. DetailedLocation exists outside the hierarchy.
   LocationKeywords

   ;; Dates related to activities involving the metadata record itself. For example, Future Review
   ;; date is the date that the metadata record is scheduled to be reviewed.
   MetadataDates

   ;; The Version Description of the collection.
   VersionDescription

   ;; This is deprecated and will be removed. Use LocationKeywords instead. Controlled hierarchical
   ;; keywords used to specify the spatial location of the collection. The controlled vocabulary for
   ;; spatial keywords is maintained in the Keyword Management System (KMS). The Spatial Keyword
   ;; hierarchy includes one or more of the following layers: Location_Category (e.g., Continent),
   ;; Location_Type (e.g. Africa), Location_Subregion1 (e.g., Central Africa), Location_Subregion2
   ;; (e.g., Cameroon), and Location_Subregion3.
   SpatialKeywords

   ;; Identifies the topic categories from the EN ISO 19115-1:2014 Geographic Information – Metadata
   ;; – Part 1: Fundamentals (http://www.isotc211.org/) Topic Category Code List that pertain to
   ;; this collection, based on the Science Keywords associated with the collection. An ISO Topic
   ;; Category is a high-level thematic classification to assist in the grouping of and search for
   ;; available collections.
   ISOTopicCategories

   ;; The short name associated with the collection.
   ShortName

   ;; A brief description of the collection or service the metadata represents.
   Abstract

   ;; The language used in the metadata record.
   MetadataLanguage

   ;; Formerly called Internal Directory Name (IDN) Node (IDN_Node). This element has been used
   ;; historically by the GCMD internally to identify association, responsibility and/or ownership
   ;; of the dataset, service or supplemental information. Note: This field only occurs in the DIF.
   ;; When a DIF record is retrieved in the ECHO10 or ISO 19115 formats, this element will not be
   ;; translated.
   DirectoryNames

   ;; Suggested usage or purpose for the collection data or service.
   Purpose

   ;; Name of the two-dimensional tiling system for the collection. Previously called
   ;; TwoDCoordinateSystem.
   TilingIdentificationSystems

   ;; Describes key bibliographic citations pertaining to the collection.
   PublicationReferences

   ;; This element stores the DOI (Digital Object Identifier) that identifies the collection. Note:
   ;; The values should start with the directory indicator which in ESDIS' case is 10. If the DOI
   ;; was registered through ESDIS, the beginning of the string should be 10.5067. The DOI URL is
   ;; not stored here; it should be stored as a RelatedURL. The DOI organization that is responsible
   ;; for creating the DOI is described in the Authority element. For ESDIS records the value of
   ;; https://doi.org/ should be used. While this element is not required, NASA metadata providers
   ;; are strongly encouraged to include DOI and DOI Authority for their collections.
   DOI

   ;; This element describes any data/service related URLs that include project home pages,
   ;; services, related data archives/servers, metadata extensions, direct links to online software
   ;; packages, web mapping services, links to images, or other data.
   RelatedUrls

   ;; Dates related to activities involving the collection data. For example, Creation date is the
   ;; date that the collection data first entered the data archive system.
   DataDates

   ;; Information about the personnel responsible for this collection and its metadata.
   ContactPersons

   ;; Allows the author to constrain access to the collection. This includes any special
   ;; restrictions, legal prerequisites, limitations and/or warnings on obtaining collection data.
   ;; Some words that may be used in this element's value include: Public, In-house, Limited, None.
   ;; The value field is used for special ACL rules (Access Control Lists
   ;; (http://en.wikipedia.org/wiki/Access_control_list)). For example it can be used to hide
   ;; metadata when it isn't ready for public consumption.
   AccessConstraints

   SpatialExtent

   ;; Information about the personnel groups responsible for this collection and its metadata.
   ContactGroups

   ;; The data’s distinctive attributes of the collection (i.e. attributes used to describe the
   ;; unique characteristics of the collection which extend beyond those defined).
   AdditionalAttributes

   ;; This element and all of its sub elements exist for display purposes. It allows a data provider
   ;; to provide archive and distribution information up front to an end user, to help them decide
   ;; if they can use the product.
   ArchiveAndDistributionInformation

   ;; Controlled Science Keywords describing the collection. The controlled vocabulary for Science
   ;; Keywords is maintained in the Keyword Management System (KMS).
   ScienceKeywords

   ;; Free text description of the quality of the collection data. Description may include: 1)
   ;; succinct description of the quality of data in the collection; 2) Any quality assurance
   ;; procedures followed in producing the data in the collection; 3) indicators of collection
   ;; quality or quality flags - both validated or invalidated; 4) recognized or potential problems
   ;; with quality; 5) established quality control mechanisms; and 6) established quantitative
   ;; quality measurements.
   Quality

   ;; The title of the collection or service described by the metadata.
   EntryTitle

   ;; This element describes the production status of the data set. There are four choices for Data
   ;; Providers: PLANNED refers to data sets to be collected in the future and are thus unavailable
   ;; at the present time. For Example: The Hydro spacecraft has not been launched, but information
   ;; on planned data sets may be available. ACTIVE refers to data sets currently in production or
   ;; data that is continuously being collected or updated. For Example: data from the AIRS
   ;; instrument on Aqua is being collected continuously. COMPLETE refers to data sets in which no
   ;; updates or further data collection will be made. For Example: Nimbus-7 SMMR data collection
   ;; has been completed. NOT APPLICABLE refers to data sets in which a collection progress is not
   ;; applicable such as a calibration collection. There is a fifth value of NOT PROVIDED that
   ;; should not be used by a data provider. It is currently being used as a value when a correct
   ;; translation cannot be done with the current valid values, or when the value is not provided by
   ;; the data provider.
   CollectionProgress

   ;; For paleoclimate or geologic data, PaleoTemporalCoverage is the length of time represented by
   ;; the data collected. PaleoTemporalCoverage should be used when the data spans time frames
   ;; earlier than yyyy-mm-dd = 0001-01-01.
   PaleoTemporalCoverages

   ;; The reference frame or system in which altitudes (elevations) are given. The information
   ;; contains the datum name, distance units and encoding method, which provide the definition for
   ;; the system. This field also stores the characteristics of the reference frame or system from
   ;; which depths are measured. The additional information in the field is geometry reference data
   ;; etc.
   SpatialInformation

   ;; Identifies the collection as a Science Quality collection or a non-science-quality collection
   ;; such as a Near-Real-Time collection.
   CollectionDataType

   ;; Designed to protect privacy and/or intellectual property by allowing the author to specify how
   ;; the collection may or may not be used after access is granted. This includes any special
   ;; restrictions, legal prerequisites, terms and conditions, and/or limitations on using the item.
   ;; Providers may request acknowledgement of the item from users and claim no responsibility for
   ;; quality and completeness. Note: Use Constraints describe how the item may be used once access
   ;; has been granted; and is distinct from Access Constraints, which refers to any constraints in
   ;; accessing the item.
   UseConstraints

   ;; One or more words or phrases that describe the temporal resolution of the dataset.
   TemporalKeywords

   ;; Allows authors to provide words or phrases outside of the controlled Science Keyword
   ;; vocabulary, to further describe the collection.
   AncillaryKeywords

   ;; The identifier for the processing level of the collection (e.g., Level0, Level1A).
   ProcessingLevel

   ;; Information about the relevant platform(s) used to acquire the data in the collection.
   ;; Platform types are controlled in the Keyword Management System (KMS), and include Spacecraft,
   ;; Aircraft, Vessel, Buoy, Platform, Station, Network, Human, etc.
   Platforms

   ;; The name of the scientific program, field campaign, or project from which the data were
   ;; collected. This element is intended for the non-space assets such as aircraft, ground systems,
   ;; balloons, sondes, ships, etc. associated with campaigns. This element may also cover a long
   ;; term project that continuously creates new data sets — like MEaSUREs from ISCCP and NVAP or
   ;; CMARES from MISR. Project also includes the Campaign sub-element to support multiple campaigns
   ;; under the same project.
   Projects

   ;; The Version of the collection.
   Version

   ;; This class contains attributes which describe the temporal range of a specific collection.
   ;; Temporal Extent includes a specification of the Temporal Range Type of the collection, which
   ;; is one of Range Date Time, Single Date Time, or Periodic Date Time
   TemporalExtents

   ;; Information about the data centers responsible for this collection and its metadata.
   DataCenters

   ;; This element is used to identify other services, collections, visualizations, granules, and
   ;; other metadata types and resources that are associated with or dependent on the data described
   ;; by the metadata. This element is also used to identify a parent metadata record if it exists.
   ;; This usage should be reserved for instances where a group of metadata records are subsets that
   ;; can be better represented by one parent metadata record, which describes the entire set. In
   ;; some instances, a child may point to more than one parent. The EntryId is the same as the
   ;; element described elsewhere in this document where it contains and ID, and Version.
   MetadataAssociations

   ;; Describes the language used in the preparation, storage, and description of the collection. It
   ;; is the language of the collection data themselves. It does not refer to the language used in
   ;; the metadata record (although this may be the same language).
   DataLanguage
  ])
(record-pretty-printer/enable-record-pretty-printing UMM-C)

;; For paleoclimate or geologic data, PaleoTemporalCoverage is the length of time represented by the
;; data collected. PaleoTemporalCoverage should be used when the data spans time frames earlier than
;; yyyy-mm-dd = 0001-01-01.
(defrecord PaleoTemporalCoverageType
  [
   ;; Hierarchy of terms indicating units of geologic time, i.e., eon (e.g, Phanerozoic), era (e.g.,
   ;; Cenozoic), period (e.g., Paleogene), epoch (e.g., Oligocene), and stage or age (e.g,
   ;; Chattian).
   ChronostratigraphicUnits

   ;; A string indicating the number of years furthest back in time, including units, e.g., 100 Ga.
   ;; Units may be Ga (billions of years before present), Ma (millions of years before present), ka
   ;; (thousands of years before present) or ybp (years before present).
   StartDate

   ;; A string indicating the number of years closest to the present time, including units, e.g., 10
   ;; ka. Units may be Ga (billions of years before present), Ma (millions of years before present),
   ;; ka (thousands of years before present) or ybp (years before present).
   EndDate
  ])
(record-pretty-printer/enable-record-pretty-printing PaleoTemporalCoverageType)

;; This sub-element either contains a license summary or free-text description that details the
;; permitted use or limitation of this collection.
(defrecord UseConstraintsDescriptionType
  [
   ;; This sub-element either contains a license summary or free-text description that details the
   ;; permitted use or limitation of this collection.
   Description
  ])
(record-pretty-printer/enable-record-pretty-printing UseConstraintsDescriptionType)

;; Information about a collection with horizontal spatial coverage.
(defrecord HorizontalSpatialDomainType
  [
   ;; The appropriate numeric or alpha code used to identify the various zones in the collection's
   ;; grid coordinate system.
   ZoneIdentifier

   Geometry

   ;; Specifies the horizontal spatial extents coordinate system and its resolution.
   ResolutionAndCoordinateSystem
  ])
(record-pretty-printer/enable-record-pretty-printing HorizontalSpatialDomainType)

;; Contains the excluded boundaries from the GPolygon.
(defrecord ExclusiveZoneType
  [
   Boundaries
  ])
(record-pretty-printer/enable-record-pretty-printing ExclusiveZoneType)

;; Information about a two-dimensional tiling system related to this collection.
(defrecord TilingIdentificationSystemType
  [
   TilingIdentificationSystemName

   Coordinate1

   Coordinate2
  ])
(record-pretty-printer/enable-record-pretty-printing TilingIdentificationSystemType)

;; Specifies the geographic and vertical (altitude, depth) coverage of the data.
(defrecord SpatialExtentType
  [
   ;; Denotes whether the collection's spatial coverage requires horizontal, vertical, horizontal
   ;; and vertical, orbit, or vertical and orbit in the spatial domain and coordinate system
   ;; definitions.
   SpatialCoverageType

   HorizontalSpatialDomain

   VerticalSpatialDomains

   OrbitParameters

   GranuleSpatialRepresentation
  ])
(record-pretty-printer/enable-record-pretty-printing SpatialExtentType)

;; This element defines a mapping to the GCMD KMS hierarchical location list. It replaces
;; SpatialKeywords. Each tier must have data in the tier above it.
(defrecord LocationKeywordType
  [
   ;; Top-level controlled keyword hierarchical level that contains the largest general location
   ;; where the collection data was taken from.
   Category

   ;; Second-tier controlled keyword hierarchical level that contains the regional location where
   ;; the collection data was taken from
   Type

   ;; Third-tier controlled keyword heirarchical level that contains the regional sub-location where
   ;; the collection data was taken from
   Subregion1

   ;; Fourth-tier controlled keyword heirarchical level that contains the regional sub-location
   ;; where the collection data was taken from
   Subregion2

   ;; Fifth-tier controlled keyword heirarchical level that contains the regional sub-location where
   ;; the collection data was taken from
   Subregion3

   ;; Uncontrolled keyword heirarchical level that contains the specific location where the
   ;; collection data was taken from. Exists outside the heirarchy.
   DetailedLocation
  ])
(record-pretty-printer/enable-record-pretty-printing LocationKeywordType)

(defrecord LocalCoordinateSystemType
  [
   ;; The information provided to register the local system to the Earth (e.g. control points,
   ;; satellite ephemeral data, and inertial navigation data).
   GeoReferenceInformation

   ;; A description of the Local Coordinate System and geo-reference information.
   Description
  ])
(record-pretty-printer/enable-record-pretty-printing LocalCoordinateSystemType)

;; This element defines a single artifact that is distributed by the data provider. This element
;; only includes the distributable artifacts that can be obtained by the user without the user
;; having to invoke a service. These should be documented in the UMM-S specification.
(defrecord FileDistributionInformationType
  [
   ;; Allows the provider to state whether the distributable item's format is its native format or
   ;; another supported format.
   FormatType

   ;; An approximate average size of the distributable item. This gives an end user an idea of the
   ;; magnitude for each distributable file if more than 1 exists.
   AverageFileSize

   ;; Conveys the price one has to pay to obtain the distributable item.
   Fees

   ;; This element defines a single format for a distributable artifact. Examples of format include:
   ;; ascii, binary, GRIB, BUFR, HDF4, HDF5, HDF-EOS4, HDF-EOS5, jpeg, png, tiff, geotiff, kml.
   Format

   ;; An approximate total size of all of the distributable items within a collection. This gives an
   ;; end user an idea of the magnitude for all of distributable files combined.
   TotalCollectionFileSize

   ;; The date of which this collection started to collect data. This date is used by users to be
   ;; able to calculate the current total collection file size. The date needs to be in the
   ;; yyyy-MM-ddTHH:mm:ssZ format; for example: 2018-01-01T10:00:00Z.
   TotalCollectionFileSizeBeginDate

   ;; Unit of measure for the total collection file size.
   TotalCollectionFileSizeUnit

   ;; Provides the data provider a way to convey more information about the distributable item.
   Description

   ;; Unit of measure for the average file size.
   AverageFileSizeUnit

   ;; This element defines the media by which the end user can obtain the distributable item. Each
   ;; media type is listed separately. Examples of media include: CD-ROM, 9 track tape, diskettes,
   ;; hard drives, online, transparencies, hardcopy, etc.
   Media
  ])
(record-pretty-printer/enable-record-pretty-printing FileDistributionInformationType)

;; This class defines the horizontal spatial extents coordinate system and the data product's
;; horizontal data resolution. The horizontal data resolution is defined as the smallest horizontal
;; distance between successive elements of data in a dataset. This is synonymous with terms such as
;; ground sample distance, sample spacing and pixel size. It is to be noted that the horizontal data
;; resolution could be different in the two horizontal dimensions. Also, it is different from the
;; spatial resolution of an instrument, which is the minimum distance between points that an
;; instrument can see as distinct.
(defrecord ResolutionAndCoordinateSystemType
  [
   ;; This element holds a description about the resoultion and coordinate system for people to
   ;; read.
   Description

   ;; This element describes the geodetic model for the data product.
   GeodeticModel

   ;; This class defines a number of the data products horizontal data resolution. The horizontal
   ;; data resolution is defined as the smallest horizontal distance between successive elements of
   ;; data in a dataset. This is synonymous with terms such as ground sample distance, sample
   ;; spacing and pixel size. It is to be noted that the horizontal data resolution could be
   ;; different in the two horizontal dimensions. Also, it is different from the spatial resolution
   ;; of an instrument, which is the minimum distance between points that an instrument can see as
   ;; distinct.
   HorizontalDataResolutions

   ;; This element describes the local coordinate system for the data product.
   LocalCoordinateSystem
  ])
(record-pretty-printer/enable-record-pretty-printing ResolutionAndCoordinateSystemType)

(defrecord BoundingRectangleType
  [
   WestBoundingCoordinate

   NorthBoundingCoordinate

   EastBoundingCoordinate

   SouthBoundingCoordinate
  ])
(record-pretty-printer/enable-record-pretty-printing BoundingRectangleType)

(defrecord LineType
  [
   Points
  ])
(record-pretty-printer/enable-record-pretty-printing LineType)

;; This class defines a number of the data products horizontal data resolution. The horizontal data
;; resolution is defined as the smallest horizontal distance between successive elements of data in
;; a dataset. This is synonymous with terms such as ground sample distance, sample spacing and pixel
;; size. It is to be noted that the horizontal data resolution could be different in the two
;; horizontal dimensions. Also, it is different from the spatial resolution of an instrument, which
;; is the minimum distance between points that an instrument can see as distinct.
(defrecord HorizontalDataResolutionType
  [
   ;; This element describes the angle of the measurement with respect to the instrument that gives
   ;; an understanding of the specified resolution.
   ViewingAngleType

   ;; Units of measure used for the XDimension and YDimension values.
   Unit

   ;; The minimum difference between two adjacent values on a horizontal plan in the Y axis. In most
   ;; cases this is along the latitudinal axis.
   YDimension

   ;; The maximum, minimum difference between two adjacent values on a horizontal plan in the Y
   ;; axis. In most cases this is along the latitudinal axis.
   MaximumYDimension

   ;; This element describes the instrument scanning direction.
   ScanDirection

   ;; The minimum difference between two adjacent values on a horizontal plane in the X axis. In
   ;; most cases this is along the longitudinal axis.
   XDimension

   ;; The minimum, minimum difference between two adjacent values on a horizontal plane in the X
   ;; axis. In most cases this is along the longitudinal axis.
   MinimumXDimension

   ;; Horizontal Resolution Level describes if the data product is gridded.
   HorizontalResolutionProcessingLevelEnum

   ;; The maximum, minimum difference between two adjacent values on a horizontal plane in the X
   ;; axis. In most cases this is along the longitudinal axis.
   MaximumXDimension

   ;; The minimum, minimum difference between two adjacent values on a horizontal plan in the Y
   ;; axis. In most cases this is along the latitudinal axis.
   MinimumYDimension
  ])
(record-pretty-printer/enable-record-pretty-printing HorizontalDataResolutionType)

(defrecord ChronostratigraphicUnitType
  [
   Eon

   Era

   Epoch

   Stage

   DetailedClassification

   Period
  ])
(record-pretty-printer/enable-record-pretty-printing ChronostratigraphicUnitType)

(defrecord VerticalSpatialDomainType
  [
   ;; Describes the type of the area of vertical space covered by the collection locality.
   Type

   ;; Describes the extent of the area of vertical space covered by the collection. Must be
   ;; accompanied by an Altitude Encoding Method description. The datatype for this attribute is the
   ;; value of the attribute VerticalSpatialDomainType. The unit for this attribute is the value of
   ;; either DepthDistanceUnits or AltitudeDistanceUnits.
   Value
  ])
(record-pretty-printer/enable-record-pretty-printing VerticalSpatialDomainType)

(defrecord GeometryType
  [
   CoordinateSystem

   Points

   BoundingRectangles

   GPolygons

   Lines
  ])
(record-pretty-printer/enable-record-pretty-printing GeometryType)

;; The reference frame or system from which altitude is measured. The term 'altitude' is used
;; instead of the common term 'elevation' to conform to the terminology in Federal Information
;; Processing Standards 70-1 and 173. The information contains the datum name, distance units and
;; encoding method, which provide the definition for the system.
(defrecord AltitudeSystemDefinitionType
  [
   ;; The identification given to the level surface taken as the surface of reference from which
   ;; measurements are compared.
   DatumName

   ;; The units in which measurements are recorded.
   DistanceUnits

   ;; The minimum distance possible between two adjacent values, expressed in distance units of
   ;; measure for the collection.
   Resolutions
  ])
(record-pretty-printer/enable-record-pretty-printing AltitudeSystemDefinitionType)

;; The longitude and latitude values of a spatially referenced point in degrees.
(defrecord PointType
  [
   Longitude

   Latitude
  ])
(record-pretty-printer/enable-record-pretty-printing PointType)

;; This element contains the Processing Level Id and the Processing Level Description
(defrecord ProcessingLevelType
  [
   ;; Description of the meaning of the Processing Level Id, e.g., the Description for the Level4
   ;; Processing Level Id might be 'Model output or results from analyses of lower level data'
   ProcessingLevelDescription

   ;; An identifier indicating the level at which the data in the collection are processed, ranging
   ;; from Level0 (raw instrument data at full resolution) to Level4 (model output or analysis
   ;; results). The value of Processing Level Id is chosen from a controlled vocabulary.
   Id
  ])
(record-pretty-printer/enable-record-pretty-printing ProcessingLevelType)

;; Defines the minimum and maximum value for one dimension of a two dimensional coordinate system.
(defrecord TilingCoordinateType
  [
   MinimumValue

   MaximumValue
  ])
(record-pretty-printer/enable-record-pretty-printing TilingCoordinateType)

(defrecord GPolygonType
  [
   Boundary

   ExclusiveZone
  ])
(record-pretty-printer/enable-record-pretty-printing GPolygonType)

;; A boundary is set of points connected by straight lines representing a polygon on the earth. It
;; takes a minimum of three points to make a boundary. Points must be specified in counter-clockwise
;; order and closed (the first and last vertices are the same).
(defrecord BoundaryType
  [
   Points
  ])
(record-pretty-printer/enable-record-pretty-printing BoundaryType)

;; This element describes the geodetic model for the data product.
(defrecord GeodeticModelType
  [
   ;; The identification given to the reference system used for defining the coordinates of points.
   HorizontalDatumName

   ;; Identification given to established representation of the Earth's shape.
   EllipsoidName

   ;; Radius of the equatorial axis of the ellipsoid.
   SemiMajorAxis

   ;; The ratio of the Earth's major axis to the difference between the major and the minor.
   DenominatorOfFlatteningRatio
  ])
(record-pretty-printer/enable-record-pretty-printing GeodeticModelType)

;; The reference frame or system from which depth is measured. The information contains the datum
;; name, distance units and encoding method, which provide the definition for the system.
(defrecord DepthSystemDefinitionType
  [
   ;; The identification given to the level surface taken as the surface of reference from which
   ;; measurements are compared.
   DatumName

   ;; The units in which measurements are recorded.
   DistanceUnits

   ;; The minimum distance possible between two adjacent values, expressed in distance units of
   ;; measure for the collection.
   Resolutions
  ])
(record-pretty-printer/enable-record-pretty-printing DepthSystemDefinitionType)

;; This entity stores the reference frame or system from which horizontal and vertical spatial
;; domains are measured. The horizontal reference frame includes a Geodetic Model, Geographic
;; Coordinates, and Local Coordinates. The Vertical reference frame includes altitudes (elevations)
;; and depths.
(defrecord SpatialInformationType
  [
   VerticalCoordinateSystem

   ;; Denotes whether the spatial coverage of the collection is horizontal, vertical, horizontal and
   ;; vertical, orbit, or vertical and orbit.
   SpatialCoverageType
  ])
(record-pretty-printer/enable-record-pretty-printing SpatialInformationType)

;; This element defines a single archive artifact which a data provider would like to inform an end
;; user that it exists.
(defrecord FileArchiveInformationType
  [
   ;; This element defines a single format for an archival artifact. Examples of format include:
   ;; ascii, binary, GRIB, BUFR, HDF4, HDF5, HDF-EOS4, HDF-EOS5, jpeg, png, tiff, geotiff, kml.
   Format

   ;; Allows the provider to state whether the archivable item's format is its native format or
   ;; another supported format.
   FormatType

   ;; An approximate average size of the archivable item. This gives an end user an idea of the
   ;; magnitude for each archivable file if more than 1 exists.
   AverageFileSize

   ;; Unit of measure for the average file size.
   AverageFileSizeUnit

   ;; An approximate total size of all of the archivable items within a collection. This gives an
   ;; end user an idea of the magnitude for all of archivable files combined.
   TotalCollectionFileSize

   ;; Unit of measure for the total collection file size.
   TotalCollectionFileSizeUnit

   ;; Provides the data provider a way to convey more information about the archivable item.
   Description

   ;; The date of which this collection started to collect data. This date is used by users to be
   ;; able to calculate the current total collection file size. The date needs to be in the
   ;; yyyy-MM-ddTHH:mm:ssZ format; for example: 2018-01-01T10:00:00Z.
   TotalCollectionFileSizeBeginDate
  ])
(record-pretty-printer/enable-record-pretty-printing FileArchiveInformationType)

;; Orbit parameters for the collection used by the Orbital Backtrack Algorithm.
(defrecord OrbitParametersType
  [
   ;; Width of the swath at the equator in Kilometers.
   SwathWidth

   ;; Orbital period in decimal minutes.
   Period

   ;; Inclination of the orbit. This is the same as (180-declination) and also the same as the
   ;; highest latitude achieved by the satellite. Data Unit: Degree.
   InclinationAngle

   ;; Indicates the number of orbits.
   NumberOfOrbits

   ;; The latitude start of the orbit relative to the equator. This is used by the backtrack search
   ;; algorithm to treat the orbit as if it starts from the specified latitude. This is optional and
   ;; will default to 0 if not specified.
   StartCircularLatitude
  ])
(record-pretty-printer/enable-record-pretty-printing OrbitParametersType)

;; This element and all of its sub elements exist for display purposes. It allows a data provider to
;; provide archive and distribution information up front to an end user, to help them decide if they
;; can use the product.
(defrecord ArchiveAndDistributionInformationType
  [
   ;; This element defines a single archive artifact which a data provider would like to inform an
   ;; end user that it exists.
   FileArchiveInformation

   ;; This element defines a single artifact that is distributed by the data provider. This element
   ;; only includes the distributable artifacts that can be obtained by the user without the user
   ;; having to invoke a service. These should be documented in the UMM-S specification.
   FileDistributionInformation
  ])
(record-pretty-printer/enable-record-pretty-printing ArchiveAndDistributionInformationType)

;; Formerly called Internal Directory Name (IDN) Node (IDN_Node). This element has been used
;; historically by the GCMD internally to identify association, responsibility and/or ownership of
;; the dataset, service or supplemental information. Note: This field only occurs in the DIF. When a
;; DIF record is retrieved in the ECHO10 or ISO 19115 formats, this element will not be translated.
(defrecord DirectoryNameType
  [
   ShortName

   LongName
  ])
(record-pretty-printer/enable-record-pretty-printing DirectoryNameType)

;; This element defines how the data may or may not be used after access is granted to assure the
;; protection of privacy or intellectual property. This includes license text, license URL, or any
;; special restrictions, legal prerequisites, terms and conditions, and/or limitations on using the
;; data set. Data providers may request acknowledgement of the data from users and claim no
;; responsibility for quality and completeness of data.
(defrecord UseConstraintsType
  [
   Description

   ;; This element holds the URL and associated information to access the License on the web. If
   ;; this element is used the LicenseText element cannot be used.
   LicenseUrl

   ;; This element holds the actual license text. If this element is used the LicenseUrl element
   ;; cannot be used.
   LicenseText
  ])
(record-pretty-printer/enable-record-pretty-printing UseConstraintsType)

(defrecord VerticalCoordinateSystemType
  [
   AltitudeSystemDefinition

   DepthSystemDefinition
  ])
(record-pretty-printer/enable-record-pretty-printing VerticalCoordinateSystemType)