package p007b.p008a.p033m.p034a;

import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;

/* JADX INFO: renamed from: b.a.m.a.y */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1164y implements Model.JsonReader.ItemFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Model.JsonReader f1545a;

    public /* synthetic */ C1164y(Model.JsonReader jsonReader) {
        this.f1545a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (GuildJoinRequest) InboundGatewayGsonParser.fromJson(this.f1545a, GuildJoinRequest.class);
    }
}
