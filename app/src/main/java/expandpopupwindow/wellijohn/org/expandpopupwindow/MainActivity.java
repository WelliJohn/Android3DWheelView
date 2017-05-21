package expandpopupwindow.wellijohn.org.expandpopupwindow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import expandpopupwindow.wellijohn.org.expandpopupwindow.bean.Person;
import wellijohn.org.android3dwheelview.listener.OnItemSelectedListener;
import wellijohn.org.android3dwheelview.listener.OnTextDislpayListener;
import wellijohn.org.android3dwheelview.loopview.LoopView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private LinearLayout ll;
    private LoopView mLoopview;
    private LoopView mLoopviewRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tv = (TextView) findViewById(R.id.tv);
        ll = (LinearLayout) findViewById(R.id.ll);
        final View contentView = LayoutInflater.from(this).inflate(R.layout.popup_window_content, null);
        mLoopview = (LoopView) contentView.findViewById(R.id.loopview);
        mLoopviewRight = (LoopView) contentView.findViewById(R.id.loopview_right);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<OnTextDislpayListener> list = new ArrayList<>();
                for(int i=0;i<17;i++){
                    Person person = new Person();
                    person.setAge(i);
                    person.setName("list添加的对象需实现onDisplayTextListener接口");
                    list.add(person);
                }
               /* List<String> datas = Arrays.asList(getResources().getStringArray(R.array.names));*/
                mLoopview.setItems(list);
                mLoopviewRight.setItems(list);
                PopupWindow pw = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                pw.setContentView(contentView);
                pw.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                pw.setTouchable(true);
                pw.setOutsideTouchable(true);
//                pw.showAsDropDown(tv);
                int location[] = new int[2];
                v.getLocationOnScreen(location);
                pw.showAtLocation(v, Gravity.NO_GRAVITY, location[0], location[1] + v.getHeight());
            }
        });

        mLoopview.setOnItemSelectedListener(new OnItemSelectedListener<Person>() {
            @Override
            public void onItemSelected(int index, Person item) {
                Toast.makeText(MainActivity.this,item.getAge()+","+item.getName(),Toast.LENGTH_LONG).show();
            }
        });
    }


    //获取屏幕的高度
    public static int getScreenHeight(Context context) {
        WindowManager manager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        return display.getHeight();
    }

}
