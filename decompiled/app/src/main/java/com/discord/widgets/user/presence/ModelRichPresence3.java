package com.discord.widgets.user.presence;

import androidx.core.app.NotificationCompat;
import com.discord.api.application.Application;
import com.discord.models.presence.Presence;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.user.presence.ModelRichPresence$Companion$get$1$$special$$inlined$let$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: ModelRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelRichPresence3<T, R> implements Func1<Application, ModelRichPresence> {
    public final /* synthetic */ Presence $presence$inlined;

    public ModelRichPresence3(Presence presence) {
        this.$presence$inlined = presence;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ ModelRichPresence call(Application application) {
        return call2(application);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final ModelRichPresence call2(Application application) {
        return new ModelRichPresence(this.$presence$inlined, application);
    }
}
