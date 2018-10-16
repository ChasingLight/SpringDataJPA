public class ScaleTransfer {

    public static void main(String[] args) {

        String input = "-027555+692-0xD32C";  //第一位是负数怎么办？

        if (input.startsWith("-")){
            input = "0x0000" + input;
        }

        int result = 0;

        String[] firstSplit = input.split("\\-");

        for (String temp : firstSplit)
            System.out.println(temp);

        String[] secondSplit = null;

        //第一位
        if (firstSplit[0].contains("+")){
            secondSplit = firstSplit[0].split("\\+");
            for (String temp : secondSplit){
                result += tranferToTen(temp);
            }
        }else{
            result += tranferToTen(firstSplit[0]);
        }


        for(int i = 1; i < firstSplit.length; i++){

            int currSum = 0;
            if (firstSplit[i].contains("+")){
                secondSplit = firstSplit[i].split("\\+");
                for (String temp : secondSplit){
                    currSum += tranferToTen(temp);
                }
                result -= currSum;
            }else{
                result -= tranferToTen(firstSplit[i]);
            }
        }


        System.out.println(result);


    }

    //+、-、0、0x、其他

     public static int tranferToTen(String num){
        if (num.startsWith("0x")){
            return Integer.parseInt(num.substring(2), 16);
        }else if(num.startsWith("0")){
            return Integer.parseInt(num.substring(1), 8);
        }else{
            return Integer.parseInt(num);
        }
     }//end method
}
