import java.util.*;

class Solution721_unionfind {
    public static int[] parent;
    public static int[] weight;
    public int find(int target) {
        if(parent[target] == target) return target;
        return parent[target] = find(parent[target]);
    }
    public void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);
        if(findA == findB) return;

        if(weight[findA] > weight[findB]) {
            parent[findB] = findA;
            weight[findA] += weight[findB];
        } else {
            parent[findA] = findB;
            weight[findB] += weight[findA];
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int len = accounts.size();
        parent = new int[len];
        for(int i = 0; i < len; i++) {
            parent[i] = i;
        }
        weight = new int[len];

        Map<String, Integer> emailKeyIndexValueMap = new HashMap<>();
        String email = "";
        List<String> list;
        for(int i = 0; i< accounts.size(); i++) {
            list = accounts.get(i);
            for(int j = 1; j< list.size(); j++) {
                email = list.get(j);
                if(!emailKeyIndexValueMap.containsKey(email)) {
                    emailKeyIndexValueMap.put(email, i);
                }else {
                    union(i, emailKeyIndexValueMap.get(email));
                }
            }
        }

        Map<Integer, List<String>> indexKeyListValueMap = new HashMap<>();
        List<String> accountList;
        int index = 0;
        for(String key : emailKeyIndexValueMap.keySet()) {
            index = find(emailKeyIndexValueMap.get(key));
            email = accounts.get(index).get(0);
            accountList = indexKeyListValueMap.getOrDefault(index, new ArrayList<>());
            accountList.add(key);
            indexKeyListValueMap.put(index, accountList);
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> entry : indexKeyListValueMap.entrySet()) {
            List<String> child = new ArrayList<>(entry.getValue());
            child.sort((a,b) -> a.compareTo(b));
            child.add(0, accounts.get(entry.getKey()).get(0));
            result.add(child);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution721_unionfind solution721unionfind = new Solution721_unionfind();
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

        List<List<String>> result = solution721unionfind.accountsMerge(list);
        System.out.println(result.toString());
    }
}