/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

// This is a generated file - do not edit - changes should be made to the templates amd/or generator to generate this file with changes.

package org.odpi.openmetadata.fvt.opentypes.entities.DataSourcePhysicalStatusAnnotation;

import java.io.Serializable;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.odpi.openmetadata.fvt.opentypes.common.SystemAttributes;
import org.odpi.openmetadata.fvt.opentypes.common.ClassificationBean;
import org.odpi.openmetadata.fvt.opentypes.enums.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

// omrs
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.EnumPropertyValue;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.InstanceProperties;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.MapPropertyValue;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.PrimitivePropertyValue;

/**
 * DataSourcePhysicalStatusAnnotation entity.
   A set of summary properties about the physical status of an Asset.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class  DataSourcePhysicalStatusAnnotation implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(DataSourcePhysicalStatusAnnotation.class);
    private static final String className = DataSourcePhysicalStatusAnnotation.class.getName();
    private SystemAttributes systemAttributes = null;
    private Date effectiveFromTime = null;
    private Date effectiveToTime = null;
    List<ClassificationBean> classifications = null;

    private Map<String, Object> extraAttributes =null;
    private Map<String, org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.Classification> extraClassificationBeans =null;


    /**
     * Get the system attributes
     * @return SystemAttributes if populated, null otherwise.
     */
    public SystemAttributes getSystemAttributes() {
        return systemAttributes;
    }

    public void setSystemAttributes(SystemAttributes systemAttributes) {
        this.systemAttributes = systemAttributes;
    }

    // attributes
    public static final String[] PROPERTY_NAMES_SET_VALUES = new String[] {
        "createTime",
        "modifiedTime",
        "size",
        "encoding",
        "dataSourceProperties",
        "annotationType",
        "summary",
        "confidenceLevel",
        "expression",
        "explanation",
        "analysisStep",
        "jsonProperties",
        "additionalProperties",
        "annotationStatus",

    // Terminate the list
        null
    };
    public static final String[] ATTRIBUTE_NAMES_SET_VALUES = new String[] {
        "createTime",
        "modifiedTime",
        "size",
        "encoding",
        "annotationType",
        "summary",
        "confidenceLevel",
        "expression",
        "explanation",
        "analysisStep",
        "jsonProperties",

     // Terminate the list
        null
    };
    public static final String[] ENUM_NAMES_SET_VALUES = new String[] {
         "annotationStatus",

         // Terminate the list
          null
    };
    public static final String[] MAP_NAMES_SET_VALUES = new String[] {
         "dataSourceProperties",
         "additionalProperties",

         // Terminate the list
         null
    };
    public static final java.util.Set<String> PROPERTY_NAMES_SET = new HashSet(new HashSet<>(Arrays.asList(PROPERTY_NAMES_SET_VALUES)));
    public static final java.util.Set<String> ATTRIBUTE_NAMES_SET = new HashSet(new HashSet<>(Arrays.asList(ATTRIBUTE_NAMES_SET_VALUES)));
    public static final java.util.Set<String> ENUM_NAMES_SET = new HashSet(new HashSet<>(Arrays.asList(ENUM_NAMES_SET_VALUES)));
    public static final java.util.Set<String> MAP_NAMES_SET = new HashSet(new HashSet<>(Arrays.asList(MAP_NAMES_SET_VALUES)));


    InstanceProperties obtainInstanceProperties() {
        final String methodName = "obtainInstanceProperties";
        if (log.isDebugEnabled()) {
               log.debug("==> Method: " + methodName);
        }
        InstanceProperties instanceProperties = new InstanceProperties();
        EnumPropertyValue enumPropertyValue=null;
        enumPropertyValue = new EnumPropertyValue();
        // status of the processing as a result of the annotation.
        enumPropertyValue.setOrdinal(annotationStatus.ordinal());
        enumPropertyValue.setSymbolicName(annotationStatus.name());
        instanceProperties.setProperty("annotationStatus",enumPropertyValue);
        MapPropertyValue mapPropertyValue=null;
        // Discovered properties of the data source.
        mapPropertyValue = new MapPropertyValue();
        // Additional properties discovered during the analysis.
        mapPropertyValue = new MapPropertyValue();
        PrimitivePropertyValue primitivePropertyValue=null;
        primitivePropertyValue = new PrimitivePropertyValue();
        primitivePropertyValue.setPrimitiveValue(createTime);
        instanceProperties.setProperty("createTime",primitivePropertyValue);
        primitivePropertyValue = new PrimitivePropertyValue();
        primitivePropertyValue.setPrimitiveValue(modifiedTime);
        instanceProperties.setProperty("modifiedTime",primitivePropertyValue);
        primitivePropertyValue = new PrimitivePropertyValue();
        primitivePropertyValue.setPrimitiveValue(size);
        instanceProperties.setProperty("size",primitivePropertyValue);
        primitivePropertyValue = new PrimitivePropertyValue();
        primitivePropertyValue.setPrimitiveValue(encoding);
        instanceProperties.setProperty("encoding",primitivePropertyValue);
        primitivePropertyValue = new PrimitivePropertyValue();
        primitivePropertyValue.setPrimitiveValue(annotationType);
        instanceProperties.setProperty("annotationType",primitivePropertyValue);
        primitivePropertyValue = new PrimitivePropertyValue();
        primitivePropertyValue.setPrimitiveValue(summary);
        instanceProperties.setProperty("summary",primitivePropertyValue);
        primitivePropertyValue = new PrimitivePropertyValue();
        primitivePropertyValue.setPrimitiveValue(confidenceLevel);
        instanceProperties.setProperty("confidenceLevel",primitivePropertyValue);
        primitivePropertyValue = new PrimitivePropertyValue();
        primitivePropertyValue.setPrimitiveValue(expression);
        instanceProperties.setProperty("expression",primitivePropertyValue);
        primitivePropertyValue = new PrimitivePropertyValue();
        primitivePropertyValue.setPrimitiveValue(explanation);
        instanceProperties.setProperty("explanation",primitivePropertyValue);
        primitivePropertyValue = new PrimitivePropertyValue();
        primitivePropertyValue.setPrimitiveValue(analysisStep);
        instanceProperties.setProperty("analysisStep",primitivePropertyValue);
        primitivePropertyValue = new PrimitivePropertyValue();
        primitivePropertyValue.setPrimitiveValue(jsonProperties);
        instanceProperties.setProperty("jsonProperties",primitivePropertyValue);
        if (log.isDebugEnabled()) {
               log.debug("<== Method: " + methodName);
        }
        return instanceProperties;
    }

       private Date createTime;
       /**
        * {@literal When the data source was created. }
        * @return {@code Date }
        */
       public Date getCreateTime() {
           return this.createTime;
       }
       public void setCreateTime(Date createTime)  {
           this.createTime = createTime;
       }
       private Date modifiedTime;
       /**
        * {@literal When the data source was last modified. }
        * @return {@code Date }
        */
       public Date getModifiedTime() {
           return this.modifiedTime;
       }
       public void setModifiedTime(Date modifiedTime)  {
           this.modifiedTime = modifiedTime;
       }
       private Integer size;
       /**
        * {@literal Size of the data source. }
        * @return {@code Integer }
        */
       public Integer getSize() {
           return this.size;
       }
       public void setSize(Integer size)  {
           this.size = size;
       }
       private String encoding;
       /**
        * {@literal Encoding scheme used on the data. }
        * @return {@code String }
        */
       public String getEncoding() {
           return this.encoding;
       }
       public void setEncoding(String encoding)  {
           this.encoding = encoding;
       }
       private Map<String,String> dataSourceProperties;
       /**
        * {@literal Discovered properties of the data source. }
        * @return {@code {@code Map<String,String> } }
        */
       public Map<String,String> getDataSourceProperties() {
           return this.dataSourceProperties;
       }
       public void setDataSourceProperties(Map<String,String> dataSourceProperties)  {
           this.dataSourceProperties = dataSourceProperties;
       }
       private String annotationType;
       /**
        * {@literal Name of the type of annotation. }
        * @return {@code String }
        */
       public String getAnnotationType() {
           return this.annotationType;
       }
       public void setAnnotationType(String annotationType)  {
           this.annotationType = annotationType;
       }
       private String summary;
       /**
        * {@literal Description of the findings. }
        * @return {@code String }
        */
       public String getSummary() {
           return this.summary;
       }
       public void setSummary(String summary)  {
           this.summary = summary;
       }
       private Integer confidenceLevel;
       /**
        * {@literal Level of certainty in the accuracy of the results. }
        * @return {@code Integer }
        */
       public Integer getConfidenceLevel() {
           return this.confidenceLevel;
       }
       public void setConfidenceLevel(Integer confidenceLevel)  {
           this.confidenceLevel = confidenceLevel;
       }
       private String expression;
       /**
        * {@literal Expression used to create the annotation. }
        * @return {@code String }
        */
       public String getExpression() {
           return this.expression;
       }
       public void setExpression(String expression)  {
           this.expression = expression;
       }
       private String explanation;
       /**
        * {@literal Explanation of the analysis. }
        * @return {@code String }
        */
       public String getExplanation() {
           return this.explanation;
       }
       public void setExplanation(String explanation)  {
           this.explanation = explanation;
       }
       private String analysisStep;
       /**
        * {@literal The step in the pipeline that produced the annotation. }
        * @return {@code String }
        */
       public String getAnalysisStep() {
           return this.analysisStep;
       }
       public void setAnalysisStep(String analysisStep)  {
           this.analysisStep = analysisStep;
       }
       private String jsonProperties;
       /**
        * {@literal Additional properties used in the specification. }
        * @return {@code String }
        */
       public String getJsonProperties() {
           return this.jsonProperties;
       }
       public void setJsonProperties(String jsonProperties)  {
           this.jsonProperties = jsonProperties;
       }
       private Map<String,String> additionalProperties;
       /**
        * {@literal Additional properties discovered during the analysis. }
        * @return {@code {@code Map<String,String> } }
        */
       public Map<String,String> getAdditionalProperties() {
           return this.additionalProperties;
       }
       public void setAdditionalProperties(Map<String,String> additionalProperties)  {
           this.additionalProperties = additionalProperties;
       }
       private AnnotationStatus annotationStatus;
       /**
        * {@literal Status of the processing as a result of the annotation. }
        * @return {@code AnnotationStatus }
        */
       public AnnotationStatus getAnnotationStatus() {
           return this.annotationStatus;
       }
       public void setAnnotationStatus(AnnotationStatus annotationStatus)  {
           this.annotationStatus = annotationStatus;
       }
    /**
     * Return the date/time that this DataSourcePhysicalStatusAnnotation should start to be used (null means it can be used from creationTime).
     * @return Date the DataSourcePhysicalStatusAnnotation becomes effective.
     */
    public Date getEffectiveFromTime()
    {
        return effectiveFromTime;
    }

    public void setEffectiveFromTime(Date effectiveFromTime)
    {
        this.effectiveFromTime = effectiveFromTime;
    }
    /**
     * Return the date/time that this DataSourcePhysicalStatusAnnotation should no longer be used.
     *
     * @return Date the DataSourcePhysicalStatusAnnotation stops being effective.
     */
    public Date getEffectiveToTime()
    {
        return effectiveToTime;
    }
    public void setEffectiveToTime(Date effectiveToTime)
    {
        this.effectiveToTime = effectiveToTime;
    }

    public void setExtraAttributes(Map<String, Object> extraAttributes) {
        this.extraAttributes = extraAttributes;
    }

    public void setClassificationBeans(List<ClassificationBean> classifications) {
        this.classifications = classifications;
    }

    /**
     * Get the extra attributes - ones that are in addition to the standard types.
     * @return map of attributes, null if there are none
     */
    public Map<String, Object> getExtraAttributes() {
        return extraAttributes;
    }

     /**
     * ClassificationBeans
     * @return List of ClassificationBeans, null if there are none
     */
    public List<ClassificationBean> getClassificationBeans() {
        return classifications;
    }
    /**
      * Extra classifications are classifications that are not in the open metadata model - we include the OMRS ClassificationBeans.
      * @return Map of classifications with the classification Name as the map key
      */
    public Map<String, org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.Classification> getExtraClassificationBeans() {
        return extraClassificationBeans;
    }

    public void setExtraClassificationBeans(Map<String, org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.Classification> extraClassificationBeans) {
        this.extraClassificationBeans = extraClassificationBeans;
    }

    public StringBuilder toString(StringBuilder sb) {
        if (sb == null) {
            sb = new StringBuilder();
        }

        sb.append("DataSourcePhysicalStatusAnnotation{");
        if (systemAttributes !=null) {
            sb.append("systemAttributes='").append(systemAttributes.toString()).append('\'');
        }
        sb.append("DataSourcePhysicalStatusAnnotation Attributes{");
    	sb.append("CreateTime=" +this.createTime);
    	sb.append("ModifiedTime=" +this.modifiedTime);
    	sb.append("Size=" +this.size);
    	sb.append("Encoding=" +this.encoding);
    	sb.append("DataSourceProperties=" +this.dataSourceProperties);
    	sb.append("AnnotationType=" +this.annotationType);
    	sb.append("Summary=" +this.summary);
    	sb.append("ConfidenceLevel=" +this.confidenceLevel);
    	sb.append("Expression=" +this.expression);
    	sb.append("Explanation=" +this.explanation);
    	sb.append("AnalysisStep=" +this.analysisStep);
    	sb.append("JsonProperties=" +this.jsonProperties);
    	sb.append("AdditionalProperties=" +this.additionalProperties);
    	sb.append("AnnotationStatus=" +this.annotationStatus);

        sb.append('}');
        if (classifications != null) {
        sb.append(", classifications=[");
            for (ClassificationBean classification:classifications) {
                sb.append(classification.toString()).append(", ");
            }
            sb.append(" ],");
        }
        sb.append(", extraAttributes=[");
        if (extraAttributes !=null) {
            for (String attrname: extraAttributes.keySet()) {
                sb.append(attrname).append(":");
                sb.append(extraAttributes.get(attrname)).append(", ");
            }
        }
        sb.append(" ]");

        sb.append('}');

        return sb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        if (!super.equals(o)) { return false; }

        DataSourcePhysicalStatusAnnotation that = (DataSourcePhysicalStatusAnnotation) o;
        if (this.createTime != null && !Objects.equals(this.createTime,that.getCreateTime())) {
             return false;
        }
        if (this.modifiedTime != null && !Objects.equals(this.modifiedTime,that.getModifiedTime())) {
             return false;
        }
        if (this.size != null && !Objects.equals(this.size,that.getSize())) {
             return false;
        }
        if (this.encoding != null && !Objects.equals(this.encoding,that.getEncoding())) {
             return false;
        }
        if (this.dataSourceProperties != null && !Objects.equals(this.dataSourceProperties,that.getDataSourceProperties())) {
             return false;
        }
        if (this.annotationType != null && !Objects.equals(this.annotationType,that.getAnnotationType())) {
             return false;
        }
        if (this.summary != null && !Objects.equals(this.summary,that.getSummary())) {
             return false;
        }
        if (this.confidenceLevel != null && !Objects.equals(this.confidenceLevel,that.getConfidenceLevel())) {
             return false;
        }
        if (this.expression != null && !Objects.equals(this.expression,that.getExpression())) {
             return false;
        }
        if (this.explanation != null && !Objects.equals(this.explanation,that.getExplanation())) {
             return false;
        }
        if (this.analysisStep != null && !Objects.equals(this.analysisStep,that.getAnalysisStep())) {
             return false;
        }
        if (this.jsonProperties != null && !Objects.equals(this.jsonProperties,that.getJsonProperties())) {
             return false;
        }
        if (this.additionalProperties != null && !Objects.equals(this.additionalProperties,that.getAdditionalProperties())) {
             return false;
        }
        if (this.annotationStatus != null && !Objects.equals(this.annotationStatus,that.getAnnotationStatus())) {
             return false;
        }

        // We view dataSourcePhysicalStatusAnnotations as logically equal by checking the properties that the OMAS knows about - i.e. without accounting for extra attributes and references from the org.odpi.openmetadata.accessservices.subjectarea.server.
        return Objects.equals(systemAttributes, that.systemAttributes) &&
                Objects.equals(classifications, that.classifications) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
         systemAttributes.hashCode(),
         classifications.hashCode()
          , this.createTime
          , this.modifiedTime
          , this.size
          , this.encoding
          , this.dataSourceProperties
          , this.annotationType
          , this.summary
          , this.confidenceLevel
          , this.expression
          , this.explanation
          , this.analysisStep
          , this.jsonProperties
          , this.additionalProperties
          , this.annotationStatus
        );
    }

    @Override
    public String toString() {
        return toString(new StringBuilder()).toString();
    }
}