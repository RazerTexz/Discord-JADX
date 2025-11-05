package d0.e0.p.d.m0.b;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DefaultBuiltIns.kt */
/* loaded from: classes3.dex */
public final class e extends h {
    public static final a f = new a(null);
    public static final e g = new e(false, 1, null);

    /* compiled from: DefaultBuiltIns.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final e getInstance() {
            return e.access$getInstance$cp();
        }
    }

    public e(boolean z2) {
        super(new d0.e0.p.d.m0.m.f("DefaultBuiltIns"));
        if (z2) {
            d(false);
        }
    }

    public static final /* synthetic */ e access$getInstance$cp() {
        return g;
    }

    public static final e getInstance() {
        return f.getInstance();
    }

    public /* synthetic */ e(boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z2);
    }
}
