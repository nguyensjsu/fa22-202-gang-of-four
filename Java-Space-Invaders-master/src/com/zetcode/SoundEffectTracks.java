package com.zetcode;

import java.util.HashMap;
import java.util.Map;

public class SoundEffectTracks {
    public enum Track {
        IntroSound,
        HeroShoot,
        InvaderShoot,
        InvaderExplosion
    }

    private static Map<Track, String> trackToPathMap =
        new HashMap<Track, String>(){{
            put(Track.IntroSound, "resources/carter.wav");
            put(Track.HeroShoot, "resources/qubodup.wav");
            put(Track.InvaderShoot, "resources/laser.wav");
            put(Track.InvaderExplosion, "resources/matthey.wav");
        }};
    public static String GetTrackPath(Track track){
        return trackToPathMap.get(track);
    }
}
