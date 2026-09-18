package tw.pulipuli.share2draft;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class ShareActivity extends Activity {
  @Override public void onCreate(Bundle b) {
    super.onCreate(b);
    Intent incoming=getIntent();
    String text=incoming.getStringExtra(Intent.EXTRA_TEXT);
    String subject=incoming.getStringExtra(Intent.EXTRA_SUBJECT);
    if (text==null) text="";
    Intent mail=new Intent(Intent.ACTION_SENDTO);
    mail.setData(Uri.parse("mailto:"));
    if (subject!=null && !subject.isEmpty()) mail.putExtra(Intent.EXTRA_SUBJECT,subject);
    mail.putExtra(Intent.EXTRA_TEXT,text);
    mail.setPackage("com.google.android.gm");
    try { startActivity(mail); }
    catch (Exception e) {
      mail.setPackage(null);
      try { startActivity(mail); }
      catch (Exception ignored) { Toast.makeText(this,"No email app found.",Toast.LENGTH_LONG).show(); }
    }
    finish();
  }
}
