package raj.io.verticalandhoritzontalscrollandroid;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import raj.io.verticalandhoritzontalscrollandroid.adapter.VerticalRecyclerViewAdapter;
import raj.io.verticalandhoritzontalscrollandroid.model.HorizontalScrollItemModel;
import raj.io.verticalandhoritzontalscrollandroid.model.VerticalScrollItemModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.list);
        VerticalRecyclerViewAdapter adapter = new VerticalRecyclerViewAdapter(this);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter.update(getDummyList());
    }

    private List<VerticalScrollItemModel> getDummyList() {
        List<VerticalScrollItemModel> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<HorizontalScrollItemModel> list1 = new ArrayList<>();
            for (int j = 0; j < 15; j++) {
                HorizontalScrollItemModel model = new HorizontalScrollItemModel
                        (randomString(4), randomColor(), randomRating(), randomBoolean());
                list1.add(model);
            }
            VerticalScrollItemModel model = new VerticalScrollItemModel(randomString(6), list1);
            list.add(model);
        }
        return list;
    }

    private boolean randomBoolean() {
        Random r = new Random();
        return r.nextBoolean();
    }

    private int randomRating() {
        Random r = new Random();
        return r.nextInt(5);
    }

    private int randomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    private String randomString(int length) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        return output;
    }
}
