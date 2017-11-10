package binarysailor.shapeshower;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class FileOutput implements AutoCloseable {

    private OutputStream outputStream;

    FileOutput() throws IOException {
        File f = new File(generateFilePath());
        outputStream = new FileOutputStream(f);
    }

    private String generateFilePath() {
        DateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String fileName = String.format("geometric-art-%s.png", df.format(new Date()));
        String directory = System.getProperty("user.home");
        if (directory == null) {
            directory = ".";
        }

        File subdirectory = new File(directory + File.separatorChar + "geometric-art");
        if (!subdirectory.exists()) {
            subdirectory.mkdirs();
        }
        return subdirectory.getPath() + File.separatorChar + fileName;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    @Override
    public void close() throws IOException {
        outputStream.close();
    }
}
