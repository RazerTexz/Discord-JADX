package b.a.p;

import android.content.Context;
import b.i.a.c.e3.b0.r;
import com.discord.utilities.lifecycle.ApplicationProvider;
import d0.z.d.m;
import d0.z.d.o;
import java.io.File;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* compiled from: SimpleCacheProvider.kt */
/* loaded from: classes.dex */
public final class l {
    public static final Lazy a = d0.g.lazy(a.j);

    /* renamed from: b, reason: collision with root package name */
    public static final l f254b = null;

    /* compiled from: SimpleCacheProvider.kt */
    public static final class a extends o implements Function0<r> {
        public static final a j = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public r invoke() {
            Context applicationContext = ApplicationProvider.INSTANCE.get().getApplicationContext();
            m.checkNotNullExpressionValue(applicationContext, "context");
            return new r(new File(applicationContext.getCacheDir(), "app_media_player"), new b.i.a.c.e3.b0.o(104857600L), new b.i.a.c.u2.b(applicationContext));
        }
    }
}
