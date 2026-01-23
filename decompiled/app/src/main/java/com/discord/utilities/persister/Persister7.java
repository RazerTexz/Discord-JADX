package com.discord.utilities.persister;

import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.TimeElapsed;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.utilities.persister.Persister$Companion$persistAll$1$1, reason: use source file name */
/* JADX INFO: compiled from: Persister.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Persister7 extends Lambda implements Function1<Persister<?>, Unit> {
    public static final Persister7 INSTANCE = new Persister7();

    public Persister7() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Persister<?> persister) {
        invoke2(persister);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
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
                StringBuilder sbM833U = outline.m833U("Cached ");
                sbM833U.append(persister.getKey());
                sbM833U.append(" in ");
                sbM833U.append(timeElapsed.getSeconds());
                sbM833U.append(" seconds.");
                logger.invoke(4, sbM833U.toString(), null);
            }
        }
    }
}
