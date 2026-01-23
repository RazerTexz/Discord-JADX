package com.discord.widgets.voice.call;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreStream;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.widgets.voice.call.WidgetVoiceCallInline;
import kotlin.jvm.functions.Function3;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func3;

/* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallInline3<T, R> implements Func1<Channel, Observable<? extends WidgetVoiceCallInline.Model.VoiceConnected>> {
    public static final WidgetVoiceCallInline3 INSTANCE = new WidgetVoiceCallInline3();

    /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1$1 */
    /* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
    public static final /* synthetic */ class C104221 extends FunctionReferenceImpl implements Function3<Channel, MediaEngineConnection.InputMode, StreamContext, WidgetVoiceCallInline.Model.VoiceConnected> {
        public static final C104221 INSTANCE = new C104221();

        public C104221() {
            super(3, WidgetVoiceCallInline.Model.VoiceConnected.class, "<init>", "<init>(Lcom/discord/api/channel/Channel;Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;Lcom/discord/utilities/streams/StreamContext;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ WidgetVoiceCallInline.Model.VoiceConnected invoke(Channel channel, MediaEngineConnection.InputMode inputMode, StreamContext streamContext) {
            return invoke2(channel, inputMode, streamContext);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final WidgetVoiceCallInline.Model.VoiceConnected invoke2(Channel channel, MediaEngineConnection.InputMode inputMode, StreamContext streamContext) {
            Intrinsics3.checkNotNullParameter(channel, "p1");
            Intrinsics3.checkNotNullParameter(inputMode, "p2");
            return new WidgetVoiceCallInline.Model.VoiceConnected(channel, inputMode, streamContext);
        }
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetVoiceCallInline.Model.VoiceConnected> call2(Channel channel) {
        if (channel == null) {
            return new ScalarSynchronousObservable(null);
        }
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(channel);
        Observable<MediaEngineConnection.InputMode> inputMode = StoreStream.INSTANCE.getMediaSettings().getInputMode();
        Observable<StreamContext> forActiveStream = new StreamContextService(null, null, null, null, null, null, null, null, 255, null).getForActiveStream();
        C104221 c104221 = C104221.INSTANCE;
        Object widgetVoiceCallInline6 = c104221;
        if (c104221 != null) {
            widgetVoiceCallInline6 = new WidgetVoiceCallInline6(c104221);
        }
        return Observable.m11075i(scalarSynchronousObservable, inputMode, forActiveStream, (Func3) widgetVoiceCallInline6);
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetVoiceCallInline.Model.VoiceConnected> call(Channel channel) {
        return call2(channel);
    }
}
