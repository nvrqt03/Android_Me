package ajmitchell.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ajmitchell.android.android_me.R;
// todo's in notion notes for Master List Fragment

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    private int headIndex;
    private int bodyIndex;
    private int legIndex;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this, "Postion clicked = " + position, Toast.LENGTH_SHORT).show();

        int bodyPartNumber = position / 12;
        int listIndex = position - 12*bodyPartNumber;

        switch(bodyPartNumber) {
            case 0: headIndex = listIndex;
                break;
            case 1: bodyIndex = listIndex;
            break;
            case 2: legIndex = listIndex;
            break;
            default: break;
        }

        Bundle b = new Bundle();
        b.putInt("headIndex", headIndex);
        b.putInt("bodyIndex", bodyIndex);
        b.putInt("legIndex", legIndex);

        final Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtras(b);

        Button nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
}
