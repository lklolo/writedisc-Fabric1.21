package net.luckshark.tool;

public class Cleaner {
    public static void clean(String jukebox_songPath, String modelsPath, String fabricItemGroupsPath, String groupsPath, String itemsPath, String jukeboxsongsPath1, String jukeboxsongsPath2, String langPath, String soundsEventsPath, String soundsPath, String tagsPath){
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
    }

    public static void main(String[] args) {
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
    }
}
