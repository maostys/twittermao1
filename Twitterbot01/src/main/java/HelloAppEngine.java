import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class HelloAppEngine extends HttpServlet{
	static Logger logger = Logger.getLogger("SenyaBot");
	
	static String consumerKey = "xxxxxx";
	static String consumerSecret = "xxxxxx";
	
	static String accessToken = "xxxxx";
	static String accessTokenSecret = "xxxxx";
	
	private String getTweet(){
		String tweets[] = {
				"aaa"
		};
		int randint = (int)(Math.random()*tweets.length);
		return tweets[randint];
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		//http://twitter4j.org/ja/configuration.html
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
			.setOAuthAccessToken(accessToken)
			.setOAuthAccessTokenSecret(accessTokenSecret)
			.setOAuthConsumerKey(consumerKey)
			.setOAuthConsumerSecret(consumerSecret);
		String message = getTweet();
		Twitter twitter = new TwitterFactory(cb.build()).getInstance();
		try {
			//Twitter�ɏ����o��
			twitter.updateStatus(message);
		} catch (TwitterException e) {
			logger.log(Level.SEVERE, "Twitter error", e);
		}
	}
}