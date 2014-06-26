package com.androidexample.mylibapp;

import com.example.myandroidlib.R;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AlertDialog extends Dialog implements
		android.view.View.OnClickListener {
	public static final int TITLE_BUTTON_TYPE = 1;
	public static final int TITLE_TWO_BUTTON_TYPE = 2;
	public static final int BUTTON_TYPE = 3;
	public static final int TWO_BUTTON_TYPE = 4;

	private Button btn_ok, btn_cancel, btn_done;
	private LinearLayout linear_title, linear_one, linear_two;
	private TextView txt_title, txt_message;
	Context context;
	String strTitle, strMessage;

	public AlertDialog(Context context, String message) {
		super(context);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.context = context;
		strMessage = message;
		setContentView(R.layout.dialog_custom);
		setupView(BUTTON_TYPE);
	}

	public AlertDialog(Context context, String title, String message) {
		super(context);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.context = context;
		strTitle = title;
		strMessage = message;
		setContentView(R.layout.dialog_custom);
		setupView(TITLE_BUTTON_TYPE);
	}
	
	public AlertDialog(Context context, String message,int twoButton) {
		super(context);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.context = context;
		strMessage = message;
		setContentView(R.layout.dialog_custom);
		setupView(TWO_BUTTON_TYPE);
	}
	
	public AlertDialog(Context context, String title, String message, int twoButton) {
		super(context);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.context = context;
		strTitle = title;
		strMessage = message;
		setContentView(R.layout.dialog_custom);
		setupView(TITLE_TWO_BUTTON_TYPE);
	}

	private void setupView(int type) {
		linear_title = (LinearLayout) findViewById(R.id.linear_title);
		linear_one = (LinearLayout) findViewById(R.id.linear_one_button);
		linear_two = (LinearLayout) findViewById(R.id.linear_two_button);

		btn_ok = (Button) findViewById(R.id.btn_ok);
		btn_cancel = (Button) findViewById(R.id.btn_cancel);
		btn_done = (Button) findViewById(R.id.btn_done);

		txt_title = (TextView)findViewById(R.id.txt_title);
		txt_message = (TextView) findViewById(R.id.txt_message);
		switch (type) {
		case TITLE_BUTTON_TYPE:
			linear_title.setVisibility(View.VISIBLE);
			txt_title.setText(strTitle);

			linear_one.setVisibility(View.VISIBLE);
			linear_two.setVisibility(View.GONE);

			btn_done.setOnClickListener(this);
			break;

		case TITLE_TWO_BUTTON_TYPE:
			linear_title.setVisibility(View.VISIBLE);
			txt_title.setText(strTitle);
			
			linear_one.setVisibility(View.GONE);
			linear_two.setVisibility(View.VISIBLE);

			btn_ok.setOnClickListener(this);
			btn_cancel.setOnClickListener(this);
			break;

		case BUTTON_TYPE:
			linear_title.setVisibility(View.GONE);

			linear_one.setVisibility(View.VISIBLE);
			linear_two.setVisibility(View.GONE);

			btn_done.setOnClickListener(this);
			break;
		case TWO_BUTTON_TYPE:
			linear_title.setVisibility(View.GONE);

			linear_one.setVisibility(View.GONE);
			linear_two.setVisibility(View.VISIBLE);

			btn_ok.setOnClickListener(this);
			btn_cancel.setOnClickListener(this);
			break;
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_cancel:
			Toast.makeText(context, "Cancel", Toast.LENGTH_SHORT).show();
			break;
		case R.id.btn_ok:
			Toast.makeText(context, "Ok", Toast.LENGTH_SHORT).show();
			break;
		case R.id.btn_done:
			Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show();
			break;
		}
	}

}
