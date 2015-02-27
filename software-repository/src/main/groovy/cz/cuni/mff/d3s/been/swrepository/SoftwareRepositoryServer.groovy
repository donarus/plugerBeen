package cz.cuni.mff.d3s.been.swrepository

import cz.cuni.mff.d3s.been.pluger.InjectService

/**
 * Created by donarus on 2/23/15.
 */
class SoftwareRepositoryServer {

    @InjectService(serviceName = "been-properties")
    private Properties beenProperties;

    private boolean runServer

    private int serverPort

    boolean running

    String uuid

    public SoftwareRepositoryServer(String uuid) {
        this.uuid = uuid
    }

    void initialize() {
        runServer = beenProperties.get("software-repository.runServer", false)
        serverPort = beenProperties.get("software-repository.port", 81)
    }

    void start() {
        if (runServer) {
            System.out.println("run server")
            // write into hazelcast that I am UP and running
            startServer()
            running = true
        } else {
            // server disabled
        }
        System.out.println("server started")
    }

    private void startServer() {
    }
}