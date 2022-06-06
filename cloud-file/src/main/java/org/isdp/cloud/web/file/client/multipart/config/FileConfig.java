package org.isdp.cloud.web.file.client.multipart.config;

import io.quarkus.runtime.annotations.StaticInitSafe;
import io.smallrye.config.ConfigMapping;


@ConfigMapping(prefix = "isdp.file.uploads")
public interface FileConfig {

    String directory();

    String rename();
}
