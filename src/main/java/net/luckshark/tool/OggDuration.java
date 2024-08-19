package net.luckshark.tool;


import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.generic.GenericAudioHeader;
import org.jaudiotagger.audio.ogg.util.OggInfoReader;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class OggDuration {
    public static double oggDuration(String filePath) throws IOException, CannotReadException {
        File file = new File(filePath);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file,"rwd");
        OggInfoReader oggInfoReader = new OggInfoReader();
        GenericAudioHeader read = oggInfoReader.read(randomAccessFile);
        int intDuration = (int)read.getTrackLength();
        double doubleDuration = (double)intDuration;
        return doubleDuration;
    }
}
