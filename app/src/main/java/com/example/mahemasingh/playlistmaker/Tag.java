package com.example.mahemasingh.playlistmaker;

public enum Tag {
    //vector is value, then weight (8 values, 8 weights)

    //dancebiility	energy	speechiness	acousticness	instrumentalness	liveness	tempo	valence

    history (new double[] {0.1,	0.5,	0.1	,1,	0.1,	0.3,	110,	0.5, 0.3,	0.1,	0.15,	0.1,	0.05,	0.05,	0.05,	0.2}),
    outdoor(new double[]{0.5,	0.7,	0.05,	0.7,	0.01,	0.4	,140,	0.8, 0.1,	0.3,	0.05,	0.1,	0.1,	0.15,	0,	0.2}),

    sightseeing (new double [] {0.3,	0.5	,0.05,	0.7,	0.01,	0.3,	100	,0.8, 0.15,	0.1,	0.05,	0.25,	0.25,	0.05,	0.05,	0.1}),

    shopping(new double [] {0.4	,0.6,	0.05,	0.4,	0.01,	0.2	,100	,0.7,0.05,	0.3,	0.05,	0.05,	0.05,	0.05,	0.15,	0.3}),

    hangout(new double [] {0.5	,0.6,	0.05	,0.8,	0.1,	0.5,	125	,1, 0.2,	0.2,	0.05,	0.05,	0.05,	0.05,	0.1,	0.3}),
    club (new double [] {1	,1	,0.02,	0.1,	0.01,	0.1	,200	,0.3, 0.3,	0.3	,0.01,	0.1	,0.01,	0.1,	0.17,	0.01}),
    sports(new double [] {0.8,	1,	0.02,	0.2,	0.01,	0.2	,150,	0.5, 0.15,	0.25,	0.05,	0.05,	0.05,	0.15,	0.25,	0.05}),
    performance (new double [] {0.3,	0.5,	0.1,	0.7,	0.2	,0.5,	150,	0.7,0.05,	0.05	,0.1,	0.2	,0.2	,0.3,	0.05,	0.05});



    private final double[] value;

//values
    Tag(double[] value) {
        this.value = value;
    }

    //gets values
    public double [] getValue () {
        return this.value;
    }

}
