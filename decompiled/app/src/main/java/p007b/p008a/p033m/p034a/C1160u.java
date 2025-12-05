package p007b.p008a.p033m.p034a;

import com.discord.api.guildmember.GuildMember;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;

/* compiled from: lambda */
/* renamed from: b.a.m.a.u */
/* loaded from: classes.dex */
public final /* synthetic */ class C1160u implements Model.JsonReader.ItemFactory {

    /* renamed from: a */
    public final /* synthetic */ Model.JsonReader f1541a;

    public /* synthetic */ C1160u(Model.JsonReader jsonReader) {
        this.f1541a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (GuildMember) InboundGatewayGsonParser.fromJson(this.f1541a, GuildMember.class);
    }
}
