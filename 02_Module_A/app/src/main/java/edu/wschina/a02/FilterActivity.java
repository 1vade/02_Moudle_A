package edu.wschina.a02;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import edu.wschina.a02.databinding.ActivityFilterBinding;

public class FilterActivity extends AppCompatActivity {
	ActivityFilterBinding binding;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = ActivityFilterBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());
		getWindow().addFlags(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(Color.WHITE);
		
		getWindow().setNavigationBarColor(Color.WHITE);
		
		binding.back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				finish();
				
			}
		});
	}
}