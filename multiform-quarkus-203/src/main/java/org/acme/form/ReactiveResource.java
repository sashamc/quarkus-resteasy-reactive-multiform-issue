package org.acme.form;

import org.acme.form.FormData;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.MultipartForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

@Path("rest")
public class ReactiveResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy Reactive";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("form")
    public String form(@MultipartForm FormData formData) {

        FileUpload fileUpload = formData.file;
        String contentType = fileUpload.contentType();
        java.nio.file.Path path = fileUpload.uploadedFile();

        return "file: " + fileUpload.fileName()
            + ", content type: " + contentType 
            + ", uploaded file: " + path.toString();
    }
}
