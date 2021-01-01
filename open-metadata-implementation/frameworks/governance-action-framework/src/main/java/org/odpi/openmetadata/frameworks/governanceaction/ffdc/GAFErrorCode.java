/* SPDX-License-Identifier: Apache-2.0 */
package org.odpi.openmetadata.frameworks.governanceaction.ffdc;

import org.odpi.openmetadata.frameworks.auditlog.messagesets.ExceptionMessageDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * The GAF error code is used to define first failure data capture (FFDC) for errors that occur when working with
 * GAF Components.  It is used in conjunction with the GAFCheckedException and GAFRuntimeException.
 *
 * The 5 fields in the enum are:
 * <ul>
 *     <li>HTTP Error Code - for translating between REST and JAVA - Typically the numbers used are:</li>
 *     <li><ul>
 *         <li>500 - internal error</li>
 *         <li>400 - invalid parameters</li>
 *         <li>404 - not found</li>
 *         <li>409 - data conflict errors - eg item already defined</li>
 *     </ul></li>
 *     <li>Error Message Id - to uniquely identify the message</li>
 *     <li>Error Message Text - includes placeholder to allow additional values to be captured</li>
 *     <li>SystemAction - describes the result of the error</li>
 *     <li>UserAction - describes how a user should correct the error</li>
 * </ul>
 */
public enum GAFErrorCode 
{
    NULL_GOVERNANCE_CONTEXT(400, "GAF-GOVERNANCE-SERVICE-400-001",
                           "No governance context supplied to the governance service {0}",
                           "The governance service has no access to open metadata, the request type and request parameters.",
                           "This may be a configuration or, more likely a code error in the governance engine.  Look for other error messages and review the code of the governance service.  Once the cause is resolved, retry the governance request."),
    INVALID_GOVERNANCE_SERVICE_CONNECTION(400, "GAF-GOVERNANCE-SERVICE-400-002",
                                         "The governance engine {0} is not able to create the governance service for request type {1} and request parameters {2}.  Error message was {3}.  The connection was {4}",
                                         "The governance engine is not able to create a governance service because the connection information associated with the governance service is not valid.",
                                         "The connection is stored with the governance service definition in the open metadata repository used by the governance engine.  Use the error message to correct the connection properties.  Once the connection is corrected is resolved, retry the governance request."),
    INVALID_GOVERNANCE_SERVICE_CONNECTOR(400, "GAF-GOVERNANCE-SERVICE-400-003",
                                        "Invalid governance service for request type {0}.  Governance engine {1} is not able to execute the request",
                                        "The governance service is not functioning correctly.",
                                        "This may be a configuration or a code error in the connector.  Look for other error messages and review the code of the governance service.  Once the cause is resolved, retry the governance request."),

    UNEXPECTED_EXCEPTION(500, "GAF-GOVERNANCE-SERVICE-500-001",
                         "Unexpected {0} exception in governance service {1} of type {2} detected by method {3}.  The error message was {4}",
                         "The governance service failed during its operation.",
                         "This may be a configuration or a code error.  Look for other error messages and review the code of the governance service.  Once the cause is resolved, retry the governance request."),

    NULL_PROPERTY_NAME(500, "GAF-PROPERTIES-400-003",
                       "Null property name passed to properties object",
                       "A request to set an additional property failed because the property name passed was null",
                       "Recode the call to the property object with a valid property name and retry."),
    ARRAY_OUT_OF_BOUNDS(500, "GAF-PROPERTIES-400-004",
                        "{0} is unable to add a new element to location {1} of an array of size {2} value",
                        "There is an error in the update of an ArrayPropertyValue.",
                        "Recode the call to the property object with a valid element location and retry."),


    INVALID_PRIMITIVE_CLASS_NAME(500, "GAF-PROPERTIES-500-001",
                                 "The Java class {0} for PrimitiveDefCategory {1} is not known",
                                 "There is an internal error in Java class PrimitiveDefCategory as it has been set up with an invalid class.",
                                 "Raise a Github issue to get this fixed."),
    INVALID_PRIMITIVE_VALUE(500, "GAF-PROPERTIES-500-002",
                            "The primitive value should be stored in Java class {0} rather than {1} since it is of PrimitiveDefCategory {2}",
                            "There is an internal error in the creation of a PrimitiveTypeValue.",
                            "Open an issue on GitHub to get this addressed."),
    INVALID_PRIMITIVE_CATEGORY(500, "GAF-PROPERTIES-500-003",
                               "There is a problem in the definition of primitive type {0}.",
                               "There is an internal error during the creation of a PrimitiveTypeValue.",
                               "Open a Github issue to get this looked into."),
    INVALID_PRIMITIVE_TYPE(500, "GAF-PROPERTIES-500-004",
                           "The value supplied for an attribute of PrimitiveDefCategory {0} is expected as Java class {1} but was supplied as Java class {2}",
                           "There is an internal error - code that sets a primitive property value is using an incorrect Java class.",
                           "Report as a Github issue to get this addressed."),

    ;

    private ExceptionMessageDefinition messageDefinition;

    /**
     * The constructor for GAFErrorCode expects to be passed one of the enumeration rows defined in
     * GAFErrorCode above.   For example:
     *
     *     GAFErrorCode   errorCode = GAFErrorCode.UNKNOWN_ENDPOINT;
     *
     * This will expand out to the 5 parameters shown below.
     *
     * @param httpErrorCode   error code to use over REST calls
     * @param errorMessageId   unique Id for the message
     * @param errorMessage   text for the message
     * @param systemAction   description of the action taken by the system when the error condition happened
     * @param userAction   instructions for resolving the error
     */
    GAFErrorCode(int  httpErrorCode, String errorMessageId, String errorMessage, String systemAction, String userAction)
    {
        this.messageDefinition = new ExceptionMessageDefinition(httpErrorCode,
                                                                errorMessageId,
                                                                errorMessage,
                                                                systemAction,
                                                                userAction);
    }


    /**
     * Retrieve a message definition object for an exception.  This method is used when there are no message inserts.
     *
     * @return message definition object.
     */
    public ExceptionMessageDefinition getMessageDefinition()
    {
        return messageDefinition;
    }


    /**
     * Retrieve a message definition object for an exception.  This method is used when there are values to be inserted into the message.
     *
     * @param params array of parameters (all strings).  They are inserted into the message according to the numbering in the message text.
     * @return message definition object.
     */
    public ExceptionMessageDefinition getMessageDefinition(String... params)
    {
        messageDefinition.setMessageParameters(params);

        return messageDefinition;
    }
}
