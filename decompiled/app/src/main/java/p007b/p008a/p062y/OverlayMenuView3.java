package p007b.p008a.p062y;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreStream;
import com.discord.views.OverlayMenuView;
import com.discord.widgets.voice.model.CallModel;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func4;

/* compiled from: OverlayMenuView.kt */
/* renamed from: b.a.y.r, reason: use source file name */
/* loaded from: classes2.dex */
public final class OverlayMenuView3<T, R> implements Func1<Channel, Observable<? extends OverlayMenuView.C7085a>> {

    /* renamed from: j */
    public static final OverlayMenuView3 f2068j = new OverlayMenuView3();

    @Override // p637j0.p641k.Func1
    public Observable<? extends OverlayMenuView.C7085a> call(Channel channel) {
        Channel channel2 = channel;
        if (channel2 == null) {
            return new ScalarSynchronousObservable(null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<Long> observableObservePermissionsForChannel = companion.getPermissions().observePermissionsForChannel(channel2.getId());
        Observable<Guild> observableObserveGuild = companion.getGuilds().observeGuild(channel2.getGuildId());
        Observable<CallModel> observable = CallModel.INSTANCE.get(channel2.getId());
        Observable<RtcConnection.Quality> quality = companion.getRtcConnection().getQuality();
        OverlayMenuView2 overlayMenuView2 = OverlayMenuView2.f2065j;
        Object overlayMenuView6 = overlayMenuView2;
        if (overlayMenuView2 != null) {
            overlayMenuView6 = new OverlayMenuView6(overlayMenuView2);
        }
        return Observable.m11073h(observableObservePermissionsForChannel, observableObserveGuild, observable, quality, (Func4) overlayMenuView6);
    }
}
