package algorithm.FiboSeries;


//题目介绍：小明的腿长，可以每次上1阶台阶或者2阶台阶，现在小明需要走n阶台阶才能到达目标位置。请问有几种到达目标位置的方案？
//eg：n=1, result=1；n=2, result=2； n=3, result=3; n=4, result=5; n=5,result=8...  result= f(n+1)  f即斐波那契额数列
public class ComputeSolution {

    public static void main(String[] args) {

        System.out.println(getCountSolutions(4));  //为什么底层和斐波那契数列有关系呢？

    }

    public static int getCountSolutions(int n){

        if(n == 0) return 0;

        return fib(n+1);

    }

    /**
     * 求第m位，斐波那契数列的数值
     * @param m
     * @return
     */
    public static int fib(int m){

        if (m == 1) return 1;
        else if (m == 2) return 1;

        return fib(m-2)+fib(m-1);
    }

}
