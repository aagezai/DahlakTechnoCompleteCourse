public class Exam {
    public void createPyramid(){
        for (int i=1; i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }

    }
    private int areaOfRectangle(int length, int breadth) {
        return length * breadth;
    }
    private int parameterOfRectangle(int length, int breadth) {
        return 2*length*breadth;
    }
    private void question3(int[] array) {
        System.out.println("question 3(a) --> length of array");
        System.out.println(" length of given array is "+ array.length);
        System.out.println("question 3(b) print first 5 elements of given array \n");
        int j=0;
        while (j<5){
            System.out.print(array[j] + " ");
            j++;
        }
        System.out.println("\nquestion 3(c) print elements of given array except the 3rd \n");
        int k=0;
        while (k<array.length){
            if(k!=2){
                System.out.print(array[k] + " ");
            }
            k++;
        }

    }

    public static void main(String args[]){
        System.out.println("-------question 1 draw pyramid like sample given-------");
        Exam examObject = new Exam();
        examObject.createPyramid();

        System.out.println("-------question 2 (a) calculate area of a rectangle -------");
        int length = 4;
        int breadth = 5;
        int area = examObject.areaOfRectangle(length,breadth);
        System.out.println("area of rectangle length =" + length + " and breadth = "+breadth +" = " + area);

        System.out.println("-------question 2 (b) calculate parameter of a rectangle -------");
        int parameter = examObject.parameterOfRectangle(length,breadth);
        System.out.println("parameter of rectangle length =" + length + " and breadth = "+breadth +" = " + parameter);

        System.out.println("-------question 3  -------");
        int[] array = {23,12,18,7,19,78,45,76};
        examObject.question3(array);


    }



}
