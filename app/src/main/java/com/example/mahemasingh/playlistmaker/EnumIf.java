package com.example.mahemasingh.playlistmaker;


//determines if a specified enum is one
public class EnumIf {

    public Tag enumIf(String type) {

        switch (type) {
            case "History":
                return Tag.history;


            case "Outdoor":
                return Tag.outdoor;


            case "Shopping":
                return Tag.shopping;


            case "Sightseeing":
                return Tag.sightseeing;

            case "Hangout":
                return Tag.history;

            case "Club":
                return Tag.club;


            case "Sports":
                return Tag.sports;


            case "Performance":
                return Tag.performance;


            default:
                throw new IllegalArgumentException("no proper tag for location");
        }
    }


}
