package cz.cuni.mff.d3s.been.swrepository

import cz.cuni.mff.d3s.been.pluger.InjectService

/**
 * Created by donarus on 2/23/15.
 */
class SoftwareRepositoryClient implements ISoftwareRepositoryClient {

    @InjectService(serviceName = "been-properties")
    private Properties properties

    @InjectService
    private SoftwareRepositoryServer[] servers

    private SoftwareRepositoryServer localServer

    private String softwareRepositoryServerUUID

    public SoftwareRepositoryClient(String softwareRepositoryServerUUID) {
        this.softwareRepositoryServerUUID = softwareRepositoryServerUUID
    }

    void initialize() {
        localServer = servers.find { it.uuid == softwareRepositoryServerUUID }
    }

    void start() {
        println "client started"
    }

}
