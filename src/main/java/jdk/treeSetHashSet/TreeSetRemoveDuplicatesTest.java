package jdk.treeSetHashSet;

import java.util.*;

public class TreeSetRemoveDuplicatesTest {

    public static void main(String[] args) {
        TerminalUserVo vo11 = new TerminalUserVo(1L, "小明1","111");
        TerminalUserVo vo12 = new TerminalUserVo(1L, "小明1","111");
        TerminalUserVo vo13 = new TerminalUserVo(1L, "小明1","111");
        TerminalUserVo vo2 = new TerminalUserVo(2L, "小明2","222");
        TerminalUserVo vo3 = new TerminalUserVo(3L, "小明3","333");

        List<TerminalUserVo> list = Arrays.asList(vo11, vo12, vo13, vo2, vo3);

        list = removeDuplicteUsers(list);

        for (TerminalUserVo temp : list){
            System.out.println(temp.toString());
        }


    }



    /**
     * 将列表中重复的用户移除，重复指的是userid相同
     * @param userList
     * @return
     */
    public static ArrayList<TerminalUserVo> removeDuplicteUsers(List<TerminalUserVo> userList){
        Set<TerminalUserVo> s= new TreeSet<>(new Comparator<TerminalUserVo>(){

            @Override
            public int compare(TerminalUserVo o1, TerminalUserVo o2) {
                return o1.getUserId().compareTo(o2.getUserId());
            }

        });

        s.addAll(userList);
        return new ArrayList<>(s);
    }

}
