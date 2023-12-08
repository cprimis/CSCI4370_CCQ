package com.Spotify.data;

public class Leader {
    private int rank;
    private String Album;
    private String Artist;
    private int TrackCount;

    public Leader(int rank, String Album, String Artist, int TrackCount) {
        this.rank = rank;
        this.Album = Album;
        this.Artist = Artist;
        this.TrackCount = TrackCount;
    }
    
    @Override
    public String toString() {
        return "Leader{" +
                "rank=" + rank +
                ", Album='" + Album + 
                ", Artist='" + Artist + 
                ", review_count=" + TrackCount +
                '}';
    } // toString
}
