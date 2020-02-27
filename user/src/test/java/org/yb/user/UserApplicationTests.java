package org.yb.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.util.SocketUtils;
import org.yb.user.dao.UserDAO;
import org.yb.user.entities.User;
import com.mongodb.MongoClient;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

@SpringBootTest
class UserApplicationTests {
	
	@Autowired
	private UserDAO userDao;

	private MongodExecutable mongodExecutable;
    private MongoTemplate mongoTemplate;

    @AfterEach
    void clean() {
        mongodExecutable.stop();
    }

    @BeforeEach
    void setup() throws Exception {
        String ip = "localhost";
        int randomPort = SocketUtils.findAvailableTcpPort();

        IMongodConfig mongodConfig = new MongodConfigBuilder().version(Version.Main.PRODUCTION)
            .net(new Net(ip, randomPort, Network.localhostIsIPv6()))
            .build();

        MongodStarter starter = MongodStarter.getDefaultInstance();
        mongodExecutable = starter.prepare(mongodConfig);
        mongodExecutable.start();
        mongoTemplate = new MongoTemplate(new MongoClient(ip, randomPort), "test");
    }
	
	
	
	@Test
	public void userGivenNotFound() {
		Optional<User> userFound = userDao.findById("u0");
		assertThat(userFound.isPresent()).isEqualTo(false);
	}
	
	
	@Test
	public void allUsersFound() {
		userDao.deleteAll();
		userDao.save(new User("u1","bouazizi","younes",28,"France","bouazizi.younes@gmail.com"));
		userDao.save(new User("u2","safwane","ilyas",27,"France",""));
		userDao.save(new User("u3","obaita","jaafar",29,"France","jaafar.obaita@gmail.com"));
		
		int collectionsNumber = userDao.findAll().size();
		
		assertThat(collectionsNumber==3).isEqualTo(true);
	}
	

}
