class Solution {
    public String reverseWords(String s) {
        if(s==null)
            return s;
        //s=s.replaceAll("( +)", " ").trim();
        //or
        s=s.trim();
        String[] arr=s.split(" +");
        StringBuilder sb=new StringBuilder();
        for(int j=arr.length-1 ; j>=0 ; --j){
            sb.append(arr[j]);
            if(j!=0)
                sb.append(" ");
        }
        return sb.toString();
    }
}
