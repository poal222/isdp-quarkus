package org.isdp.cloud.eip.sass.permit.authentication.credentials;

import lombok.Data;

import javax.enterprise.inject.Model;

@Model
@Data
public class UsernameAndPasswordCredential implements Credential{

    private String username ="username";

    private String password ="password";

    private String xcode = "xcode";

    @Override
    public String toString() {
        return "UsernameAndPasswordCredential{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
