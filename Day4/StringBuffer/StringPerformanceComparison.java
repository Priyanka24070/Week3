import java.util.*;

public class StringPerformanceComparison{
    public static void main(String[] args){
        long iterations=1000000;
        String text="Hello";

        StringBuffer stringbuffer=new StringBuffer();
        long startTimeBuffer=System.nanoTime();//using nanoTime() to measure total time of operation

        for(int i=0;i<iterations;i++){
            stringbuffer.append(text);
        }

        long endTimeBuffer=System.nanoTime();
        long bufferTime=endTimeBuffer-startTimeBuffer;//calculate total time taken by StringBuffer

        StringBuilder stringbuilder=new StringBuilder();
        long startTimeBuilder=System.nanoTime();

        for(int i=0;i<iterations;i++){
            stringbuilder.append(text);
        }
       
        long endTimeBuilder=System.nanoTime();
        long builderTime=endTimeBuilder-startTimeBuilder;//calculate total time taken by StringBuilder

        System.out.println("Time taken by StringBuffer: " + bufferTime / 1000000.0 + " ms");
        System.out.println("Time taken by StringBuilder: " + builderTime / 1000000.0 + " ms");

        if (bufferTime > builderTime) {
            System.out.println("StringBuilder is faster.");
        } else {
            System.out.println("StringBuffer is faster.");
        }


    }
}