class Solution {
    public String solution(String s, String skip, int index) {
        String src = "abcdefghijklmnopqrstuvwxyz";
        src = src.replaceAll(String.format("[%s]", skip), "");
        char[] a = src.toCharArray();
        System.out.println(src);
        
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = src.indexOf(ch) + index;
            
            while (idx >= a.length) {
                idx -= a.length;
            }
            
            sb.append(a[idx]);
        }
        
        
        return sb.toString();
    }
}