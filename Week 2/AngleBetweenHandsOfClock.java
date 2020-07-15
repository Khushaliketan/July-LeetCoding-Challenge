class Solution {
    public double angleClock(int hour, int minutes) {
        //METHOD 1:
        /*
        double minutesDegree= minutes * 6 ; //degrees covered in a minute of a clock
        System.out.println(minutesDegree);
        
        double hourDegree = hour * 30;  //degrees covered in an hour of a clock
        hourDegree += minutes*0.5; //Relative to minute hand, hour hand moves 0.5 degrees in every minute
        System.out.println(hourDegree);
        
        double res = Math.abs(hourDegree-minutesDegree);
        return res > 180 ? 360-res : res;
        */
        
        //METHOD 2: 
        double a1 = 360.0 * (hour + minutes / 60.0) / 12;
        double a2 = 360.0 * minutes / 60;
        
        double temp = Math.abs(a1 - a2);
        return temp > 180 ? 360 - temp : temp;
    }
}
