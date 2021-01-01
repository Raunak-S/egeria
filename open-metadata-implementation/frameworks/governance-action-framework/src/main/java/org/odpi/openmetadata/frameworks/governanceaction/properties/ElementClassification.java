/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.governanceaction.properties;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.frameworks.governanceaction.search.ElementProperties;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * The ElementClassification bean describes a single classification associated with an element.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class ElementClassification extends ElementClassificationHeader
{
    private static final long    serialVersionUID = 1L;

    private String            classificationName       = null;
    private ElementProperties classificationProperties = null;


    /**
     * Default constructor
     */
    public ElementClassification()
    {
        super();
    }


    /**
     * Copy/clone constructor
     *
     * @param template template to copy
     */
    public ElementClassification(ElementClassification template)
    {
        super(template);

        if (template != null)
        {
            classificationName            = template.getClassificationName();
            classificationProperties      = template.getClassificationProperties();
        }
    }


    /**
     * Set up the name of the classification.  This name is the type name defined in a ClassificationDef type definition.
     *
     * @param classificationName  name of classification
     */
    public void setClassificationName(String classificationName)
    {
        this.classificationName = classificationName;
    }


    /**
     * Return the name of the classification
     *
     * @return String name
     */
    public String getClassificationName()
    {
        return classificationName;
    }


    /**
     * Set up a collection of the additional stored properties for the classification.
     * If no stored properties are present then null is returned.
     *
     * @param classificationProperties  properties for the classification
     */
    public void setClassificationProperties(ElementProperties classificationProperties)
    {
        this.classificationProperties = classificationProperties;
    }


    /**
     * Return a collection of the additional stored properties for the classification.
     * If no stored properties are present then null is returned.
     *
     * @return properties map
     */
    public ElementProperties getClassificationProperties()
    {
        return classificationProperties;
    }


    /**
     * Standard toString method.
     *
     * @return print out of variables in a JSON-style
     */
    @Override
    public String toString()
    {
        return "ElementClassification{" +
                "classificationName='" + classificationName + '\'' +
                ", classificationProperties=" + classificationProperties +
                ", classificationTypeId='" + getClassificationTypeId() + '\'' +
                ", classificationTypeVersion=" + getClassificationTypeVersion() +
                ", classificationTypeDescription='" + getClassificationTypeDescription() + '\'' +
                ", classificationOrigin=" + getClassificationOrigin() +
                ", classificationOriginGUID='" + getClassificationOriginGUID() + '\'' +
                ", elementSourceServer='" + getElementSourceServer() + '\'' +
                ", elementOrigin=" + getElementOrigin() +
                ", elementMetadataCollectionId='" + getElementMetadataCollectionId() + '\'' +
                ", elementMetadataCollectionName='" + getElementMetadataCollectionName() + '\'' +
                ", elementLicense='" + getElementLicense() + '\'' +
                ", status=" + getStatus() +
                ", elementCreatedBy='" + getElementCreatedBy() + '\'' +
                ", elementUpdatedBy='" + getElementUpdatedBy() + '\'' +
                ", elementMaintainedBy=" + getElementMaintainedBy() +
                ", elementCreateTime=" + getElementCreateTime() +
                ", elementUpdateTime=" + getElementUpdateTime() +
                ", elementVersion=" + getElementVersion() +
                ", mappingProperties=" + getMappingProperties() +
                ", headerVersion=" + getHeaderVersion() +
                '}';
    }


    /**
     * Compare the values of the supplied object with those stored in the current object.
     *
     * @param objectToCompare supplied object
     * @return boolean result of comparison
     */
    @Override
    public boolean equals(Object objectToCompare)
    {
        if (this == objectToCompare)
        {
            return true;
        }
        if (objectToCompare == null || getClass() != objectToCompare.getClass())
        {
            return false;
        }
        if (!super.equals(objectToCompare))
        {
            return false;
        }
        ElementClassification that = (ElementClassification) objectToCompare;
        return Objects.equals(classificationName, that.classificationName) &&
                Objects.equals(classificationProperties, that.classificationProperties);
    }


    /**
     * Create a hash code for this element type.
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), classificationName, classificationProperties);
    }
}
