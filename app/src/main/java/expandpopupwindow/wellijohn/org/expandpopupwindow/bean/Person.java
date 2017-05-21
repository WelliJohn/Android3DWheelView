package expandpopupwindow.wellijohn.org.expandpopupwindow.bean;


import wellijohn.org.android3dwheelview.listener.OnTextDislpayListener;

/**
 * Created by warrior Jiang on 2017/5/20.
 */

public class Person implements OnTextDislpayListener {
    private int age;

    private String name;



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private String getStringText() {
        return age + "," + name;
    }

    @Override
    public String getDisplayInItem() {
        return getStringText();
    }



}
