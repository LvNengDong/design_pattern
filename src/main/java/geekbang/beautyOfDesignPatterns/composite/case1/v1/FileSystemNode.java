package geekbang.beautyOfDesignPatterns.composite.case1.v1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author lnd
 * @Description
 * @Date 2023/1/30 23:43
 */
public class FileSystemNode {

    private String path;
    private boolean isFile;
    //仅对目录有意义，表示目录的子节点
    private List<FileSystemNode> subNodes = new ArrayList<>();

    public FileSystemNode(String path, boolean isFile) {
        this.path = path;
        this.isFile = isFile;
    }

    public int countNumOfFiles() {
        //处理文件
        if (isFile) {
            return 1;
        }
        //处理目录
        int numOfFiles = 0;
        for (FileSystemNode fileOrDir : subNodes) {
            numOfFiles += fileOrDir.countNumOfFiles();
        }
        return numOfFiles;
    }

    public long countSizeOfFiles() {
        //处理文件
        if (isFile) {
            File file = new File(path);
            if (!file.exists()) return 0;
            return file.length();
        }
        //处理目录
        long sizeofFiles = 0;
        for (FileSystemNode fileOrDir : subNodes) {
            sizeofFiles += fileOrDir.countSizeOfFiles();
        }
        return sizeofFiles;
    }

    public String getPath() {
        return path;
    }

    /**
     * 添加子节点不区分文件或目录
     */
    public void addSubNode(FileSystemNode fileOrDir) {
        subNodes.add(fileOrDir);
    }

    /**删除指定节点(文件/目录)*/
    public void removeSubNode(FileSystemNode fileOrDir) {
        int size = subNodes.size();
        int i = 0; //这里把i初始化的过程提到循环外面是为了增加i的作用范围，让后面的if判断可以使用i
        for (; i < size; ++i) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.getPath())) {
                break;
            }
        }
        if (i < size) {
            subNodes.remove(i);
        }
    }
}
