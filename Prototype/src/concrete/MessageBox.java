package Prototype.src.concrete;

import Prototype.src.framework.Product;

public class MessageBox implements Product{
    private char decochar;

    public MessageBox(char decochar){
        this.decochar = decochar;
    }

    @Override
    public void use(String s){
        int decolen = 1 + s.length() + 1;
        for (int i=0; i<decolen; i++){
            System.out.print(decochar);
        }
        System.out.println();
        System.out.println(decochar + " " + s + " " + decochar);
        for (int i=0; i<decolen; i++){
            System.out.print(decochar);
        }
        System.out.println();
    }

    @Override
    public Product createClone(){
        Product p = null;
        try{
            p = (Product)clone(); //인스턴스 메서드
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return p;
    }
}
