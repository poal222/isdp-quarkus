package org.isdp.cloud.eip.sass;


import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.jboss.logging.Logger;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


/**
 * @author 王岗
 */
@ApplicationPath("/eip/api/v1/")
@QuarkusMain
public class EipApplication extends Application {
    static Logger logger = Logger.getLogger(EipApplication.class);

    public static void main(String... args) {
        Quarkus.run(MyApp.class, args);
    }

    public static class MyApp implements QuarkusApplication {
        @Override
        public int run(String... args) throws Exception {
            logger.info("EipApplication starting!");
            Quarkus.waitForExit();
            return 0;
        }
    }

}
