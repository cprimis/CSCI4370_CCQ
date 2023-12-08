package com.Spotify.data;

public class AllStats {
    private String Track;
    private String Artist;
    private String Album;
    private double Tempo;
    private String Key;
    private double Energy;
    private double Danceability;
    private double Valence;
    private double Liveness;
    private double Loudness;
    private double Instrumentalness;
    private double Speechiness;
    private double Acousticness;

    public AllStats(String Track, String Artist, String Album, double Tempo, String Key, double Energy, double Danceability,
            double Valence, double Liveness, double Loudness, double Instrumentalness, double Speechiness,
            double Acousticness) {
        this.Track = Track;
        this.Artist = Artist;
        this.Album = Album;
        this.Tempo = Tempo;
        this.Key = Key;
        this.Energy = Energy;
        this.Danceability = Danceability;
        this.Valence = Valence;
        this.Liveness = Liveness;
        this.Loudness = Loudness;
        this.Instrumentalness = Instrumentalness;
        this.Speechiness = Speechiness;
        this.Acousticness = Acousticness;
    }

    @Override
    public String toString() {
        return "AllStats{" + "Track=" + Track + ", Artist=" + Artist + ", Album=" + Album + ", Tempo=" + Tempo + ", Key="
                + Key + ", Energy=" + Energy + ", Danceability=" + Danceability + ", Valence=" + Valence
                + ", Liveness=" + Liveness + ", Loudness=" + Loudness + ", Instrumentalness=" + Instrumentalness
                + ", Speechiness=" + Speechiness + ", Acousticness=" + Acousticness + '}';
    } // toString
}
