package p007b.p225i.p226a.p341g.p352k;

import android.content.Context;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* compiled from: ClickActionDelegate.java */
/* renamed from: b.i.a.g.k.a, reason: use source file name */
/* loaded from: classes3.dex */
public class ClickActionDelegate extends AccessibilityDelegateCompat {

    /* renamed from: a */
    public final AccessibilityNodeInfoCompat.AccessibilityActionCompat f11857a;

    public ClickActionDelegate(Context context, int i) {
        this.f11857a = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, context.getString(i));
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.addAction(this.f11857a);
    }
}
