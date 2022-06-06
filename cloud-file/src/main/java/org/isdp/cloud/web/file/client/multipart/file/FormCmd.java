package org.isdp.cloud.web.file.client.multipart.file;



import org.apache.commons.io.IOUtils;
import org.isdp.cloud.web.file.client.multipart.config.FileConfig;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.MultipartForm;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.common.constraint.NotNull;
import io.smallrye.mutiny.Uni;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

@Path("/multipart")
public class FormCmd {

    private static final Logger LOG = Logger.getLogger(FormCmd.class);


    @Inject
    FileConfig fileConfig;

    

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("/uploadFile")
    /**
     * 上传文件
     * @param formData
     * @return
     */
    public Uni<RestResponse<String>> form(@MultipartForm @NotNull UpdateFormData updateFormData) {


        String newFileName = "";



        if("UUID".equals(fileConfig.rename()))newFileName=UUID.randomUUID().toString();


        newFileName=newFileName+updateFormData.file.contentType().replace("/", ".");

        // 写入oss地址中
        LOG.infof("上传文件名:{}", newFileName);
        try {
            IOUtils.copy(new FileInputStream(updateFormData.file.filePath().toFile()),new FileOutputStream(fileConfig.directory()+newFileName));
        } catch (FileNotFoundException e) {
           throw new WebApplicationException("FileNotFoundException",e);
            e.printStackTrace();
        } catch (IOException e) {
            throw  new WebApplicationException("IOException",e);
        }
 
        return Uni.createFrom().item(ResponseBuilder.ok("success").build());
        
       
    }
    /**
     * 下载只限于阻塞端点
     * @param fileName
     * @return
     */
    @GET
    @Produces(MediaType.MULTIPART_FORM_DATA)
    @Path("/downloadFile")
    @Blocking
    public RestResponse<File> getFile(@QueryParam("fileName") String fileName) {

        

        DownloadFormData downloadFormData = new DownloadFormData();
        downloadFormData.name=fileName;
        downloadFormData.file=new File(fileConfig.directory()+fileName);

        if( !downloadFormData.file.exists()) throw new WebApplicationException("this file is not exist!");
        // //对输出的文件名进行编码，防止下载的中文文件名乱码
        String encodFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8);
        return ResponseBuilder.ok(downloadFormData.file)
                .header("content-disposition", "attachment; filename=\"" + encodFileName + "\"")
                .header("Content-Length", downloadFormData.file.length())
                .build();
    }
}