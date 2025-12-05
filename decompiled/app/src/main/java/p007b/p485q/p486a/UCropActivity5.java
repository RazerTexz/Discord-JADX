package p007b.p485q.p486a;

import android.view.View;
import com.yalantis.ucrop.UCropActivity;

/* compiled from: UCropActivity.java */
/* renamed from: b.q.a.e, reason: use source file name */
/* loaded from: classes3.dex */
public class UCropActivity5 implements View.OnClickListener {

    /* renamed from: j */
    public final /* synthetic */ UCropActivity f14392j;

    public UCropActivity5(UCropActivity uCropActivity) {
        this.f14392j = uCropActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UCropActivity uCropActivity = this.f14392j;
        uCropActivity.f22194w.m7482k(90);
        uCropActivity.f22194w.setImageToWrapCropBounds(true);
    }
}
