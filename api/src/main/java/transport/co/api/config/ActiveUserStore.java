package transport.co.api.config;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ActiveUserStore {
    public List<String> users;

    public ActiveUserStore() {
        users = new ArrayList<String>();
    }

}
