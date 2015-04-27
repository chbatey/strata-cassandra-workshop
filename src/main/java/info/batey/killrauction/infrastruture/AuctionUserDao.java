package info.batey.killrauction.infrastruture;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import info.batey.killrauction.domain.AuctionUser;
import info.batey.killrauction.web.user.UserCreate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.SecureRandom;
import java.util.Optional;

@Component
public class AuctionUserDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuctionUserDao.class);

    private Session session;
    private Md5PasswordEncoder md5PasswordEncoder;
    private SecureRandom secureRandom;

    @Autowired
    public AuctionUserDao(Session session, Md5PasswordEncoder md5PasswordEncoder, SecureRandom secureRandom) {
        this.session = session;
        this.md5PasswordEncoder = md5PasswordEncoder;
        this.secureRandom = secureRandom;
    }

    @PostConstruct
    public void prepareStatements() {
        //TODO 2a: Prepare any statements
    }

    /**
     *
     * @param userCreate User to create
     * @return Whether the username was allowed
     */
    public boolean createUser(UserCreate userCreate) {
        LOGGER.debug("Creating user request {}", userCreate);
        Object salt = secureRandom.nextLong();
        String endcodedPassword = md5PasswordEncoder.encodePassword(userCreate.getPassword(), salt);
        //TODO 2b: Create the user
        return false;
    }

    public Optional<AuctionUser> retrieveUser(String userName) {
        //TODO 2c: Get user
        return null;
    }
}
