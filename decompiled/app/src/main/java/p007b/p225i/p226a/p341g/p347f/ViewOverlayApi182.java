package p007b.p225i.p226a.p341g.p347f;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.internal.ViewOverlayImpl;

/* compiled from: ViewOverlayApi18.java */
@RequiresApi(18)
/* renamed from: b.i.a.g.f.b, reason: use source file name */
/* loaded from: classes3.dex */
public class ViewOverlayApi182 implements ViewOverlayImpl {

    /* renamed from: a */
    public final ViewOverlay f11712a;

    public ViewOverlayApi182(@NonNull View view) {
        this.f11712a = view.getOverlay();
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void add(@NonNull Drawable drawable) {
        this.f11712a.add(drawable);
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void remove(@NonNull Drawable drawable) {
        this.f11712a.remove(drawable);
    }
}
