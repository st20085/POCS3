package pocs3_service_definitions;

import java.util.List;

/**
 * The interface <b>IPocS3Profile</b> allows to.<br>
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
