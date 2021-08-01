package org.acme.form;

import io.quarkus.vertx.web.Route;
import io.vertx.core.http.HttpServerResponse;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FailureEndpoint {

    @Route(type = Route.HandlerType.FAILURE)
    void responseFailure(UnsupportedOperationException e, HttpServerResponse response) {
        response.setStatusCode(501).end(e.getMessage());
    }
}
