package tw.pulipuli.share2draft;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
  @Override public void onCreate(Bundle b) {
    super.onCreate(b);
    TextView v=new TextView(this);
    v.setText("Share to Draft\n\nUse Android's Share menu and select Share to Draft. It will open Gmail's composer with the shared text. Gmail automatically keeps an opened composition as a draft.");
    v.setTextSize(18); v.setPadding(48,64,48,48);
    setContentView(v);
  }
}
