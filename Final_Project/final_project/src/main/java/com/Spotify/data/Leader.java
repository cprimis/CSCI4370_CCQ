package com.Spotify.data;

public class Leader {
    private int rank;
    private String Album_Name;
    private int TrackCount;

    public Leader(int rank, String Album_Name, int TrackCount) {
        this.rank = rank;
        this.Album_Name = Album_Name;
        this.TrackCount = TrackCount;
    }
    
    @Override
    public String toString() {
        return "Leader{" +
                "rank=" + rank +
                ", Album_Name='" + Album_Name + '\'' +
                ", review_count=" + TrackCount +
                '}';
    } // toString

}
