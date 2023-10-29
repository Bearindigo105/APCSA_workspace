package Project_CrackTheCode;

public class CrackMe{

    private String _pin;

    public CrackMe(){
        this._pin = (int)(Math.random()*900 + 100) + "";
    }

    public boolean checkFirstDigit(String guess){
        return this._pin.charAt(0) == (guess.charAt(0));
    }

    public boolean checkSecondDigit(String guess){
        return this._pin.charAt(1) == (guess.charAt(1));
    }

    public boolean checkThirdDigit(String guess){
        return this._pin.charAt(2) == (guess.charAt(2));
    }

    public void setPin(String newVal){
        this._pin = newVal;
    }

    public String getPin(){
        return this._pin;
    }

    @Override
    public String toString(){
        return "pin: " + this._pin;
    }
}
