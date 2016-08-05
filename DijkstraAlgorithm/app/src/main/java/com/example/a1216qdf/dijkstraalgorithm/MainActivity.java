package com.example.a1216qdf.dijkstraalgorithm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.a1216qdf.dijkstraalgorithm.Dijkstra2.Edge;
import com.example.a1216qdf.dijkstraalgorithm.Dijkstra2.Vertex;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn_ok;
    private Button btn_add;
    private Button btn_reset;
    private EditText et_point;
    private TextView tv_point;
    private String path = "";
    private String point[] = new String[9];
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_add = (Button) findViewById(R.id.btn_add);
        btn_ok = (Button) findViewById(R.id.btn_ok);
        btn_reset = (Button) findViewById(R.id.btn_reset);
        et_point = (EditText) findViewById(R.id.et_point);
        tv_point = (TextView) findViewById(R.id.textView1);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_point.getText() == null
                        || et_point.getText().toString() == "") {
                    btn_add.setClickable(false);
                }
                if (i == 9) {
                    btn_add.setClickable(false);
                    btn_add.setText("到达点数上限");
                }
                point[i] = et_point.getText().toString();
                tv_point.setText(tv_point.getText().toString() + point[i]
                        + ",,");
                i++;
                et_point.setText("");
            }
        });
        btn_ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                for (int j = 1; j < i; j++) {
                    path += dijkstra(point[j - 1], point[j]);
                }
                tv_point.setText(path);
            }
        });
        btn_reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO 自动生成的方法存根
                Intent intent = getIntent();
                finish();
                startActivity(intent);

            }
        });
    }

    public String dijkstra(String p1, String p2) {


        Vertex v1 = new Vertex("a");
        Vertex v2 = new Vertex("b");
        Vertex v3 = new Vertex("c");
        Vertex v4 = new Vertex("d");
        Vertex v5 = new Vertex("e");

        List<Edge> e1l = v1.adj;
        List<Edge> e2l = v2.adj;
        List<Edge> e3l = v3.adj;
        List<Edge> e4l = v4.adj;
        List<Edge> e5l = v5.adj;

        Edge e12 = new Edge(v2, 45);
        Edge e13 = new Edge(v3, 30);
        Edge e15 = new Edge(v5, 50);
        e1l.add(e13);
        e1l.add(e15);
        e1l.add(e12);

        Edge e24 = new Edge(v4, 60);
        Edge e21 = new Edge(v1, 45);
        e2l.add(e24);
        e2l.add(e21);

        Edge e35 = new Edge(v5, 45);
        e3l.add(e35);
        Edge e31 = new Edge(v1, 30);
        e3l.add(e31);

        Edge e45 = new Edge(v5, 55);
        e4l.add(e45);
        Edge e42 = new Edge(v2, 60);
        e4l.add(e42);

        Edge e51 = new Edge(v1, 50);
        Edge e53 = new Edge(v3, 45);
        Edge e54 = new Edge(v4, 55);
        e5l.add(e51);
        e5l.add(e54);
        e5l.add(e53);

        Dijkstra2.vertexMap.put("a", v1);
        Dijkstra2.vertexMap.put("b", v2);
        Dijkstra2.vertexMap.put("c", v3);
        Dijkstra2.vertexMap.put("d", v4);
        Dijkstra2.vertexMap.put("e", v5);

        return Dijkstra2.dijkstra(p1, p2);
    }

}


