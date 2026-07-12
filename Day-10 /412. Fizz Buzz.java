class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> abcd = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%15 == 0){
                abcd.add("FizzBuzz");
            } else if(i%3 == 0){
                abcd.add("Fizz");
            } else if(i%5 == 0){
                abcd.add("Buzz");
            } else {
                abcd.add(String.valueOf(i));
            } 
        }
        return abcd;
    }
}
