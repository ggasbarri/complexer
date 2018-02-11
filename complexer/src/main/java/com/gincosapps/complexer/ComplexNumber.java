package com.gincosapps.complexer;

public class ComplexNumber {
    
    private double x;
    private double y;
    private double module;
    private double angle;
    
    public double getX() {
        return x;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public double getY() {
        return y;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    public double getModule() {
        return module;
    }
    
    public void setModule(double module) {
        this.module = module;
    }
    
    public double getAngle() {
        return angle;
    }
    
    public void setAngle(double angle) {
        this.angle = angle;
    }
    
    public ComplexNumber(double x, double y){
        this.x = x;
        this.y = y;
        this.module = Math.sqrt( Math.pow(x,2) + Math.pow(y, 2) );
        this.angle = Math.atan2(y, x);
    }
    
    public ComplexNumber(double module, double angle, boolean isPolar){
        if(isPolar){
            this.module = module;
            this.angle = angle;
            this.x = module * Math.cos(angle);
            this.y = module * Math.sin(angle);
        }else{
            this.x = module;
            this.y = angle;
            this.module = Math.sqrt( Math.pow(x,2) + Math.pow(y, 2) );
            this.angle = Math.atan2(y, x);
        }
    
    }
    
    public static ComplexNumber sum(ComplexNumber... numbers){
        ComplexNumber total = new ComplexNumber(0,0);
        for(ComplexNumber number : numbers){
            total.x += number.x;
            total.y += number.y;
        }
        return total;
    }
    
    public static ComplexNumber sust(ComplexNumber a, ComplexNumber b){
        return sum(a, b.getOpposite());
    }
    
    public static ComplexNumber mult(ComplexNumber... numbers){
        ComplexNumber total = new ComplexNumber(1,0);
        for(ComplexNumber number : numbers){
            total.x = (total.x * number.x) - (total.y * number.y);
            total.y = (total.x * number.y) + (total.y * number.x);
        }
        return total;
    }
    
    public static ComplexNumber divide(ComplexNumber a, ComplexNumber b){
        return new ComplexNumber( (a.x * b.x + a.y * b.y) / (Math.pow(b.x, 2) + Math.pow(b.y, 2)) ,
                                  (a.y * b.x - a.x * b.y) / (Math.pow(b.x, 2) + Math.pow(b.y, 2)));
    }
    
    public ComplexNumber getOpposite(){
        return new ComplexNumber((-1) * this.x ,(-1) * this.y);
    }
    
    public ComplexNumber getConjugate(){
        return new ComplexNumber(this.x ,(-1) * this.y);
    }
    
    public ComplexNumber getInverse(){
        return divide(new ComplexNumber(1,0), this);
    }
    
}
