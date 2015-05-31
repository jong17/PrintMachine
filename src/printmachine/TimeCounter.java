/*TimeCounter*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printmachine;

/**
 *
 * @author lateh
 */
public class TimeCounter extends Thread {
    long t_new;
    long t_count=0,t_count_old=0;
    long t_shirt=0,t_shirt_old=0;
    long t=0,to=0;
    int h=0,m=0,s=0;
    int rh=0,rm=0,rs=0;
    long durationTimeMillis,remainingTimeMillis,workingTimeSec;
    
    TimeCounter(){
         t_count=0;t_count_old=0;
        t_shirt=0;t_shirt_old=0;
        t=0;to=0;
        h=0;m=0;s=0;
        rh=0;rm=0;rs=0;
        workingTimeSec = (long)machineInfo.totalWorkingTime;
    }
    
    public void run(){
        while(true){
            timeCount();
            //shirtSuccessCount();
            //shirtScreen();
            t_new = System.currentTimeMillis();
        }
    }
    
    public void timeCount(){
        if(to!=0)
            t += t_new-to;
        to=t_new;
        if(t>=1000){
            s += 1;
            if(s%60==0){
                s = 0;
                m += 1;
                if(m%60==0){
                     m = 0;
                    h += 1;
                }
            }System.out.println(h+" "+m+" "+s);
            t=0;

            durationTimeMillis = h*3600+m*60+s;
            remainingTimeMillis = workingTimeSec - durationTimeMillis;
            if(remainingTimeMillis<=0) {
                rh=0;
                rm=0;
                rs=0;
            }
            else{
                rh = (int)(Math.ceil(remainingTimeMillis/3600));
                rm = (int)(Math.ceil((remainingTimeMillis%3600)/60));
                rs = (int)remainingTimeMillis%60;
              
            }
        }
    }
    
    public boolean shirtSuccessCount(){
            if(t_shirt_old!=0)
                t_shirt += t_new-t_shirt_old;
            t_shirt_old=t_new;
            if(t_shirt>=machineInfo.setSuccesShirtScreen()){
                //if(StatusPanel.countShirt<machineInfo.numShirt)
                    //StatusPanel.countShirt++;
                System.out.println("increase");
                t_shirt=0;
                return true;
            }
            else return false;
    }
    
}
