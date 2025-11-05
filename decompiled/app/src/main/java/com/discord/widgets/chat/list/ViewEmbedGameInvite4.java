package com.discord.widgets.chat.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityParty;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserPresence;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import rx.Observable;

/* compiled from: ViewEmbedGameInvite.kt */
/* renamed from: com.discord.widgets.chat.list.ViewEmbedGameInvite$Model$Companion$getForShare$activityObs$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ViewEmbedGameInvite4<T, R> implements Func1<Long, Observable<? extends Activity>> {
    public final /* synthetic */ Long $applicationId;
    public final /* synthetic */ String $partyId;

    /* compiled from: ViewEmbedGameInvite.kt */
    /* renamed from: com.discord.widgets.chat.list.ViewEmbedGameInvite$Model$Companion$getForShare$activityObs$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Activity, Boolean> {
        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Activity activity) {
            return call2(activity);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
        /* renamed from: call, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Boolean call2(Activity activity) {
            boolean z2;
            if (activity == null) {
                z2 = false;
            } else {
                ActivityParty party = activity.getParty();
                if (Intrinsics3.areEqual(party != null ? party.getId() : null, ViewEmbedGameInvite4.this.$partyId)) {
                    z2 = true;
                }
            }
            return Boolean.valueOf(z2);
        }
    }

    public ViewEmbedGameInvite4(Long l, String str) {
        this.$applicationId = l;
        this.$partyId = str;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Activity> call(Long l) {
        return call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Activity> call2(Long l) {
        StoreUserPresence presences = StoreStream.INSTANCE.getPresences();
        Intrinsics3.checkNotNullExpressionValue(l, "authorId");
        return presences.observeApplicationActivity(l.longValue(), this.$applicationId.longValue()).y(new AnonymousClass1());
    }
}
