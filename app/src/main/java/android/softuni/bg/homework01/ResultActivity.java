package android.softuni.bg.homework01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
  private TextView mTextView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_result);

    mTextView = (TextView) findViewById(R.id.textView_result_activity);

    if ((getIntent() != null) && (mTextView != null)) {
      mTextView.setText("ID: " + getIntent().getIntExtra(Constants.INTENT_BUNDLE_COMPONENT_ID, -1) + " , Text: " + getIntent().getStringExtra(Constants.INTENT_BUNDLE_COMPONENT_TEXT));
    }
  }
}
