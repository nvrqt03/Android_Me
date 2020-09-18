package ajmitchell.android.android_me.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ajmitchell.android.android_me.R;
// todo's in notion notes for Master List Fragment

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this, "Postion clicked = " + position, Toast.LENGTH_SHORT).show();
    }
}
