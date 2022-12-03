class soru1 {
    public static void main(String[] args) {

       for(int i = 10; i<100;i++){
        if(palindromik(i)){
            System.out.println(i);
        }
       }     

    }


    static boolean palindromik(int sayi){
        int temp =sayi;
        int tersCevir=0;
        int sayi2;

        while(temp !=0){
            sayi2=temp%10;
            tersCevir =(tersCevir*10)+sayi2;
            temp/=10;
        }

        if(sayi==tersCevir){
            return true;
        
        }else
        return false;
    }
}