package sample.Common;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by TeTorro on 26.03.2017.
 */
public abstract class Algorithm<T> {

    protected File inputFile;
    protected File outputFile;


    protected String bitRepresentationInput;
    protected String dnaRepresentationOutput;

    public Algorithm(File inputFile) {
        this.inputFile = inputFile;
        this.bitRepresentationInput = fileToByteArray();
    }

    public Algorithm(){}

    public void saveFile(){

    }

    public void setInputFile(File file){

    };

    public String getOutput() {
        return dnaRepresentationOutput;
    }

    public String getRepresentation() {
        return bitRepresentationInput;
    }

    public abstract void convert();

    @Override
    public abstract String toString();

    protected String fileToByteArray() {
        byte[] bytesArray = new byte[(int) inputFile.length()];

        try {
            FileInputStream fis = new FileInputStream(inputFile);
            fis.read(bytesArray);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return byteArrayToString(bytesArray);
    }

    private String byteArrayToString(byte[] bytesArray){
        StringBuilder builder = new StringBuilder();
        for (byte b : bytesArray) {
            builder.append(byteToBit(b));
        }
        return builder.toString();
    }

    private String byteToBit(byte b){
        String result = "";
        for(int i = 0; i < 8; i++)
            result += (b & (1 << i)) == 0 ? "0" : "1";
        return result;
    }

}
