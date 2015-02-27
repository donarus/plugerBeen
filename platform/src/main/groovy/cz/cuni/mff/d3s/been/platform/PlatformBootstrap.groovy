package cz.cuni.mff.d3s.been.platform

import cz.cuni.mff.d3s.been.pluger.IServiceRegistrator
import cz.cuni.mff.d3s.been.pluger.impl.Pluger

/**
 * Created by donarus on 2/24/15.
 */
class PlatformBootstrap {
    public static void main(String[] args) {
        def config = [
                (Pluger.WORKING_DIRECTORY_KEY) : new File("/tmp/platform").toPath(),
                (Pluger.DEPENDENCIES_FINAL_KEY): []
        ]

        def beenProperties = new Properties()
        beenProperties.put("software-repository.runServer", true)
        beenProperties.put("software-repository.port", 99)
        def pluger = new Pluger(config) {
            void preRegisterServices(IServiceRegistrator registry) {
                registry.registerService("been-properties", beenProperties)
            }
        }
        pluger.start();
    }

}


