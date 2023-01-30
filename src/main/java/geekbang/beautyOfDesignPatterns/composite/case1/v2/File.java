package geekbang.beautyOfDesignPatterns.composite.case1.v2;

/**
 * @Author lnd
 * @Description
 * @Date 2023/1/31 0:02
 */
public class File extends FileSystemNode {

    public File(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        return 1;
    }

    @Override
    public long countSizeOfFiles() {
        java.io.File file = new java.io.File(path);
        if (!file.exists()) return 0;
        return file.length();
    }
}
