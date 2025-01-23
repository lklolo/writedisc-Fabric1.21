package net.luckshark;

import net.luckshark.gentools.*;
import net.luckshark.tool.Cleaner;
import net.luckshark.tool.OggDuration;
import org.jaudiotagger.audio.exceptions.CannotReadException;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws CannotReadException, IOException {

        //软件包“gentools”是数据生成工具，里面填写了默认内容，请按需更改。（随意更改可能导致变量名、namespace、identifier无法对应）
        //软件包”tool“是工具类包，请忽视它
        //使用前请清楚地知道生成的数据该放到哪里
        //所有在.txt文件中生成的内容都是代码
        //某些在.txt文件中生成的内容（例如“lang.txt”、“tags.txt”），为数据生成器的代码，应填入Fabric的提供的数据生成器中再次生成
        //使用时请将要读取的文件放入下方设置的模板文件目录，程序会自动遍历读取文件名

        // 模板文件目录
        String directoryPath = "F:/IDEA/Adisc/writejsons/template";
        // 指定文件扩展名
        String extension = ".ogg";
        // 指定各数据生成工具内容输出目录或文件
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

        Cleaner.clean(jukebox_songPath, modelsPath, fabricItemGroupsPath, groupsPath, itemsPath, jukeboxsongsPath1, jukeboxsongsPath2, langPath, soundsEventsPath, soundsPath, tagsPath);

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
