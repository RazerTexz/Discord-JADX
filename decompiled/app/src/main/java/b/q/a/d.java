package b.q.a;

import android.view.View;
import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.view.GestureCropImageView;

/* compiled from: UCropActivity.java */
/* loaded from: classes3.dex */
public class d implements View.OnClickListener {
    public final /* synthetic */ UCropActivity j;

    public d(UCropActivity uCropActivity) {
        this.j = uCropActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UCropActivity uCropActivity = this.j;
        GestureCropImageView gestureCropImageView = uCropActivity.w;
        gestureCropImageView.k(-gestureCropImageView.getCurrentAngle());
        uCropActivity.w.setImageToWrapCropBounds(true);
    }
}
