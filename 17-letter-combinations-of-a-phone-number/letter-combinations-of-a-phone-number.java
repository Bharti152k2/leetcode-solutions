class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,List<Character>> hmap= new HashMap<>();
        hmap.put('2',List.of('a','b','c'));
        hmap.put('3',List.of('d','e','f'));
        hmap.put('4' ,List.of('g','h','i'));
        hmap.put('5',List.of('j','k','l'));
        hmap.put('6',List.of('m','n','o'));
        hmap.put('7',List.of('p','q','r','s'));
        hmap.put('8',List.of('t','u','v'));
        hmap.put('9',List.of('w','x','y','z'));
        List<String> res= new ArrayList<>();
        dfs(digits,hmap,0,"",res);
        return res;
    }
    public void dfs(String digits, HashMap<Character,List<Character>> hmap,int index,String combination,List<String> res){
        if(index == digits.length()){
            res.add(combination);
            return;
        }
        char digit=digits.charAt(index);
        List<Character> cur = hmap.get(digit);
        for(int i=0; i<cur.size();i++){
            dfs(digits,hmap,index+1,combination+cur.get(i),res);
        }
    }
}