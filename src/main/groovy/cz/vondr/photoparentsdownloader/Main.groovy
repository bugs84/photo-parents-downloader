package cz.vondr.photoparentsdownloader

import java.awt.Desktop
import java.text.SimpleDateFormat

class Main {

    String PC_PHOTO_DIR = "d:/tmp/deleteTryingPhotos"
    String CAMERA_PHOTO_DIR = "d:/tmp"


    void start() {
        File pcPhotoFolder = createPcPhotoFolder()

        openExplorerWithPcPhotoFolder(pcPhotoFolder)
    }


    private File createPcPhotoFolder() {
        String pcPhotoFolderName = new SimpleDateFormat("yyyy_MM_dd").format(new Date())
        File pcPhotoFolder = new File(PC_PHOTO_DIR, pcPhotoFolderName)
        pcPhotoFolder.mkdirs()
        pcPhotoFolder
    }

    private openExplorerWithPcPhotoFolder(File pcPhotoFolder) {
        Desktop.desktop.open(pcPhotoFolder)
    }

    static void main(String[] args) {
        new Main().start()
    }
}
