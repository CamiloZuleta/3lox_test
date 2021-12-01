
public class Point9 {
    private int[] vector = new int[100];
    private double max = 100000;

    public Point9(){
        setUpArray();
        sortArray();
        printArray();
    }

    public void setUpArray(){
        for(int i=0; i<vector.length; i++){
            vector[i] = (int) Math.round(Math.random()*(max));
        }
    }

    public void sortArray(){
        int aux;
        for(int i=0; i<vector.length; i++){
            for(int j=0; j<vector.length; j++){
                if(vector[i]<vector[j]){
                    aux = vector[i];
                    vector[i] = vector[j];
                    vector[j] = aux;
                }
            }
        }
    }

    public void printArray(){
        for (int i=0; i<vector.length; i++){
            System.out.println(vector[i]);
        }
    }

    public static void main(String[] args){
        Point9 test = new Point9();
    }
}
