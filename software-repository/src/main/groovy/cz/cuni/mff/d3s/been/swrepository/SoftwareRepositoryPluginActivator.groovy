package cz.cuni.mff.d3s.been.swrepository

import cz.cuni.mff.d3s.been.pluger.IPluginActivator
import cz.cuni.mff.d3s.been.pluger.IServiceRegistrator

class SoftwareRepositoryPluginActivator implements IPluginActivator {

    private SoftwareRepositoryServer softwareRepositoryServer
    private SoftwareRepositoryClient softwareRepositoryClient

    @Override
    void activate(IServiceRegistrator iServiceRegistrator) {
        def serverUUID = UUID.randomUUID().toString()
        softwareRepositoryServer = iServiceRegistrator.registerService(new SoftwareRepositoryServer(serverUUID))
        softwareRepositoryClient = iServiceRegistrator.registerService(new SoftwareRepositoryClient(serverUUID))
    }

    @Override
    void initialize() {
        softwareRepositoryServer.initialize()
        softwareRepositoryClient.initialize()
    }

    @Override
    void start() {
        softwareRepositoryClient.start()
        softwareRepositoryServer.start()
    }
}
