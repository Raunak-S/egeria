/* SPDX-License-Identifier: Apache 2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.governanceaction;

import org.odpi.openmetadata.frameworks.connectors.ffdc.InvalidParameterException;
import org.odpi.openmetadata.frameworks.connectors.ffdc.PropertyServerException;
import org.odpi.openmetadata.frameworks.connectors.ffdc.UserNotAuthorizedException;
import org.odpi.openmetadata.frameworks.governanceaction.events.WatchdogEventType;
import org.odpi.openmetadata.frameworks.governanceaction.properties.ActionTargetElement;
import org.odpi.openmetadata.frameworks.governanceaction.properties.IncidentDependency;
import org.odpi.openmetadata.frameworks.governanceaction.properties.IncidentImpactedElement;
import org.odpi.openmetadata.frameworks.governanceaction.properties.RequestSourceElement;

import java.util.List;
import java.util.Map;


/**
 * WatchdogGovernanceContext provides the watchdog governance service with access to information about
 * the request, open metadata store and the ability to register a listener to receive governance events.
 */
public abstract class WatchdogGovernanceContext extends GovernanceContext
{
    private WatchdogGovernanceListener registeredListener = null;
    private List<WatchdogEventType>    interestingEvents  = null;
    private List<String>               interestingTypes   = null;


    /**
     * Constructor sets up the key parameters for processing the request to the governance service.
     *
     * @param userId calling user
     * @param requestType unique identifier of the asset that the annotations should be attached to
     * @param requestParameters name-value properties to control the governance service
     * @param requestSourceElements metadata elements associated with the request to the governance service
     * @param actionTargetElements metadata elements that need to be worked on by the governance service
     * @param openMetadataStore client to the metadata store for use by the governance service
     */
    public WatchdogGovernanceContext(String                     userId,
                                     String                     requestType,
                                     Map<String, String>        requestParameters,
                                     List<RequestSourceElement> requestSourceElements,
                                     List<ActionTargetElement>  actionTargetElements,
                                     OpenMetadataStore          openMetadataStore)
    {
        super(userId, requestType, requestParameters, requestSourceElements, actionTargetElements, openMetadataStore);
    }


    /**
     * Register a listener to receive events about changes to metadata elements in the open metadata store.
     * There can be only one registered listener.  If this method is called more than once, the new parameters
     * replace the existing parameters.  This means the watchdog governance service can change the
     * listener and the parameters that control the types of events received while it is running.
     *
     * The types of events passed to the listener are controlled by the combination of the interesting event types and
     * the interesting metadata types.  That is an event is only passed to the listener if it matches both
     * the interesting event types and the interesting metadata types.
     *
     * If interestingEventTypes or interestingMetadataTypes are null, it defaults to "any".
     * If the listener parameter is null, no more events are passed to the listener.
     *
     * @param listener listener object to receive events
     * @param interestingEventTypes types of events that should be passed to the listener
     * @param interestingMetadataTypes types of elements that are the subject of the interesting event types.
     */
    public void registerListener(WatchdogGovernanceListener listener,
                                 List<WatchdogEventType>    interestingEventTypes,
                                 List<String>               interestingMetadataTypes)
    {
        this.registeredListener = listener;
        this.interestingEvents  = interestingEventTypes;
        this.interestingTypes   = interestingMetadataTypes;
    }


    /**
     * Create a governance action in the metadata store which will trigger the governance service
     * associated with the supplied request type.  The governance action remains to act as a record
     * of the actions taken for auditing.
     *
     * @param qualifiedName unique identifier to give this governance action
     * @param domainIdentifier governance domain associated with this action (0=ALL)
     * @param displayName display name for this action
     * @param description description for this action
     * @param requestSourceGUIDs  request source elements for the resulting governance service
     * @param actionTargetGUIDs list of action targets for the resulting governance service
     * @param requestType request type to identify the governance service to run
     * @param guards guards to pass on to the requested action
     * @param requestProperties properties to pass to the governance service
     *
     * @return unique identifier of the governance action
     * @throws InvalidParameterException null qualified name
     * @throws UserNotAuthorizedException this governance service is not authorized to create a governance action
     * @throws PropertyServerException there is a problem with the metadata store
     */
    public abstract String initiateGovernanceAction(String              qualifiedName,
                                                    int                 domainIdentifier,
                                                    String              displayName,
                                                    String              description,
                                                    List<String>        requestSourceGUIDs,
                                                    List<String>        actionTargetGUIDs,
                                                    String              requestType,
                                                    String              guards,
                                                    Map<String, String> requestProperties) throws InvalidParameterException,
                                                                                                  UserNotAuthorizedException,
                                                                                                  PropertyServerException;


    /**
     * Using the named governance action process as a template, initiate a chain of governance actions.
     *
     * @param processQualifiedName unique name of the governance action process to use
     * @param requestSourceGUIDs  request source elements for the resulting governance service
     * @param actionTargetGUIDs list of action targets for the resulting governance service
     *
     * @return unique identifier of the first governance action of the process
     * @throws InvalidParameterException null or unrecognized qualified name of the process
     * @throws UserNotAuthorizedException this governance service is not authorized to create a governance action process
     * @throws PropertyServerException there is a problem with the metadata store
     */
    public abstract String initiateGovernanceActionProcess(String       processQualifiedName,
                                                           List<String> requestSourceGUIDs,
                                                           List<String> actionTargetGUIDs) throws InvalidParameterException,
                                                                                                  UserNotAuthorizedException,
                                                                                                  PropertyServerException;


    /**
     * Create an incident report to capture the situation detected by this governance service.
     * This incident report will be processed by other governance activities.
     *
     * @param qualifiedName unique identifier to give this new incident report
     * @param domainIdentifier governance domain associated with this action (0=ALL)
     * @param background description of the situation
     * @param impactedResources details of the resources impacted by this situation
     * @param previousIncidents links to previous incident reports covering this situation
     * @param incidentClassifiers initial classifiers for the incident report
     * @param additionalProperties additional arbitrary properties for the incident reports
     *
     * @return unique identifier of the resulting incident report
     * @throws InvalidParameterException null or non-unique qualified name for the incident report
     * @throws UserNotAuthorizedException this governance service is not authorized to create a incident report
     * @throws PropertyServerException there is a problem with the metadata store
     */
    public abstract String createIncidentReport(String                        qualifiedName,
                                                int                           domainIdentifier,
                                                String                        background,
                                                List<IncidentImpactedElement> impactedResources,
                                                List<IncidentDependency>      previousIncidents,
                                                Map<String, Integer>          incidentClassifiers,
                                                Map<String, String>           additionalProperties) throws InvalidParameterException,
                                                                                                           UserNotAuthorizedException,
                                                                                                           PropertyServerException;


    /**
     * Standard toString method.
     *
     * @return print out of variables in a JSON-style
     */
    @Override
    public String toString()
    {
        return "WatchdogGovernanceContext{" +
                       "registeredListener=" + registeredListener +
                       ", interestingEvents=" + interestingEvents +
                       ", interestingTypes=" + interestingTypes +
                       ", requestType='" + getRequestType() + '\'' +
                       ", requestParameters=" + getRequestParameters() +
                       ", requestSourceElements=" + getRequestSourceElements() +
                       ", actionTargetElements=" + getActionTargetElements() +
                       ", openMetadataStore=" + getOpenMetadataStore() +
                       '}';
    }
}
