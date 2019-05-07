package cz.vondr.flash

class ParentsFlashDeleter {

    private void start() {
        File drive = new File("E:/")
        File directoryToDelete = new File(drive, "RECORDS")
        directoryToDelete.listFiles().each { it.delete() }
    }

    static void main(String[] args) {
        ParentsFlashDeleter app = new ParentsFlashDeleter();
        app.start();
    }
}
