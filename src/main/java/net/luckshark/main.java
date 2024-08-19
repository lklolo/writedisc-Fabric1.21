package net.luckshark;

import net.luckshark.gentools.*;
import net.luckshark.tool.DirectoryCleaner;
import net.luckshark.tool.FileCleaner;
import net.luckshark.tool.OggDuration;
import org.jaudiotagger.audio.exceptions.CannotReadException;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws CannotReadException, IOException {
        // 指定模板文件目录
        String directoryPath = "F:/IDEA/Adisc/writejsons/template";
        // 指定文件扩展名
        String extension = ".ogg";
        // 指定各内容输出目录或文件
        String jukebox_songPath = "F:/IDEA/Adisc/writejsons/gen/jukebox_song";
        String modelsPath = "F:/IDEA/Adisc/writejsons/gen/models";
        String fabricItemGroupsPath = "F:/IDEA/Adisc/writejsons/gen/fabricitemgroups.txt";
        String groupsPath = "F:/IDEA/Adisc/writejsons/gen/groups.txt";
        String itemsPath = "F:/IDEA/Adisc/writejsons/gen/items.txt";
        String jukeboxsongsPath1 = "F:/IDEA/Adisc/writejsons/gen/jukeboxsongs1.txt";
        String jukeboxsongsPath2 = "F:/IDEA/Adisc/writejsons/gen/jukeboxsongs2.txt";
        String langPath = "F:/IDEA/Adisc/writejsons/gen/lang.txt";
        String soundsEventsPath = "F:/IDEA/Adisc/writejsons/gen/soundevents.txt";
        String soundsPath = "F:/IDEA/Adisc/writejsons/gen/sounds.json";
        String tagsPath = "F:/IDEA/Adisc/writejsons/gen/tags.txt";

        System.out.println("--------------------");

        //运行前清理文件或目录
        DirectoryCleaner.directoryCleaner(jukebox_songPath);
        DirectoryCleaner.directoryCleaner(modelsPath);
        FileCleaner.fileCleaner(fabricItemGroupsPath);
        FileCleaner.fileCleaner(groupsPath);
        FileCleaner.fileCleaner(itemsPath);
        FileCleaner.fileCleaner(jukeboxsongsPath1);
        FileCleaner.fileCleaner(jukeboxsongsPath2);
        FileCleaner.fileCleaner(langPath);
        FileCleaner.fileCleaner(soundsEventsPath);
        FileCleaner.fileCleaner(soundsPath);
        FileCleaner.fileCleaner(tagsPath);

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            FilenameFilter filter = (dir, name) -> name.toLowerCase().endsWith(extension.toLowerCase());
            File[] files = directory.listFiles(filter);
            System.out.println("--------------------");
            if (files != null && files.length > 0) {
                for (File file : files) {

                    String fullFileName = file.getName();
                    String fileName = fullFileName.substring(0, fullFileName.lastIndexOf('.'));
                    String upperCaseFileName = fileName.toUpperCase();
                    double duration = OggDuration.oggDuration(file.getAbsolutePath());

                    System.out.println("File: " + file.getAbsolutePath());
                    System.out.println("Name: " + fileName);
                    System.out.println("UpperCaseName: " + upperCaseFileName);
                    System.out.println("Duration: " + duration);

                    System.out.println("Generate fabricitemgroups");
                    GenFabricItemGroup.gen(fileName, upperCaseFileName, fabricItemGroupsPath);

                    System.out.print("Generate jukebox_song: ");
                    GenJukebox_song.gen(fileName, duration, jukebox_songPath);

                    System.out.print("Generate models: ");
                    GenModels.gen(fileName, modelsPath);

                    System.out.print("Generate groups: ");
                    GenGroups.gen(fileName, upperCaseFileName, groupsPath);

                    System.out.print("Generate items: ");
                    GenItems.gen(fileName, upperCaseFileName, itemsPath);

                    System.out.print("Generate jukeboxsongs1: ");
                    GenJukeboxsongs1.gen(fileName, upperCaseFileName, duration, jukeboxsongsPath1);

                    System.out.print("Generate jukeboxsongs2: ");
                    GenJukeboxsongs2.gen(fileName, upperCaseFileName, duration, jukeboxsongsPath2);

                    System.out.print("Generate lang: ");
                    GenLang.gen(fileName, upperCaseFileName, langPath);

                    System.out.print("Generate soundevents: ");
                    GenSoundEvents.gen(fileName, upperCaseFileName, soundsEventsPath);

                    System.out.print("Generate sounds: ");
                    GenSounds.gen(fileName, soundsPath);

                    System.out.print("Generate tags: ");
                    GenTags.gen(fileName, upperCaseFileName, tagsPath);

                    System.out.println("--------------------");
                }
                System.out.println("All files processed.");
                System.out.println("--------------------");
            } else {
                System.out.println("No files with the specified extension were found.");
            }
        } else {
            System.out.println("The specified path is not a directory or does not exist.");
        }
    }
}
