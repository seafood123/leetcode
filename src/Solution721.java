import java.util.*;
import java.util.stream.Collectors;

class Solution721 {
    // union find 문제네;;; 그냥 풀어본 방법... 내일 유니온파인드 해봐야지..
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Set<String>>> map = new HashMap<>();
        for (List<String> account : accounts) {
            List<Set<String>> list = map.getOrDefault(account.get(0), new ArrayList<>());
            map.put(account.get(0), makeAccountList(list, account));
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<Set<String>>> entry : map.entrySet()) {
            for (Set<String> set : entry.getValue()) {
                List<String> item = new ArrayList<>();
                item.add(entry.getKey());
                item.addAll(set.stream().sorted().collect(Collectors.toList()));
                result.add(item);
            }
        }
        return result;
    }

    private List<Set<String>> makeAccountList(List<Set<String>> list, List<String> accounts) {
        List<String> account = new ArrayList<>(accounts);
        account.remove(0);
        Set<String> newSet = new HashSet<>(account);
        boolean containFlag = false;

        List<Set<String>> result = new ArrayList<>();

        for (Set<String> saveList : list) {
            containFlag = false;
            for (String str : saveList) {
                if (newSet.contains(str)) {
                    containFlag = true;
                    break;
                }
            }
            if (containFlag) {
                newSet.addAll(saveList);
            } else {
                result.add(saveList);
            }
        }
        result.add(newSet);

        System.out.println(result.toString());

        return result;
    }

    public static void main(String[] args) {
        Solution721 solution721 = new Solution721();
        List<List<String>> list = new ArrayList<>();

        List<String> john = new ArrayList<>();
        john.add("john");
        john.add("5@mail.com");
        john.add("2@mail.com");
        john.add("20@mail.com");
        john.add("20@mail.com");
        john.add("1@mail.com");
        list.add(john);

        List<String> john2 = new ArrayList<>();
        john2.add("john");
        john2.add("1@mail.com");
        john2.add("2@mail.com");
        john2.add("2@mail.com");
        john2.add("2@mail.com");
        john2.add("12@mail.com");
        list.add(john2);

        List<String> john3 = new ArrayList<>();
        john3.add("john");
        john3.add("8@mail.com");
        john3.add("4@mail.com");
        john3.add("18@mail.com");
        john3.add("17@mail.com");
        john3.add("16@mail.com");
        list.add(john3);

        List<String> john4 = new ArrayList<>();
        john4.add("john");
        john4.add("0@mail.com");
        john4.add("6@mail.com");
        john4.add("5@mail.com");
        john4.add("1@mail.com");
        john4.add("13@mail.com");
        list.add(john4);

        List<List<String>> result = solution721.accountsMerge(list);
        System.out.println(result.toString());

//        [
//        ["Celine","Celine5@m.co","Celine2@m.co","Celine20@m.co","Celine20@m.co","Celine1@m.co"],
//        ["Celine","Celine1@m.co","Celine2@m.co","Celine2@m.co","Celine2@m.co","Celine12@m.co"],
//        ["Celine","Celine8@m.co","Celine4@m.co","Celine18@m.co","Celine17@m.co","Celine16@m.co"],
//        ["Celine","Celine0@m.co","Celine6@m.co","Celine5@m.co","Celine1@m.co","Celine13@m.co"]]
//
//        ["Ethan","Ethan7@m.co","Ethan16@m.co","Ethan0@m.co","Ethan12@m.co","Ethan7@m.co"],
//        ["John","John20@m.co","John6@m.co","John20@m.co","John3@m.co","John16@m.co"],
//        ["Hanzo","Hanzo9@m.co","Hanzo5@m.co","Hanzo17@m.co","Hanzo7@m.co","Hanzo9@m.co"],
//        ["Hanzo","Hanzo13@m.co","Hanzo10@m.co","Hanzo1@m.co","Hanzo2@m.co","Hanzo2@m.co"],
//        ["John","John3@m.co","John1@m.co","John5@m.co","John2@m.co","John20@m.co"],
//        ["Hanzo","Hanzo9@m.co","Hanzo3@m.co","Hanzo13@m.co","Hanzo0@m.co","Hanzo19@m.co"],
//        ["Fern","Fern12@m.co","Fern6@m.co","Fern18@m.co","Fern16@m.co","Fern16@m.co"],
//        ["Gabe","Gabe0@m.co","Gabe10@m.co","Gabe0@m.co","Gabe19@m.co","Gabe3@m.co"],
//        ["Alex","Alex12@m.co","Alex17@m.co","Alex6@m.co","Alex16@m.co","Alex1@m.co"],
//        ["Gabe","Gabe16@m.co","Gabe20@m.co","Gabe13@m.co","Gabe6@m.co","Gabe6@m.co"],
//        ["Kevin","Kevin9@m.co","Kevin6@m.co","Kevin7@m.co","Kevin18@m.co","Kevin3@m.co"],
//        ["John","John13@m.co","John13@m.co","John14@m.co","John16@m.co","John1@m.co"],
//        ["David","David15@m.co","David8@m.co","David3@m.co","David14@m.co","David15@m.co"],
//        ["Alex","Alex2@m.co","Alex11@m.co","Alex11@m.co","Alex2@m.co","Alex12@m.co"],
//        ["Hanzo","Hanzo2@m.co","Hanzo9@m.co","Hanzo19@m.co","Hanzo10@m.co","Hanzo12@m.co"],
//        ["Isa","Isa16@m.co","Isa1@m.co","Isa1@m.co","Isa10@m.co","Isa12@m.co"],

    }
}