//https://leetcode.com/problems/number-of-segments-in-a-string/description/

//Problem



//Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
//
//        Please note that the string does not contain any non-printable characters.
//
//        Example:
//
//        Input: "Hello, my name is John"
//        Output: 5



//Solution



class NumberofSegmentsinaString {
    public void countSegments(String s) {
        s="";
        if(s=="")
            System.out.print("0");

        String[] split = s.split( " " );
        System.out.print(split.length);
    }

    public static void main(String []){
        String s="";
        countSegments(s);
    }
}