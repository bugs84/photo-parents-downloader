package cz.vondr.photoparentsdownloader

import java.awt.Desktop
import java.text.SimpleDateFormat
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.FileAlreadyExistsException
import static groovy.io.FileType.FILES


class Main {

    String PC_PHOTO_DIR = "c:/foto"
    String CAMERA_PHOTO_DIR = "e:/DCIM"
	
	File pcPhotoFolder


    void start() {
	
	
        pcPhotoFolder = createPcPhotoFolder()
		
		copyAllFiles()
		
		println "VŠE ÚSPĚŠNĚ ZKOPÍROVÁNO"
    }

	

    private File createPcPhotoFolder() {     
        String pcPhotoFolderName = "foto_" + new SimpleDateFormat("yyyy_MM_dd").format(new Date())
        File pcPhotoFolder = new File(PC_PHOTO_DIR, pcPhotoFolderName)
        pcPhotoFolder.mkdirs()
		println "Vytvořena složka: '$pcPhotoFolder'"
        pcPhotoFolder
    }
	
	private void copyAllFiles() {     
	    File cameraDir = new File(CAMERA_PHOTO_DIR)
	    cameraDir.eachFileRecurse(FILES) {
           println "Kopiruji soubor '$it'"
		   try {
		       Files.copy(it.toPath(),  Paths.get(pcPhotoFolder.absolutePath, it.name))
		   } catch(FileAlreadyExistsException ex) {
		       println "Soubor byl preskočen - již existuje. '$it'"
		   }	   
        }
	}

    private openExplorerWithPcPhotoFolder(File pcPhotoFolder) {
        Desktop.desktop.open(pcPhotoFolder)
    }

    static void main(String[] args) {
        new Main().start()
    }
}
