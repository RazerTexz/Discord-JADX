package b.a.y;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreStream;
import com.discord.views.OverlayMenuView;
import com.discord.widgets.voice.model.CallModel;
import rx.Observable;
import rx.functions.Func4;

/* compiled from: OverlayMenuView.kt */
/* loaded from: classes2.dex */
public final class r<T, R> implements j0.k.b<Channel, Observable<? extends OverlayMenuView.a>> {
    public static final r j = new r();

    @Override // j0.k.b
    public Observable<? extends OverlayMenuView.a> call(Channel channel) {
        Channel channel2 = channel;
        if (channel2 == null) {
            return new j0.l.e.k(null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<Long> observableObservePermissionsForChannel = companion.getPermissions().observePermissionsForChannel(channel2.getId());
        Observable<Guild> observableObserveGuild = companion.getGuilds().observeGuild(channel2.getGuildId());
        Observable<CallModel> observable = CallModel.INSTANCE.get(channel2.getId());
        Observable<RtcConnection.Quality> quality = companion.getRtcConnection().getQuality();
        q qVar = q.j;
        Object uVar = qVar;
        if (qVar != null) {
            uVar = new u(qVar);
        }
        return Observable.h(observableObservePermissionsForChannel, observableObserveGuild, observable, quality, (Func4) uVar);
    }
}
