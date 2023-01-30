package geekbang.beautyOfDesignPatterns.composite.case1.v2;

/**
 * @Author lnd
 * @Description
 * @Date 2023/1/31 0:01
 */
public abstract class FileSystemNode {

    protected String path;

    public FileSystemNode(String path) {
        this.path = path;
    }

    public abstract int countNumOfFiles();

    public abstract long countSizeOfFiles();

    public String getPath() {
        return path;
    }
}