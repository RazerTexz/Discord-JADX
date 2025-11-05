package b.f.g.g;

import android.content.Context;
import android.view.ViewConfiguration;
import androidx.annotation.VisibleForTesting;

/* compiled from: GestureDetector.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    public final float f524b;

    @VisibleForTesting
    public long e;

    @VisibleForTesting
    public float f;

    @VisibleForTesting
    public float g;

    @VisibleForTesting
    public InterfaceC0069a a = null;

    @VisibleForTesting
    public boolean c = false;

    @VisibleForTesting
    public boolean d = false;

    /* compiled from: GestureDetector.java */
    /* renamed from: b.f.g.g.a$a, reason: collision with other inner class name */
    public interface InterfaceC0069a {
    }

    public a(Context context) {
        this.f524b = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
