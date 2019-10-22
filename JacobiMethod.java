
package JacobiAlgorithm;


public class JacobiMethod {
public static void main(String[] args) {
        double[][] equation = {
                        {19, 3, 2, 9},
                        {3, 15, 1, 11},
                        {1, 2, -3, 10}};
        solve(equation);
        
    }
    
    static void solve(double[][] equation){
        double[] init={1,8,0};
        double eps=0.1;
        int size = equation.length;
        double[] prevX = new double[size];
        prevX=init.clone();
        double[] X = new double[size];
        X=init.clone();
        
        int iterations = 0;
        double prevErr=0f,err=0f;
        
        while (true) {            
            iterations++;
            System.out.print(iterations+"\t");
            for (int i = 0; i < size; i++) {
                double variableValue = equation[i][size];
                
                for (int j = 0; j < size; j++) {
                    if(i!=j){
                        variableValue-=equation[i][j]*prevX[j];
                    }
                }
                X[i]=(1/equation[i][i])*variableValue;
                System.out.printf(" %15.4f ",X[i]);
            }    
            System.out.println("");
            System.out.printf("Err => ");;
            
            err=checkErr(prevX, X, eps);
            
            System.out.println("\n");
            
           if(Math.abs(err)<eps) break;
            
            prevErr=err;
            prevX=X.clone();
        }
       
        System.out.println("Iterations = "+iterations);
        System.out.println("Epsilon = "+eps);
        System.out.printf("relative approximate error = %5.4f\n",Math.abs(err));
        for (int i = 0; i < X.length; i++) {
            System.out.printf("X_%d: %5.4f\n",i,X[i]);
        }
    }
    
    static double checkErr(double[] prevX,double[] X,double eps){
        //Math.abs((xNew-xOld)/xNew
        double maxErr = 0f;
        double err = 0f;
        for(int i=0 ; i < prevX.length ; i++){
            err=Math.abs((X[i]-prevX[i])/X[i])*100;
            System.out.printf("%16.4fP",err);
            if(err>maxErr){
                maxErr = err;
            }
        }

        return maxErr;
    }

}
