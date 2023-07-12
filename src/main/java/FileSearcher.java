import java.io.File;

public class FileSearcher implements FileSearcherI{

    private String path;
    private String fileName;
    protected FileSearcher(){

    }
    public FileSearcher(String path, String fileName) {
        this.path = path;
        this.fileName = fileName;
    }

    public String find() {
        return searchFile(new File(path));
    }

    public String searchFile(File directory) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        String result = searchFile(file);
                        if (result != null) {
                            return result;
                        }
                    } else if (file.getName().equals(fileName)) {
                        return file.getAbsolutePath();
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        FileSearcher fileSearcher = new FileSearcher("C:\\", "еуыезкщпкф0ььу.txt");
        String filePath = fileSearcher.find();
        if (filePath != null) {
            System.out.println("File found at: " + filePath);
        } else {
            System.out.println("File not found.");
        }
    }
}