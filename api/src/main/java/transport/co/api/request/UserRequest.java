package transport.co.api.request;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserRequest {

    @NotNull
    private String username;

    @NotNull
    private String password;
    private String matchingPassword;

}
