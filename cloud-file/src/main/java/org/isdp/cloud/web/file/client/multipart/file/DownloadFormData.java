package org.isdp.cloud.web.file.client.multipart.file;

import java.io.File;

import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;
/**
 * download file pojo
 * 想要公开的信息
 */
public class DownloadFormData {

    @RestForm
    String name;

    @RestForm
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    File file;


}