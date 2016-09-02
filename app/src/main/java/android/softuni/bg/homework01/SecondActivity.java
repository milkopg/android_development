package android.softuni.bg.homework01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
  private Button mButtonTop;
  private Button mButtonMiddle;
  private Button mButtonBottom;
  private TextView mTextViewResult;
  private int lastPressedButtonId;
  private HashMap<Integer, String> mTextButtonsHashMap;

  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.button_top:

        changeTextOfDoublePressedButton(view.getId(), mButtonTop,String.valueOf(R.id.button_top));
        mTextViewResult.setText(String.valueOf(R.id.button_top));
        lastPressedButtonId = R.id.button_top;
        break;
      case R.id.button_middle:
        changeTextOfDoublePressedButton(view.getId(), mButtonMiddle, String.valueOf(R.id.button_middle));
        mTextViewResult.setText(String.valueOf(R.id.button_middle));
        lastPressedButtonId = R.id.button_middle;
        break;
      case R.id.button_bottom:
        changeTextOfDoublePressedButton(view.getId(), mButtonBottom, String.valueOf(R.id.button_bottom));
        mTextViewResult.setText(String.valueOf(R.id.button_bottom));
        lastPressedButtonId = R.id.button_bottom;
        break;
      case R.id.textView_result_second_activity:
        Intent intent = new Intent(SecondActivity.this, ResultActivity.class);
        intent.putExtra(Constants.INTENT_BUNDLE_COMPONENT_ID, Integer.parseInt(mTextViewResult.getText().toString()));
        intent.putExtra(Constants.INTENT_BUNDLE_COMPONENT_TEXT, mTextButtonsHashMap.get(lastPressedButtonId));
        startActivity(intent);
        break;
    }
  }

  private void changeTextOfDoublePressedButton(int buttonId, Button button, String buttonText) {
    if (lastPressedButtonId == buttonId) {
      button.setText(buttonText);
      return;
    } else {
      button.setText(mTextButtonsHashMap.get(buttonId));
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);

    mButtonTop = (Button) findViewById(R.id.button_top);
    mButtonMiddle = (Button) findViewById(R.id.button_middle);
    mButtonBottom = (Button) findViewById(R.id.button_bottom);
    mTextViewResult = (TextView) findViewById(R.id.textView_result_second_activity);
    fillTextButtonsHashHashMap();

    mButtonTop.setOnClickListener(this);
    mButtonMiddle.setOnClickListener(this);
    mButtonBottom.setOnClickListener(this);
    mTextViewResult.setOnClickListener(this);
  }

  private void fillTextButtonsHashHashMap() {
    mTextButtonsHashMap = new HashMap<>();
    mTextButtonsHashMap.put(R.id.button_top, mButtonTop.getText().toString());
    mTextButtonsHashMap.put(R.id.button_middle, mButtonMiddle.getText().toString());
    mTextButtonsHashMap.put(R.id.button_bottom, mButtonBottom.getText().toString());
  }
}
