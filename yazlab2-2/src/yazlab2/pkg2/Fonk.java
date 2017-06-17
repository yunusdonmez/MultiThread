/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yazlab2.pkg2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Yusuf
 */
public class Fonk {
    private int value;
    public int enUygunDegeriBul(ArrayList<Integer> ozellik,ArrayList<Integer> sonuc,int baslangic,int son) throws InterruptedException{
        int aralik[]=new int[3];
        aralik[0]=baslangic;
        aralik[1]=baslangic+(son-baslangic)/3;
        aralik[2]=baslangic+2*((son-baslangic)/3);
        double entTmp=100,sonEnt;
        int sayiTmp=1,sonSayi;
        MyThread2 myThreadObj1=new MyThread2(ozellik,sonuc,aralik[0],aralik[1],baslangic,son);
        MyThread2 myThreadObj2=new MyThread2(ozellik,sonuc,aralik[1],aralik[2],baslangic,son);
        MyThread2 myThreadObj3=new MyThread2(ozellik,sonuc,aralik[2],son,baslangic,son);
        
        
        myThreadObj1.start();
        myThreadObj2.start();
        myThreadObj3.start();
        
        String line;
        String deneme[]=null;
        myThreadObj1.join();
        myThreadObj2.join();
        myThreadObj3.join();
        line=myThreadObj1.dondur;
        deneme=line.split("-");
        sonEnt=Double.parseDouble(deneme[1]); 
        sonSayi=Integer.parseInt(deneme[0]);
        line=myThreadObj2.dondur;
        deneme=line.split("-");
        entTmp=Double.parseDouble(deneme[1]); 
        sayiTmp=Integer.parseInt(deneme[0]);
        if(entTmp<=sonEnt){
            sonEnt=entTmp;
            sonSayi=sayiTmp;
        }
        line=myThreadObj3.dondur;
        deneme=line.split("-");
        
        entTmp=Double.parseDouble(deneme[1]); 
        sayiTmp=Integer.parseInt(deneme[0]);
        if(entTmp<=sonEnt){
            sonEnt=entTmp;
            sonSayi=sayiTmp;
        }
        
        return sonSayi;
    }
    public int oku(String file) throws IOException{
        FileReader fileReader = new FileReader(file);
        String line;
        int sayac=0;
        BufferedReader br = new BufferedReader(fileReader);
        while ((line = br.readLine()) != null) {
            sayac++;
        }
        br.close();
        return sayac;
    }
    public int enk(ArrayList <Integer> ozellik){
        int min = ozellik.get(0);
        for(int i=0; i<ozellik.size(); i++)
        {
            if(min >  ozellik.get(i))
            {
                min = ozellik.get(i);
            }
        }
        return min;
    }
    public int enb(ArrayList <Integer> ozellik){
        int max = ozellik.get(0);
        for(int i=0; i<ozellik.size(); i++)
        {
            if(max < ozellik.get(i))
            {
                max = ozellik.get(i);
            }
        }
        return max;
    }
    public double hesaplaEnt(ArrayList <Integer> ozellik,ArrayList <Integer> sonuc,int baslangic,int son){
        double ent=0;
        double tmp=0;
        double payda=ozellik.size();
        double kont1=0,kont2=0;
        for (int i = baslangic; i <= son; i++) {
            for (int j = 0; j < ozellik.size(); j++) {
                if(ozellik.get(j)==i && sonuc.get(j)==1){
                    kont1++;
                }else if(ozellik.get(j)==i && sonuc.get(j)==2){
                    kont2++;
                }
            }
           if(kont1!=0){
                tmp=(-1*kont1/(kont1+kont2))*(Math.log(kont1/(kont1+kont2))/Math.log(2));
                if(kont2!=0)
                    tmp=tmp-(kont2/(kont1+kont2))*(Math.log(kont2/(kont1+kont2))/Math.log(2));
                tmp=tmp*((kont1+kont2)/payda);
            }else if(kont2!=0){
                tmp=-(kont2/(kont1+kont2))*(Math.log(kont2/(kont1+kont2))/Math.log(2));
                tmp=tmp*((kont1+kont2)/payda);
            }else{
                tmp=0;
            }
           
            ent+=tmp;
            kont1=0;
            kont2=0;
        }
        return ent;
    }
    
}
