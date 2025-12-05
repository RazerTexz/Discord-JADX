package p007b.p225i.p226a.p341g.p342a;

import android.view.View;
import androidx.core.view.ViewCompat;

/* compiled from: ViewOffsetHelper.java */
/* renamed from: b.i.a.g.a.d, reason: use source file name */
/* loaded from: classes3.dex */
public class ViewOffsetHelper {

    /* renamed from: a */
    public final View f11530a;

    /* renamed from: b */
    public int f11531b;

    /* renamed from: c */
    public int f11532c;

    /* renamed from: d */
    public int f11533d;

    /* renamed from: e */
    public int f11534e;

    /* renamed from: f */
    public boolean f11535f = true;

    /* renamed from: g */
    public boolean f11536g = true;

    public ViewOffsetHelper(View view) {
        this.f11530a = view;
    }

    /* renamed from: a */
    public void m6033a() {
        View view = this.f11530a;
        ViewCompat.offsetTopAndBottom(view, this.f11533d - (view.getTop() - this.f11531b));
        View view2 = this.f11530a;
        ViewCompat.offsetLeftAndRight(view2, this.f11534e - (view2.getLeft() - this.f11532c));
    }

    /* renamed from: b */
    public boolean m6034b(int i) {
        if (!this.f11535f || this.f11533d == i) {
            return false;
        }
        this.f11533d = i;
        m6033a();
        return true;
    }
}
