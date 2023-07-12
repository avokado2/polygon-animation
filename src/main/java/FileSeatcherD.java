import java.io.File;

public class FileSeatcherD implements   FileSearcherI{


    private final FileSearcherI delegate;
    public FileSeatcherD(FileSearcherI fileSearcher) {

        this.delegate =  fileSearcher;
    }
    @Override
    public String searchFile(File directory) {
        System.out.println("Current directory:" + directory.getAbsolutePath());
        return delegate.searchFile(directory);
    }
}
