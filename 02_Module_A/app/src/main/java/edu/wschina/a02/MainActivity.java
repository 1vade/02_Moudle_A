package edu.wschina.a02;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

import edu.wschina.a02.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
	ActivityMainBinding binding;
	List<Picture> pictureList = new ArrayList<>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = ActivityMainBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());
		
		getWindow().addFlags(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(Color.WHITE);
		
		getWindow().setNavigationBarColor(Color.WHITE);
		initList();
		
		binding.filter.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(MainActivity.this, FilterActivity.class));
				
			}
		});
		
		binding.textFilter.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(MainActivity.this, FilterActivity.class));
				
			}
		});
		
		binding.scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
			@Override
			public void onScrollChange(@NonNull NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
				if (scrollY <= 430) {
					binding.yincang.setVisibility(View.VISIBLE);
					binding.xianshi.setVisibility(View.GONE);
				} else {
					binding.yincang.setVisibility(View.GONE);
					binding.xianshi.setVisibility(View.VISIBLE);
				}
			}
		});
		
		binding.date.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				new DateDialog().show(getSupportFragmentManager(), "DateDialog");
				
			}
		});
	}
	
	private void initList() {
		pictureList.add(new Picture("Grand Royal Hotel", "$180", "80 Reviews", R.drawable.hotel1));
		pictureList.add(new Picture("Grand Royal Hotel", "$323", "34 Reviews", R.drawable.hotel2));
		pictureList.add(new Picture("Grand Royal Hotel", "$134", "645 Reviews", R.drawable.hotel3));
		pictureList.add(new Picture("Grand Royal Hotel", "$235", "233 Reviews", R.drawable.hotel4));
		pictureList.add(new Picture("Grand Royal Hotel", "$80", "233 Reviews", R.drawable.hotel5));
		
		binding.recyclerView.setAdapter(new PicAdapter(pictureList));
		binding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
	}
	
	
	private class PicAdapter extends RecyclerView.Adapter<PicViewHolder> {
		private final List<Picture> picList;
		
		private PicAdapter(List<Picture> picList) {
			this.picList = picList;
		}
		
		@NonNull
		@Override
		public PicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
			return new PicViewHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.item_pic_list, parent, false));
		}
		
		@Override
		public void onBindViewHolder(@NonNull PicViewHolder holder, int position) {
			final Picture item = picList.get(position);
			holder.name.setText(item.name);
			holder.price.setText(item.price);
			holder.reviews.setText(item.reviews);
			holder.pic.setImageResource(item.pic);
		}
		
		@Override
		public int getItemCount() {
			return picList.size();
		}
	}
	
	private class PicViewHolder extends RecyclerView.ViewHolder {
		TextView name, price, reviews;
		ImageView pic;
		
		public PicViewHolder(@NonNull View itemView) {
			super(itemView);
			
			name = itemView.findViewById(R.id.name);
			price = itemView.findViewById(R.id.price);
			reviews = itemView.findViewById(R.id.reviews);
			pic = itemView.findViewById(R.id.pic);
			
			
		}
	}
}