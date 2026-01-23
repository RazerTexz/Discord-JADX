package com.discord.widgets.voice.call;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.widgets.voice.call.WidgetVoiceCallIncoming;
import com.discord.widgets.voice.model.CallModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$Model$Companion$get$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetVoiceCallIncoming.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallIncoming2<T, R> implements Func1<Set<? extends Long>, Observable<? extends WidgetVoiceCallIncoming.Model>> {
    public static final WidgetVoiceCallIncoming2 INSTANCE = new WidgetVoiceCallIncoming2();

    /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$Model$Companion$get$1$1 */
    /* JADX INFO: compiled from: WidgetVoiceCallIncoming.kt */
    public static final class C104151<T, R> implements Func1<CallModel, WidgetVoiceCallIncoming.Model> {
        public final /* synthetic */ Set $incomingCalls;

        /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$Model$Companion$get$1$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetVoiceCallIncoming.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<StoreVoiceParticipants.VoiceUser, Boolean> {
            public final /* synthetic */ CallModel $callModel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(CallModel callModel) {
                super(1);
                this.$callModel = callModel;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
                return Boolean.valueOf(invoke2(voiceUser));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
                Intrinsics3.checkNotNullParameter(voiceUser, "participant");
                if (ChannelUtils.m7702z(this.$callModel.getChannel())) {
                    if (voiceUser.isConnected() || voiceUser.isRinging()) {
                        return true;
                    }
                } else if (!voiceUser.isMe()) {
                    return true;
                }
                return false;
            }
        }

        public C104151(Set set) {
            this.$incomingCalls = set;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ WidgetVoiceCallIncoming.Model call(CallModel callModel) {
            return call2(callModel);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetVoiceCallIncoming.Model call2(CallModel callModel) {
            if (callModel == null) {
                return null;
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(callModel);
            Collection<StoreVoiceParticipants.VoiceUser> collectionValues = callModel.getParticipants().values();
            ArrayList arrayList = new ArrayList();
            for (T t : collectionValues) {
                if (anonymousClass1.invoke2((StoreVoiceParticipants.VoiceUser) t)) {
                    arrayList.add(t);
                }
            }
            return new WidgetVoiceCallIncoming.Model(callModel, arrayList, this.$incomingCalls.size());
        }
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetVoiceCallIncoming.Model> call(Set<? extends Long> set) {
        return call2((Set<Long>) set);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetVoiceCallIncoming.Model> call2(Set<Long> set) {
        if (set.isEmpty()) {
            return new ScalarSynchronousObservable(null);
        }
        CallModel.Companion companion = CallModel.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(set, "incomingCalls");
        return companion.get(((Number) _Collections.first(set)).longValue()).m11083G(new C104151(set));
    }
}
