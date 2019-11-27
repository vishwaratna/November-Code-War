import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CandidateCode {
    public static void main(String[] args) {
        List<Integer> landList = new ArrayList<Integer>();
        List<Integer> usedList = new ArrayList<Integer>();
        List<Integer> sumOfLandOfSons = new ArrayList<Integer>();
        List<Integer> usedListIndex = new ArrayList<Integer>();


        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String [] inputSeperated = input.split(" ");
        int totalPlotArea = Integer.valueOf(inputSeperated[0]);
        int numberOfSons = Integer.valueOf(inputSeperated[1]);
        landList=  IntStream.range(0, totalPlotArea).boxed().collect(Collectors.toList());
        //System.out.println(landList);
        for(int i=0;i<numberOfSons;i++) {
            String sonChoice = sc.nextLine();
            String[] splitedChoices = sonChoice.split(" ");

            if(Integer.valueOf(splitedChoices[0]).equals(Integer.valueOf(splitedChoices[1]))) {
                //	sumOfLandOfSons.add(Integer.valueOf(splitedChoices[0]));
                usedList.add(Integer.valueOf(splitedChoices[0]));
                System.out.println("UsedList: "+usedList);
                //minimum taking
                for(int index=0;index<usedList.size();index++) {
                    if(landList.contains(usedList.get(index))&& index !=0) {
                        for(int j =index;j<usedList.size();j++) {
                            if(!usedList.contains(landList.get(j-1))) {
                                sumOfLandOfSons.add(Integer.valueOf(splitedChoices[0])+landList.get(j-1));
                                usedList.add(landList.get(j-1));

                            }
                            else {
                                continue;
                            }
                        }

                    }
                }


            }
            else {
                sumOfLandOfSons.add(Integer.valueOf(splitedChoices[0])+Integer.valueOf(splitedChoices[1]));
                usedList.add(Integer.valueOf(splitedChoices[0]));
                usedList.add(Integer.valueOf(splitedChoices[1]));
                System.out.println("UsedList: "+usedList);
            }

        }
        usedList.forEach(s->{
            usedListIndex.add(s);
        });

        System.out.println(sumOfLandOfSons);
        System.out.println(usedList);
        System.out.println(usedListIndex);
        System.out.println(landList);

    }



}
