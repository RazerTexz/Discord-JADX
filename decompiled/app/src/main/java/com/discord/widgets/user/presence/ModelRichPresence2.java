package com.discord.widgets.user.presence;

import androidx.core.app.NotificationCompat;
import com.discord.api.activity.Activity;
import com.discord.models.presence.Presence;
import com.discord.stores.StoreStream;
import com.discord.utilities.presence.PresenceUtils;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import rx.Observable;

/* compiled from: ModelRichPresence.kt */
/* renamed from: com.discord.widgets.user.presence.ModelRichPresence$Companion$get$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelRichPresence2<T, R> implements Func1<Presence, Observable<? extends ModelRichPresence>> {
    public static final ModelRichPresence2 INSTANCE = new ModelRichPresence2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends ModelRichPresence> call(Presence presence) {
        return call2(presence);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ModelRichPresence> call2(Presence presence) {
        Long applicationId;
        if (presence == null) {
            return new ScalarSynchronousObservable(null);
        }
        Activity primaryActivity = PresenceUtils.INSTANCE.getPrimaryActivity(presence);
        return (primaryActivity == null || (applicationId = primaryActivity.getApplicationId()) == null) ? new ScalarSynchronousObservable(new ModelRichPresence(presence, null, 2, null)) : StoreStream.INSTANCE.getApplication().observeApplication(Long.valueOf(applicationId.longValue())).G(new ModelRichPresence3(presence));
    }
}
