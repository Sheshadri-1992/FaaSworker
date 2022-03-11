package miscellaneous;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import thriftservices.ImageBinary;
import thriftservices.Location;

public class TestFolderFileListing {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(TestFolderFileListing.class);
	
	public String writeFileToWorker(String directoryName, List<ImageBinary> imageBinaryList, Location workerLocation) {
		File directory = new File(directoryName);
		if (!directory.exists()) {
			directory.mkdirs();
			// If you require it to make the entire directory path including parents,
			// use directory.mkdirs(); here instead.
		}
		int index=0;
		for(ImageBinary imgBin : imageBinaryList) {
			String imageFileName = directoryName + "img_"+index+".jpg";
			System.out.println(imageFileName);
			try {
				FileUtils.writeByteArrayToFile(new File(imageFileName), imgBin.getImageFile());				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			index = index + 1;
			
		}				
		/** Write the file locally **/

		return "Written Successfully";
	}
	
	public String readFileFromWorker(String directoryName, Location workerLocation) {

		if(directoryName.charAt(directoryName.length()-1) != '/') {
			directoryName = directoryName + "/";
		}
		LOGGER.info(directoryName);
		
		ArrayList<String> imageFileNameList = new ArrayList<String>();
		File folder = new File(directoryName);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File " + listOfFiles[i].getName());
				imageFileNameList.add(directoryName+listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());			 	
				
			}
		}
		System.out.println(imageFileNameList);

		List<ImageBinary> imageBinaryList = new ArrayList<ImageBinary>();
		
		for(String imageFile : imageFileNameList) {
			Path path = Paths.get(imageFile);

			byte[] payloadByteArray = null;
			try {
				payloadByteArray = Files.readAllBytes(path);
				ImageBinary  myBinImage = new ImageBinary();
				myBinImage.setImageFile(payloadByteArray);
				myBinImage.setFileLength(payloadByteArray.length);
				imageBinaryList.add(myBinImage);
				LOGGER.info("The length of the payload is " + payloadByteArray.length);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		writeFileToWorker(directoryName, imageBinaryList, null);
		
		return "Sent all files to Worker";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> imageFilename = new ArrayList<String>();
		String dirName = "/home/swamiji/phd/csl/serverless_computing/project_full_paper/i3_i7/image_converter_and_gif_conv/3_imgs/";
//		File folder = new File(dirName);
//		File[] listOfFiles = folder.listFiles();
//		for (int i = 0; i < listOfFiles.length; i++) {
//			if (listOfFiles[i].isFile()) {
//				System.out.println("File " + listOfFiles[i].getName());
//				imageFilename.add(dirName+listOfFiles[i].getName());
//			} else if (listOfFiles[i].isDirectory()) {
//				System.out.println("Directory " + listOfFiles[i].getName());
//			}
//		}
//		
//		for(String filename : imageFilename) {
//			System.out.println(filename);
//		}
		
		TestFolderFileListing obj = new TestFolderFileListing();
		obj.readFileFromWorker(dirName, null);
	}

}
