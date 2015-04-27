package info.batey.killrauction.infrastruture;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.google.common.collect.Sets;
import info.batey.killrauction.domain.AuctionUser;
import info.batey.killrauction.web.user.UserCreate;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class AuctionUserDaoTest {

    private static Cluster cluster;
    private static Session session;

    private AuctionUserDao underTest;

    @Mock
    private Md5PasswordEncoder md5PasswordEncoder;

    @Mock
    private SecureRandom secure;

    @BeforeClass
    public static void schemaSetup() throws Exception {
        cluster = Cluster.builder().addContactPoint("localhost").build();
        session = cluster.connect();
        session.execute("CREATE KEYSPACE IF NOT EXISTS killrauction_tests WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1 }");
        session.execute("use killrauction_tests");
    }

    @AfterClass
    public static void shutdown() throws Exception {
        session.execute("drop keyspace killrauction_tests");
        session.close();
        cluster.close();
    }

    @Before
    public void setUp() throws Exception {
        session.execute("truncate users");
        underTest = new AuctionUserDao(session, md5PasswordEncoder, secure);
        underTest.prepareStatements();
    }

}