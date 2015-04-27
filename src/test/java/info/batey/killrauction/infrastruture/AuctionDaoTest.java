package info.batey.killrauction.infrastruture;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.utils.UUIDs;
import info.batey.killrauction.domain.Auction;
import info.batey.killrauction.domain.BidVo;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class AuctionDaoTest {
    private static Cluster cluster;
    private static Session session;

    private AuctionDao underTest;

    @BeforeClass
    public static void schemaSetup() throws Exception {
        cluster = Cluster.builder().addContactPoint("localhost").build();
        session = cluster.connect();
        session.execute("CREATE KEYSPACE IF NOT EXISTS killrauction_tests WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1 }");
        session.execute("use killrauction_tests");

        //TODO create any tables?
    }

    @AfterClass
    public static void shutdown() throws Exception {
        session.execute("drop keyspace killrauction_tests");
        session.close();
        cluster.close();
    }

}