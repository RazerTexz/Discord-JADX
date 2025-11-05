package b.a.k;

import android.view.View;
import androidx.core.view.ViewCompat;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: Format.kt */
/* loaded from: classes.dex */
public final class a {
    public static b.a.k.g.b a;

    /* renamed from: b, reason: collision with root package name */
    public static Function0<Integer> f245b = C0034a.j;
    public static Function2<? super String, ? super View, Unit> c = b.j;
    public static final a d = null;

    /* compiled from: Format.kt */
    /* renamed from: b.a.k.a$a, reason: collision with other inner class name */
    public static final class C0034a extends o implements Function0<Integer> {
        public static final C0034a j = new C0034a();

        public C0034a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    /* compiled from: Format.kt */
    public static final class b extends o implements Function2<String, View, Unit> {
        public static final b j = new b();

        public b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(String str, View view) {
            m.checkNotNullParameter(str, "<anonymous parameter 0>");
            m.checkNotNullParameter(view, "<anonymous parameter 1>");
            return Unit.a;
        }
    }
}
