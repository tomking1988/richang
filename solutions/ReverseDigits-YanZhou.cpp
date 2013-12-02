class Solution {
public:
    int reverse(int x) {
        double y = 0;
        int sign = 1;
        
        if(x < 0){
            sign = -1;
            x = x * sign;
        }
        
        do{
            y = (x % 10) + (y * 10);
            x = x / 10;
        }while(x != 0);
        
        if(y > INT_MAX){
            return (INT_MAX * sign);
        }
        else{
            return (y * sign);
        }
  
    }
};