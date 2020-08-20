import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class SelectionSort {

    public static long tempoExecucao;
    public static int comparisons = 0;
    public static int moves = 0;

    public static int[] selection(int[] array, int n){
        for ( int i=0; i < n-1; i++ ){
    
            int min = i;
            for ( int j=(i+1); j < n; j++ ){
                if ( array[min] > array[j]){
                    min = j;
                } 
                comparisons++;
            }
    
            int temp = array[min];
            array[min] = array[i];
            moves++;
            array[i] = temp;
            moves++;
        }
    
    
        return array;
    }

    public static void main(String[] args) throws Exception{
        int[] array = new int[]{5, 4, 6, 3, 2, 1, 8, 0, 9, 7};
        long initialTime = System.nanoTime();
        array = selection(array, array.length);
        long finalTime = System.nanoTime();
        long executionTime = finalTime - initialTime;

        for(int i : array){
            System.out.println(i);
        }
        createLog(executionTime);
    }

    public static void createLog(long executionTime) throws IOException {
        FileWriter fw = new FileWriter(new File("selection_sort.txt"));
        fw.write("Comparisons: " + comparisons + "\n" + "Moves: " + moves + "\n" + "Time: " + executionTime);
        fw.close();
    }
}