package com.Spotify.data;

public class Stat {
    private int rank;
    private String Track;
    private String Artist;
    private double Stat;

    public Stat(int rank, String Track, String Artist, double Stat) {
        this.rank = rank;
        this.Track = Track;
        this.Artist = Artist;
        this.Stat = Stat;
    }

    @Override
    public String toString() {
        return "Stat{" + "rank=" + rank + "Track=" + Track + "Artist=" + Artist + ", Stat='" + Stat + '}';
    } // toString
}
