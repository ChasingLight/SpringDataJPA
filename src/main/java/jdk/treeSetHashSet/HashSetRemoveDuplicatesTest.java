package jdk.treeSetHashSet;

import java.util.*;

public class HashSetRemoveDuplicatesTest {

    public static void main(String[] args) {
        TerminalUserVo vo11 = new TerminalUserVo(1L, "小明1","111");
        TerminalUserVo vo12 = new TerminalUserVo(1L, "小明1","111");
        TerminalUserVo vo13 = new TerminalUserVo(1L, "小明1","111");
        TerminalUserVo vo2 = new TerminalUserVo(2L, "小明2","222");
        TerminalUserVo vo3 = new TerminalUserVo(2L, "小明3","333");

        List<TerminalUserVo> list = Arrays.asList(vo11, vo12, vo13, vo2, vo3);

        Set<TerminalUserVo> hashSet = new HashSet<>();
        hashSet.addAll(list);

        list = new ArrayList<>(hashSet);


        for (TerminalUserVo temp : list){
            System.out.println(temp.toString());
        }


    }//emd main

}
