package org.isdp.cloud.eip.sass.permit.authentication;

import io.quarkus.logging.Log;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.isdp.cloud.eip.sass.permit.authentication.credentials.Credential;
import org.isdp.cloud.eip.sass.permit.authentication.credentials.UsernameAndPasswordCredential;
import org.isdp.cloud.eip.sass.permit.authentication.event.BeforeAuthenticEvent;
import org.isdp.cloud.web.reactive.web.IsdpResponse;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/isdp/auth/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "auth", description = "认证服务")
public class IsdpAuthenCmd {


    @Inject
    @BeforeAuthentic
    Event<BeforeAuthenticEvent> beforeAuthenticEventEvent;

    @Path("login")
    @POST
    public IsdpResponse login(UsernameAndPasswordCredential credential){


        Log.infov("befor login param is {0}",credential);
        // 认证前 同步消费
        BeforeAuthenticEvent beforeAuthenticEvent = new BeforeAuthenticEvent("digital");

        beforeAuthenticEvent.checkXcode(credential.getXcode());
        beforeAuthenticEventEvent.fire(beforeAuthenticEvent);
        Log.infov("after auth fire event is {0}",beforeAuthenticEvent);

        return IsdpResponse.OK("认真陈宫");
    }


}
