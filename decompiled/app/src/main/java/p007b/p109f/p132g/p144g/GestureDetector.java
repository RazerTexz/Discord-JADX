package p007b.p109f.p132g.p144g;

import android.content.Context;
import android.view.ViewConfiguration;
import androidx.annotation.VisibleForTesting;

/* compiled from: GestureDetector.java */
/* renamed from: b.f.g.g.a, reason: use source file name */
/* loaded from: classes.dex */
public class GestureDetector {

    /* renamed from: b */
    @VisibleForTesting
    public final float f3481b;

    /* renamed from: e */
    @VisibleForTesting
    public long f3484e;

    /* renamed from: f */
    @VisibleForTesting
    public float f3485f;

    /* renamed from: g */
    @VisibleForTesting
    public float f3486g;

    /* renamed from: a */
    @VisibleForTesting
    public a f3480a = null;

    /* renamed from: c */
    @VisibleForTesting
    public boolean f3482c = false;

    /* renamed from: d */
    @VisibleForTesting
    public boolean f3483d = false;

    /* compiled from: GestureDetector.java */
    /* renamed from: b.f.g.g.a$a */
    public interface a {
    }

    public GestureDetector(Context context) {
        this.f3481b = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
