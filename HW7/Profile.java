/**
 * Homework 7 - Profile
 * <p>
 * The Profile class represents details about a content viewer.
 * This includes their username, an array of Channel
 * objects representing content creators they've subscribed to, and the
 * number of channels subscribed to.
 * @author Shatakshi Singh
 * @version October 05, 2021
 */
public class Profile {
    /**
     * Username of the user
     */
    private final String username;
    /**
     * An array containing channels subscribed to by this user.
     */
    private Channel[] subscribed;
    /**
     * Number of channels subscribed to by this user
     */
    private int numSubscribed;

    public Profile(String username) {
        this.username = username;
        this.numSubscribed = 0;
        this.subscribed = new Channel[100];
    }
    public String getUsername() {
        return username;
    }
    public Channel[] getSubscribed() {
        return subscribed;
    }
    public void setSubscribed(Channel[] newsubscribed, int newnumSubscribed) {
        this.subscribed = newsubscribed;
        this.numSubscribed = newnumSubscribed;
    }
    public boolean subscribeToChannel(Channel channel) {
        if (numSubscribed == 100)
            return false;
        else {
            if (!(findChannel(channel.getChannelName()) == null))
                return false;
            else {
                this.subscribed[numSubscribed] = channel;
                numSubscribed++;
                channel.addChannelSubscriber();
                return true;
            }
        }
    }
    public Channel findChannel(String channelName) {
        for (int i = 0; i < numSubscribed; i++) {
            if (subscribed[i].getChannelName().equals(channelName))
                return subscribed[i];
        }
        return null;
    }
    public String toString() {
        return "Profile[" + getUsername() + "]";
    }
}
