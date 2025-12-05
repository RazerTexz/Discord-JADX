package p007b.p008a.p040p;

import android.content.Context;
import com.discord.utilities.lifecycle.ApplicationProvider;
import java.io.File;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import p007b.p225i.p226a.p242c.p257e3.p258b0.LeastRecentlyUsedCacheEvictor;
import p007b.p225i.p226a.p242c.p257e3.p258b0.SimpleCache2;
import p007b.p225i.p226a.p242c.p264u2.ExoDatabaseProvider;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: SimpleCacheProvider.kt */
/* renamed from: b.a.p.l, reason: use source file name */
/* loaded from: classes.dex */
public final class SimpleCacheProvider {

    /* renamed from: a */
    public static final Lazy f1596a = LazyJVM.lazy(a.f1598j);

    /* renamed from: b */
    public static final SimpleCacheProvider f1597b = null;

    /* compiled from: SimpleCacheProvider.kt */
    /* renamed from: b.a.p.l$a */
    public static final class a extends Lambda implements Function0<SimpleCache2> {

        /* renamed from: j */
        public static final a f1598j = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public SimpleCache2 invoke() {
            Context applicationContext = ApplicationProvider.INSTANCE.get().getApplicationContext();
            Intrinsics3.checkNotNullExpressionValue(applicationContext, "context");
            return new SimpleCache2(new File(applicationContext.getCacheDir(), "app_media_player"), new LeastRecentlyUsedCacheEvictor(104857600L), new ExoDatabaseProvider(applicationContext));
        }
    }
}
