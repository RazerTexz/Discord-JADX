package com.discord.widgets.voice.call;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreStream;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.widgets.voice.call.WidgetVoiceCallInline;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.jvm.functions.Function3;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: WidgetVoiceCallInline.kt */
/* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetVoiceCallInline3<T, R> implements Func1<Channel, Observable<? extends WidgetVoiceCallInline.Model.VoiceConnected>> {
    public static final WidgetVoiceCallInline3 INSTANCE = new WidgetVoiceCallInline3();

    /* compiled from: WidgetVoiceCallInline.kt */
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<Channel, MediaEngineConnection.InputMode, StreamContext, WidgetVoiceCallInline.Model.VoiceConnected> {
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
            Intrinsics3.checkNotNullParameter(channel, "p1");
            Intrinsics3.checkNotNullParameter(inputMode, "p2");
            return new WidgetVoiceCallInline.Model.VoiceConnected(channel, inputMode, streamContext);
        }
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetVoiceCallInline.Model.VoiceConnected> call2(Channel channel) {
        if (channel == null) {
            return new ScalarSynchronousObservable(null);
        }
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(channel);
        Observable<MediaEngineConnection.InputMode> inputMode = StoreStream.INSTANCE.getMediaSettings().getInputMode();
        Observable<StreamContext> forActiveStream = new StreamContextService(null, null, null, null, null, null, null, null, 255, null).getForActiveStream();
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        Object widgetVoiceCallInline6 = anonymousClass1;
        if (anonymousClass1 != null) {
            widgetVoiceCallInline6 = new WidgetVoiceCallInline6(anonymousClass1);
        }
        return Observable.i(scalarSynchronousObservable, inputMode, forActiveStream, (Func3) widgetVoiceCallInline6);
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetVoiceCallInline.Model.VoiceConnected> call(Channel channel) {
        return call2(channel);
    }
}
