/* SPDX-License-Identifier: Apache 2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.governanceaction.search;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.frameworks.governanceaction.ffdc.GAFErrorCode;
import org.odpi.openmetadata.frameworks.governanceaction.ffdc.GAFRuntimeException;

import java.io.Serializable;
import java.util.*;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;


/**
 * The ElementProperties class provides support for properties to be added to a metadata element,
 * classification or relationship instances.
 *
 * There are variable properties that are defined in the TypeDefs. They are managed in
 * a java.util.Map map object built around HashMap.  The property name (or domain) of the map is the name
 * of the property.  The property value (or range) of the map is a subclass of InstancePropertyValue depending on
 * the type of the property:
 * <ul>
 *     <li>
 *         PrimitivePropertyValue: for primitives such as strings and numbers.  The full list of primitives are
 *         given in PrimitiveDefCategory.
 *     </li>
 *     <li>
 *         EnumPropertyValue: for properties with a type consisting of an enumeration of valid values.  Each
 *     </li>
 *     <li>
 *         StructPropertyValue: for properties that have a type of a complex structure (aka struct).
 *         The Struct can be thought of as a list of related properties.
 *     </li>
 *     <li>
 *         MapPropertyValue: for properties that have a type of map.
 *         The map holds an unordered list of name-value pairs.  The pairs are of the same type and the name for
 *         the pair is unique within the map.
 *     </li>
 *     <li>
 *         ArrayPropertyValue: for properties that have a type of Array.
 *         This is an ordered list of values of the same type.
 *     </li>
 * </ul>
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class ElementProperties implements Serializable
{
    private static final long    serialVersionUID = 1L;

    private Map<String, InstancePropertyValue>  instanceProperties = new HashMap<>();


    /**
     * Typical constructor
     */
    public ElementProperties()
    {
        super();
    }


    /**
     * Copy/clone constructor.
     *
     * @param templateProperties template object to copy.
     */
    public ElementProperties(ElementProperties templateProperties)
    {
        /*
         * An empty properties object is created in the private variable declaration so nothing to do.
         */
        if (templateProperties != null)
        {
            Iterator<String> propertyNames = templateProperties.getPropertyNames();

            if (propertyNames != null)
            {
                while (propertyNames.hasNext())
                {
                    String                 newPropertyName  = propertyNames.next();
                    InstancePropertyValue  newPropertyValue = templateProperties.getPropertyValue(newPropertyName);

                    instanceProperties.put(newPropertyName, newPropertyValue);
                }
            }
        }
    }


    /**
     * Return the instance properties as a map.
     *
     * @return  instance properties map.
     */
    public Map<String, InstancePropertyValue> getInstanceProperties()
    {
        if (instanceProperties == null)
        {
            return null;
        }
        else if (instanceProperties.isEmpty())
        {
            return null;
        }
        else
        {
            return new HashMap<>(instanceProperties);
        }
    }


    /**
     * Set up the instance properties map.
     *
     * @param instanceProperties map of name valued properties
     */
    public void setInstanceProperties(Map<String, InstancePropertyValue> instanceProperties)
    {
        if (instanceProperties == null)
        {
            this.instanceProperties = new HashMap<>();
        }
        else
        {
            this.instanceProperties = instanceProperties;
        }
    }


    /**
     * Returns a list of the instance properties for the element.
     * If no stored properties are present then null is returned.
     *
     * @return list of properties
     */
    public Iterator<String> getPropertyNames()
    {
        return instanceProperties.keySet().iterator();
    }


    /**
     * Returns the requested instance property for the element.
     * If no stored property with that name is present then null is returned.
     *
     * @param name String name of the property to return.
     * @return requested property value.
     */
    public InstancePropertyValue getPropertyValue(String name)
    {
        return instanceProperties.get(name);
    }


    /**
     * Adds or updates an instance property.
     * If a null is supplied for the property name, an OMRS runtime exception is thrown.
     * If a null is supplied for the property value, the property is removed.
     *
     * @param  newPropertyName name
     * @param  newPropertyValue value
     */
    public void setProperty(String newPropertyName, InstancePropertyValue newPropertyValue)
    {
        final String methodName = "setProperty";

        if (newPropertyName == null)
        {
            /*
             * Build and throw exception.
             */
            throw new GAFRuntimeException(GAFErrorCode.NULL_PROPERTY_NAME.getMessageDefinition(),
                                          this.getClass().getName(),
                                          methodName);
        }
        else if (newPropertyValue == null)
        {
            instanceProperties.remove(newPropertyName);
        }
        else
        {
            instanceProperties.put(newPropertyName, newPropertyValue);
        }
    }


    /**
     * Return the number of properties stored.
     *
     * @return int property count
     */
    public int getPropertyCount()
    {
        return instanceProperties.size();
    }


    /**
     * Standard toString method.
     *
     * @return JSON style description of variables.
     */
    @Override
    public String toString()
    {
        return "ElementProperties{" +
                "propertyNames=" + getPropertyNames() +
                ", propertyCount=" + getPropertyCount() +
                ", instanceProperties=" + instanceProperties +
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
        if (!(objectToCompare instanceof ElementProperties))
        {
            return false;
        }
        ElementProperties that = (ElementProperties) objectToCompare;
        return Objects.equals(getInstanceProperties(), that.getInstanceProperties());
    }


    /**
     * Return a hash code based on the values of this object.
     *
     * @return in hash code
     */
    @Override
    public int hashCode()
    {

        return Objects.hash(getInstanceProperties());
    }
}

