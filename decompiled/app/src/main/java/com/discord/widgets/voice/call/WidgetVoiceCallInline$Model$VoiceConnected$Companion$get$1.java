package com.discord.widgets.voice.call;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreStream;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.widgets.voice.call.WidgetVoiceCallInline;
import d0.z.d.k;
import d0.z.d.m;
import j0.k.b;
import kotlin.jvm.functions.Function3;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: WidgetVoiceCallInline.kt */
/* loaded from: classes.dex */
public final class WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1<T, R> implements b<Channel, Observable<? extends WidgetVoiceCallInline.Model.VoiceConnected>> {
    public static final WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1 INSTANCE = new WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1();

    /* compiled from: WidgetVoiceCallInline.kt */
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function3<Channel, MediaEngineConnection.InputMode, StreamContext, WidgetVoiceCallInline.Model.VoiceConnected> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(3, WidgetVoiceCallInline.Model.VoiceConnected.class, "<init>", "<init>(Lcom/discord/api/channel/Channel;Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;Lcom/discord/utilities/streams/StreamContext;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ WidgetVoiceCallInline.Model.VoiceConnected invoke(Channel channel, MediaEngineConnection.InputMode inputMode, StreamContext streamContext) {
            return invoke2(channel, inputMode, streamContext);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final WidgetVoiceCallInline.Model.VoiceConnected invoke2(Channel channel, MediaEngineConnection.InputMode inputMode, StreamContext streamContext) {
            m.checkNotNullParameter(channel, "p1");
            m.checkNotNullParameter(inputMode, "p2");
            return new WidgetVoiceCallInline.Model.VoiceConnected(channel, inputMode, streamContext);
        }
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetVoiceCallInline.Model.VoiceConnected> call2(Channel channel) {
        if (channel == null) {
            return new j0.l.e.k(null);
        }
        j0.l.e.k kVar = new j0.l.e.k(channel);
        Observable<MediaEngineConnection.InputMode> inputMode = StoreStream.INSTANCE.getMediaSettings().getInputMode();
        Observable<StreamContext> forActiveStream = new StreamContextService(null, null, null, null, null, null, null, null, 255, null).getForActiveStream();
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        Object widgetVoiceCallInline$sam$rx_functions_Func3$0 = anonymousClass1;
        if (anonymousClass1 != null) {
            widgetVoiceCallInline$sam$rx_functions_Func3$0 = new WidgetVoiceCallInline$sam$rx_functions_Func3$0(anonymousClass1);
        }
        return Observable.i(kVar, inputMode, forActiveStream, (Func3) widgetVoiceCallInline$sam$rx_functions_Func3$0);
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetVoiceCallInline.Model.VoiceConnected> call(Channel channel) {
        return call2(channel);
    }
}
