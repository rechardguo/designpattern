package rechard.learn.designpattern.composite;

public class CompositeDemo {


    public static void main(String[] args) {
        Entry entry=EntryFactory.create("c:/;c:/a/b/c.zip");
        if(entry!=null) {
            entry.readClass();
        }
    }

    public static interface Entry{
        public byte[] readClass();
    }

    public static class DirEntry implements Entry{
        private String dirPath;

        public DirEntry(String dirPath) {
            this.dirPath = dirPath;
        }

        @Override
        public byte[] readClass() {
            System.out.println("Dir模式里找到某个class");
            return new byte[0];
        }
    }

    //这个是组合模式的应用
    /**
     * 重点观察这个复合模式是由各个子Entry组合而成的
     */
    public static class CompositeEntry implements Entry{
        private Entry[] entries;
        public CompositeEntry(String path){
            String[] paths=path.split(";");
            entries=new Entry[paths.length];
            for(int i=0;i<paths.length;i++){
                entries[i]=EntryFactory.create(paths[i]);
            }
        }
        @Override
        public byte[] readClass() {
           for (Entry entry:entries){
               entry.readClass();
           }
            return new byte[0];
        }
    }

    public static class ZipEntry implements Entry{

        private String zipPath;

        public ZipEntry(String zipPath) {
            this.zipPath = zipPath;
        }

        @Override
        public byte[] readClass() {
            System.out.println("zip模式里找到某个class");
            return new byte[0];
        }
    }

    public static class EntryFactory{
        public static Entry create(String path){
            if(path.contains(";")){
                return new CompositeEntry(path);
            }else if(path.endsWith(".zip")){
                return new ZipEntry(path);
            }else if(path.endsWith("/")){
                return new DirEntry(path);
            }else {
                return null;
            }
        }
    }

}
