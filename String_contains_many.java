public class String_contains_many {
    public static void main(String[] args) {
        String str="cbaskrcbawecbarngcbaengcba";
        String dst="cba";

        String_contains_many contains_many = new String_contains_many();
        System.out.println(contains_many.countcontent(str,dst));

    }
    public int  countcontent(String str,String dst)
    {
       int counts = 0;
       int index = str.indexOf(dst);
       while(index!=-1){
           counts++;
           index=index+dst.length();
           index=str.indexOf(dst,index);//巧用indexof()
       }
       return  counts;
    }
}
