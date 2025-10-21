package com.discord.utilities.persister;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.TimeElapsed;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: Persister.kt */
/* renamed from: com.discord.utilities.persister.Persister$Companion$persistAll$1$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class Persister7 extends Lambda implements Function1<Persister<?>, Unit> {
    public static final Persister7 INSTANCE = new Persister7();

    public Persister7() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Persister<?> persister) {
        invoke2(persister);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Persister<?> persister) {
        if (persister != null) {
            Clock clockAccess$getClock$cp = Persister.access$getClock$cp();
            if (clockAccess$getClock$cp == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("clock");
            }
            TimeElapsed timeElapsed = new TimeElapsed(clockAccess$getClock$cp, 0L, 2, null);
            Persister.access$persist(persister);
            if (timeElapsed.getMilliseconds() > 100) {
                Function3<Integer, String, Exception, Unit> logger = Persister.INSTANCE.getLogger();
                StringBuilder sbU = outline.U("Cached ");
                sbU.append(persister.getKey());
                sbU.append(" in ");
                sbU.append(timeElapsed.getSeconds());
                sbU.append(" seconds.");
                logger.invoke(4, sbU.toString(), null);
            }
        }
    }
}
