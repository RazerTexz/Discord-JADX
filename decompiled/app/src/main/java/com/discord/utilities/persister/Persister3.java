package com.discord.utilities.persister;

import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.persister.Persister;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Persister.kt */
/* renamed from: com.discord.utilities.persister.Persister$Companion$init$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class Persister3 extends Lambda implements Function1<Boolean, Unit> {
    public static final Persister3 INSTANCE = new Persister3();

    public Persister3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean bool) {
        Persister.Companion.access$persistAll(Persister.INSTANCE);
    }
}
