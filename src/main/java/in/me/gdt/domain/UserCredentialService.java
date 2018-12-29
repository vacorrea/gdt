
package in.me.gdt.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserCredentialService extends CrudRepository<UserCredentials, String> {
        
}