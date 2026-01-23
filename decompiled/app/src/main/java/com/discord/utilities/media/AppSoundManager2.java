package com.discord.utilities.media;

import com.discord.utilities.lifecycle.ApplicationProvider;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.utilities.media.AppSoundManager$Provider$INSTANCE$2, reason: use source file name */
/* JADX INFO: compiled from: AppSoundManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppSoundManager2 extends Lambda implements Function0<AppSoundManager> {
    public static final AppSoundManager2 INSTANCE = new AppSoundManager2();

    public AppSoundManager2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AppSoundManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AppSoundManager invoke() {
        return new AppSoundManager(ApplicationProvider.INSTANCE.get());
    }
}
