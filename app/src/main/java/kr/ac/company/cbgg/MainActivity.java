package kr.ac.company.cbgg;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import net.daum.mf.map.api.MapView;


public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if(item.getItemId() == R.id.find_path) {
                mTextMessage.setText(R.string.title_find_path);
                // FInd_PATH 함수
                // 지도 화면
                find_path(item.getItemId());
                return true;
            }else{
                find_facility(item.getItemId());
                return true;
            }
        }
    };

    private void find_path(int itemId) {
        // default값은 출발지 (출발지랑 도착지 둘 다 선택 가능)
        // 걸리는 시간 확인
        // 경로 표시도 빨간색
    }

    private void find_facility(int id){
        // id 값 별로 화면 표시하면서
        // 현재 위치와 가장 가까운 시설은 빨간색
        // 전체 위치는 파란색
        // 내 위치는 빨간색 점
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapView mapView = new MapView(this);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
