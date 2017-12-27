/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssc.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Jesus_Serrato
 */
public class AlbumStreams {
    
    public AlbumStreams() {
        Album a = new Album("A");
        a.addTrack(new Track("a1", 100));
        a.addTrack(new Track("a2", 50));
        
        Album b = new Album("B");
        b.addTrack(new Track("b1", 40));
        b.addTrack(new Track("b2", 50));
        
        Album c = new Album("C");
        c.addTrack(new Track("c1", 600));
        c.addTrack(new Track("c2", 10));
        
        Album d = new Album("D");
        d.addTrack(new Track("d1", 160));
        d.addTrack(new Track("d2", 200));
        
        findLongTracks(Arrays.asList(a, b, c, d)).stream().forEach(System.out::println);
    }
    
    public Set<String> findLongTracks(List<Album> albums) {
        return albums.stream().flatMap(album -> album.getTrackList().stream())
                       .filter(track -> track.getLength() > 60)
                       .map(track -> track.getName())
                       .collect(Collectors.toSet());
    }
    
    private class Album {
        
        private String name;
        private List<Track> trackList;
        
        public Album() {
            trackList = new ArrayList<>();
        }
        
        public Album(String name) {
            this();
            this.name = name;
        }
        
        public Album(String name, List<Track> trackList) {
            this(name);
            this.trackList.addAll(trackList);
        }
        
        public Album(String name, Track... tracks) {
            this(name);
            trackList.addAll(Arrays.asList(tracks));
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public String getName() {
            return name;
        }
        
        public void addTrack(Track track) {
            trackList.add(track);
        }
        
        public void setTrackList(List<Track> trackList) {
            trackList.addAll(trackList);
        }
        
        public List<Track> getTrackList() {
            return trackList;
        }
        
    }
    
    private class Track {
        
        private String name;
        private int length;
        
        public Track() {
        
        }
        
        public Track(String name, int length) {
            this.name = name;
            this.length = length;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public String getName() {
            return name;
        }
        
        public void setLength(int length) {
            this.length = length;
        }
        
        public int getLength() {
            return length;
        }
        
    }
    
    public static void main(String[] args) {
        new AlbumStreams();
    }
    
}
