package info.batey.killrauction.infrastruture;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.utils.UUIDs;
import info.batey.killrauction.domain.Auction;
import info.batey.killrauction.domain.BidVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class AuctionDao {

    private final static Logger LOGGER = LoggerFactory.getLogger(AuctionDao.class);

    private Session session;

    @Inject
    public AuctionDao(Session session) {
        this.session = session;
    }

    @PostConstruct
    public void prepareStatements() {
        //TODO 3a: Prepare any statements
    }

    public void createAuction(Auction auction) {
        //TODO 3b: Create the auction
    }

    public UUID placeBid(String auctionName, String user, Long amount) {
        //TODO 3c: Place a bid
        return null;
    }

    public List<Auction> getAllAuctionsSparse() {
        //TODO 3d: Get all the auctions without the bids
        return Collections.emptyList();
    }

    public Optional<Auction> getAuction(String auctionName) {
        //TODO 3e: Get a single auction
        return Optional.empty();
    }
}
