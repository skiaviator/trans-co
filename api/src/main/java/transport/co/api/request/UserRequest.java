package transport.co.api.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    @NotNull
    private String username;

    @NotNull
    private String password;
    private String matchingPassword;

}
