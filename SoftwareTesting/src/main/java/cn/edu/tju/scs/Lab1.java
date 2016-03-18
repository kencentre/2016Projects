package cn.edu.tju.scs;

/**
 * Hello world!
 *
 */
public class Lab1
{

    /**
     * 判断是否为三角形，
     * 若是，是否是等腰或者等边
     * @param a
     * @param b
     * @param c
     * @return   -1 :不是； 0：普通三角形；1 等腰三角形；2：等边三角形
     */
    public static int judgeTri(int a,int b,int c){
        System.out.println("参数： " + a + " " + b + " " + c);
        int result = -1;
        if(a <=0 || b <= 0 || c<= 0){
            System.out.println("return -1 --------------: 不是三角形");
            return result;
        }
        if(a + b > c && a + c > b && b + c > a){
            result = 0;
            if(a == b  && a == c){
                System.out.println("return 2 --------------: 等边三角形");
                result = 2;
            }else if(a ==b || a == c || b== c){
                System.out.println("return 1 --------------: 等腰三角形");
                result = 1;
            }else {
                System.out.println("return 0 --------------: 普通三角形");
            }
        }else{
            System.out.println("return -1 --------------: 不是三角形");
        }
        return result;
    }
}
