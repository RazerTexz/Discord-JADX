package b.a.y;

import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection;
import com.discord.views.OverlayMenuView;
import com.discord.widgets.voice.model.CallModel;
import kotlin.jvm.functions.Function4;

/* compiled from: OverlayMenuView.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class q extends d0.z.d.k implements Function4<Long, Guild, CallModel, RtcConnection.Quality, OverlayMenuView.a> {
    public static final q j = new q();

    public q() {
        super(4, OverlayMenuView.a.class, "<init>", "<init>(Ljava/lang/Long;Lcom/discord/models/guild/Guild;Lcom/discord/widgets/voice/model/CallModel;Lcom/discord/rtcconnection/RtcConnection$Quality;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public OverlayMenuView.a invoke(Long l, Guild guild, CallModel callModel, RtcConnection.Quality quality) {
        RtcConnection.Quality quality2 = quality;
        d0.z.d.m.checkNotNullParameter(quality2, "p4");
        return new OverlayMenuView.a(l, guild, callModel, quality2);
    }
}
