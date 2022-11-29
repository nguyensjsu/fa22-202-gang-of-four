package com.zetcode.utilites;

import java.util.HashMap;
import java.util.Map;

public class SoundEffectTracks {
    public enum Track {
        IntroSound,
        HeroShoot,
        InvaderShoot,
        InvaderExplosion,
        SpeedUp
    }

    private static Map<Track, String> trackToPathMap =
        new HashMap<Track, String>(){{
            put(Track.IntroSound, "Java-Space-Invaders-master/src/resources/carter.wav");
            put(Track.HeroShoot, "Java-Space-Invaders-master/src/resources/qubodup.wav");
            put(Track.InvaderShoot, "Java-Space-Invaders-master/src/resources/laser.wav");
            put(Track.InvaderExplosion, "Java-Space-Invaders-master/src/resources/matthey.wav");
            put(Track.SpeedUp, "Java-Space-Invaders-master/src/resources/SpeedUp.wav");
        }};
    public static String GetTrackPath(Track track){
        return trackToPathMap.get(track);
    }
}
