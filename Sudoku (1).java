import java.util.Scanner;

public class Sudoku {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int end = 0;

        System.out.print("Enter Game Size: ");
        int newLength = scanner.nextInt();
        
        while (newLength%2==0){
            System.out.println("Enter an odd number please!");
            System.out.print("Enter Game Size: ");
            newLength = scanner.nextInt();
        }
        int length = newLength - 1;

        System.out.print("Enter starting row between 1 and "+newLength+": ");
        int newRow = scanner.nextInt();
        int row = newRow - 1;

        while (row>length || row<0){
            end++;
            if (end>3){
                System.out.println("Self destruct");
                System.exit(1);
            }
            else if (end==2){
                System.out.println("Are you having diffculty understanding?");
            }
            else if (end==1){
                System.out.println("Please read instructions carefully");
            }
            System.out.print("Enter starting row between 1 and "+newLength+": ");
            newRow = scanner.nextInt();
            row = newRow - 1;
        }
        end=0;
        

        System.out.print("Enter starting column : ");
        int newColumn = scanner.nextInt();
        int col = newColumn -1;
        
        while (col>length || col<0){
            end++;
            if (end>3){
                System.out.println("Self destruct");
                System.exit(1);
            }
            else if (end==2){
                System.out.println("Are you having diffculty understanding?");
            }
            else if (end==1){
                System.out.println("Please read instructions carefully");
            }
            System.out.print("Enter starting col between 1 and "+newLength+": ");
            newColumn = scanner.nextInt();
            col = newColumn -1;
        }
        

        System.out.print("Enter Starting Number: ");
        int num = scanner.nextInt();

        int sudoku[][];
        sudoku = new int[newLength][newLength];
        int total[];
        total = new int[newLength];
        int totalBottom[];
        totalBottom = new int[newLength];

        for(int x=0; x<newLength; x++){
            int a=row, b=col;
            for(int y=0; y<newLength; y++){
                sudoku[a][b] = num;
                total[a] += sudoku[a][b];
                totalBottom[b] += sudoku[a][b];
                a--;
                b--;
                num++;
                if (a<0)
                    a=length;
                if (b<0)
                    b=length;
                
            }
            row++;
            col--;

            if (row>length)
                row=0;
            if (col<0)
                col=length;
        }

        for (int v=0; v<newLength; v++){
            System.out.print("\n");
            for (int h=0; h<newLength; h++){
                System.out.print(sudoku[v][h]+" ");
            }
            System.out.print("\t"+total[v]);
        }
        System.out.println("\n");
        for (int t=0; t<newLength; t++){
            System.out.print(totalBottom[t]+" ");
        }
        System.out.println("\n \n");

        scanner.close();

    }
}