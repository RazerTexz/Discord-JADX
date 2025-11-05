package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.overlay.WidgetChatOverlay;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* compiled from: WidgetChatOverlay.kt */
/* loaded from: classes2.dex */
public final class WidgetChatOverlay$OldMessageModel$Companion$get$1<T, R> implements b<Long, Observable<? extends WidgetChatOverlay.OldMessageModel>> {
    public static final WidgetChatOverlay$OldMessageModel$Companion$get$1 INSTANCE = new WidgetChatOverlay$OldMessageModel$Companion$get$1();

    /* compiled from: WidgetChatOverlay.kt */
    /* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$OldMessageModel$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Boolean, WidgetChatOverlay.OldMessageModel> {
        public final /* synthetic */ Long $selectedChannelId;

        public AnonymousClass1(Long l) {
            this.$selectedChannelId = l;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ WidgetChatOverlay.OldMessageModel call(Boolean bool) {
            return call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChatOverlay.OldMessageModel call2(Boolean bool) {
            Long l = this.$selectedChannelId;
            m.checkNotNullExpressionValue(l, "selectedChannelId");
            long jLongValue = l.longValue();
            m.checkNotNullExpressionValue(bool, "isViewingOldMessages");
            return new WidgetChatOverlay.OldMessageModel(jLongValue, bool.booleanValue());
        }
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatOverlay.OldMessageModel> call(Long l) {
        return call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatOverlay.OldMessageModel> call2(Long l) {
        Observable observableJ;
        if (l.longValue() <= 0) {
            observableJ = new k(Boolean.FALSE);
        } else {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            StoreMessages messages = companion.getMessages();
            m.checkNotNullExpressionValue(l, "selectedChannelId");
            observableJ = Observable.j(messages.observeIsDetached(l.longValue()), companion.getChat().observeInteractionState().y(new WidgetChatOverlay$OldMessageModel$Companion$get$1$isViewingOldMessagesObs$1(l)).p(200L, TimeUnit.MILLISECONDS), WidgetChatOverlay$OldMessageModel$Companion$get$1$isViewingOldMessagesObs$2.INSTANCE);
        }
        return Observable.m(new k(Boolean.FALSE), observableJ).r().G(new AnonymousClass1(l));
    }
}
