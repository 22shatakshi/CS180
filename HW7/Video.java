/**
 * Homework 7 - Video
 * <p>
 * The Video class represents common details about a video uploaded to a video sharing platform.
 * Each video is created by a Channel.
 * @author Shatakshi Singh
 * @version October 05, 2021
 */
public class Video {
    /**
     * Name of the video.
     */
    private final String videoName;
    /**
     * Channel which created the video.
     */
    private final Channel channel;
    /**
     * Length of video in seconds
     */
    private final int duration;
    /**
     * Number of views for the video, initialized at zero.
     */
    private int numViews;

    public Video(String videoName, Channel channel, int minutes, int seconds) {
        this.videoName = videoName;
        this.channel = channel;
        this.duration = minutes * 60 + seconds;
        this.numViews = 0;
    }

    public String getVideoName() {
        return videoName;
    }
    public Channel getChannel() {
        return channel;
    }
    public String getDuration() {
        return String.valueOf(duration / 60) + ":" + String.format("%.2f", duration % 60);
    }
    public int getViews() {
        return numViews;
    }
    public void setViews(int newnumViews) {
        this.numViews = newnumViews;
    }
    public void addView() {
        this.numViews++;
    }
    public String toString() {
        String video = "Video[" + videoName + ", " + channel.getChannelName() + ", " 
            + getDuration() + ", " + numViews + "]";
        return video;
    }
}
