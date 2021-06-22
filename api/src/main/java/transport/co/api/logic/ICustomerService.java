package transport.co.api.logic;

import transport.co.api.model.Customer;
import transport.co.api.request.PersonRequest;

public interface ICustomerService {
    Customer registerNewCustomerAccount(PersonRequest personRequest);
}
