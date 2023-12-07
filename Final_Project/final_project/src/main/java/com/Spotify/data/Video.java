package com.Spotify.data;

public class Video {
    private String Track;
    private String Artist;
    private String Title;
    private String Channel;
    private String Licensed;
    private String Official;
    private String URL;
    private int Likes;
    private int Comments;

    public Video(String Track, String Artist, String Title, String Channel, String Licensed, String Official,
            String URL, int Likes, int Comments) {
        this.Track = Track;
        this.Artist = Artist;
        this.Title = Title;
        this.Channel = Channel;
        this.Licensed = Licensed;
        this.Official = Official;
        this.URL = URL;
        this.Likes = Likes;
        this.Comments = Comments;
    }

    @Override
    public String toString() {
        return "Video{" + "Track=" + Track + "Artist=" + Artist + ", Title='" + Title + ", Channel=" + Channel
                + ", Licensed='" + Licensed + ", Official=" + Official + ", URL='" + URL + ", Likes=" + Likes
                + ", Comments='" + Comments + '}';
    } // toString
}
