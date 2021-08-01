package org.acme.form;

import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

public class FormData {

    @RestForm("payload")
    public FileUpload file;
}
