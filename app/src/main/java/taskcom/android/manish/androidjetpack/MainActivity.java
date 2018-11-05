package taskcom.android.manish.androidjetpack;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Manish Kumar on 11/5/2018
 */
public class MainActivity extends AppCompatActivity {
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvNumber = findViewById(R.id.tvDisplayNumber);

        final MainActivityViewModel viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class); // Data is preserved when screen is rotated.
        final LiveData<String> randomNumber = viewModel.getNumber();
        randomNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tvNumber.setText(s);
            }
        });


        Button btnGetRandomNumber = findViewById(R.id.btnGetRandomNumber);
        btnGetRandomNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.createNumber();
            }
        });
    }
}