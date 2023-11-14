package lecture.lecture6;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Settings {


    private static Settings instance;

    private final String repoType;

    private final String repoFile;

    private Settings(String repoType, String repoFile) {
        this.repoType = repoType;
        this.repoFile = repoFile;
    }

    public String getRepoFile() {
        return repoFile;
    }

    public String getRepoType() {
        return repoType;
    }

    private static Properties loadSettings() {
        try (FileReader fr = new FileReader("settings.properties")) {
            Properties settings = new Properties();
            settings.load(fr);
            return settings;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized Settings getInstance() {
        Properties properties = loadSettings();
        // TODO De vazut ce se intampla daca setarea nu e in fisier
        instance = new Settings(properties.getProperty("repo_type"), properties.getProperty("repo_file"));
        return instance;
    }


}
