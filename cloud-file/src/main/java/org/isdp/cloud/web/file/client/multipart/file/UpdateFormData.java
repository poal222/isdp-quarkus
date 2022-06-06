package org.isdp.cloud.web.file.client.multipart.file;

import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import javax.ws.rs.core.MediaType;

/**
 * 文件处理 pojo
 * 为了处理具有multipart/form-data内容类型的 HTTP 请求
 *
 */
public class UpdateFormData {

    @RestForm
    @PartType(MediaType.TEXT_PLAIN)
    public String description;

    @RestForm("file")
    public FileUpload file;

    public void formData() {

    }

    /** no-args constructor */
    public UpdateFormData() {
    }

}