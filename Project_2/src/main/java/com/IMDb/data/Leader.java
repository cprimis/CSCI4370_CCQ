package com.IMDb.data;

public class Leader {
    private int rank;
    private String username;
    private int review_count;

    public Leader(int rank, String username, int review_count) {
        this.rank = rank;
        this.username = username;
        this.review_count = review_count;
    }
    
    @Override
    public String toString() {
        return "Leader{" +
                "rank=" + rank +
                ", username='" + username + '\'' +
                ", review_count=" + review_count +
                '}';
    } // toString

}
