package com.androidexample.mylibapp;

import com.example.myandroidlib.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	Button btn1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		setupview();

	}

	private void setupview() {
		btn1 = (Button)findViewById(R.id.button1);
		btn1.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
				AlertDialog aler = new AlertDialog(this, "Title","This is alert have two Button");
				aler.show();
			break;
		}
	}
}
