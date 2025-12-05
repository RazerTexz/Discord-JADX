package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.overlay.WidgetChatOverlay;
import java.util.concurrent.TimeUnit;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* compiled from: WidgetChatOverlay.kt */
/* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$OldMessageModel$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatOverlay2<T, R> implements Func1<Long, Observable<? extends WidgetChatOverlay.OldMessageModel>> {
    public static final WidgetChatOverlay2 INSTANCE = new WidgetChatOverlay2();

    /* compiled from: WidgetChatOverlay.kt */
    /* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$OldMessageModel$Companion$get$1$1 */
    public static final class C81871<T, R> implements Func1<Boolean, WidgetChatOverlay.OldMessageModel> {
        public final /* synthetic */ Long $selectedChannelId;

        public C81871(Long l) {
            this.$selectedChannelId = l;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ WidgetChatOverlay.OldMessageModel call(Boolean bool) {
            return call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChatOverlay.OldMessageModel call2(Boolean bool) {
            Long l = this.$selectedChannelId;
            Intrinsics3.checkNotNullExpressionValue(l, "selectedChannelId");
            long jLongValue = l.longValue();
            Intrinsics3.checkNotNullExpressionValue(bool, "isViewingOldMessages");
            return new WidgetChatOverlay.OldMessageModel(jLongValue, bool.booleanValue());
        }
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatOverlay.OldMessageModel> call(Long l) {
        return call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatOverlay.OldMessageModel> call2(Long l) {
        Observable observableM11076j;
        if (l.longValue() <= 0) {
            observableM11076j = new ScalarSynchronousObservable(Boolean.FALSE);
        } else {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            StoreMessages messages = companion.getMessages();
            Intrinsics3.checkNotNullExpressionValue(l, "selectedChannelId");
            observableM11076j = Observable.m11076j(messages.observeIsDetached(l.longValue()), companion.getChat().observeInteractionState().m11118y(new WidgetChatOverlay3(l)).m11110p(200L, TimeUnit.MILLISECONDS), WidgetChatOverlay4.INSTANCE);
        }
        return Observable.m11079m(new ScalarSynchronousObservable(Boolean.FALSE), observableM11076j).m11112r().m11083G(new C81871(l));
    }
}
