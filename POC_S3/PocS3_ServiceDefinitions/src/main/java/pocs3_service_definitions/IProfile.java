package pocs3_service_definitions;

import java.util.List;

/**
 * The interface IProfile allows to
 */
public interface IProfile {

    /**
     * Return profile name
     */
    public String getName();

    /**
     * Return application list
     */
    public List<IApplication> getApplications();
}
