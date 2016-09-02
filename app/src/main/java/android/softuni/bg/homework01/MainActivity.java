package android.softuni.bg.homework01;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
  private Button mButtonImplicit;
  private Button mButtonExplicit;
  private TextView mTextViewResult;
  private RelativeLayout mRelativeLayout;
  private  int mIdButtonExplicit;
  private  int mImplicitButtonCounts = 0;
  private int mExplicitButtonCounts = 0;

  @Override
  public void onClick(View view) {

    if (view.getId() == R.id.btn_implicit) {
      mImplicitButtonCounts++;
      mTextViewResult.setText(String.valueOf(mImplicitButtonCounts));
    } else if (view.getId() == mIdButtonExplicit){
      mExplicitButtonCounts++;
      mTextViewResult.setText(String.valueOf(mExplicitButtonCounts));
    } else if (view.getId() == R.id.text_view_buttons_count_result) {
      Intent intent = new Intent(this, SecondActivity.class);
      startActivity(intent);
    }

  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mButtonImplicit = (Button) findViewById(R.id.btn_implicit);
    mButtonImplicit.setOnClickListener(this);

    mButtonExplicit = createButtonExplicit();
    mButtonExplicit.setOnClickListener(this);

    mRelativeLayout = (RelativeLayout) findViewById(R.id.layout_relative);
    RelativeLayout.LayoutParams paramsExplicitButton =    new RelativeLayout.LayoutParams(mButtonImplicit.getLayoutParams());
    paramsExplicitButton.addRule(RelativeLayout.ALIGN_PARENT_TOP);
    paramsExplicitButton.addRule(RelativeLayout.CENTER_HORIZONTAL);

    mRelativeLayout.addView(mButtonExplicit, paramsExplicitButton);

    mTextViewResult = (TextView) findViewById(R.id.text_view_buttons_count_result);
    mTextViewResult.setOnClickListener(this);
  }

  private Button createButtonExplicit() {
    mButtonExplicit = new Button(this);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
      mIdButtonExplicit = View.generateViewId();
      mButtonExplicit.setId(mIdButtonExplicit);
    }
    mButtonExplicit.setLayoutParams(mButtonImplicit.getLayoutParams());
    mButtonExplicit.setText(getResources().getString(R.string.button_explicit));
    return mButtonExplicit;
  }
}
