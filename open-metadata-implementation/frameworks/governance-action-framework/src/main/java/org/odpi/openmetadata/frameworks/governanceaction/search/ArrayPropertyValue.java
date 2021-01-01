/* SPDX-License-Identifier: Apache 2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.governanceaction.search;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.frameworks.governanceaction.ffdc.GAFErrorCode;
import org.odpi.openmetadata.frameworks.governanceaction.ffdc.GAFRuntimeException;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * ArrayPropertyValue stores the values of an array within an entity or relationship properties.
 * The elements of the array are stored in an ElementProperties map where the property name is set to the element
 * number and the property value is set to the value of the element in the array.
 */
@JsonAutoDetect(getterVisibility = PUBLIC_ONLY, setterVisibility = PUBLIC_ONLY, fieldVisibility = NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArrayPropertyValue extends InstancePropertyValue
{
    private static final long    serialVersionUID = 1L;

    private int               arrayCount  = 0;
    private ElementProperties arrayValues = null;


    /**
     * Default constructor sets the array to empty.
     */
    public ArrayPropertyValue() {
        super(PropertyCategory.ARRAY);
    }


    /**
     * Copy/clone constructor set up the array using the supplied template.
     *
     * @param template ArrayPropertyValue
     */
    public ArrayPropertyValue(ArrayPropertyValue template)
    {
        super(template);

        if (template != null)
        {
            arrayCount = template.getArrayCount();
            arrayValues = template.getArrayValues();
        }
    }


    /**
     * Delegate the process of cloning to the subclass.
     *
     * @return subclass of InstancePropertyValue
     */
    public InstancePropertyValue cloneFromSubclass() {
        return new ArrayPropertyValue(this);
    }


    /**
     * Return the string version of the value - used for error logging.
     *
     * @return string value
     */
    public String valueAsString() {
        return mapValuesAsString(arrayValues.getInstanceProperties()).toString();
    }


    /**
     * Return the object version of the value - used for comparisons.
     *
     * @return object value
     */
    public Object valueAsObject() {
        return mapValuesAsObject(arrayValues.getInstanceProperties());
    }


    /**
     * Return the number of elements in the array.
     *
     * @return int array size
     */
    public int getArrayCount() {
        return arrayCount;
    }


    /**
     * Set up the number of elements in the array.
     *
     * @param arrayCount int array size
     */
    public void setArrayCount(int arrayCount) {
        this.arrayCount = arrayCount;
    }


    /**
     * Return a copy of the array elements.
     *
     * @return ElementProperties containing the array elements
     */
    public ElementProperties getArrayValues()
    {
        if (arrayValues == null)
        {
            return null;
        }
        else
        {
            return new ElementProperties(arrayValues);
        }
    }


    /**
     * Add or update an element in the array.
     *
     * @param elementNumber index number of the element in the array
     * @param propertyValue value to store
     */
    public void setArrayValue(int elementNumber, InstancePropertyValue propertyValue)
    {
        if (arrayCount > elementNumber)
        {
            if (arrayValues == null)
            {
                arrayValues = new ElementProperties();
            }
            arrayValues.setProperty(Integer.toString(elementNumber), propertyValue);
        }
        else
        {
            /*
             * Throw runtime exception to show the caller they are not using the array correctly.
             */
            throw new GAFRuntimeException(GAFErrorCode.ARRAY_OUT_OF_BOUNDS.getMessageDefinition(this.getClass().getSimpleName(),
                                                                                                Integer.toString(elementNumber),
                                                                                                Integer.toString(arrayCount)),
                                          this.getClass().getName(),
                                          "setArrayValue");
        }
    }


    /**
     * Set up the array elements in one call.
     *
     * @param arrayValues ElementProperties containing the array elements
     */
    public void setArrayValues(ElementProperties arrayValues) {
        this.arrayValues = arrayValues;
    }


    /**
     * Standard toString method.
     *
     * @return JSON style description of variables.
     */
    @Override
    public String toString() {
        return "ArrayPropertyValue{" +
                "arrayCount=" + arrayCount +
                ", arrayValues=" + arrayValues +
                ", instancePropertyCategory=" + getPropertyCategory() +
                ", typeGUID='" + getTypeGUID() + '\'' +
                ", typeName='" + getTypeName() + '\'' +
                '}';
    }


    /**
     * Validate that an object is equal depending on their stored values.
     *
     * @param objectToCompare object
     * @return boolean result
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
        ArrayPropertyValue that = (ArrayPropertyValue) objectToCompare;
        return arrayCount == that.arrayCount &&
                Objects.equals(arrayValues, that.arrayValues);
    }


    /**
     * Return a hash code based on the property values
     *
     * @return int hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(arrayCount, arrayValues);
    }
}
