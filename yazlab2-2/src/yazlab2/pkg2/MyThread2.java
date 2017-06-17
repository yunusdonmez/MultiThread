/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yazlab2.pkg2;

import java.util.ArrayList;

/**
 *
 * @author Yusuf
 */
public class MyThread2 extends Thread{
    ArrayList <Integer> ozellik, sonuc;
    int baslangic, bitis, bas, son, sss;
    public String dondur;
    

    public MyThread2(ArrayList <Integer> ozellik, ArrayList <Integer> sonuc,int baslangic,int bitis,int bas,int son) {
        this.ozellik=ozellik;
        this.sonuc=sonuc;
        this.bas=bas;
        this.baslangic=baslangic;
        this.bitis=bitis;
        this.son=son;
        this.sss=sss;
    }
    
    @Override
    public void run(){
        int uygunSayi=0;
        int elemanSayisi1=0,elemanSayisi2=0;
        double value=1;
        
        for (int i = baslangic; i <= bitis; i++) {
            elemanSayisi2=0;
            elemanSayisi1=0;
            ArrayList <Integer> diziKucukOzellik=new ArrayList<>();
            ArrayList <Integer> diziKucukSonuc=new ArrayList<>();
            for (int j = 0; j < ozellik.size(); j++) {
                if(i>ozellik.get(j)){
                    diziKucukOzellik.add(ozellik.get(j));
                    diziKucukSonuc.add(sonuc.get(j));
                    elemanSayisi1++;
                }             
            }
            if(elemanSayisi1==0)
                continue;
            Fonk olustur=new Fonk();
            ArrayList <Integer> diziBuyukOzellik=new ArrayList<>();
            ArrayList <Integer> diziBuyukSonuc=new ArrayList<>();
            for (int j = 0; j < ozellik.size(); j++) {
                if(i<=ozellik.get(j)){
                    diziBuyukOzellik.add(ozellik.get(j));
                    diziBuyukSonuc.add(sonuc.get(j));
                    elemanSayisi2++;
                }             
            }
           if(elemanSayisi2==0)
              continue;
              
           double tmp;
           
            tmp=(olustur.hesaplaEnt(diziKucukOzellik, diziKucukSonuc, bas, i)*elemanSayisi1+olustur.hesaplaEnt(diziBuyukOzellik, diziBuyukSonuc, i, son)*elemanSayisi2)/(elemanSayisi1+elemanSayisi2);
            
            if(tmp<value){
                value=tmp;
                uygunSayi=i;
            }
        }
        dondur=uygunSayi+"-"+value;
    }
}
