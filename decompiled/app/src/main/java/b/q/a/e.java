package b.q.a;

import android.view.View;
import com.yalantis.ucrop.UCropActivity;

/* compiled from: UCropActivity.java */
/* loaded from: classes3.dex */
public class e implements View.OnClickListener {
    public final /* synthetic */ UCropActivity j;

    public e(UCropActivity uCropActivity) {
        this.j = uCropActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UCropActivity uCropActivity = this.j;
        uCropActivity.w.k(90);
        uCropActivity.w.setImageToWrapCropBounds(true);
    }
}
