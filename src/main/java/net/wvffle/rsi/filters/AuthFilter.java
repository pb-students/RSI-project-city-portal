package net.wvffle.rsi.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.DatatypeConverter;

@Provider
public class AuthFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext req) throws IOException {
        // Break if request method is GET
        if (req.getMethod().equalsIgnoreCase("get")) {
            return;
        }

        // Get basic auth user and password as variables
        String authHeader = req.getHeaderString("Authorization");

        String authUser = null;
        String authPassword = null;

        if (authHeader != null) {
            String[] authParts = authHeader.split(" ");

            if (authParts.length == 2) {
                String authInfo = authParts[1];
                String decodedAuth = new String(DatatypeConverter.parseBase64Binary(authInfo));
                String[] authInfoParts = decodedAuth.split(":");
                if (authInfoParts.length == 2) {
                    authUser = authInfoParts[0];
                    authPassword = authInfoParts[1];
                }
            }
        }

        // Break if we gave correct credentials
        if (authUser != null && authPassword != null) {
            if (authUser.equals("root") && authPassword.equals("root")) {
                return;
            }
        }

        // Return 401 error code
        req.abortWith(
            Response.status(Response.Status.UNAUTHORIZED)
                .entity("User cannot access the resource.")
                .build()
        );

    }
    
}
