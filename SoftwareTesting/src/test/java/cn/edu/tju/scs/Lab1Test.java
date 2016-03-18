package cn.edu.tju.scs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
@RunWith(Parameterized.class)
public class Lab1Test {
    int expected = 0;
    int input1 = 0;
    int input2 = 0;
    int input3 = 0;


    /**
     * 判断是否为三角形，
     * 若是，是否是等腰或者等边
     * @return   -1 :不是； 0：普通三角形；1 等腰三角形；2：等边三角形
     */

    @Parameterized.Parameters
    public static Collection<Object[]> t(){
        return Arrays.asList(new Object[][]{
                {-1,0,0,0},
                {-1,1,3,4},
                {1,3,3,2},
                {2,3,3,3},
                {0,4,5,3},
                {-1,3,0,-4},
                {0,5,7,3},
                {1,3,5,5}
        });
    }
    public Lab1Test(int expected,int input1,int input2,int input3){
        this.expected = expected;
        this.input1 = input1;
        this.input2 = input2;
        this.input3 = input3;
    }

    @Before
    public void before(){
        System.out.println("测试开始 - - - - - - - - - - - - - - - - - - - - - - - ");
    }

    @Test
    public void testJudgeTri(){
        assertEquals(expected,Lab1.judgeTri(input1,input2,input3));
    }

    @After
    public void afeter(){
        System.out.println("测试结束 - - - - - - - - - - - - - - - - - - - - - - - \n\n");
    }



}
